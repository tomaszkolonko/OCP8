import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TheSortingStuff {
    Person[] personArray;
    List<Person> personList;

    public static void main(String[] args) {
        TheSortingStuff runner = new TheSortingStuff();
        runner.populateArrayAndList();

        // Sorting with Arrays
        runner.printArray();
        runner.sortArrayByDefaultAndPrint();
        runner.sortArrayByPhoneAndPrint();
        runner.sortArrayByRegionAndPrint();

        // Sorting with Lists
        runner.printList();
        runner.sortListByDefaultAndPrint();
        runner.sortListByPhoneAndPrint();
        runner.sortListByRegionAndPrint();

    }

    private void printArray() {
        for(Person person : personArray) {
            System.out.println(person);
        }
        System.out.println("\n====================\n");
    }

    private void sortArrayByDefaultAndPrint() {
        Arrays.sort(personArray);
        printArray();
    }

    private void sortArrayByPhoneAndPrint() {
        Arrays.sort(personArray, new SortByPhone());
        printArray();
    }

    private void sortArrayByRegionAndPrint() {
        Arrays.sort(personArray, (p1, p2) -> p1.getRegion().compareTo(p2.getRegion()));
        printArray();
    }

    private void printList() {
        for(Person person : personList) {
            System.out.println(person);
        }
        System.out.println("\n====================\n");
    }

    private void sortListByDefaultAndPrint() {
        Collections.sort(personList);
        printList();
    }

    private void sortListByPhoneAndPrint() {
        Collections.sort(personList, new SortByPhone());
        printList();
    }

    private void sortListByRegionAndPrint() {
        Collections.sort(personList, (p1, p2) -> p1.getRegion().compareTo(p2.getRegion()));
        printList();
    }

    private void populateArrayAndList() {
        Person p1 = new Person("Peter", "Amherd", "Bern", "0792947728");
        Person p2 = new Person("Julia", "Iten", "Luzern", "0781527781");
        Person p3 = new Person("Sandra", "Brunner", "Fribourg", "0776398112");
        Person p4 = new Person("Moritz", "Vielle", "Biel", "0796755223");
        Person p5 = new Person("Max", "Goethe", "Zürich", "0787777448");

        personArray = new Person[] {p1, p2, p3, p4, p5};
        personList = new ArrayList<Person>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        System.out.println("\n====================\n");

    }

    class SortByPhone implements Comparator<Person> {
        @Override
        public int compare(final Person p1, final Person p2) {
            return p1.getPhone().compareTo(p2.getPhone());
        }
    }

}
