package carpackage;

public class BMW extends Car {
    private int priceTag;

    public BMW(int power, boolean electric, int priceTag) {
        super(power, electric);
        this.priceTag = priceTag;
    }

    public int getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(int priceTag) {
        this.priceTag = priceTag;
    }

    // default toString method
    String printStringDefaultAccess() {
        return "Default BMW to String";
    }

    // protected toString method
    protected String printStringProtectedAccess() {
        return "Protected BMW to String";
    }
}
