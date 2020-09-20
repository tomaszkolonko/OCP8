public class Runner {

    public static void main(String[] args) {
        try(ExceptionOne exceptionOne = new ExceptionOne(); ExceptionTwo exceptionTwo = new ExceptionTwo()) {
            throw new Exception("Try");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            for(Throwable throwable : e.getSuppressed()) {
                System.err.println("suppressed: " + throwable);
            }
        }
    }

}
