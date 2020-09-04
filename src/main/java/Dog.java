public class Dog extends Animal {
    int happinessFactor;

    public Dog(final int happinessFactor) {
        super("Dog");
        this.happinessFactor = happinessFactor;
    }

    public int getHappinessFactor() {
        return happinessFactor;
    }

    public void setHappinessFactor(final int happinessFactor) {
        this.happinessFactor = happinessFactor;
    }
}
