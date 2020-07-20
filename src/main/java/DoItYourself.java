import java.io.IOException;
import java.io.Reader;

public class DoItYourself {
    public static void main(String[] args) throws IOException {
        DoItYourself doItYourself = new DoItYourself();
        doItYourself.go();
    }

    public void go() throws IOException {
        Reader reader = null;
        try {
            // read from the file
            throw new IOException();
        } catch(IOException e) {
            System.out.println("Some Logging");;
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // ignore exceptions on closing a file
                }
            }
        }
    }

}
