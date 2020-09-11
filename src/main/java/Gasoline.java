public class Gasoline implements Drinkable {
    String brandName;
    boolean isBio;
    int toxicity;

    public Gasoline(final String brandName, final boolean isBio, final int toxicity) {
        this.brandName = brandName;
        this.isBio = isBio;
        this.toxicity = toxicity;
    }

    @Override
    public boolean isDrinkable() {
        return true;
    }

    /**
     * TRY TO REMOVE THE PUBLIC IN FRONT OF THE METHOD
     *
     * @param toxicity
     */
    @Override
    public void setToxicity(final int toxicity) {
        this.toxicity = toxicity;
    }
}
