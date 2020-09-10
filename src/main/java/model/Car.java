package model;

abstract class Car {
    private double price;
    private int year;

    public Car(final double price, final int year) {
        this.price = price;
        this.year = year;
    }

    public abstract void accelerate();
    public abstract void turn();

    public void fillUp() {
        System.out.println("Tank has been filled up");
    }
}
