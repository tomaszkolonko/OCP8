import java.util.concurrent.ThreadLocalRandom;

public class InfinityRunnable implements Runnable {
    @Override
    public void run() {
        while(true) {
            int count = ThreadLocalRandom.current().nextInt(1, 11);
            for (int i = 0; i <= count; i++) {
                System.out.print("arghhhh... " + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
