import java.util.concurrent.atomic.AtomicInteger;

public class CounterRight implements Counter {
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void increment() {
        count.getAndIncrement();
    }

    @Override
    public int getCount() {
        return count.intValue();
    }
}
