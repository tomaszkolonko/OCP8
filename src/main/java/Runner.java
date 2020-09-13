public class Runner {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();
        CatLikeDog catLikeDog = new CatLikeDog();

        cat.eat();
        cat.cuddleWithOwner();

        dog.eat();
        dog.cuddleWithOwner();

        catLikeDog.eat();
        catLikeDog.cuddleWithOwner();
    }
}
