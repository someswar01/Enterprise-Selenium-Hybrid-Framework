package utilities;

import driver.DriverManager;
import logger.FrameworkLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class FrameUtils {

    private FrameUtils() {
        throw new UnsupportedOperationException(
                "FrameUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Switch to frame using index.
     *
     * @param index Frame index
     */
    public static void switchToFrame(int index) {

        DriverManager.getDriver()
                .switchTo()
                .frame(index);

        FrameworkLogger.info("Switched to frame using index : " + index);
    }

    /**
     * Switch to frame using name or id.
     *
     * @param nameOrId Frame name or id
     */
    public static void switchToFrame(String nameOrId) {

        DriverManager.getDriver()
                .switchTo()
                .frame(nameOrId);

        FrameworkLogger.info("Switched to frame : " + nameOrId);
    }

    /**
     * Switch to frame using WebElement.
     *
     * @param frameElement Frame WebElement
     */
    public static void switchToFrame(WebElement frameElement) {

        DriverManager.getDriver()
                .switchTo()
                .frame(frameElement);

        FrameworkLogger.info("Switched to frame using WebElement.");
    }

    /**
     * Switch to frame using locator.
     *
     * @param locator Frame locator
     */
    public static void switchToFrame(By locator) {

        WebElement frame =
                WaitUtils.waitForVisibility(locator);

        DriverManager.getDriver()
                .switchTo()
                .frame(frame);

        FrameworkLogger.info("Switched to frame using locator : " + locator);
    }

    /**
     * Switch back to parent frame.
     */
    public static void switchToParentFrame() {

        DriverManager.getDriver()
                .switchTo()
                .parentFrame();

        FrameworkLogger.info("Switched to parent frame.");
    }

    /**
     * Switch back to default content.
     */
    public static void switchToDefaultContent() {

        DriverManager.getDriver()
                .switchTo()
                .defaultContent();

        FrameworkLogger.info("Switched to default content.");
    }

    /**
     * Get current active frame element.
     *
     * @return Current frame WebElement
     */
    public static WebElement getCurrentFrame() {

        return DriverManager.getDriver()
                .switchTo()
                .activeElement();
    }

    /**
     * Check whether frame exists.
     *
     * @param locator Frame locator
     * @return true if frame exists
     */
    public static boolean isFramePresent(By locator) {

        try {

            WaitUtils.waitForVisibility(locator);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}