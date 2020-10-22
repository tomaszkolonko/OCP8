import com.sun.org.apache.bcel.internal.classfile.InnerClass;

public class OuterClass {
    private String outerClassString = "outerClass String";
    private Dog passedObject;
    private InnerClass innerClass;

    void doSomething() {
        final Dog dog = new Dog("Puppy");
        class InnerClass {
            String innerClassString = "innerClass String";

            public void seeOuterClassString() {
                System.out.println("outerClassString: " + outerClassString);
                System.out.println("innerClassString: " + innerClassString);
                System.out.println("\t" + dog);
                // dog = new Dog("Max");
                preserveLocalObject(dog);
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.seeOuterClassString();
        System.out.println(innerClass.innerClassString);

        System.out.println("\t" + passedObject);
    }

    void preserveLocalObject(Dog dog) {
        passedObject = dog;
    }
}
