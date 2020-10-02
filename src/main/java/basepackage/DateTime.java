package basepackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class DateTime {

    private DateTime() {}

    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime nowDateTimeOne = LocalDateTime.now();
        LocalDateTime nowDateTimeTwo = LocalDateTime.of(nowDate, nowTime);
        LocalDate nowDateTwo = LocalDate.of(2020, 12, 12);
        LocalDateTime nowDateTimeFour = LocalDateTime.of(2020, 12, 12, 9, 30, 23, 159);
//        LocalDateTime wontWork = LocalDateTime.of(nowDate, 9, 30, 23, 159);
        LocalDate nowDateThree = LocalDate.parse("2020-12-12");
//        LocalDate wrongFormateDate = LocalDate.parse("2020-1-12");
        LocalTime nowTimeTwo = LocalTime.parse("09:12:15");
//        LocalTime wrongFormatTime = LocalTime.parse("9:12:15");
        LocalDateTime nowDateTimeFive = LocalDateTime.parse("2020-12-12T09:12:15");
        LocalDateTime nowDateTimeFivee = LocalDateTime.parse("2020-12-12T09:12:15.342");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime nowDateTimeSix = LocalDateTime.parse("2020-08-21 13:11", formatter);

        System.out.println("\n========================\n");

        System.out.println(nowDateTimeFive + " plus 3 days: " + nowDateTimeFive.plusDays(3));
        System.out.println(nowDateTimeFive + " plus 3 hours: " + nowDateTimeFive.plusHours(3));

        System.out.println("\n========================\n");

        System.out.println(nowDateTimeFive + " Day of Week: " + nowDateTimeFive.getDayOfWeek());
        System.out.println(nowDateTimeFive + " Day of Month: " + nowDateTimeFive.getDayOfMonth());

        System.out.println("\n========================\n");

        ZonedDateTime zonedDateTime = ZonedDateTime.of(nowDateTimeFour, ZoneId.of("US/Pacific"));
        System.out.println(nowDateTimeFour + " zonedDateTime: " + zonedDateTime);

        System.out.println("\n========================\n");
        System.out.println("Show list of all zones:");

        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        List<String> zoneList = new ArrayList<>(zoneIds);
        for(String zoneId : zoneIds) {
            if(zoneId.toLowerCase().contains("europe")) {
                System.out.println(zoneId);
            }
        }

    }

}
