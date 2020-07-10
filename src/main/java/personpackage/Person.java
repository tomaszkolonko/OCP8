package personpackage;

public class Person {
    private int age;
    private int sex;

    public Person(int age, int sex) {
        this.age = age;
        this.sex = sex;
    }

    public static String getHello() {
        return "Hello";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
