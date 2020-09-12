package person;

/**
 * Play around by changing public, default and private modifiers of the class and of class members and
 * especially of class member methods, don't forge to play with super
 */
public class Person {
    private int age;

    public Person(final int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello from public Person method");
    }


}
