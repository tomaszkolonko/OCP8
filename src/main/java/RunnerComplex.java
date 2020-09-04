import java.util.ArrayList;
import java.util.List;

public class RunnerComplex {
    public static void main(String[] args) {
        RunnerComplex runnerComplex = new RunnerComplex();

        List<Dog> dogList = new ArrayList<Dog>();
        dogList.add(new Dog(234));
        dogList.add(new Dog(23));

        runnerComplex.printAnimalList(dogList);
        runnerComplex.addToAnimalList(dogList);

        runnerComplex.addToAnimalListSafely(dogList);

        List<Animal> animalList = new ArrayList<Animal>();
        // why not, the dog being added is still an Animal
        runnerComplex.addToAnimalListSafely(animalList);

        List<Object> objectList = new ArrayList<>();
        // why not, the dog being added is still an object
        runnerComplex.addToAnimalListSafely(objectList);

        runnerComplex.printFinalList(dogList);

    }

    private void printAnimalList(List<? extends Animal> animals) {
        for(Animal animal : animals) {
            System.out.println(animal.getType());
        }
    }

    private void addToAnimalList(List<? extends Animal> animals) {
//        animals.add(new Animal("Animal"));
//        animals.add(new Dog(123));
        System.out.println("Adding with this construct of \"List<? extends Animal> animals\" is not possilbe");
    }

    private void addToAnimalListSafely(List<? super Dog> animals) {
        animals.add(new Dog(999));
//        animals.add(new Animal("Super Animal"));
//        animals.add(new Object());
    }

    private void printFinalList(List<Dog> dogList) {
        for(Dog dog : dogList) {
            System.out.println("Type of Animal: " + dog.getType() + " with happiness factor of: " + dog.getHappinessFactor());
        }
    }


}
