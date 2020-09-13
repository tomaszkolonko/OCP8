

public class ReferenceType {
    public static void main(String[] args) {
        Animal dog = new Dog(23);
        Animal fish = new Fish(22);

        System.out.println("Dog is: " + dog.getAge());
//        dog.cuddleWithOwner();

        fish.setAge(100);
        System.out.println("Fish is: " + fish.getAge());
//        fish.swimAwayFromShark();

        Animal[] myAnimals = new Animal[2];
        myAnimals[0] = dog;
        myAnimals[1] = fish;

        for(int i = 0; i < myAnimals.length; i++) {
            myAnimals[i].move();
//            myAnimals[i].cuddleWithOwner();
        }
    }
}

class Animal {
    private int age;

    public Animal(int age) { this.age = age; }

    public void move() {
        System.out.println("animal is moving around");
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }
}

class Dog extends Animal {

    public Dog(int age) { super(age); }

    @Override
    public void move() {
        System.out.println("dog is moving around");
    }

    public void cuddleWithOwner() {
        System.out.println("Cuddling with the Owner");
    }
}

class Fish extends Animal {

    public Fish(int age) { super(age); }

    @Override
    public void move() {
        System.out.println("fish is swimming around");
    }

    public void swimAwayFromShark() {
        System.out.println("Fleeing from Shark");
    }
}
