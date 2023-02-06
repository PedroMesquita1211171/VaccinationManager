package app.domain.model.US16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParser {

    public static LocalDateTime parseDate(String date, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        return LocalDateTime.parse(date, formatter);
    }
}
