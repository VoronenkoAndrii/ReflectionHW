import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReflectionPracticeImpl implements ReflectionPractice {
    private Object anInstanceOfSomething;
    private Class<?> myClass;

    @Override
    public void load(Object anInstanceOfSomething) {
        this.anInstanceOfSomething = anInstanceOfSomething;
        myClass = anInstanceOfSomething.getClass();
    }

    @Override
    public int getTotalNumberOfMethods() {
        return myClass.getMethods().length;
    }

    @Override
    public int getTotalNumberOfConstructors() {

        return myClass.getConstructors().length;
    }

    @Override
    public int getTotalNumberOfFields() {

        return myClass.getFields().length;
    }

    @Override
    public Set<String> getAllImplementedInterfaces() {
        Class<?>[] implementedClasses = myClass.getInterfaces();
        Set<String> resultInterfaces = new HashSet<>();

        for (Class<?> cl : implementedClasses) {
            resultInterfaces.add(cl.getName());
        }

        return resultInterfaces;
    }

    @Override
    public int getCountOfConstantFields() {
        Field[] fields = myClass.getFields();
        Set<Field> result = new HashSet<>();
        for (Field field : fields) {
            if (field.toGenericString().contains("final")) {
                result.add(field);
            }
        }
        return result.size();
    }

    @Override
    public int getCountOfStaticMethods() {
        Method[] methods = myClass.getMethods();
        Set<Method> resultMethod = new HashSet<>();
        for (Method method : methods) {
            if (method.toGenericString().contains("static")){
                resultMethod.add(method);
            }
        }
        return resultMethod.size();
    }

    @Override
    public boolean isExtendingClassWhichIsNotObject() {
        return !getParentClassSimpleName().equals("Object");
    }

    @Override
    public String getParentClassSimpleName() {
        return myClass.getSuperclass().getSimpleName();
    }

    @Override
    public boolean isParentClassAbstract() {
        return myClass.getSuperclass().toString().contains("Anstract");
    }

    @Override
    public Set<String> getNamesOfAllFieldsIncludingInheritanceChain() {
        Set<String> fielsds = new HashSet<>();
        Field[] currentClassFields = myClass.getFields();
        Class currentClass = myClass;
        while (!"Object".equals(currentClass.getSimpleName())) {
            addFieldsNames(fielsds, currentClassFields);
            currentClass = currentClass.getSuperclass();
            currentClassFields = currentClass.getFields();

        }
        addFieldsNames(fielsds, currentClassFields);
        return fielsds;
    }

    private void addFieldsNames(Set<String> fielsds, Field[] currentClassFields) {
        for (Field f : currentClassFields) {
            fielsds.add(f.getName());
        }
    }

    @Override
    public int invokeMethodThatReturnsInt(String methodName, Class... args)  {
        try {
            Method inputMethod = myClass.getMethod(methodName,args);
            return (int)inputMethod.invoke(anInstanceOfSomething);
        }catch (NoSuchMethodException e){
            System.out.println("oops");
        }catch (IllegalArgumentException e){
            System.out.println("oops");
        }catch (IllegalAccessException e){
            System.out.println("oops");
        }catch (InvocationTargetException e){
            System.out.println("oops");
        }
        return 0;
    }

    @Override
    public Object createInstance(int numberOfArgs, Object... args) {
        //
        return null; //TODO.
    }

    @Override
    public Object invokePrivateMethod(String name, Class<?>[] parametersTypes, Object... args) {
        return null; //TODO.
    }

    @Override
    public String getInheritanceChain(String delimiter) {
        String result = "";
        Class currentClass = myClass;
        while (!"Object".equals(currentClass.getSimpleName())) {
            result = result + currentClass.getSimpleName() + delimiter;
            currentClass = currentClass.getSuperclass();
        }
        result = result + currentClass.getSimpleName();
        return result;
    }

    @Override
    public int howManyAnnotationsTheClassAndMethodsHave() {
        int annotationsSum = 0;
        Method[] methods = myClass.getMethods();
        for (Method m : methods) {
            annotationsSum = annotationsSum + m.getDeclaredAnnotations().length;
        }
        return annotationsSum + myClass.getAnnotations().length;
    }

    @Override
    public List<Integer> getAllMethodAnnotationsParamsNumber(Class<? extends Annotation> annotation ) {
        // if mahod contains anotation -> return its parameters number?
        List<Integer> methodAnnotationsParamsNumber = new ArrayList<>();
        Method[] methods = myClass.getMethods();
        for (Method m : methods) {
            if(m.getDeclaredAnnotation(annotation)!=null) {
                methodAnnotationsParamsNumber.add(m.getParameterCount());
            }
        }
        return methodAnnotationsParamsNumber;
    }
}
