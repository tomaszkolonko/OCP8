public interface DogBehaviour {

    void eat();

    default void cuddleWithOwner() {
        System.out.println("Cuddle With Owner in a dog way");
    }
}
