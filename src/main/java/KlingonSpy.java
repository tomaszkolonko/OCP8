public class KlingonSpy {
    public static void main(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.printInnerWisdom();
        innerClass.printOuterWisdom();

//        innerClass.hiddenNews();

        OuterClass outerClass = new OuterClass();
        outerClass.doMagic();

//        outerClass.hiddenNews();
    }

    public void printOuterClassReference(OuterClass outerClassReference) {
        System.out.println("outerClassRefernce: " + outerClassReference);
    }

    public void printInnerClassReference(OuterClass.InnerClass innerClassReference) {
        System.out.println("innerClassReference: " + innerClassReference);
        innerClassReference.printInnerWisdom();
        innerClassReference.printOuterWisdom();
//        innerClassReference.hiddenNews();
    }
}
