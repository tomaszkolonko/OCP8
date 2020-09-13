public class Cat extends Animal implements CatBehaviour {

    @Override
    public void eat() {
        System.out.println("Eating mice");
    }

    public void doSomeOtherStuff() {
        System.out.println("...");
    }
}
