import java.util.concurrent.RecursiveTask;

public class FindMaxPositionRecursiveTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 1_000;
    private int[] data;
    private int start;
    private int end;

    public FindMaxPositionRecursiveTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int position = 0;
            for(int i = start; i < end; i++) {
                if(data[i] > data[position]) {
                    position = i;
                }
            }
            return position;
        } else {
            int halfWay = ((end - start) / 2) + start;
            FindMaxPositionRecursiveTask t1 = new FindMaxPositionRecursiveTask(data, start, halfWay);
            t1.fork();
            FindMaxPositionRecursiveTask t2 = new FindMaxPositionRecursiveTask(data, halfWay, end);
            int position2 = t2.compute();
            int position1 = t1.join();
            if(data[position1] > data[position2]) {
                return position1;
            } else if (data[position1] < data[position2]) {
                return position2;
            } else {
                return position1 < position2 ? position1 : position2;
            }
        }
    }
}
