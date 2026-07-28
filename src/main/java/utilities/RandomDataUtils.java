package utilities;

import java.util.Random;
import java.util.UUID;

public final class RandomDataUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private RandomDataUtils() {
        throw new UnsupportedOperationException(
                "RandomDataUtils is a utility class and cannot be instantiated.");
    }

    private static final Random RANDOM = new Random();

    /**
     * Generates a random integer.
     *
     * @param bound Upper bound (exclusive)
     * @return Random integer
     */
    public static int getRandomNumber(int bound) {

        return RANDOM.nextInt(bound);
    }

    /**
     * Generates a random integer within the given range.
     *
     * @param min Minimum value
     * @param max Maximum value
     * @return Random number
     */
    public static int getRandomNumber(int min, int max) {

        return RANDOM.nextInt(max - min + 1) + min;
    }

    /**
     * Generates a random alphabetic string.
     *
     * @param length Required length
     * @return Random string
     */
    public static String getRandomString(int length) {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {

            builder.append(
                    characters.charAt(
                            RANDOM.nextInt(characters.length())));
        }

        return builder.toString();
    }

    /**
     * Generates a random numeric string.
     *
     * @param length Required length
     * @return Random numeric string
     */
    public static String getRandomNumericString(int length) {

        String numbers = "0123456789";

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {

            builder.append(
                    numbers.charAt(
                            RANDOM.nextInt(numbers.length())));
        }

        return builder.toString();
    }

    /**
     * Generates a random email address.
     *
     * @return Random email
     */
    public static String getRandomEmail() {

        return "user"
                + UUID.randomUUID().toString().substring(0, 8)
                + "@gmail.com";
    }

    /**
     * Generates a random mobile number.
     *
     * @return Random mobile number
     */
    public static String getRandomMobileNumber() {

        return "9" + getRandomNumericString(9);
    }

    /**
     * Generates a UUID.
     *
     * @return UUID string
     */
    public static String getUUID() {

        return UUID.randomUUID().toString();
    }

    public static String getRandomEmail(String domain) {

        return "user"
                + UUID.randomUUID().toString().substring(0, 8)
                + "@"
                + domain;
    }
}