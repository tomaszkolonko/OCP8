import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Set;

public class Runner {

    public static void main(String[] args) throws IOException {

        changeLastModifiedExample();
        System.out.println("\n=====================\n");
        workingWithFileAttribues();
        System.out.println("\n=====================\n");
        workingWithDOSFileAttributes();
        System.out.println("\n=====================\n");
        workingWithPOSIXFileAttributes();
    }

    public static void changeLastModifiedExample() throws IOException {
        ZonedDateTime now = ZonedDateTime.now();
        Instant nowInstant = now.toInstant();

        // old way
        File file = new File("c:/devsbb/ocp_temp/file.txt");
        file.createNewFile();
        file.setLastModified(nowInstant.getEpochSecond() * 1_100);
        System.out.println(file.lastModified());
        file.delete();

        Path path = Paths.get("c:/devsbb/ocp_temp/file2.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.fromMillis(nowInstant.getEpochSecond() * 1_100);
        Files.setLastModifiedTime(path, fileTime);
        System.out.println(Files.getLastModifiedTime(path));
        Files.delete(path);
    }

    public static void workingWithFileAttribues() throws IOException {
        Path fileName = Paths.get("c:/devsbb/ocp_temp/file3.txt");
        if (!Files.exists(fileName)) {
            Files.createFile(fileName);
        }
        BasicFileAttributes basicFileAttributes = Files.readAttributes(fileName, BasicFileAttributes.class);
        System.out.println("creationTime: " + basicFileAttributes.creationTime());
        System.out.println("lastAccessTime: " + basicFileAttributes.lastAccessTime());
        System.out.println("lastModifyTime: " + basicFileAttributes.lastModifiedTime());
        System.out.println("directory: " + basicFileAttributes.isDirectory());

        // All of the same type
        FileTime lastUpdated = basicFileAttributes.lastModifiedTime();
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime newLastAccessTime = FileTime.fromMillis(System.currentTimeMillis()*2);

        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(fileName, BasicFileAttributeView.class);
        basicFileAttributeView.setTimes(lastUpdated, newLastAccessTime, creationTime);

        BasicFileAttributes basicFileAttributes2 = Files.readAttributes(fileName, BasicFileAttributes.class);
        System.out.println("creationTime: " + basicFileAttributes2.creationTime());
        System.out.println("lastAccessTime: " + basicFileAttributes2.lastAccessTime());
        System.out.println("lastModifyTime: " + basicFileAttributes2.lastModifiedTime());
        System.out.println("directory: " + basicFileAttributes2.isDirectory());
    }

    public static void workingWithDOSFileAttributes() throws IOException {
        Path fileName = Paths.get("c:/devsbb/ocp_temp/file4.txt");
        if (!Files.exists(fileName)) {
            Files.createFile(fileName);
        }
        Files.setAttribute(fileName, "dos:hidden", true);
        Files.setAttribute(fileName, "dos:readonly", true);

        DosFileAttributes dosFileAttributes = Files.readAttributes(fileName, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isHidden());
        System.out.println(dosFileAttributes.isReadOnly());

        Files.setAttribute(fileName, "dos:hidden", false);
        Files.setAttribute(fileName, "dos:readonly", false);
        dosFileAttributes = Files.readAttributes(fileName, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isHidden());
        System.out.println(dosFileAttributes.isReadOnly());
        Files.delete(fileName);
    }

    public static void workingWithPOSIXFileAttributes() throws IOException {
        Path fileName = Paths.get("c:/devsbb/ocp_temp/file5.txt");
        if (!Files.exists(fileName)) {
            Files.createFile(fileName);
        }

        // throws UnsupportedOperationException on windows!!
        PosixFileAttributes posixFileAttributes = Files.readAttributes(fileName, PosixFileAttributes.class);
        Set<PosixFilePermission> permissionSet = PosixFilePermissions.fromString("rw-r--r--");
        Files.setPosixFilePermissions(fileName, permissionSet);
        System.out.println(posixFileAttributes.permissions());
    }

}
