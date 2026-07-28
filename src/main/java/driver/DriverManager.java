package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
        throw new UnsupportedOperationException(
                "DriverManager is a utility class and cannot be instantiated.");
    }

    private static final ThreadLocal<WebDriver> driverThreadLocal =
            new ThreadLocal<>();

    /**
     * Store driver for current thread.
     */
    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    /**
     * Returns driver for current thread.
     */
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    /**
     * Removes driver from current thread.
     */
    public static void unloadDriver() {
        driverThreadLocal.remove();
    }

}
