
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            System.out.println("interrupted sleep");
        }
    }
}
