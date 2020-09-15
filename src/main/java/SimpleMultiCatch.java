import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class SimpleMultiCatch {
    public static void main(String[] args) {
        SimpleMultiCatch simpleMultiCatch = new SimpleMultiCatch();
        // simpleMultiCatch.catchOneException();
        simpleMultiCatch.catchSomeExceptions();
        System.out.println("\n");
        simpleMultiCatch.catchOneException();
    }

    // Example with two different exceptions

    private void catchSomeExceptions() {
        try {
            throwSomeExceptions();
        } catch (SQLException | IOException e) {
            System.out.println("catching a wild card exception???");
            e.printStackTrace();

            UtilityClass.sleepForASecond();

//            e = new ExceptionThree();
            e.printStackTrace();
        }
    }

    private void throwSomeExceptions() throws SQLException, IOException {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new SQLException();
        } else {
            throw new IOException();
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

            // legal but bad practice
            e = new ExceptionTwo(); // !!!!!

            System.out.println("exception after new assignment:");
            e.printStackTrace();
        }
    }

    private void throwASingelException() throws ExceptionOne {
        throw new ExceptionOne();
    }
}
