import java.util.Arrays;
import java.util.Comparator;

public class Runner {

    public static void main(String[] args) {
        String[] fruits = {"Apple", "Strawberries", "Banana", "Peach", "Kiwi"};

        printTheFruitsArray(fruits);

        Arrays.sort(fruits);
        printTheFruitsArray(fruits);
        System.out.print("Banana = " + Arrays.binarySearch(fruits, "Banana"));

        System.out.println("\n\nReversing the Sorting");
        ReverseSort reverseSort = new ReverseSort();
        Arrays.sort(fruits, reverseSort);
        printTheFruitsArray(fruits);
        System.out.println("Banana = " + Arrays.binarySearch(fruits, "Banana"));
        System.out.println("Banana = " + Arrays.binarySearch(fruits, "Banana", reverseSort));
    }

    public static void printTheFruitsArray(String[] fruits) {
        for(String s : fruits) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static class ReverseSort implements Comparator<String> {

        @Override
        public int compare(String first, String second) {
            return second.compareTo(first);
        }
    }

}
