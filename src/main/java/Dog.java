public class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if((object instanceof Dog) && ((Dog) object).name == this.name) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return name.length();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
