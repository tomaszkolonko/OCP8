package model;

public class Ford extends Car {
    private String model;

    public Ford(final double price, final int year, final String model) {
        super(price, year);
        this.model = model;
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerate slowly");
    }

    @Override
    public void turn() {
        System.out.println("Turn slowly");

    }
}
