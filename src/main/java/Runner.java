import car.Audi;
import special.SpecialPerson;

public class Runner {

    public static void main(String[] args) {

        System.out.println("CAR EXAMPLE");
        Audi audi = new Audi(4);
        audi.tryOut();

        System.out.println("\n\nPERSON EXAMPLE:");
        SpecialPerson specialPerson = new SpecialPerson(123, 2);
        specialPerson.tryOut();


    }

}
