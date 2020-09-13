public class Dog extends Animal implements DogBehaviour {

    @Override
    public void eat() {
        System.out.println("Eating meatballs");
    }

    public void doSomeOtherStuff() {
        System.out.println("...");
    }
}
