

public class Company {
    private String companyName;
    private FortuneTeller fortuneTeller;

    public Company(String companyName) {
        this.companyName = companyName;
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
