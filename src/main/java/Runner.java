import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.useLists();
        runner.useSets();
        runner.useMaps();
    }

    public void useLists() {
        List<Dog> listOfDogs = new ArrayList<>();
        // keep the reference dogPeter
        Dog dogPeter = new Dog("Peter");
        listOfDogs.add(dogPeter);
        listOfDogs.add(new Dog("Maxi"));
        listOfDogs.add(new Dog("Martin"));

        // iterator with generics
        Iterator<Dog> iterator = listOfDogs.iterator();

        while(iterator.hasNext()) {
            Dog dog = iterator.next();
            System.out.println(dog.getName());
        }

        // regular list methods
        System.out.println("size: " + listOfDogs.size());
        System.out.println("get dog at index 1: " + listOfDogs.get(1));
        System.out.println("Martin's index: " + listOfDogs.indexOf(dogPeter));

        listOfDogs.remove(dogPeter);

        Object[] listOfObjects = listOfDogs.toArray();
        for(Object object : listOfObjects) {
            Dog dog = (Dog) object;
            System.out.println(dog);
        }

        // iterator without generics
        Iterator someIterator = listOfDogs.iterator();
        Dog nextDog = (Dog)someIterator.next();
        System.out.println(nextDog);

        System.out.println("\n=====================\n");
    }

    public void useSets() {
        boolean[] resultArray = new boolean[5];

        Set set = new HashSet();

        // If you want a sorted Set, you need to have elements
        // that are mutually comparable
//        Set set = new TreeSet();

        resultArray[0] = set.add("a");
        resultArray[1] = set.add(new Integer(3));
        resultArray[2] = set.add("a");
        resultArray[3] = set.add("b");
        resultArray[4] = set.add(new Object());

        for(int x = 0; x < resultArray.length; x++) {
            System.out.println(resultArray[x] + " ");
        }
        System.out.println();
        for(Object o : set) {
            System.out.println(o + " ");
        }
        System.out.println("\n=====================\n");
    }

    public void useMaps() {
        Map<Object, Object> myMap = new HashMap<>();

        myMap.put("k1", new Dog("Peter"));
        myMap.put("k2", Pets.DOG);
        myMap.put(Pets.CAT, "CAT key");
        Dog dog1 = new Dog("Maxi");
        myMap.put(dog1, "Dog key");
        myMap.put(new Cat(), "Cat key");

        System.out.println(myMap.get("k1"));
        String k2 = "k2";
        System.out.println(myMap.get(k2));
        Pets pets = Pets.CAT;
        System.out.println(myMap.get(pets));
        System.out.println(myMap.get(dog1));
        System.out.println(myMap.get(new Cat()));
        System.out.println(myMap.size());

        // changing the objects value which is used as a key will lead to the object
        // not being able to be found
        dog1.setName("Edward");
        System.out.println(myMap.get(dog1));

        System.out.println("\n=====================\n");
    }

}
