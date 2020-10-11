import java.util.ArrayList;
import java.util.List;

public class TheBasicStuff {

    public static void main(String[] args) {
        TheBasicStuff theBasicStuff = new TheBasicStuff();
        
        theBasicStuff.introToBasics();
        System.out.println("\n=======================\n");
        theBasicStuff.autoboxing();
        System.out.println("\n=======================\n");
        theBasicStuff.constantPool();

    }

    public void introToBasics() {
        // pre java 5
        List myOldPreJava5List = new ArrayList();

        myOldPreJava5List.add("apple");
        myOldPreJava5List.add("banana");
        myOldPreJava5List.add("peach");

        // as of java 5 with generics
        List<String> myList = new ArrayList<>();

        String myString = "cous";

        myList.add("Hello");
        myList.add(myString);
        myList.add(myString + myString);
        System.out.println(myList.size());
        System.out.println(myList.contains("beans"));
        System.out.println(myList.contains("couscous"));
        myList.remove("Hello");
        myList.remove(myString);
        System.out.println(myList.size());

        myList.addAll(myOldPreJava5List);

        for(String s : myList) {
            System.out.println("*** " + s);
        }
    }

    public void autoboxing() {
        // In general collections can hold only objects and no primitives
        // which is an amazing use of wrappers

        // pre Java 5
        Integer y = new Integer(123);
        int x = y.intValue();
        x++;
        y = new Integer(x);
        System.out.println(y);

        // as of java 5 the autoboxing happens automatically, it's not
        // the refernce of the object being incremented as you might think
        Integer a = new Integer(123);
        System.out.println(++a);
    }

    public void constantPool() {
        Integer i1 = new Integer(42);
        Integer i2 = new Integer(42);

        System.out.println("i1 == i2 \t\t" + (i1 == i2));
        System.out.println("i1.equals(i2) \t" + i1.equals(i2));

        System.out.println("------");

        Integer i3 = 42;
        Integer i4 = 42;

        System.out.println("i3 == i4 \t\t" + (i3 == i4));
        System.out.println("i3.equals(i4) \t" + i3.equals(i4));

        System.out.println("------");

        Integer b6 = new Integer(234);
        Integer b7 = new Integer(234);

        System.out.println("b6 == b7 \t\t" + (b6 == b7));
        System.out.println("b6.equals(b7) \t" + b6.equals(b7));

    }

}
