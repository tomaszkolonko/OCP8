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

        // what are the implications?
        driveForward();
        this.driveForward();

        super.driveForward();

        Car newCar = new Car(4);
        newCar.driveForward();
    }
}
