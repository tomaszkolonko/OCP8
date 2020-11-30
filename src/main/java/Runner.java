import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Runner {

    public static void main(String[] args) {
        List<Reading> readings = Arrays.asList(new Reading(2020, 10, 1, 8.2),
                new Reading(2020, 10, 3, 12.9),
                new Reading(2020, 10, 5, 4.4),
                new Reading(2020, 10, 8, 234.4),
                new Reading(2020, 10, 13, 10.7),
                new Reading(2020, 10, 15, 9.9),
                new Reading(2020, 10, 19, 8.2),
                new Reading(2020, 10, 22, 3.9),
                new Reading(2020, 10, 26, 5.6),
                new Reading(2020, 10, 28, 8.5));


        // Calculating the average of the readings

        OptionalDouble average = readings
                .stream()
                .mapToDouble(reading -> reading.value)
                .filter(reading -> reading > -10 && reading < 50)
                .average();

        if (average.isPresent()) {
            System.out.println("The average temperature in october was: " + average.getAsDouble());
        } else {
            System.out.println("Empty optional!");
        }


        // Calculating the maximum of the readings

        OptionalDouble maximum = readings
                .stream()
                .mapToDouble(reading -> reading.value)
                .filter(reading -> reading > -10 && reading < 50)
                .max();

        if (maximum.isPresent()) {
            System.out.println("The maximum temperature in october was: " + maximum.getAsDouble());
        } else {
            System.out.println("Empty optional!");
        }


        // Calculating the minimum of the readings

        OptionalDouble minimum = readings
                .stream()
                .mapToDouble(reading -> reading.value)
                .filter(reading -> reading > -10 && reading < 50)
                .average();

        if (minimum.isPresent()) {
            System.out.println("The minimum temperature in october was: " + minimum.getAsDouble());
        } else {
            System.out.println("Empty optional!");
        }


        // Calculating the sum of the readings

        double sum = readings
                .stream().mapToDouble(reading -> reading.value)
                .filter(reading -> reading > -10 && reading < 50)
                .sum();

        System.out.println("The sum temperature in october was: " + sum);


        // Calculating the sum of the readings with own reduce implementation

        OptionalDouble sum2 = readings
                .stream().mapToDouble(reading -> reading.value)
                .filter(reading -> reading > -10 && reading < 50)
                .reduce((one, two) -> one + two);

        if(sum2.isPresent()) {
            System.out.println("The sum temperature in october was: " + sum2.getAsDouble());
        } else {
            System.out.println("Empty optional!");
        }
    }

}
