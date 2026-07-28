package utilities;

import driver.DriverManager;
import logger.FrameworkLogger;
import org.openqa.selenium.JavascriptExecutor;

public final class LocalStorageUtils {

    /**
     * Private constructor to prevent object creation.
     */
    private LocalStorageUtils() {
        throw new UnsupportedOperationException(
                "LocalStorageUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Sets an item in Local Storage.
     *
     * @param key Storage key
     * @param value Storage value
     */
    public static void setItem(String key, String value) {

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript(
                        "window.localStorage.setItem(arguments[0], arguments[1]);",
                        key,
                        value);

        FrameworkLogger.info("LocalStorage Item Added : " + key);
    }

    /**
     * Returns a value from Local Storage.
     *
     * @param key Storage key
     * @return Storage value
     */
    public static String getItem(String key) {

        String value = (String) ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript(
                        "return window.localStorage.getItem(arguments[0]);",
                        key);

        FrameworkLogger.info("LocalStorage Item Retrieved : " + key);

        return value;
    }

    /**
     * Removes an item from Local Storage.
     *
     * @param key Storage key
     */
    public static void removeItem(String key) {

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript(
                        "window.localStorage.removeItem(arguments[0]);",
                        key);

        FrameworkLogger.info("LocalStorage Item Removed : " + key);
    }

    /**
     * Clears Local Storage.
     */
    public static void clear() {

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("window.localStorage.clear();");

        FrameworkLogger.info("LocalStorage Cleared.");
    }

    /**
     * Returns the number of items.
     *
     * @return Item count
     */
    public static long size() {

        Long size = (Long) ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript(
                        "return window.localStorage.length;");

        FrameworkLogger.info("LocalStorage Size : " + size);

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