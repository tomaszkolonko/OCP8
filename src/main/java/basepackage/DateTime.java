package basepackage;

import java.time.DayOfWeek;
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
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public final class DateTime {

    private DateTime() {}

    public static void main(String[] args) {
        Locale myLocale = Locale.getDefault();
        System.out.println("Default Locale: " + myLocale);

        LocalDateTime localDateTime = LocalDateTime.of(2024, 4, 6, 13, 34, 12);
        System.out.println("Date and Time: " + localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("US/Pacific"));

        Locale locITandIT = new Locale("it", "IT");
        Locale locITandCH = new Locale("it", "CH");
        Locale locFRandFR = new Locale("fr", "FR");
        Locale locXXandXX = new Locale("xx", "xx");

        System.out.println("locITandIT: " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locITandIT)));
        System.out.println("locITandCH: " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locITandCH)));
        System.out.println("locFRandFR: " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locFRandFR)));
        System.out.println("locXXandXX: " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locXXandXX)));
        System.out.println("locXXandXX: " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(myLocale)));

        System.out.println("locITandIT country: " + locITandIT.getDisplayCountry());
        System.out.println("locITandIT language: " + locITandIT.getDisplayLanguage());

        Locale locBR = new Locale("pt", "BR");
        System.out.println("Brazilian language in Brazil: " + locBR.getDisplayLanguage(locBR));
        System.out.println("Brazilian language in US: " + locBR.getDisplayLanguage(myLocale));







    }

}
