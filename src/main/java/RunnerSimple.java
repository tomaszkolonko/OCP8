import java.util.ArrayList;
import java.util.List;

public class RunnerSimple {

    public static void main(String[] args) {
        RunnerSimple runnerSimple = new RunnerSimple();
        runnerSimple.simpleArrayMethods();
        runnerSimple.simpleCollectionMethods();
    }

    private void simpleArrayMethods() {
        Animal[] animals = new Animal[2];
        animals = addToArray(animals);

        System.out.println("\ninside the simpleArrayMethods");
        for(Animal animal : animals) {
            System.out.println(animal.getName());
        }

    }

    private Animal[] addToArray(Animal[] animalsList) {
        animalsList[0] = new Dog(99);
        animalsList[1] = new Cat(334);
        return animalsList;
    }

    private void simpleCollectionMethods() {
        List<Animal> animals = new ArrayList<Animal>();
        animals = addToCollection(animals);

        System.out.println("\ninside the simpleCollectionMethod");
        for(Animal animal : animals) {
            System.out.println(animal.getName());
        }
    }

    private List<Animal> addToCollection(List<Animal> animalsList) {
        animalsList.add(new Dog(99));
        animalsList.add(new Cat(334));
        return animalsList;
    }

}
