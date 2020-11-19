import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class InfinityCallable implements Callable {
    @Override
    public Integer call() {
        boolean check = true;
        while(check) {
            int count = ThreadLocalRandom.current().nextInt(1, 11);
            for (int i = 0; i <= count; i++) {
                System.out.println("arghhhh... " + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        return new Integer(3);
    }
}
