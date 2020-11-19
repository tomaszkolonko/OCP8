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

        InfinityCallable infinityCallable = new InfinityCallable();

        executorService.submit(infinityCallable);
        executorService.submit(infinityCallable);

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
            }
        }

        System.out.println("*******************************************");
        System.out.println("***************  FINISHED  ****************");
        System.out.println("*******************************************");

    }

}
