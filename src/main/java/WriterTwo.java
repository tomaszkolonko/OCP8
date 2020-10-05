import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriterTwo {

    public static void main(String[] args) {
        try {
            File file = new File("fileWriter.txt");
            writeSomething(file);
            readSomething(file);
            deleteFile(file);
        } catch (IOException e) {
            System.out.println("huhu");
        }
    }

    private static void writeSomething(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file); // This acutally creates the file
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("Hello");
        bufferedWriter.newLine();
        bufferedWriter.write("World");

        bufferedWriter.close();

    }

    private static void readSomething(File file) throws IOException {
        String lineOfString;
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((lineOfString = bufferedReader.readLine()) != null) {
            System.out.println(lineOfString);
        }

        bufferedReader.close();
    }

    private static void deleteFile(File file) throws IOException {
        file.delete();
    }

}
