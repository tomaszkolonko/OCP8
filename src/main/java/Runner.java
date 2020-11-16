public class Runner {
    public static void main(String[] args) {
        CounterWrong counterWrong = new CounterWrong();
        createAndRunThreads(counterWrong);


        System.out.println("\n\n====================\n\n");


        CounterInefficient counterInefficient = new CounterInefficient();
        createAndRunThreads(counterInefficient);

        
        System.out.println("\n\n====================\n\n");


        CounterRight counterRight = new CounterRight();
        createAndRunThreads(counterRight);
    }

    private static void createAndRunThreads(Counter counter) {
        IncrementThread t1 = new IncrementThread(counter);
        IncrementThread t2 = new IncrementThread(counter);

        long startTime = System.currentTimeMillis();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println(counter.getCount() + " in " + (endTime-startTime) + " milliseconds");
    }

}
