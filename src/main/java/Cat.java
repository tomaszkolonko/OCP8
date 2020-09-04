public class Cat extends Animal {
    int fightFactor;

    public Cat(final int fightFactor) {
        super("Cat");
        this.fightFactor = fightFactor;
    }

    public int getFightFactor() {
        return fightFactor;
    }

    public void setFightFactor(final int fightFactor) {
        this.fightFactor = fightFactor;
    }
}
