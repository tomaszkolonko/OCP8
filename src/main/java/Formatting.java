import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatting {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.of(2017, 10, 27, 14, 22, 54, 0);
        DateTimeFormatter formatterOne = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        DateTimeFormatter formatterTwo = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        DateTimeFormatter formatterThree = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:MM:ss");
        DateTimeFormatter formatterFour = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterFive = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");

        // This will show 02 for two o'clock in the afternoon with PM added to the time
        // That's because of the small letter hh for hours
        System.out.println("Formatted DateTime (yyyy-MM-dd hh:mm:ss a): " + now.format(formatterOne));

        // This one results in a 12-hour format without AM/PM at the end
        System.out.println("Formatted DateTime (yyyy-MM-dd hh:mm:ss): " + now.format(formatterTwo));

        // This one changes minutes with months !!! Suddenly it's month 22 which doesn't exist
        // Since we have HH for hours, the 24-hour format is being displayed
        System.out.println("Formatted DateTime (yyyy-mm-dd HH:MM:ss): " + now.format(formatterThree));

        // 24-hour format without AM/PM at the end
        System.out.println("Formatted DateTime (yyyy-MM-dd HH:mm:ss): " + now.format(formatterFour));

        // This format requires a ZonedDateTime not a DateTime to work properly. It will lead
        // to a runtime exception since the compiler cannot catch that one.
        // System.out.println("Formatted DateTime (yyyy-MM-dd HH:mm:ss Z): " + now.format(formatterFive));
    }
}
