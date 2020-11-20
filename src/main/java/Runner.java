import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Runner {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        usingParallelMethod(nums);
        System.out.println("\n=============================\n");
        usingParallelStreamMethod(nums);
        System.out.println("\n=============================\n");
        usingOnly2Threads(nums);
        System.out.println("\n=============================\n");

    }

    public static void usingParallelMethod(List<Integer> nums) {
        int sum = nums.stream()
                .parallel()
                .peek(i -> System.out.println(i + ": " + Thread.currentThread().getName()))
                .mapToInt(n -> n)
                .sum();

        System.out.println("Sum: " + sum);
    }

    public static void usingParallelStreamMethod(List<Integer> nums) {
        int sum = nums.parallelStream()
                .peek(i -> System.out.println(i + ": " + Thread.currentThread().getName()))
                .mapToInt(n -> n)
                .sum();

        System.out.println("Sum: " + sum);
    }

    public static void usingOnly2Threads(List<Integer> nums) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        try {
            int sum = forkJoinPool.submit(() -> nums.stream()
                    .parallel()
                    .peek(i -> System.out.println(i + ": " + Thread.currentThread()
                            .getName()))
                    .mapToInt(n -> n)
                    .sum()
            ).get();
            System.out.println("Sum: " + sum);
        } catch (Exception e) {
            System.out.println("Some Error happened");
            e.printStackTrace();
        }
    }

}
