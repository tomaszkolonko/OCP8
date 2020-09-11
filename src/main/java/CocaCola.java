public class CocaCola implements Drinkable {
    char size;
    int toxicity;

    CocaCola(char size, int toxicity) {
        this.size = size;
        this.toxicity = toxicity;
    }

    @Override
    public boolean isDrinkable() {
        return true;
    }

    @Override
    public void setToxicity(final int toxicity) {
        this.toxicity = toxicity;
    }

    public int getToxicity() {
        return toxicity;
    }
}
