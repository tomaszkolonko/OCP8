import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int count = ThreadLocalRandom.current().nextInt(1,11);
        for(int i = 0; i <= count; i++) {
            System.out.println("Running... " + i);
        }
        return count;
    }
}
