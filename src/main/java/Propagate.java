import static java.lang.Thread.sleep;

public class Propagate {

    public static void main (String[] args) throws ExceptionOne {

        String stringToBeReversed = "anna";
        String nextStringToBeConverted = "Exception";
        String nullString = null;

        System.out.println(reverse(stringToBeReversed));
        System.out.println(reverse(nextStringToBeConverted));
        try {
            System.out.println(reverse(nullString));
        } catch (ExceptionOne e) {
            System.out.println("Exception Was Thrown");
            e.printStackTrace();
        } finally {

        }

//        try {
//            sleep(10000);
//        } catch (InterruptedException interruptedException) {
//            System.out.println("sleep interrupted");
//        }

        System.out.println("End of program");
    }

    private static String reverse(String string) throws ExceptionOne {
        if(string == null) {
            throw new ExceptionOne();
        }
        int stringLength = string.length();
        char[] stringArray = new char[stringLength];
        for(int i = 0; i < stringLength; i++) {
            stringArray[stringLength-i-1] = string.charAt(i);
        }
        return String.valueOf(stringArray);
    }

}
