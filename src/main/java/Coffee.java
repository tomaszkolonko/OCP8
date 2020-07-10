import enumPackage.Decoration.CrazyPublicDecoration;
// import enumPackage.DefaultEnum; doesn't work
import enumPackage.PublicEnum;

public class Coffee {
    private CoffeeSize size;
    private FairTradeLabel fairTradeLabel;
    private CrazyPublicDecoration deco;
    // private DefaultEnum defaultEnum; // doesn't work
    private PublicEnum publicEnum;

    enum FairTradeLabel {
        NOT_FAIR, FAIR, SUPER_FAIR
    }

    public Coffee(CoffeeSize size, FairTradeLabel label) {
        this.size = size;
        this.fairTradeLabel = label;
    }

    public void decorateYourCoffee(CrazyPublicDecoration deco) {
        this.deco = deco;
    }

    @Override
    public String toString() {
        String summary = "You got a " + size + " coffe which was produced: " + fairTradeLabel;
        summary = addDecorationIfExists(summary);

        return summary;
    }

    private String addDecorationIfExists(String summary) {
        if(deco != null) {
            summary += " and " + deco + " decoration";
        } else {
            summary += " and no decoration";
        }
        return summary;
    }


}
