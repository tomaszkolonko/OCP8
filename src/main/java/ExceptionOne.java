import java.io.IOException;

public class ExceptionOne implements AutoCloseable {

    @Override
    public void close() throws IOException {
        throw new IOException("Closing ExceptionOne");

    }
}
