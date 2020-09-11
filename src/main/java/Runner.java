

public class Runner {
    public static void main(String[] args) {
        Runner runner = new Runner();
        CocaCola coke = new CocaCola('M', 100);
        if(coke.isDrinkable()) {
            if (coke.toxicity < Drinkable.SAFE) {
                System.out.println("Take a huge sip of coke");
            } else if (coke.toxicity < Drinkable.DANGEROUS) {
                System.out.println("Take a small sip of coke");
            } else {
                System.out.println("DON'T DRINK");
            }
        }

        Gasoline gasoline = new Gasoline("gazUp", true, 90);
        // Cannot assign a value to final variable 'SAFE'
        // System.out.println(gasoline.SAFE = 32);

    }

}
