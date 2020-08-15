import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void main(String[] args) {
        try {
            File file = new File("fileWriter.txt");
            writeSomething(file);
            readSomething(file);

        } catch (IOException e) {
            System.out.println("huhu");
        }
    }

    private static void writeSomething(File file) throws IOException {
        FileWriter fw = new FileWriter(file); // This acutally creates the file
        fw.write("Hello\nWorld\n");
        fw.flush();
        fw.close();
    }

    private static void readSomething(File file) throws IOException {
        char[] in = new char[50];
        FileReader fileReader = new FileReader(file);
        int size = fileReader.read(in);

        System.out.println(size + " ");
        for(char c : in) {
            System.out.print(c);
        }
        fileReader.close();
    }

}
