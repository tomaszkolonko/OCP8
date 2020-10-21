public class SomeOtherClass {
    public static void main(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.printInnerWisdom();
        innerClass.printOuterWisdom();

        // innerClass.hiddenMethod();

        OuterClass outerClass = new OuterClass();
        outerClass.doMagic();
    }

    public void printOuterClassReference(OuterClass outerClassReference) {
        System.out.println("outerClassRefernce: " + outerClassReference);
    }

    public void printInnerClassReference(OuterClass.InnerClass innerClassReference) {
        System.out.println("innerClassReference: " + innerClassReference);
    }
}
