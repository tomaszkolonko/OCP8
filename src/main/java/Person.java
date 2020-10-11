public class Person implements Comparable<Person> {
    String firstName;
    String lastName;
    String region;
    String phone;

    public Person(final String firstName, final String lastName, final String region, final String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = region;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(final Person person) {
        return this.firstName.compareTo(person.getFirstName());
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + ", " + this.region + ", phone: " + this.phone;
    }
}
