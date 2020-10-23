import enumPackage.Decoration.CrazyPublicDecoration;
import enumPackage.PublicEnum;

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

        System.out.println("\n==========================\n");

        System.out.println(CoffeeSize.HUGE);
//        System.out.println(Decoration.CrazyDefaultDecoration);
        System.out.println(CrazyPublicDecoration.JELLYFISH);
//        System.out.println(DefaulEnum);
        System.out.println(PublicEnum.PUBLIC_ONE);
    }

}
