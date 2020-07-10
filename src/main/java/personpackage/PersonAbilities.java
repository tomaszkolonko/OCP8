package personpackage;

interface PersonAbilities {

    public abstract void driveCar();
    public default void swim() {
        System.out.println("Person is swimming");
    }

    default void swimFast() {
        System.out.println("Person is swimming fast");
    }
}
