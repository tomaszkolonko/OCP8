package model;

/**
 * Prevent other people to inherit from BWM by making it final.
 */
public final class BMW extends Car {
    private String model;
    private int horsepower;
    private boolean convertibla;

    public BMW(final double price, final int year, final String model, final int horsepower, final boolean convertibla) {
        super(price, year);
        this.model = model;
        this.horsepower = horsepower;
        this.convertibla = convertibla;
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerates super fast");
    }

    @Override
    public void turn() {
        System.out.println("Turns by its own");
    }
}
