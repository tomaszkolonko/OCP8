

public class Runner {

    public static void main(String[] args) {
        StatisticalModel statisticalModel = new StatisticalModel();
        statisticalModel.setModel();

        System.out.println("\n===================\n");

        StatisticalModel.Counter counter = new StatisticalModel.Counter();
        counter.getCountInformation();

        System.out.println("\n===================\n");

        statisticalModel.printTruth();
        // Cannot resolve method 'printTruth' in 'Counter'
//        counter.printTruth();
    }

}
