import enumPackage.Decoration.CrazyPublicDecoration;

public class Consumer {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.getCoffee();
    }

    public void getCoffee() {
        Coffee coffee = new Coffee(CoffeeSize.LARGE, Coffee.FairTradeLabel.FAIR);
        System.out.println(coffee);
        coffee.decorateYourCoffee(CrazyPublicDecoration.CHOCOLATE);
        System.out.println(coffee);
    }

}
