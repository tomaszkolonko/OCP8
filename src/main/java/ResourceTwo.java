public class ResourceTwo implements java.lang.AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Closing - TWO");
    }
}
