import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Runner {

    public static void main(String[] args) {
        Callable<Integer> callable = new MyCallable();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(callable);

        try {
            Integer value = future.get();
            System.out.println("Value in Future: " + value);
        } catch (InterruptedException | ExecutionException exception) {
            System.out.println("Something went wrong...");
        }

        InfinityRunnable infinityRunnable = new InfinityRunnable();
        Thread t1 = new Thread(infinityRunnable);
        Thread t2 = new Thread(infinityRunnable);
        Thread t3 = new Thread(infinityRunnable);
        Thread t4 = new Thread(infinityRunnable);
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
        executorService.submit(t4);

        // Don't except any new tasks but finish the running ones
        executorService.shutdown();

        try {
            boolean term = executorService.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println(term);
        } catch (InterruptedException exception) {
            System.out.println("Was interrupted during waiting for shutdown ;( ");
        } finally {
            if(!executorService.isTerminated()) {
                List<Runnable> unfinished = executorService.shutdownNow();
                System.out.println(unfinished);
                if(!t1.isInterrupted()) {
                    System.out.println("t1 still working therefore shut it down");
                    t1.interrupt();
                }
                if(!t2.isInterrupted()) {
                    System.out.println("t2 still working therefore shut it down");
                    t2.interrupt();
                }
                if(!t3.isInterrupted()) {
                    System.out.println("t3 still working therefore shut it down");
                    t3.interrupt();
                }
                if(!t4.isInterrupted()) {
                    System.out.println("t4 still working therefore shut it down");
                    t4.interrupt();
                }
            }
        }

        System.out.println("*******************************************");
        System.out.println("***************  FINISHED  ****************");
        System.out.println("*******************************************");

    }

}
