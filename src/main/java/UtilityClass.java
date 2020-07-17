import static java.lang.Thread.sleep;

public final class UtilityClass {

    private UtilityClass() {}

    public static void sleepForASecond() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
