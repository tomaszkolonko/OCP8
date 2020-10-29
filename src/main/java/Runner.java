

public class Runner {

    public static void main(String[] args) {
        Train trainOne = new Train("RABe511", ETCSLevel.ETCS_LEVEL_1);
        Track trackOne = new Track("BN", "ZUE", ETCSLevel.ETCS_LEVEL_1);

        // Creating an instanc of a class that implements ETCSChecker
        ETCSConformityChecker etcsConformityChecker1 = new ETCSConformityChecker();
        boolean checked = etcsConformityChecker1.etcsCheck(trainOne, trackOne);

        System.out.println(trainOne.getTrainType() + " is allowed from " + trackOne.getFromBP() + " to " + trackOne.getToBP() + ": " + checked);



        System.out.println("\n\n=================================================\n\n");


        // Creating an instance of an anonymous subclass of ETCSConformityChecker that implements ETCSChecker
        ETCSConformityChecker etcsConformityChecker2 = new ETCSConformityChecker() {
            @Override
            public boolean etcsCheck(Train train, Track track) {
                return train.getEtcsLevel().ordinal() >= track.getEtcsLevel().ordinal();
            }
        };

        checked = etcsConformityChecker2.etcsCheck(trainOne, trackOne);
        System.out.println(trainOne.getTrainType() + " is allowed from " + trackOne.getFromBP() + " to " + trackOne.getToBP() + ": " + checked);



        System.out.println("\n\n=================================================\n\n");


        // Creating an instance of an anonymous subclass of ETCSConformityChecker that implements ETCSChecker
        // and putting it into a variable of type ETCSChecker.
        ETCSChecker etcsChecker1 = new ETCSConformityChecker() {
            @Override
            public boolean etcsCheck(Train train, Track track) {
                return train.getEtcsLevel().ordinal() >= track.getEtcsLevel().ordinal();
            }
        };

        checked = etcsChecker1.etcsCheck(trainOne, trackOne);
        System.out.println(trainOne.getTrainType() + " is allowed from " + trackOne.getFromBP() + " to " + trackOne.getToBP() + ": " + checked);



        System.out.println("\n\n=================================================\n\n");



        ETCSChecker etcsChecker2 = new ETCSChecker() {
            @Override
            public boolean etcsCheck(Train train, Track track) {
                return train.getEtcsLevel().ordinal() >= track.getEtcsLevel().ordinal();
            }
        };

        checked = etcsChecker2.etcsCheck(trainOne, trackOne);
        System.out.println(trainOne.getTrainType() + " is allowed from " + trackOne.getFromBP() + " to " + trackOne.getToBP() + ": " + checked);



        System.out.println("\n\n=================================================\n\n");


        ETCSChecker etcsChecker3 = (Train train, Track track)  -> train.getEtcsLevel().ordinal() >= track.getEtcsLevel().ordinal();

        checked = etcsChecker3.etcsCheck(trainOne, trackOne);
        System.out.println(trainOne.getTrainType() + " is allowed from " + trackOne.getFromBP() + " to " + trackOne.getToBP() + ": " + checked);


    }

}

class ETCSConformityChecker implements ETCSChecker {

    @Override
    public boolean etcsCheck(Train train, Track track) {
        return train.getEtcsLevel().ordinal() >= track.getEtcsLevel().ordinal();
    }
}
