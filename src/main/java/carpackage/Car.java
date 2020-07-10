package carpackage;

public class Car {
    private int power;
    private boolean electric;

    public Car(int power, boolean electric) {
        this.power = power;
        this.electric = electric;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }
}
