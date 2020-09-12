import car.Audi;
import car.SubAudi;
import other.Ford;
import other.SubFord;

public class Runner {

    public static void main(String[] args) {

        System.out.println("CAR EXAMPLE");
        Audi audi = new Audi(4);
        System.out.println("audi public string instance variabel: " + audi.publicString);
        // System.out.println("audi protected string instance variable: " + audi.protectedString);

        Ford ford = new Ford(4);
        System.out.println("audi public string instance variabel: " + ford.publicString);
        // System.out.println("audi protected string instance variable: " + ford.protectedString);

        ford.tryOut();


        // Subclasses
        audi.tryOut();

        SubAudi subAudi = new SubAudi(4);
        subAudi.tryOutSubAudi();

        SubFord subFord = new SubFord(4);
        subFord.tryOutSubFord();



    }

}
