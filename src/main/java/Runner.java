import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.simpleConsumerExample();
        runner.displaySystemEnv();
        runner.usingForEach();
    }

    public void simpleConsumerExample() {
        Consumer<String> consumerOne = new Consumer<String>() {
            @Override
            public void accept(String s) {
                if(s.equalsIgnoreCase("dog")) {
                    System.out.println("This is a Dog");
                } else if (s.equalsIgnoreCase("Cat")) {
                    System.out.println("This is a Cat");
                } else {
                    System.out.println("It's from another planes");
                }
            }
        };

        consumerOne.accept("dog");

        System.out.println("\n====================\n");
    }

    public void displaySystemEnv() {
        Map<String, String> myEnv = System.getenv();

        BiConsumer<String, String> printEnv = (key, value) -> {
            System.out.println(key + " ----> " + value);
        };

        printEnv.accept("USERNAME", myEnv.get("USERNAME"));

        System.out.println("\n====================\n");
    }

    public void usingForEach() {
        List<String> listAnimals = Arrays.asList("Bird", "Tiger", "Fish", "Butterfly");
        Consumer<String> printName = name -> System.out.println(name);

        listAnimals.forEach(printName);

        System.out.println("\n====================\n");

        Map<String, String> myEnv = System.getenv();

        BiConsumer<String, String> printEnv = (key, value) -> {
            System.out.println(key + "  ~~~~~~~~~~~>  " + value);
        };

        myEnv.forEach(printEnv);


    }
}
