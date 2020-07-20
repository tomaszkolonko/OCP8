public class CleanUp {
    public static void main(String[] args) {
        CleanUp cleanUp = new CleanUp();
        cleanUp.go();
    }

    public void go() {
        try(ResourceOne one = new ResourceOne(); ResourceTwo two = new ResourceTwo()) {
            System.out.println("TRY");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("CATCH");
        } finally {
            System.out.println("FINALLY");
        }
    }

}
