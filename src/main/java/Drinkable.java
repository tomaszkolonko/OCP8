public abstract interface Drinkable {

    // Modifiers redundant
    public static final int SAFE = 40;
    public static final int DANGEROUS = 70;
    public static final int DEADLY = 100;

    // Modifiers redundant
    public abstract boolean isDrinkable();
    void setToxicity(int toxicity);

}
