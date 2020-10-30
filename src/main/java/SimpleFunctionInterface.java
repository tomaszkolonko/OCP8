import java.util.function.BiFunction;
import java.util.function.Function;

public class SimpleFunctionInterface {
    public static void main(String[] args) {
        Function<Integer, String> answer = a -> {
            if(a == 42) {
                return "forty-two";
            } else {
                return "no answer, sorry...";
            }
        };

        System.out.println(answer.apply(31));
        System.out.println(answer.apply(42));

        System.out.println("\n==============================\n");

        BiFunction<String, String, String> fullName = (first, last) -> "This is your full name: " + first + ", " + last;
        System.out.println(fullName.apply("Peter", "Pan"));

    }
}
