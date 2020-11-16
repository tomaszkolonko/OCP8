
public class CounterWrong implements Counter {
    private int count;

    @Override
    public void increment() {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }
}
