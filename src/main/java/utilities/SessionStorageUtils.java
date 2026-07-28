package utilities;

import driver.DriverManager;
import logger.FrameworkLogger;
import org.openqa.selenium.JavascriptExecutor;

public final class SessionStorageUtils {

    /**
     * Private constructor to prevent object creation.
     */
    private SessionStorageUtils() {
        throw new UnsupportedOperationException(
                "SessionStorageUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Sets an item in Session Storage.
     *
     * @param key Storage key
     * @param value Storage value
     */
    public static void setItem(String key, String value) {

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript(
                        "window.sessionStorage.setItem(arguments[0], arguments[1]);",
                        key,
                        value);

        FrameworkLogger.info("SessionStorage Item Added : " + key);
    }

    /**
     * Returns an item from Session Storage.
     *
     * @param key Storage key
     * @return Storage value
     */
    public static String getItem(String key) {

        String value = (String) ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript(
                        "return window.sessionStorage.getItem(arguments[0]);",
                        key);

        FrameworkLogger.info("SessionStorage Item Retrieved : " + key);

        return value;
    }

    /**
     * Removes an item.
     *
     * @param key Storage key
     */
    public static void removeItem(String key) {

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript(
                        "window.sessionStorage.removeItem(arguments[0]);",
                        key);

        FrameworkLogger.info("SessionStorage Item Removed : " + key);
    }

    /**
     * Clears Session Storage.
     */
    public static void clear() {

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("window.sessionStorage.clear();");

        FrameworkLogger.info("SessionStorage Cleared.");
    }

    /**
     * Returns the number of items.
     *
     * @return Item count
     */
    public static long size() {

        Long size = (Long) ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript(
                        "return window.sessionStorage.length;");

        FrameworkLogger.info("SessionStorage Size : " + size);

        return size;
    }

    /**
     * Checks whether a key exists.
     *
     * @param key Storage key
     * @return true if present
     */
    public static boolean contains(String key) {

        return getItem(key) != null;
    }
}