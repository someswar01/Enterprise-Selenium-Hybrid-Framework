package utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import driver.DriverManager;

public final class WindowUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private WindowUtils() {
        throw new UnsupportedOperationException(
                "WindowUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Returns the current window handle.
     *
     * @return Current window handle
     */
    public static String getCurrentWindow() {

        return DriverManager.getDriver().getWindowHandle();
    }

    /**
     * Returns all available window handles.
     *
     * @return Set of window handles
     */
    public static Set<String> getAllWindows() {

        return DriverManager.getDriver().getWindowHandles();
    }

    /**
     * Switches to a window using its handle.
     *
     * @param windowHandle Window handle
     */
    public static void switchToWindow(String windowHandle) {

        DriverManager.getDriver()
                .switchTo()
                .window(windowHandle);
    }

    /**
     * Switches to the newly opened window.
     */
    public static void switchToNewWindow() {

        String currentWindow = getCurrentWindow();

        for (String window : getAllWindows()) {

            if (!window.equals(currentWindow)) {

                switchToWindow(window);

                break;
            }
        }
    }

    /**
     * Closes the current window.
     */
    public static void closeCurrentWindow() {

        DriverManager.getDriver().close();
    }

    /**
     * Closes the current window and switches back
     * to the parent window.
     *
     * @param parentWindow Parent window handle
     */
    public static void closeCurrentWindowAndSwitchBack(String parentWindow) {

        DriverManager.getDriver().close();

        switchToWindow(parentWindow);
    }

    /**
     * Returns the number of opened windows.
     *
     * @return Window count
     */
    public static int getWindowCount() {

        return getAllWindows().size();
    }

    /**
     * Closes all child windows and switches back
     * to the parent window.
     *
     * @param parentWindow Parent window handle
     */
    public static void closeAllChildWindows(String parentWindow) {

        WebDriver driver = DriverManager.getDriver();

        for (String window : driver.getWindowHandles()) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
    }

    /**
     * Switches to a window based on its title.
     *
     * @param title Window title
     */
    public static void switchToWindowByTitle(String title) {

        WebDriver driver = DriverManager.getDriver();

        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);

            if (driver.getTitle().equals(title)) {

                break;
            }
        }
    }

    /**
     * Switches to a window based on URL.
     *
     * @param url URL to match
     */
    public static void switchToWindowByUrl(String url) {

        WebDriver driver = DriverManager.getDriver();

        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);

            if (driver.getCurrentUrl().contains(url)) {

                break;
            }
        }
    }

}