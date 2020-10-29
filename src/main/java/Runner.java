import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        int magicNumber = 42;

        Laptop lenovo = new Laptop("Lenovo X1", 4);
        Laptop macBook = new Laptop("MacBook Pro", 3);

        Company company = new Company("SBB", d -> d.getNumberOfPorts() < 4);
        System.out.println("SBB needs additional Hub for Lenovo: " + company.checkIfLaptopNeedsHub(lenovo));
        System.out.println("SBB needs additional Hub for MacBook: " + company.checkIfLaptopNeedsHub(macBook));

        System.out.println("\n===========================\n");

        Company companyOther = new Company("BLS", d -> d.getNumberOfPorts() < 5);
        System.out.println("BLS needs additional Hub for Lenovo: " + companyOther.checkIfLaptopNeedsHub(lenovo));
        System.out.println("BLS needs additional Hub for MacBook: " + companyOther.checkIfLaptopNeedsHub(macBook));

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
