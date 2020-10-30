import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<String> listOfAnimals = Arrays.asList("Bird", "Ant", "Snake", "Elephant");

        listOfAnimals.forEach(t -> System.out.println(t));

        System.out.println("\n=========\n");

        listOfAnimals.forEach(System.out::println);

        System.out.println("\n=========\n");

        listOfAnimals.forEach(MethodReferences::printAnimalNames);

    }

}
