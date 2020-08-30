import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesAndDirectories {
    Path pathOne = Paths.get("/devsbb/ocp_dump/file.txt");
    Path pathTwo = Paths.get("c:\\devsbb\\ocp_dump\\test_directory");
    Path pathThree = Paths.get("/devsbb", "ocp_dump", "file.txt"); // same as pathOne
    Path pathFour = Paths.get("c:", "devsbb", "ocp_dump", "test_directory"); // same as pathTwo
    Path pathFive = Paths.get("c:\\devsbb", "ocp_dump", "test_directory");

    public static void main(String[] args) {
        FilesAndDirectories filesAndDirectories = new FilesAndDirectories();
        filesAndDirectories.createSomeFilesAndDirectories();
        System.out.println("\n=======================\n");
        // filesAndDirectories.copyingMovingDeletingSomeFiles();
        System.out.println("\n=======================\n");
        filesAndDirectories.differentPathFormats();
        System.out.println("\n=======================\n");
    }

    private void createSomeFilesAndDirectories() {
        // Conversion from IO to NIO and back
        File file = new File("file.txt");
        Path convertedPath = file.toPath();
        File convertedFile = convertedPath.toFile();

        Boolean pathThreeAlreadyExists = Files.exists(pathThree);
        System.out.println(pathThreeAlreadyExists);
        if(!pathThreeAlreadyExists) {
            try {
                Files.createDirectories(pathTwo);
                Files.createFile(pathThree);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException caught");
            }
        }
        System.out.println(Files.exists(pathThree));
    }

    private void copyingMovingDeletingSomeFiles() {
        Path targetPath = Paths.get("c:\\devsbb\\ocp_dump\\file2.txt");
        Path finalPath = Paths.get("fileMoved.txt");
        try {
            Thread.sleep(3_000);
            Files.copy(pathOne, targetPath);
            System.out.println("File copied... there should be two now");
            Thread.sleep(3_000);
            Files.delete(pathOne);
            System.out.println("File deleted... there should be one now");
            Thread.sleep(3_000);
            Files.move(targetPath, finalPath);
            System.out.println("File moved... it should be now in your project");
            Thread.sleep(4_000);
            Files.delete(finalPath);
        } catch (IOException | InterruptedException e) {
            System.out.println("Exception caught:");
            e.printStackTrace();
        }
    }

    private void differentPathFormats() {
        Path absolutVersionOne = Paths.get("c:\\devsbb\\ocp_dump\\absolutVersionOne.txt");
        Path absolutVersionTwo = Paths.get("c:","devsbb", "ocp_dump", "absolutVersionTwo.txt");
        Path absolutVersionThree = Paths.get("/devsbb/ocp_dump/absolutVersionThree.txt");
        Path absolutVersionFour = Paths.get("/devsbb", "ocp_dump", "absolutVersionFour.txt");

        try {
            Files.createFile(absolutVersionOne);
            Thread.sleep(3_000);
            Files.delete(absolutVersionOne);

            Files.createFile(absolutVersionTwo);
            Thread.sleep(3_000);
            Files.delete(absolutVersionTwo);

            Files.createFile(absolutVersionThree);
            Thread.sleep(3_000);
            Files.delete(absolutVersionThree);

            Files.createFile(absolutVersionFour);
            Thread.sleep(3_000);
            Files.delete(absolutVersionFour);

        } catch (IOException | InterruptedException e) {
            System.out.println("Exception caught");
            e.printStackTrace();
        }
    }



}
