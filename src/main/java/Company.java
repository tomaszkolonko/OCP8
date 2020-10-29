public class Company {
    private String companyName;
    private HubChecker hubChecker;
    private FortuneTeller fortuneTeller;

    public Company(String companyName, HubChecker hubChecker) {
        this.companyName = companyName;
        this.hubChecker = hubChecker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public HubChecker getHubChecker() {
        return hubChecker;
    }

    public void setHubChecker(HubChecker hubChecker) {
        this.hubChecker = hubChecker;
    }

    public FortuneTeller getFortuneTeller() {
        return fortuneTeller;
    }

    public void setFortuneTeller(FortuneTeller fortuneTeller) {
        this.fortuneTeller = fortuneTeller;
    }

    // Returns true if laptop has not enough ports available
    public boolean checkIfLaptopNeedsHub(Laptop laptop) {
        return hubChecker.checkIfHubNeeded(laptop);
    }

    public String willItEvenWork() {
        return fortuneTeller.willItWork();
    }


}
