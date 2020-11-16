import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankManager {

    public void sensitiveAndUrgentTransaction() {
        Lock l1 = new ReentrantLock();
        l1.lock(); // blocking

        try {
            System.out.println("lock has been acquired: sensitiveAndUrgendTransaction()");
        } finally {
            l1.unlock();
        }
    }

    public void verySensitiveTransaction() {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();

        boolean acquiredLock1 = l1.tryLock();
        boolean acquiredLock2 = l2.tryLock();

        try {
            if(acquiredLock1 && acquiredLock2) {
                System.out.println("locks one and two have been acquired: verySensitiveTransaction()");
            }
        } finally {
            if (acquiredLock1) l1.unlock();
            if (acquiredLock2) l2.unlock();
        }
    }

    public void watingSensitiveTransaction() {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();

        boolean acquiredLock1 = false;
        boolean acquiredLock2 = false;
        try {
            acquiredLock1 = l1.tryLock(2, TimeUnit.DAYS);
            acquiredLock2 = l2.tryLock(2, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            if(acquiredLock1 && acquiredLock2) {
                System.out.println("locks one and two have been acquired: waitingSensitiveTransaction()");
            }
        } finally {
            if (acquiredLock1) l1.unlock();
            if (acquiredLock2) l2.unlock();
        }
    }

}
