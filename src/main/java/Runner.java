import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Runner {
    final static int INPUT_LENGTH = 12;

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.createNewFile();
        runner.lowLevelFileIO();
        runner.bufferedFileIO();

    }

    private void createNewFile() {
        try {
            boolean newFile = false;
            File file = new File("fileWriter1.txt");
            System.out.println(file.exists());

            // file.createNewFile() return true if the file did not exist previously
            // it returns false if the file did already exist
            newFile = file.createNewFile();
            System.out.println(file.exists());

            System.out.println(newFile);


        } catch (IOException e) {
            System.out.println("Exception caught");
        }
    }


    // ============================== //


    private void lowLevelFileIO() {
        char[] in = new char[INPUT_LENGTH];
        try {
            File file = new File("fileWriter2.txt");
            createAndWriteToFile(file);
            writeSthToFile(file, in);

            for(char c : in) {
                System.out.println(c);
            }

        } catch(IOException e) {
            System.out.println("some IOException occured");
        }
    }

    private void createAndWriteToFile(File file) throws IOException{
        // this already creates a new file !!!
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("Hello\nWorld");
        // Make sure everything got written to the file
//        fileWriter.flush();
        // Free up those resources
//        fileWriter.close();
    }

    private void writeSthToFile(File file, char[] in) throws IOException {
        FileReader fileReader = new FileReader(file);
        System.out.println("Size: " + fileReader.read(in));
        // Free up those resources
        fileReader.close();
    }


    // ============================== //


    private void bufferedFileIO() {
        File file = new File("bufferedFileIO.txt");
        writeToBufferedFile(file);
        readFromBufferedFile(file);
    }

    private void writeToBufferedFile(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("This is\n");
            bufferedWriter.write("a test\n");

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("some IOException occured");
        }
    }

    private void readFromBufferedFile(File file) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            java.lang.String line;

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }

            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("some IO Exception occured");
        }
    }
}
