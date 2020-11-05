import java.util.Optional;
import java.util.stream.Stream;

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.simpleExample();
        System.out.println("\n\n================================\n\n");
        runner.optionalWithObjects();
    }

    public void simpleExample() {
        Stream<Double> stream = Stream.of(1.0, 2.0, 3.0, 4.0);
        Optional<Double> num = stream.findFirst();
        if (num.isPresent()) {
            System.out.println("First number as Optional in stream: " + num);
            System.out.println("First number as primitive value: " + num.get());
        } else {
            System.out.println("empty stream");
        }


        // Emtpy stream
        Stream<Double> stream2 = Stream.of();
        Optional<Double> num2 = stream2.findFirst();
        if (num2.isPresent()) {
            System.out.println("First number as Optional in stream: " + num2);
            System.out.println("First number as primitive value: " + num2.get());
        } else {
            System.out.println("empty stream");
        }


        // isPresent() also takes a Consumer as an argument
        Stream<Double> stream3 = Stream.of(1.0, 2.0, 3.0, 4.0);
        Optional<Double> num3 = stream3.findFirst();
        // be careful about the name of this method: IFpresent(Consumer con)
        num3.ifPresent(number -> System.out.println("First number: " + number));
    }

    public void optionalWithObjects() {
        Dog dog = new Dog("Peter", 7, 6.2);
        Optional<Dog> optionalDog = Optional.of(dog);
        optionalDog.ifPresent(d -> System.out.println(d));

        Dog dog2 = null;
//        Optional<Dog> optionalDog1 = Optional.of(dog2);
//        optionalDog1.ifPresent(System.out::println);

        Optional<Dog> optionalDog1 = Optional.ofNullable(dog2);
        optionalDog1.ifPresent(System.out::println);

        // Create an empty Optional
        Optional<Dog> optionalDog2 = Optional.empty();
        Dog newDog = optionalDog2.orElse(new Dog("Default", 1, 1));
        System.out.println("New Dog created: " + newDog.getName() + " with weight set to " + newDog.getWeight() + " and age set to " + newDog.getAge());

    }


}
