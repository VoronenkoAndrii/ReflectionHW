import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

public interface ReflectionPractice {

    void load(Object anInstanceOfSomething);

    int getTotalNumberOfMethods();

    int getTotalNumberOfConstructors();

    int getTotalNumberOfFields();

    Set<String> getAllImplementedInterfaces();

    int getCountOfConstantFields();

    int getCountOfStaticMethods();

    boolean isExtendingClassWhichIsNotObject();

    String getParentClassSimpleName();

    boolean isParentClassAbstract();

    Set<String> getNamesOfAllFieldsIncludingInheritanceChain();

    int invokeMethodThatReturnsInt(String methodName, Class... args);

    Object createInstance(int numberOfArgs, Object... args);

    Object invokePrivateMethod(String name, Class<?>[] parametersTypes, Object... args);

    String getInheritanceChain(String delimiter);

    int howManyAnnotationsTheClassAndMethodsHave();

    List<Integer> getAllMethodAnnotationsParamsNumber(Class<? extends Annotation> annotation);
}
