public class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("Dog is eating happily");
    }

    public void eat(String foodType) {
        System.out.println("Dog is eating " + foodType);
    }
}
