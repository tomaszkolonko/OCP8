import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Runner {
    static List<Integer> listOfPrimeNumbers = new ArrayList<>();
    static List<Integer> firstRangeOfNumbers = IntStream.range(100_000, 150_000).boxed().collect(Collectors.toList());
    static List<Integer> secondRangeOfNumbers = IntStream.range(400_000, 450_000).boxed().collect(Collectors.toList());
    static List<Integer> thirdRangeOfNumbers = IntStream.range(600_000, 650_000).boxed().collect(Collectors.toList());

    CyclicBarrier barrier;

    public Runner() {
        barrier = new CyclicBarrier(3, () -> {
            for (int i = 0; i < firstRangeOfNumbers.size(); i++) {
                listOfPrimeNumbers.add(firstRangeOfNumbers.get(i));
            }
            for (int i = 0; i < secondRangeOfNumbers.size(); i++) {
                listOfPrimeNumbers.add(secondRangeOfNumbers.get(i));
            }
            System.out.println(Thread.currentThread().getName() + " Result: " + listOfPrimeNumbers);
        });

        Thread threadOne = new Thread(new PrimeCalc(firstRangeOfNumbers));
        Thread threadTwo = new Thread(new PrimeCalc(secondRangeOfNumbers));
        Thread threadThree = new Thread(new PrimeCalc(thirdRangeOfNumbers));
        threadOne.start();
        threadTwo.start();
        
        System.out.println("Main Thread is done");

    }


    class PrimeCalc implements Runnable {
        List<Integer> currentList;

        public PrimeCalc(List<Integer> list) {
            this.currentList = list;
        }

        @Override
        public synchronized void run() {
            for (int position = 0; position < currentList.size(); position++) {
                for(int i = 2; i < currentList.get(position); i++) {
                    if(currentList.get(position) % i == 0) {
                        currentList.remove(position);
                        position--;
                        break;
                    }
                }

            }
            try {
                System.out.println(Thread.currentThread().getName() + " at the barrier");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException exception) {
                System.out.println("Something's not right");
            }
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
    }

    private synchronized static boolean isPrime(int i) {
        for (int x = 2; x < i; x++) {
            if (i % x == 0) {
                return false;
            }
        }
        return true;
    }

}
