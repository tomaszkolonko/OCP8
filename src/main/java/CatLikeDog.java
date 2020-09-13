public class CatLikeDog extends Animal implements CatBehaviour, DogBehaviour {

    @Override
    public void eat() {
        System.out.println("Happy with meatballs or mice");
    }

    @Override
    public void cuddleWithOwner() {
        System.out.println("cudling like a CatLikeDog");
    }
}
