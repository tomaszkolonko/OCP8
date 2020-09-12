package car;

/**
 * Play around by changing public, default and private modifiers of the class and of class members and
 * especially of class member methods, don't forge to play with super
 */
public class Audi extends Car {

    public Audi(final int numberOfTires) {
        super(numberOfTires);
    }

    public void tryOut() {
        System.out.println(publicString);
        System.out.println(protectedString);
//        System.out.println(privateString);

        Car car = new Car(5);
        System.out.println(car.publicString);
        System.out.println(car.protectedString);
//        System.out.println(car.privateString);
    }
}
