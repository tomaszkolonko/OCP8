package car;

import other.Ford;
import other.SubFord;

public class SubAudi extends Audi {
    public SubAudi(final int numberOfTires) {
        super(numberOfTires);
    }

    public void tryOutSubAudi() {
        System.out.println(publicString);
        System.out.println(protectedString);
//        System.out.println(privateString);
    }

    public void instantiateOutsideOfPackage() {
        Ford ford = new Ford(4);
        System.out.println(ford.publicString);
        // Since we are in the package car where the car class resides (where the protected members are defined)
        // you are allowed to call the protected instance variable on a reference of an outside-the-package object
        System.out.println(ford.protectedString);

        SubFord subFord = new SubFord(4);
        System.out.println(subFord.publicString);
        // Since we are in the package car where the car class resides (where the protected members are defined)
        // you are allowed to call the protected instance variable on a reference of an outside-the-package object
        System.out.println(subFord.protectedString);
    }
}
