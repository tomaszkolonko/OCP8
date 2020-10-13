import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Runner {
    Integer[] integerArray = {1,5,2,3,6,4,7,9,8};
    List<Integer> integerList = Arrays.asList(integerArray);


    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.usePriorityQueue();
        runner.usePriorityQueueWithComparator();
        runner.useDeque();
    }

    public void usePriorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int x : integerArray) {
            priorityQueue.offer(x);
        }

        while(!priorityQueue.isEmpty()) {
            // returns the highest-priority element and removes it
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println(priorityQueue.size() + "");
        System.out.println("\n=====================\n");
    }

    public void usePriorityQueueWithComparator() {
        ReverseSort reverseSort = new ReverseSort();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10, reverseSort);

        for(int x : integerArray) {
            priorityQueue.offer(x);
        }

        System.out.println("size " + priorityQueue.size());
        System.out.println("peek " + priorityQueue.peek());
        System.out.println("size " + priorityQueue.size());
        System.out.println("poll " + priorityQueue.poll());
        System.out.println("size " + priorityQueue.size());
        System.out.println();

        for(int x = 0; x < integerArray.length; x++) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println("\n\n=====================\n");
    }

    public void useDeque() {
        ArrayDeque<Integer> a = new ArrayDeque<>(2);
        ArrayDeque<Integer> b = new ArrayDeque<>(2);
        ArrayDeque<Integer> c = new ArrayDeque<>(2);
        ArrayDeque<Integer> d = new ArrayDeque<>(2);
        ArrayDeque<Integer> e = new ArrayDeque<>(2);

        // add 6 elements to each Deque, each using different methods
        for(Integer x : integerList) {
            a.offer(x);
            b.offerFirst(x);
            c.push(x);
            d.add(x);
            e.addFirst(x);
        }

        // display the deques
        System.out.println("a: " + a + " // offer(x)");
        System.out.println("b: " + b + " // offerFirst(x)");
        System.out.println("c: " + c + " // push(x)");
        System.out.println("d: " + d + " // add(x)");
        System.out.println("e: " + e + " // addFirst(x)");
    }
}
