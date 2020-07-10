package personpackage;

import carpackage.BMW;
import carpackage.BMWextended;

public class BMWconvertible extends BMW {

    public BMWconvertible(int power, boolean electric, int priceTag) {
        super(power, electric, priceTag);
    }

    public static void main(String[] args) {
        BMWconvertible convertible = new BMWconvertible(123, true, 9_999_999);
        // Gets the printStringProtectedAccess by INHERITANCE !!!!
        System.out.println(convertible.printStringProtectedAccess());

        // 'printStringDefaultAccess()' is not public in 'carpackage.BMW'. Cannot be accessed from outside package
        // X-X-X System.out.println(convertible.printStringDefaultAccess());

        BMWextended extended = new BMWextended(123, true, 8_888_888);
        // Since no inheritance takes place here, printStringProtectedAccess is not callable
        // X-X-XSystem.out.println(extended.printStringProtectedAccess());
    }
}
