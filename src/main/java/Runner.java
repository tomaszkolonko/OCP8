import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {
    final String host;
    final int port;
    final Logger logger;

    public Runner(String string, int port, Logger logger) {
        this.host = string;
        this.port = port;
        this.logger = logger;
    }

    public static void main(String[] args) {
        Runner runner = new Runner("google.com", 80, Logger.getLogger("Status Logger"));
        runner.simpleSupplierExample();

        runner.setLogLevel();


        long startTime = System.nanoTime();

        for(int i = 0; i < 10; i++) {
            runner.goLogSomethingWithSupplier();
        }
        long endTime = System.nanoTime();
        long timeWithSupplier = (endTime - startTime);
        System.out.println("Logging WITH Supplier: " + timeWithSupplier);


        startTime = System.nanoTime();
        for(int i = 0; i < 10; i++) {
            runner.goLogSomethingWithoutSupplier();
        }
        endTime = System.nanoTime();
        long timeWithoutSupplier = (endTime - startTime);
        System.out.println();
        System.out.println("Logging WITHOUT Supplier: " + timeWithoutSupplier);
        System.out.println();
        System.out.println("Without supplier it takes " + timeWithoutSupplier / timeWithSupplier + " longer !!!");
    }

    public void simpleSupplierExample() {
        Supplier<Integer> innerClassOfSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 42;
            }
        };

        Supplier<Integer> innerClassWithLambda = () -> 42;

        System.out.println(innerClassOfSupplier.get());
        System.out.println(innerClassWithLambda.get());

        System.out.println("\n=============================\n");

//        Map<String, String> env = System.getenv();
//        for(Map.Entry<String, String> e : env.entrySet()) {
//            System.out.println(e.getKey() + ": " + e.getValue());
//        }

        Supplier<String> userSupplier = () -> {
            Map<String, String> myMap = System.getenv();
            // Do some other crazy stuff
            return myMap.get("USERNAME");
        };

        System.out.println("Owner of this Computer is: " + userSupplier.get());
    }

    public void goLogSomethingWithSupplier() {
        Supplier<String> status = () -> {
            int timeout = 1000;
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(host, port), timeout);
                return "up and running";
            } catch (IOException e) {
                return "down ";
            }
        };

        try {
            logger.log(Level.INFO, status);
        } catch (Exception e) {
            logger.log(Level.SEVERE, status);
        }
    }

    public void goLogSomethingWithoutSupplier() {
        int timeout = 1000;
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            logger.log(Level.INFO, "up and running");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "down");
        }
    }

    private void setLogLevel() {
        logger.setLevel(Level.SEVERE);
    }

}
