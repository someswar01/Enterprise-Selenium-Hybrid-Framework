package utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class DateUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private DateUtils() {
        throw new UnsupportedOperationException(
                "DateUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Returns today's date.
     *
     * @return Today's date
     */
    public static LocalDate getCurrentDate() {

        return LocalDate.now();
    }

    /**
     * Returns current date and time.
     *
     * @return Current date time
     */
    public static LocalDateTime getCurrentDateTime() {

        return LocalDateTime.now();
    }

    /**
     * Returns today's date in the given format.
     *
     * @param pattern Date format pattern
     * @return Formatted date
     */
    public static String getCurrentDate(String pattern) {

        return LocalDate.now()
                .format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Returns current date and time in the given format.
     *
     * @param pattern Date time format pattern
     * @return Formatted date time
     */
    public static String getCurrentDateTime(String pattern) {

        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Returns a future date.
     *
     * @param days Number of days to add
     * @return Future date
     */
    public static LocalDate getFutureDate(int days) {

        return LocalDate.now().plusDays(days);
    }

    /**
     * Returns a past date.
     *
     * @param days Number of days to subtract
     * @return Past date
     */
    public static LocalDate getPastDate(int days) {

        return LocalDate.now().minusDays(days);
    }

    /**
     * Returns a future date in the specified format.
     *
     * @param days Number of days
     * @param pattern Date format
     * @return Formatted future date
     */
    public static String getFutureDate(int days, String pattern) {

        return LocalDate.now()
                .plusDays(days)
                .format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Returns a past date in the specified format.
     *
     * @param days Number of days
     * @param pattern Date format
     * @return Formatted past date
     */
    public static String getPastDate(int days, String pattern) {

        return LocalDate.now()
                .minusDays(days)
                .format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Returns the current timestamp.
     *
     * @return Timestamp
     */
    public static String getTimeStamp() {

        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    }

    /**
     * Returns the first day of the current month.
     *
     * @return First day of current month in yyyy-MM-dd format
     */
    public static String getFirstDayOfMonth() {

        return LocalDate.now()
                .withDayOfMonth(1)
                .toString();
    }

    /**
     * Returns the last day of the current month.
     *
     * @return Last day of current month in yyyy-MM-dd format
     */
    public static String getLastDayOfMonth() {

        return LocalDate.now()
                .withDayOfMonth(
                        LocalDate.now().lengthOfMonth())
                .toString();
    }

    /**
     * Checks whether the current year is a leap year.
     *
     * @return true if current year is leap year
     */
    public static boolean isLeapYear() {

        return Year.now().isLeap();
    }

    /**
     * Returns the number of days between two dates.
     *
     * @param start Start date
     * @param end End date
     * @return Number of days between dates
     */
    public static long daysBetween(LocalDate start,
                                   LocalDate end) {

        return ChronoUnit.DAYS.between(start, end);
    }

    /**
     * Returns the current year.
     *
     * @return Current year
     */
    public static int getCurrentYear() {

        return LocalDate.now().getYear();
    }

    /**
     * Returns the current month.
     *
     * @return Current month (1-12)
     */
    public static int getCurrentMonth() {

        return LocalDate.now().getMonthValue();
    }
}