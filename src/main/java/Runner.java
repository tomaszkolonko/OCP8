

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();

        long startTime = System.currentTimeMillis();
        runner.goFetchFromAPIOne();
        runner.goFetchFromAPITwo();
        runner.goFetchFromAPIThree();
        long endTime = System.currentTimeMillis();
        System.out.println("Fetching all information sequentially took: " + ((endTime - startTime) / 1000) + " seconds");


        System.out.println("\n\n===============================\n\n");


        startTime = System.currentTimeMillis();
        MyThread myThread = new MyThread();         // equals goFetchFromAPIOne
        MyRunnable myRunnable = new MyRunnable();   // equals goFetchFromAPITwo
        Runnable myRunnabelNext = () -> {           // equals goFetchFromAPIThree
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                System.out.println("interrupted sleep");
            }
        };

        // calling the run() method is legal but it does NOT start a new Thread !!!
        myThread.run();
        myRunnable.run();
        myRunnabelNext.run();

        endTime = System.currentTimeMillis();
        System.out.println("Fetching all information in pseudo-parallel took: " + ((endTime - startTime) / 1000) + " seconds");


        System.out.println("\n\n===============================\n\n");


        startTime = System.currentTimeMillis();

        MyThread myThreadOne = new MyThread();
        Thread tOne = new Thread(myRunnable);
        Thread tTwo = new Thread(myRunnabelNext);
        myThreadOne.start();
        tOne.start();
        tTwo.start();


        endTime = System.currentTimeMillis();
        System.out.println("Fetching all information in parallel took: " + ((endTime - startTime) / 1000) + " seconds");


        System.out.println("\n\n===============================\n\n");


        startTime = System.currentTimeMillis();

        MyThread myThread3 = new MyThread();
        Thread tOneNext = new Thread(myRunnable);
        Thread tTwoNext = new Thread(myRunnabelNext);
        myThread3.start();
        tOneNext.start();
        tTwoNext.start();

        try {
            myThread3.join();
            tOneNext.join();
            tTwoNext.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted execution of thread");
        }

        endTime = System.currentTimeMillis();
        System.out.println("Fetching all information in parallel took: " + ((endTime - startTime) / 1000) + " seconds");

    }

    public void goFetchFromAPIOne() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            System.out.println("interrupted sleep");
        }
    }

    public void goFetchFromAPITwo() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            System.out.println("interrupted sleep");
        }
    }

    public void goFetchFromAPIThree() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            System.out.println("interrupted sleep");
        }
    }

}

