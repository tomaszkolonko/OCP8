import java.util.List;

public class GenericShelf<T> {
    private List<T> pool;

    public GenericShelf(List<T> list) {
        this.pool = list;
    }

    public T getFirst() {
        return pool.get(0);
    }

    public void putIntoPool(T t) {
        pool.add(t);
    }

    public void printContent() {
        for(T t : pool) {
            System.out.println(t);
        }
    }

}
