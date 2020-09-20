import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class AutoCloseable {
    String file = "pathToFile";

    public static void main(String[] args) throws IOException {
        AutoCloseable autoCloseable = new AutoCloseable();
        autoCloseable.go();
        autoCloseable.goSuperSimple();
        autoCloseable.notQuiteRight();
    }

    public void go() throws IOException {
        try(Reader reader = new BufferedReader(new FileReader(file))) {
            // Read from File and do some stuff
        } catch (IOException e) {
            System.out.println("Logging");
            throw e;
        }
    }

    public void goSuperSimple() throws IOException {
        try(Reader reader = new BufferedReader(new FileReader(file))) {
            // Read from File and do some stuff
        }
        // With AutoCloseable there is a hidden finally block already !!!
    }

    public void notQuiteRight() {
        // Why does this not work?
//        try(String s = "Hello") {
//            // Do sth.
//        }
    }

}
