import java.util.HashMap;
import java.util.Map;

public class Runner {
    Person john = new Person("John", "Meier", 22);
    Person john2 = new Person("John", "Meier", 139);
    Person jolanda = new Person("Jolanda", "Liechti", 66);
    Person peter = new Person("Peter", "Iten", 52);
    Person maria = new Person("Maria", "Lopez", 48);
    Person steffanie = new Person("Steffanie", "Fuchs", 32);
    Person bruna = new Person("Brunhilde", "Fuchs", 322);


    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.simpleEquals();
        runner.hashCodeExample();
        runner.anotherHashCodeExample();
    }

    private void simpleEquals() {
        System.out.println("john.equals(john) \t" + john.equals(john));
        System.out.println("john.equals(john2) \t" + john.equals(john2));
        System.out.println("hashCode of john \t" + john.hashCode());
        System.out.println("hashCode of john2 \t" + john2.hashCode());
        System.out.println("john == john2 \t\t" + (john == john2));
        System.out.println("\n ---------------------------- \n");
    }

    private void hashCodeExample() {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(john.hashCode(), john);
        personMap.put(john2.hashCode(), john2);
        personMap.put(jolanda.hashCode(), jolanda);
        personMap.put(peter.hashCode(), peter);
        personMap.put(maria.hashCode(), maria);
        personMap.put(steffanie.hashCode(), steffanie);
        personMap.put(bruna.hashCode(), bruna);

        Person steffanieToBeSearched = new Person("Steffanie", "Fuchs", 32);

        System.out.println(steffanie);
        System.out.println(steffanieToBeSearched);

        System.out.println("steff.equals(steffToBeSearched): " + steffanie.equals(steffanieToBeSearched));
        System.out.println();

        Person foundPerson = personMap.get(steffanieToBeSearched.hashCode());
        System.out.println("Steffanie found: " + foundPerson);
        System.out.println("hashCode of Steffanie: " + steffanie.hashCode());
        System.out.println("hashCode of second Steffanie: " + steffanieToBeSearched.hashCode());
        System.out.println("\n ---------------------------- \n");
    }

    private void anotherHashCodeExample() {
        Map<Person, Integer> personIntegerHashMap = new HashMap<>();
        personIntegerHashMap.put(john, john.hashCode());
        personIntegerHashMap.put(john2, john2.hashCode());
        personIntegerHashMap.put(jolanda, jolanda.hashCode());
        personIntegerHashMap.put(peter, peter.hashCode());
        personIntegerHashMap.put(maria, maria.hashCode());
        personIntegerHashMap.put(steffanie, steffanie.hashCode());
        personIntegerHashMap.put(bruna, bruna.hashCode());

        Person steffanieToBeSearched = new Person("Steffanie", "Fuchs", 32);

        System.out.println(steffanie);
        System.out.println(steffanieToBeSearched);

        System.out.println("steff.equals(steffToBeSearched): " + steffanie.equals(steffanieToBeSearched));
        System.out.println();

        Integer foundPersonHash = personIntegerHashMap.get(steffanieToBeSearched);
        System.out.println("Steffanie's Hash found: " + foundPersonHash);
        System.out.println("hashCode of second Steffanie: " + steffanieToBeSearched.hashCode());
        System.out.println("\n ---------------------------- \n");
    }
}
