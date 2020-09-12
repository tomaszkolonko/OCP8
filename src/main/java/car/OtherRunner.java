package car;

public class OtherRunner {
    // calling protectedTryOut() from another class NOT inside the car package on the same
    // object didn't work, but now works on the EXACT same object !!! The important part
    // to understand is the the calling class must be within the package in order to call
    // its package-private methods / members.
    public void proxyForAudi(Car car) {
        System.out.println("*** proxyForAudi ***");
        car.driveForward();
        if(car instanceof Audi) {
            ((Audi) car).tryOut();
            ((Audi) car).protectedTryOut();
        }
    }

    public void proxyCreateNewAudi() {
        System.out.println("*** proxyForCreateNewAudi ***");
        Audi audi = new Audi(4);
        audi.tryOut();
        audi.protectedTryOut();
    }
}
