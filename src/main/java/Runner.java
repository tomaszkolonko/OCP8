public class Runner {
    public static void main(String[] args) {
        Animal animalAnimal = new Animal();
        animalAnimal.eat();
//        animalAnimal.eat("Meatballs");

        Animal animalDog = new Dog();
        animalDog.eat();
//        animalDog.eat("Meatballs");

        Dog dog = new Dog();
        dog.eat();
        dog.eat("Meatballs");

        System.out.println("\n=====================\n");

        redirection(animalAnimal);
        redirection(animalDog);
        redirection(dog);

    }

    static void redirection(Animal animal) {
        System.out.println("Inside redirection(Animal)");
        animal.eat();
//        if(animal instanceof Dog) {
//            animal.eat("super meatballs");
//        }
        System.out.println();
    }

    static void redirection(Dog dog) {
        System.out.println("Inside redirection(Animal)");
        dog.eat();
        dog.eat("super delicious meatballs");
        System.out.println();
    }


}

