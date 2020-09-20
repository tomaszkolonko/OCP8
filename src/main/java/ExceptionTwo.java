import java.io.IOException;

public class ExceptionTwo implements AutoCloseable {

    @Override
    public void close() throws IOException {
        throw new IOException("Closing ExceptionTwo");
    }
}
