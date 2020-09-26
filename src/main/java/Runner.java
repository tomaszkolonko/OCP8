import java.io.Console;

public class Runner {
    final static int INPUT_LENGTH = 12;

    public static void main(String[] args) {
        String name = "";
        Console console = System.console();
        char[] pw;
        pw = console.readPassword("%s", "pw: ");
        for(char character : pw) {
            console.format("%c", character);
        }
        console.format("\n");

        MyUtility myUtility = new MyUtility();
        while(true) {
            name = console.readLine("%s", "input: " );
            console.format("output: %s \n", myUtility.doStuff(name));
        }

    }
}
