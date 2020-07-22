package basepackage;

import java.time.*;
import java.time.format.DateTimeFormatter;

public final class DateTime {

    private DateTime() {}

    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime nowDateTimeOne = LocalDateTime.now();
        LocalDateTime nowDateTimeTwo = LocalDateTime.of(nowDate, nowTime);
        LocalDate nowDateTwo = LocalDate.of(2020, 12, 12);
        LocalDateTime nowDateTimeFour = LocalDateTime.of(2020, 12, 12, 9, 30, 23, 159);
        LocalDate nowDateThree = LocalDate.parse("2020-12-12");
        LocalTime nowTimeTwo = LocalTime.parse("09:12:15");
        LocalDateTime nowDateTimeFive = LocalDateTime.parse("2020-12-12T09:12:15");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime nowDateTimeSix = LocalDateTime.parse("2020-08-21 13:11", formatter);

        System.out.println("nowDateTimeOne: " + nowDateTimeOne);
        System.out.println("nowDateTimeTwo: " + nowDateTimeTwo);
        System.out.println(nowDateTwo);
        System.out.println(nowDateTimeFour);
        System.out.println(nowDateThree);
        System.out.println(nowTimeTwo);
        System.out.println(nowDateTimeFive);
        System.out.println(nowDateTimeSix);

        System.out.println("\n========================\n");

        System.out.println("plus 3 days: " + nowDateTimeFive.plusDays(3));
        System.out.println("plus 3 hours: " + nowDateTimeFive.plusHours(3));

        System.out.println("\n========================\n");

        System.out.println("Day of Week: " + nowDateTimeFive.getDayOfWeek());
        System.out.println("Day of Month: " + nowDateTimeFive.getDayOfMonth());

        System.out.println("\n========================\n");


    }

}
