package special;

import person.Person;

/**
 * Play around by changing public, default and private modifiers of the class and of class members and
 * especially of class member methods, don't forge to play with super
 */
public class SpecialPerson extends Person {
    private int specialFactor;

    public SpecialPerson(final int age, final int specialFactor) {
        super(age);
        this.specialFactor = specialFactor;
    }

    @Override
    public void sayHello() {
        System.out.println("Say Hello from public SpecialPerson method");
    }

    public void tryOut() {
        sayHello();
        this.sayHello();

        // What is the implication of using super?
        super.sayHello();

        Person person = new Person(123);
        person.sayHello();
    }
}
