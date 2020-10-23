

public class OuterClass {
    private int outerWisdomNumber = 13;

    public static void main(String[] args) {
        // To create an instance of an inner class, you must have an instance of the outer class
        // to tie to the inner class.
        // InnerClass innerClass = new InnerClass();
        OuterClass outerClass = new OuterClass();
        outerClass.doMagic();

        System.out.println("\n\n==================================\n\n");

        InnerClass innerClass2 = new OuterClass().new InnerClass();
        innerClass2.treason();
    }

    public void doMagic() {
        InnerClass innerClass = new InnerClass();
        innerClass.printInnerWisdom();

        // The enclosing class can access the (private) members from the inner class ONLY
        // through an instance of the enclosing class.
//        System.out.println("Accessing inner wisdom from outer space: " + innerWisdomNumber);
        System.out.println("Accessing inner wisdom from outer space: " + innerClass.innerWisdomNumber);
    }

    private void hiddenNews() {
        System.out.println("outerNews: check 20min for more information");
    }


    public class InnerClass {
        private final int innerWisdomNumber = 42;

        public void printInnerWisdom() {
            // The inner class can use the enclosing classes (private) members.
            System.out.println("Accessing inner wisdom number: " + innerWisdomNumber);
        }

        public void printOuterWisdom() {
            System.out.println("Accessing outer wisdom number: " + outerWisdomNumber);
        }

        private void hiddenNews() {
            System.out.println("innerNews: Elon Musk just arrived at moonstation.");
        }

        private void treason() {
            KlingonSpy spy = new KlingonSpy();
            spy.printOuterClassReference(OuterClass.this);

            spy.printInnerClassReference(this);
        }
    }
}
