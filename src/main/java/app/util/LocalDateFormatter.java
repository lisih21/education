package app.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@UtilityClass
public class LocalDateFormatter {
    private static final String PATTERN = "yyyy-MM-dd";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);
    LocalDate START_DATE = LocalDate.of(1900, 01, 01);

    public LocalDate format(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    public boolean isValid(String date) {
        try {
            Optional<LocalDate> optional = Optional.ofNullable(date)
                    .map(LocalDateFormatter::format);
            boolean result = optional.isPresent()
                    && !optional.get().isAfter(LocalDate.now())
                    && !optional.get().isBefore(START_DATE);
            return result;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
