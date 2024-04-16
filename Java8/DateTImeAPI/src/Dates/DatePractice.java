package Dates;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePractice {

    public static void main(String[] args) {

        // Formatting
        LocalDate localDate = LocalDate.of(1996, 3, 2);
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = localDate.format(formatter);
        System.out.println(formattedDate);

        DateTimeFormatter formatter1 =
                DateTimeFormatter.ofPattern("MMM dd, yyyy");
        String formattedDate1 = localDate.format(formatter1);
        System.out.println(formattedDate1);

        // Parsing
        LocalDate parsedDate = null;
        try {
            parsedDate = LocalDate.parse(formattedDate, formatter);
        } catch (DateTimeException e) {
            System.out.println(e);
        }
        System.out.println(parsedDate);
    }
}
