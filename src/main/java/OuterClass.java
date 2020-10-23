import com.sun.org.apache.bcel.internal.classfile.InnerClass;

public class OuterClass {
    private String outerClassString = "outerClass String";
    private Dog passedObject;
    private InnerClass innerClass;

    void doSomething() {
        Dog dog = new Dog("Puppy");
        int number = 42;
        class InnerClass {
            String innerClassString = "innerClass String";

            public void seeOuterClassString() {
                System.out.println("outerClassString: " + outerClassString);
                System.out.println("innerClassString: " + innerClassString);
                System.out.println("\t" + dog);
//                dog = new Dog("Max");
                preserveLocalObject(dog);
            }

            // Try out passing in another number
            // which one will be taken??
            public void printNumber(int number) {
                System.out.println(number);
            }
        }
        InnerClass innerClass = new InnerClass();
        // Move this line in front of the class.

        innerClass.seeOuterClassString();
        System.out.println(innerClass.innerClassString);

        System.out.println("\t" + passedObject);

        innerClass.printNumber(number);
    }

    void preserveLocalObject(Dog dog) {
        passedObject = dog;
    }
}
