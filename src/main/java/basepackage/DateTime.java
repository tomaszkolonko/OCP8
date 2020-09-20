package basepackage;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public final class DateTime {

    private DateTime() {
    }

    public static void main(String[] args) {
        LocalDateTime nowDateTimeOne = LocalDateTime.now();

        System.out.println("NOW: \t\t\t\t" + nowDateTimeOne);
        LocalDateTime followingThursdayDateTime = nowDateTimeOne.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        System.out.println("NEXT: \t\t\t\t" + followingThursdayDateTime + " -> " + followingThursdayDateTime.getDayOfWeek());
        LocalDateTime firstDayOfCurrentMonth = nowDateTimeOne.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("First of Month: \t" + firstDayOfCurrentMonth + " -> " + firstDayOfCurrentMonth.getDayOfWeek());

        // Important to know is that you never use the new keyword to create new objects, but new objects are created indeed.

    }
}
