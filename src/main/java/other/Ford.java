package other;

import car.Audi;
import car.Car;

/**
 * Be aware that other.Ford is in another package than Car !!
 * But public and protected instance variables of Car are inherited and available here
 */
public class Ford extends Car  {

    public Ford(final int numberOfTires) {
        super(numberOfTires);
    }

    public void tryOut() {
        System.out.println("From inside other.Ford (public variable): " + publicString);
        System.out.println("From inside other.Ford (protected variable): " + protectedString);
//        System.out.println("From inside other.Ford (protected variable): " + privateString);

        Car car = new Car(4);
        System.out.println(car.publicString);
        // You cannot call protected or private instance variables form another package on
        // a reference variable !!!
//        System.out.println(car.protectedString);
//        System.out.println(car.privateString);

        Audi audi = new Audi(4);
        System.out.println(audi.publicString);
//        System.out.println(audi.protectedString);
//        System.out.println(audi.privateString);
    }
}
