package car;

/**
 * Play around by changing public, default and private modifiers of the class and of class members and
 * especially of class member methods, don't forge to play with super
 */
public class Car {
    private int numberOfTires;
    public String publicString = "public string in Car";
    protected String protectedString = "protected string in Car";
    private String privateString = "private string in Car";


    public Car(final int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    public int getNumberOfTires() {
        return numberOfTires;
    }

    public void setNumberOfTires(final int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    void driveForward() {
        System.out.println("Driving forward");
    }
}
