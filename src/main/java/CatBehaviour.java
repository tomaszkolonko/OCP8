public interface CatBehaviour {

    void eat();

    default void cuddleWithOwner() {
        System.out.println("Cuddle With Owner in a cat way");
    }
}
