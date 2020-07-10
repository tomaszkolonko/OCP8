

public class Train {
    EVU evu;

    public static void main(String[] args) {
        Train train = new Train();
        train.orderNewTrain();
    }

    public void orderNewTrain() {
        Train trainSBB = new Train();
        trainSBB.evu = EVU.SBB;
        System.out.println(trainSBB.evu + ": " + trainSBB.evu.geteDebitCode());

        Train trainBLS = new Train();
        trainBLS.evu = EVU.BLS;
        System.out.println(trainBLS.evu + ": " + trainBLS.evu.geteDebitCode());

        System.out.println("\n===========================\n");

        // Every enum has a static method values(), that returns an array of the enum's
        // values in the order they have been declared previously.
        for(EVU evu : EVU.values()) {
            System.out.println(evu + ": " + evu.geteDebitCode());
        }
    }

}
