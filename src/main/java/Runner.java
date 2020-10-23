

public class Runner {

    public static void main(String[] args) {
        PetShop petShop = new PetShop();
        System.out.println(petShop.cat.getName());
        petShop.cat.testMe();

        System.out.println("\n\n===============================\n\n");

//        petShop.cat.printSecretTrick();
        petShop.classMethod();
    }

}

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void testMe() {
        System.out.println("TestMe::Cat");
    }
}

class PetShop {
    Cat cat = new Cat("Minzi") {
        private String secretTrick = "rolling on your back";

        @Override
        public void testMe() {
            System.out.println("TestMe::PetShop");
        }

        public void printSecretTrick() {
            System.out.println(secretTrick);
        }
    };

    public void classMethod() {
        System.out.println("Cat's name is: " + cat.getName());
//        cat.printSecretTrick();
        cat.testMe();
    }
}
