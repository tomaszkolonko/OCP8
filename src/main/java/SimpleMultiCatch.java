import static java.lang.Thread.sleep;
import java.util.Random;

public class SimpleMultiCatch {
    public static void main(String[] args) throws ExceptionOne, ExceptionTwo {
        SimpleMultiCatch simpleMultiCatch = new SimpleMultiCatch();
        // simpleMultiCatch.catchOneException();
        simpleMultiCatch.catchSomeExceptions();
    }

    // Example with two different exceptions

    private void catchSomeExceptions() {
        try {
            throwSomeExceptions();
        } catch (Exception e) {
            System.out.println("catching a wild card exception???");
            e.printStackTrace();

            UtilityClass.sleepForASecond();

            e = new ExceptionThree();
            e.printStackTrace();
        }
    }

    private void throwSomeExceptions() throws ExceptionOne, ExceptionTwo {
        Random random = new Random();
        if(random.nextBoolean()) {
            throw new ExceptionOne();
        } else {
            throw new ExceptionTwo();
        }
    }

    // Example with only one exception

    private void catchOneException() {
        try {
            throwASingelException();
        } catch (Exception e) {
            System.out.println("exception before new assignment:");
            e.printStackTrace();

            UtilityClass.sleepForASecond();

            e = new ExceptionTwo(); // !!!!!

            System.out.println("exception after new assignment:");
            e.printStackTrace();
        }
    }

    private void throwASingelException() throws ExceptionOne {
        throw new ExceptionOne();
    }

}
