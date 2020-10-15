import java.util.ArrayList;
import java.util.List;

public class RunnerSimple {

    public static void main(String[] args) {
        RunnerSimple runnerSimple = new RunnerSimple();
        runnerSimple.simpleArrayMethods();
        runnerSimple.simpleCollectionMethods();

        runnerSimple.weWantPreventThat();
    }

    public void simpleArrayMethods() {
        Animal[] animals = new Animal[2];
        animals = addToArray(animals);

        System.out.println("\ninside the simpleArrayMethods");
        for(Animal animal : animals) {
            System.out.println(animal.getType());
        }
    }

    private Animal[] addToArray(Animal[] animalArray) {
        animalArray[0] = new Dog(99);
        animalArray[1] = new Cat(334);
        return animalArray;
    }

    public void simpleCollectionMethods() {
        List<Animal> animals = new ArrayList<Animal>();
        animals = addToCollection(animals);

        System.out.println("\ninside the simpleCollectionMethod");
        for(Animal animal : animals) {
            System.out.println(animal.getType());
        }
    }

    private List<Animal> addToCollection(List<Animal> animalsList) {
        animalsList.add(new Dog(99));
        animalsList.add(new Cat(334));
        return animalsList;
    }

    public void weWantPreventThat() {
        Cat[] catArray = new Cat[2];
        catArray[0] = new Cat(23);
        catArray[1] = new Cat(-1);

        addAnimals(catArray);

        for(Cat cat : catArray) {
            System.out.println("Fightfactor is: " + cat.getFightFactor());
        }

    }

    /**
     *       !!!!!!
     * The reason it is dangerous to pass a collection (array or ArrayList) of a subtype into a
     * method that takes a collection of a supertype is because you might add something...
     * And that means you might add the WRONG THING.
     *       !!!!!!
     */
    private Animal[] addAnimals(Animal[] animals) {
        // for the compiler it's absolutely fine, but at runtime there will be an
        // java.lang.ArrayStoreException
        animals[1] = new Dog(123);
        return animals;
    }

}
