package basepackage;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public final class DateTime {

    private DateTime() {
    }

    public static void main(String[] args) {
        LocalDateTime nowDateTimeOne = LocalDateTime.now();

        // Period: A period of days, months or years

        Period period = Period.ofMonths(1);
        System.out.println("Period is: " + period);
        LocalDateTime dateTimeInPast = nowDateTimeOne.minus(period);
        System.out.println(nowDateTimeOne + " One month in the past: " + dateTimeInPast);
        LocalDateTime dateTimeInFuture = nowDateTimeOne.plus(period);
        System.out.println(nowDateTimeOne + " One month in the future: " + dateTimeInFuture);

        System.out.println("\n ======================= \n");

        // Duration: A period of minutes or hours

        LocalTime start = LocalTime.of(10, 0, 0);
        LocalTime end = LocalTime.of(10, 29, 59);

        System.out.println("Coffee breakt starts at " + start + " and ends late at " + end);
        long numberOfMinutes = ChronoUnit.MINUTES.between(start, end);
        System.out.println("end - start is " + numberOfMinutes);
        long numberOfSecondes = ChronoUnit.SECONDS.between(start, end);
        System.out.println("end - start is " + numberOfSecondes);

        Duration duration = Duration.ofMinutes(numberOfMinutes);
        System.out.println(duration); // PT stands for period of time

        System.out.println("\n ======================= \n");

        ZonedDateTime nowZonedDateTime = ZonedDateTime.now();
        // Instant: represents an instant in time
        // It's like a timestamp in seconds starting at 01.01.1970
        Instant instant = nowZonedDateTime.toInstant();
        System.out.println("The instant of now is: " + instant);

        System.out.println("\n ======================= \n");

        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.of("Europe/Zurich");
        ZoneOffset zoneOffset = zone.getRules().getOffset(dateTime);
        System.out.println("DateTime: " + dateTime);
        System.out.println("Zone: " + zone);
        System.out.println("zoneOffset: " + zoneOffset);

        System.out.println("\n ======================= \n");

        Instant instantTwo = dateTime.toInstant(zoneOffset);
        System.out.println("instantTwo: " + instantTwo); // instant is always GMT

        Instant now = Instant.now();
        System.out.println("Seconds since epoch: " + now.getEpochSecond());

        System.out.println("\n ======================= \n");

        // Formatting

        System.out.println(nowZonedDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
        System.out.println(nowZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm")));
        System.out.println(nowZonedDateTime.format(DateTimeFormatter.ofPattern("hh:mm yyyy/MM/dd")));
        System.out.println(nowZonedDateTime.format(DateTimeFormatter.ofPattern("hh.mmyyyyMM::dd")));
//        System.out.println(nowZonedDateTime.format(DateTimeFormatter.ofPattern("Holidays in: hh:mm yyyy/MM/dd")));

        System.out.println("\n ======================= \n");

        System.out.println(nowZonedDateTime
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK)));
        System.out.println(nowZonedDateTime
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK)));
        System.out.println(
                nowZonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.UK)));
    }

}
