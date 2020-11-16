

public class Runner {

    public static void main(String[] args) {
        BankManager bankManager = new BankManager();
        Thread thread1 = new Thread(() -> bankManager.sensitiveAndUrgentTransaction());
        thread1.start();

        Thread thread2 = new Thread(() -> bankManager.verySensitiveTransaction());
        thread2.start();

        Thread thread3 = new Thread(() -> bankManager.watingSensitiveTransaction());
        thread3.start();
    }

}
