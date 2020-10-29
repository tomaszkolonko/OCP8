import java.util.Random;
import java.util.function.Predicate;

public class Runner {

    public static void main(String[] args) {
        int magicNumber = 42;

        Laptop lenovo = new Laptop("Lenovo X1", 4);
        Laptop macBook = new Laptop("MacBook Pro", 3);

        Predicate<Laptop> predicateSBB = d -> d.getNumberOfPorts() < 4;
        Company company = new Company("SBB");
//        Company company = new Company("SBB", d -> d.getNumberOfPorts() < 4);
        System.out.println("SBB needs additional Hub for Lenovo: " + predicateSBB.test(lenovo));
        System.out.println("SBB needs additional Hub for MacBook: " + predicateSBB.test(macBook));

        System.out.println("\n===========================\n");

        Predicate<Laptop> predicateBLS = d -> d.getNumberOfPorts() < 5;
        Company companyOther = new Company("SBB");
//        Company companyOther = new Company("BLS", d -> d.getNumberOfPorts() < 5);
        System.out.println("BLS needs additional Hub for Lenovo: " + predicateBLS.test(lenovo));
        System.out.println("BLS needs additional Hub for MacBook: " + predicateBLS.test(macBook));

        System.out.println("\n===========================\n");

        // magicNumber needs to be final or effectively final
        company.setFortuneTeller(() -> {
//            int magicNumber = 112;
            System.out.println("magic number is: " + magicNumber);
            int r = new Random().nextInt();
            System.out.println("random number is: " + r);
            if(r < magicNumber) {
                return "probably yes";
            }
            return "probably no";
        });

        System.out.println("Will the ports even work? : " + company.willItEvenWork());



    }
}
