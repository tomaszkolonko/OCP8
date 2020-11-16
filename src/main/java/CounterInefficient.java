public class CounterInefficient implements Counter {
    private int count;

    @Override
    public synchronized void increment() {
        count++;
    }

    @Override
    public synchronized  int getCount() {
        return count;
    }
}
