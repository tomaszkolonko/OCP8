import java.io.File;
import java.io.IOException;

public class FilesAndDirectories {
    public static void main(String[] args) {
        File directoryToBeDeleted = new File("directoryToBeDeleted");
        directoryToBeDeleted.mkdir();

        File fileToBeDeleted = new File(directoryToBeDeleted, "fileToBeDeleted.txt");
        File fileToBeDeletedSecond = new File(directoryToBeDeleted, "fileToBeDeletedSecond.txt");
        try {
            fileToBeDeleted.createNewFile();
            fileToBeDeletedSecond.createNewFile();
        } catch (IOException e) {
            System.out.println("creating new file in directory failed");
        }

        fileToBeDeleted.delete();
        System.out.println("directoryToBeDeleted is deleted: " + directoryToBeDeleted.delete());

        // TODO: The following 4 lines of code don't work as expected
        File newFileName = new File("newFileName.txt");
        fileToBeDeletedSecond.renameTo(newFileName);

        File newDirectoryName = new File("newDirectoryName");
        directoryToBeDeleted.renameTo(newDirectoryName);

    }

}
