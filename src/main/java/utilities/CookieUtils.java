package utilities;

import driver.DriverManager;
import logger.FrameworkLogger;
import org.openqa.selenium.Cookie;

import java.util.Set;

public final class CookieUtils {

    /**
     * Private constructor to prevent object creation.
     */
    private CookieUtils() {
        throw new UnsupportedOperationException(
                "CookieUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Adds a cookie.
     *
     * @param cookie Cookie object
     */
    public static void addCookie(Cookie cookie) {

        DriverManager.getDriver()
                .manage()
                .addCookie(cookie);

        FrameworkLogger.info("Cookie added : " + cookie.getName());
    }

    /**
     * Returns a cookie by name.
     *
     * @param name Cookie name
     * @return Cookie
     */
    public static Cookie getCookie(String name) {

        FrameworkLogger.info("Getting cookie : " + name);

        return DriverManager.getDriver()
                .manage()
                .getCookieNamed(name);
    }

    /**
     * Returns all cookies.
     *
     * @return Set of Cookies
     */
    public static Set<Cookie> getAllCookies() {

        FrameworkLogger.info("Getting all cookies.");

        return DriverManager.getDriver()
                .manage()
                .getCookies();
    }

    /**
     * Deletes a cookie by name.
     *
     * @param name Cookie name
     */
    public static void deleteCookie(String name) {

        DriverManager.getDriver()
                .manage()
                .deleteCookieNamed(name);

        FrameworkLogger.info("Deleted cookie : " + name);
    }

    /**
     * Deletes the given cookie.
     *
     * @param cookie Cookie object
     */
    public static void deleteCookie(Cookie cookie) {

        DriverManager.getDriver()
                .manage()
                .deleteCookie(cookie);

        FrameworkLogger.info("Deleted cookie : " + cookie.getName());
    }

    /**
     * Deletes all cookies.
     */
    public static void deleteAllCookies() {

        DriverManager.getDriver()
                .manage()
                .deleteAllCookies();

        FrameworkLogger.info("Deleted all cookies.");
    }

    /**
     * Checks whether a cookie exists.
     *
     * @param name Cookie name
     * @return true if present
     */
    public static boolean isCookiePresent(String name) {

        boolean present = getCookie(name) != null;

        FrameworkLogger.info(
                "Cookie '" + name + "' present : " + present);

        return present;
    }

    /**
     * Returns the number of cookies.
     *
     * @return Cookie count
     */
    public static int getCookieCount() {

        int count = getAllCookies().size();

        FrameworkLogger.info("Cookie count : " + count);

        return count;
    }

    /**
     * Prints all cookies to the console.
     */
    public static void printAllCookies() {

        getAllCookies().forEach(System.out::println);

        FrameworkLogger.info("Printed all cookies.");
    }
}