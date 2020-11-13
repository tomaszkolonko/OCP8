

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        ThreadB thread = new ThreadB();
        thread.start();


//        Thread.sleep(1000);

        System.out.println("Total of computation is: " + thread.total);

        synchronized (thread) {
            try {
                System.out.println("Waiting for the thread to complete...");
                thread.wait();
            } catch (InterruptedException e) {
                System.out.println("Total is: " + thread.total);
            }
        }
    }

}
