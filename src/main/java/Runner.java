import car.Audi;
import car.OtherRunner;
import special.SpecialPerson;

public class Runner {

    public static void main(String[] args) {

        System.out.println("CAR EXAMPLE");
        Audi audi = new Audi(4);
        audi.tryOut();

        System.out.println("\n\nPERSON EXAMPLE:");
        SpecialPerson specialPerson = new SpecialPerson(123, 2);
        specialPerson.tryOut();

        // Der Ort des Aufrufes spielt eine Rolle, audi ist ja IMMER im packageOne da die
        // Klasse auch im packageOne ist, somit macht die andere Überlegung, dass es drauf
        // an kommt ob das OBJECT im package ist oder nicht, keinen Sinn.
        // audi.protectedTryOut();
        System.out.println("\n\nSPECIAL CAR EXAMPLE WITH PROTECTED METHOD");
        OtherRunner otherRunner = new OtherRunner();
        otherRunner.proxyForAudi(audi);
        otherRunner.proxyCreateNewAudi();


    }

}
