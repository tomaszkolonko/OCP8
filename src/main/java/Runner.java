import java.util.concurrent.ForkJoinPool;

public class Runner {
    public static void main(String[] args) {
        int[] data = new int[10_000_000];
        printSomeElements(data);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        RandomInitRecursiveAction action = new RandomInitRecursiveAction(data, 0, data.length);
        forkJoinPool.invoke(action);

        printSomeElements(data);

        // New Code

        FindMaxPositionRecursiveTask task = new FindMaxPositionRecursiveTask(data, 0, data.length);
        Integer position = forkJoinPool.invoke(task);
        System.out.println("Position: " + position + ", value: " + data[position]);
    }

    public static void printSomeElements(int[] data) {
        System.out.println("few elements:");
        System.out.println("1 st: " + data[0]);
        System.out.println("1'000 st: " + data[999]);
        System.out.println("10'000 st: " + data[9_999]);
        System.out.println("10'000'000 st: " + data[9_999_999]);
    }
}
