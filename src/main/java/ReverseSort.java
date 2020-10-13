import java.util.Comparator;

public class ReverseSort implements Comparator <Integer> {
    @Override
    public int compare(Integer one, Integer two) {
        return two-one;
    }
}
