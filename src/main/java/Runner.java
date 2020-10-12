import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        String[] fruitsAsArray = {"Apple", "Strawberries", "Banana", "Peach", "Kiwi"};
        List<String> fruitsAsList = Arrays.asList(fruitsAsArray);
        System.out.println("size: " + fruitsAsList.size());
        System.out.println("index 2 is: " + fruitsAsList.get(2));

        // changing the List
        fruitsAsList.set(3, "Ferrari");

        // change the String Array
        fruitsAsArray[1] = "Porsche";

        System.out.println("size: " + fruitsAsList.size());
        printListElements(fruitsAsList);
        printArrayElements(fruitsAsArray);

        creatingArrayFromList(fruitsAsList);

    }

    static void printListElements(List<String> fruitsAsList) {
        for(String s : fruitsAsList) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static void printArrayElements(String[] fruitsAsArray) {
        for(String s : fruitsAsArray) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static void creatingArrayFromList(List<String> fruitsAsList) {
        System.out.println("\n\nCreating Array out of List");

        // Flavor one
        Object[] objectArray = fruitsAsList.toArray();
        for(Object o : objectArray) {
            System.out.print(o + " ");
        }
        System.out.println();

        // Flavor two
        String[] stringArray = new String[fruitsAsList.size()];
        fruitsAsList.toArray(stringArray);
        for(String s : stringArray) {
            System.out.print(s + " ");
        }

    }

}
