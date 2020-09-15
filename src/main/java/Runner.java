public class Runner {

    public static void main (String[] args) throws ExceptionTwo {

        try {
            if(true) {
                throw new ExceptionOne();
            } else {
                throw new ExceptionTwo();
            }
        } catch (ExceptionOne e) {
            System.out.println("Exception One was caught");
            if(true) {
                throw new ExceptionTwo();
            }
        } catch (ExceptionTwo exceptionTwo) {
            System.out.println("Exception Two was caught");
        } finally {
            System.out.println("within the finally block");
        }

        System.out.println("Outside try-catch block");
    }

}
