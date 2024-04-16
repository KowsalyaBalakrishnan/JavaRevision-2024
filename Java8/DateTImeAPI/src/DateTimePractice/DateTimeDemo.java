package DateTimePractice;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        String formattedDateTime = dateTime.format(dateTimeFormatter);
        System.out.println("formattedDateTime => " + formattedDateTime);
        System.out.println("**********");

        // Zones
        ZonedDateTime india = ZonedDateTime.now();
        System.out.println(india.format(dateTimeFormatter));

        ZonedDateTime la = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(la.format(dateTimeFormatter));

        ZonedDateTime convertedToIST = la.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
        System.out.println(convertedToIST.format(dateTimeFormatter));
        System.out.println("**********");

        // Period
        Period period = Period.between(LocalDate.of(1996, 03, 02), LocalDate.now());
        System.out.println(period.getYears() + " years " + period.getMonths() + " months old");

        LocalTime laTime = LocalTime.now(ZoneId.of("America/Los_Angeles"));
        Duration duration = Duration.between(laTime, LocalTime.now());
        System.out.println(duration.toDays());

    }
}
