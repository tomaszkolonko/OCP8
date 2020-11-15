

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        ThreadB thread = new ThreadB();
        thread.start();


//        Thread.sleep(1_000);


        synchronized (thread) {
            try {
                System.out.println("Waiting for the thread to complete...");
                thread.wait(1000);
                System.out.println("Thread has completed");
            } catch (InterruptedException e) {
                System.out.println("The wait() method got interrupted ;( ");
            }
        }

        System.out.println("Total of computation is: " + thread.total);

    }

}
