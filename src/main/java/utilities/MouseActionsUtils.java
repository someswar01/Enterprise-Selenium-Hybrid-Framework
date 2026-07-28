package utilities;

import driver.DriverManager;
import logger.FrameworkLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public final class MouseActionsUtils {

    /**
     * Private constructor to prevent object creation.
     */
    private MouseActionsUtils() {
        throw new UnsupportedOperationException(
                "MouseActionsUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Returns Actions instance.
     *
     * @return Actions
     */
    private static Actions getActions() {
        return new Actions(DriverManager.getDriver());
    }

    /**
     * Moves mouse over an element.
     *
     * @param locator Element locator
     */
    public static void hover(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        getActions()
                .moveToElement(element)
                .perform();

        FrameworkLogger.info("Hovered over element : " + locator);
    }

    /**
     * Hovers over an element and clicks it.
     *
     * @param locator Element locator
     */
    public static void hoverAndClick(By locator) {

        WebElement element = WaitUtils.waitForClickable(locator);

        getActions()
                .moveToElement(element)
                .click()
                .perform();

        FrameworkLogger.info("Hovered and clicked element : " + locator);
    }

    /**
     * Performs double click.
     *
     * @param locator Element locator
     */
    public static void doubleClick(By locator) {

        WebElement element = WaitUtils.waitForClickable(locator);

        getActions()
                .doubleClick(element)
                .perform();

        FrameworkLogger.info("Double clicked element : " + locator);
    }

    /**
     * Performs right click.
     *
     * @param locator Element locator
     */
    public static void rightClick(By locator) {

        WebElement element = WaitUtils.waitForClickable(locator);

        getActions()
                .contextClick(element)
                .perform();

        FrameworkLogger.info("Right clicked element : " + locator);
    }

    /**
     * Performs drag and drop.
     *
     * @param source Source locator
     * @param target Target locator
     */
    public static void dragAndDrop(By source, By target) {

        WebElement sourceElement = WaitUtils.waitForVisibility(source);
        WebElement targetElement = WaitUtils.waitForVisibility(target);

        getActions()
                .dragAndDrop(sourceElement, targetElement)
                .perform();

        FrameworkLogger.info(
                "Dragged element from " + source + " to " + target);
    }

    /**
     * Drags an element by X and Y offset.
     *
     * @param locator Element locator
     * @param x Horizontal offset
     * @param y Vertical offset
     */
    public static void dragAndDropByOffset(By locator,
                                           int x,
                                           int y) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        getActions()
                .dragAndDropBy(element, x, y)
                .perform();

        FrameworkLogger.info(
                "Dragged element by offset X=" + x + " Y=" + y);
    }

    /**
     * Clicks and holds an element.
     *
     * @param locator Element locator
     */
    public static void clickAndHold(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        getActions()
                .clickAndHold(element)
                .perform();

        FrameworkLogger.info(
                "Clicked and held element : " + locator);
    }

    /**
     * Starts dragging an element without releasing.
     *
     * @param locator Element locator
     */
    public static void dragAndHold(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        getActions()
                .clickAndHold(element)
                .moveByOffset(100, 0)
                .perform();

        FrameworkLogger.info(
                "Started dragging element : " + locator);
    }

    /**
     * Releases the currently held mouse button.
     */
    public static void release() {

        getActions()
                .release()
                .perform();

        FrameworkLogger.info("Released mouse button.");
    }

    /**
     * Releases mouse on target element.
     *
     * @param locator Target locator
     */
    public static void release(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        getActions()
                .release(element)
                .perform();

        FrameworkLogger.info(
                "Released mouse on element : " + locator);
    }

    /**
     * Moves mouse by X and Y offset.
     *
     * @param x Horizontal offset
     * @param y Vertical offset
     */
    public static void moveByOffset(int x,
                                    int y) {

        getActions()
                .moveByOffset(x, y)
                .perform();

        FrameworkLogger.info(
                "Moved mouse by offset X=" + x + " Y=" + y);
    }

    /**
     * Moves mouse by offset and clicks.
     *
     * @param x Horizontal offset
     * @param y Vertical offset
     */
    public static void clickByOffset(int x,
                                     int y) {

        getActions()
                .moveByOffset(x, y)
                .click()
                .perform();

        FrameworkLogger.info(
                "Clicked at offset X=" + x + " Y=" + y);
    }
}