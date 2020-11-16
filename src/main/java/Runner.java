import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Runner {
    private static char[] characterBillboard = new char[200];
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
//        Runner runner = new Runner();

        Runnable runnableOne = () -> {
            String message = "Aldi han nun neue vegane Schnitzel im Sortiment. Nur 99 Franken pro Kilo!!! Aldi han nun neue vegane Schnitzel im Sortiment. Nur 99 Franken pro Kilo!!!";
            changeBillboard(message);
        };
        Runnable runnableTwo = () -> {
            String message = "The new Pixel phone is now being shipped to all customers. Congratulations. The new Pixel phone is now being shipped to all customers. Congratulations.";
            changeBillboard(message);
        };
        Runnable runnableThree = () -> {
            String message = "This is a story about a long long forgotten dragon in the mountains of Bern This is a story about a long long forgotten dragon in the mountains of Bern";
            changeBillboard(message);
        };

        Thread tOne = new Thread(runnableOne);
        Thread tTwo = new Thread(runnableTwo);
        Thread tThree = new Thread(runnableThree);
        Thread readerThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                readBillboard();

            }
        });

        readerThread.start();
        tOne.setName("Thread-One");
        tOne.start();
        tTwo.setName("Thread-Two");
        tTwo.start();
        tThree.setName("Thread-Three");
        tThree.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println();
        }

        System.out.println(characterBillboard);
    }

    private static void changeBillboard(String message) {
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName());
        try {
            for (int runs = 0; runs < 100; runs++) {
                for (int x = 0; x < message.length(); x++) {
                    characterBillboard[x] = message.charAt(x);
                }
            }
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    private static void readBillboard() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(characterBillboard);
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

}
