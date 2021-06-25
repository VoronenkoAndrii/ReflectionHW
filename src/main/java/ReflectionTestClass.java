public class ReflectionTestClass {
    public  static void main(String[] args) {

        ReflectionPracticeImpl reflectionPractice = new ReflectionPracticeImpl();
       // reflectionPractice.load("OLOLO");
         reflectionPractice.load(new Integer(1));

        System.out.println("NumberOfMethods : "+reflectionPractice.getTotalNumberOfMethods());
        System.out.println("NumberOfConstructors : "+reflectionPractice.getTotalNumberOfConstructors());
        System.out.println("NumberOfFields : " +reflectionPractice.getTotalNumberOfFields() );
        System.out.println("getAllImplementedInterfaces : " +reflectionPractice.getAllImplementedInterfaces() );
        System.out.println("getCountOfConstantFields : "+reflectionPractice.getCountOfConstantFields());
        System.out.println("getCountOfStaticMethods : "+ reflectionPractice.getCountOfStaticMethods());
        System.out.println("getParentClassSimpleName : "+ reflectionPractice.getParentClassSimpleName());
        System.out.println("getParentClassSimpleName : "+ reflectionPractice.getParentClassSimpleName());
        System.out.println("isParentClassAbstract :" + reflectionPractice.isParentClassAbstract());
        System.out.println("getNamesOfAllFieldsIncludingInheritanceChain :" + reflectionPractice. getNamesOfAllFieldsIncludingInheritanceChain());
        System.out.println("invokeMethodThatReturnsInt :" + reflectionPractice.invokeMethodThatReturnsInt("length",null));
        System.out.println("getInheritanceChain :" + reflectionPractice. getInheritanceChain("//"));
        System.out.println("howManyAnnotationsTheClassAndMethodsHave :" + reflectionPractice.howManyAnnotationsTheClassAndMethodsHave());
        //System.out.println("getAllMethodAnnotationsParamsNumber :" + reflectionPractice.getAllMethodAnnotationsParamsNumber(null));


    }
}
