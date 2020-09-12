package other;

public class SubFord extends Ford {
    public SubFord(final int numberOfTires) {
        super(numberOfTires);
    }
    public void tryOutSubFord() {
        System.out.println(publicString);
        System.out.println(protectedString);
//        System.out.println(privateString);

        Ford ford = new Ford(4);
        System.out.println(ford.publicString);
        /**
         * BE EXTRA CAREFUL HERE:
         * Once the subclass-outside-the-package inherits the protected member, that member
         * becomes private to any code outside the subclass, with the exception of
         * subclasses of the subclass
         */
        System.out.println(ford.protectedString);
    }
}
