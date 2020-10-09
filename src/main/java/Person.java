import java.util.Objects;

public class Person {
    private static int idCounter;

    private int personId;
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.personId = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // if (o instanceof Person) return false;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.firstName.equals(person.firstName) &&
                this.lastName.equals(person.lastName) &&
                this.age == person.age;
    }

    @Override
    public int hashCode() {
        // Hmmmm.... why is the object not found in the HashMap?
        return Objects.hash(personId, firstName, lastName, age);
    }

    // QUESTION: Can you come up with an example where the objectId should not be considered
    // in either hashCode() nor equals()?
}
