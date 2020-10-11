import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TheSortingStuffOnList {
    List<Person> myPersonList;

    public static void main(String[] args) {
        TheSortingStuffOnList runner = new TheSortingStuffOnList();
        runner.populateArrayAndList();

        runner.sortList();
    }

    public void sortList()  {
        printList();
        SortByPhone sortByPhone = new SortByPhone();
        myPersonList.sort(sortByPhone);
        printList();
        myPersonList.sort((a, b) -> a.getRegion().compareTo(b.getRegion()));
        printList();
    }

    public void populateArrayAndList() {
        Person p1 = new Person("Peter", "Amherd", "Bern", "0792947728");
        Person p2 = new Person("Julia", "Iten", "Luzern", "0781527781");
        Person p3 = new Person("Sandra", "Brunner", "Fribourg", "0776398112");
        Person p4 = new Person("Moritz", "Vielle", "Biel", "0796755223");
        Person p5 = new Person("Max", "Goethe", "Zürich", "0787777448");

        // populate the ArrayList of persons
        myPersonList = new ArrayList<>();
        myPersonList.add(p1);
        myPersonList.add(p2);
        myPersonList.add(p3);
        myPersonList.add(p4);
        myPersonList.add(p5);
        System.out.println("\n====================\n");

    }

    private void printList() {
        for(Person person : myPersonList) {
            System.out.println(person);
        }
        System.out.println("\n====================\n");
    }

    class SortByPhone implements Comparator<Person> {
        @Override
        public int compare(final Person p1, final Person p2) {
            return p1.getPhone().compareTo(p2.getPhone());
        }
    }
}
