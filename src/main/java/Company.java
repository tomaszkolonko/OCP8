import java.util.function.Predicate;

public class Company {
    private String companyName;
    private Predicate<Laptop> predicate;
    private FortuneTeller fortuneTeller;

//    public Company(String companyName, HubChecker hubChecker) {
//        this.companyName = companyName;
//        this.hubChecker = hubChecker;
//    }

    public Company(String companyName) {
        this.companyName = companyName;
        this.predicate = this.predicate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public FortuneTeller getFortuneTeller() {
        return fortuneTeller;
    }

    public void setFortuneTeller(FortuneTeller fortuneTeller) {
        this.fortuneTeller = fortuneTeller;
    }

    public String willItEvenWork() {
        return fortuneTeller.willItWork();
    }


}
