package utilities;

import driver.DriverManager;
import logger.FrameworkLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public final class ElementActions {

    private ElementActions() {
        throw new UnsupportedOperationException(
                "ElementActions is a utility class and cannot be instantiated.");
    }

    /**
     * Click on an element.
     */
    public static void click(By locator) {

        WaitUtils.waitForClickable(locator).click();
        FrameworkLogger.info("Clicked on element : " + locator);
    }

    /**
     * Type text into an element.
     */
    public static void type(By locator, String text) {

        WebElement element = WaitUtils.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);

        FrameworkLogger.info("Entered text into : " + locator);
    }

    /**
     * Clear an input field.
     */
    public static void clear(By locator) {

        WaitUtils.waitForVisibility(locator).clear();
        FrameworkLogger.info("Cleared element : " + locator);
    }

    /**
     * Get visible text.
     */
    public static String getText(By locator) {

        String text = WaitUtils.waitForVisibility(locator).getText();

        FrameworkLogger.info("Text from element : " + locator);

        return text;
    }

    /**
     * Get attribute value.
     */
    public static String getAttribute(By locator, String attribute) {

        return WaitUtils.waitForVisibility(locator)
                .getAttribute(attribute);
    }

    /**
     * Check if element is displayed.
     */
    public static boolean isDisplayed(By locator) {

        try {
            return WaitUtils.waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if element is enabled.
     */
    public static boolean isEnabled(By locator) {

        return WaitUtils.waitForVisibility(locator).isEnabled();
    }

    /**
     * Check if element is selected.
     */
    public static boolean isSelected(By locator) {

        return WaitUtils.waitForVisibility(locator).isSelected();
    }

    /**
     * Submit a form.
     */
    public static void submit(By locator) {

        WaitUtils.waitForVisibility(locator).submit();

        FrameworkLogger.info("Submitted form.");
    }

    /**
     * Get element size.
     */
    public static Dimension getSize(By locator) {

        return WaitUtils.waitForVisibility(locator).getSize();
    }

    /**
     * Get element location.
     */
    public static Point getLocation(By locator) {

        return WaitUtils.waitForVisibility(locator).getLocation();
    }

    /**
     * Get CSS property value.
     */
    public static String getCssValue(By locator, String propertyName) {

        return WaitUtils.waitForVisibility(locator)
                .getCssValue(propertyName);
    }

    /**
     * Select dropdown by visible text.
     */
    public static void selectByVisibleText(By locator, String text) {

        Select select = new Select(WaitUtils.waitForVisibility(locator));
        select.selectByVisibleText(text);

        FrameworkLogger.info("Selected '" + text + "' from dropdown.");
    }

    /**
     * Select dropdown by value.
     */
    public static void selectByValue(By locator, String value) {

        Select select = new Select(WaitUtils.waitForVisibility(locator));
        select.selectByValue(value);
    }

    /**
     * Select dropdown by index.
     */
    public static void selectByIndex(By locator, int index) {

        Select select = new Select(WaitUtils.waitForVisibility(locator));
        select.selectByIndex(index);
    }

    /**
     * Return all matching elements.
     */
    public static List<WebElement> getElements(By locator) {

        return WaitUtils.waitForAllElements(locator);
    }

    /**
     * Return first matching element.
     */
    public static WebElement getElement(By locator) {

        return WaitUtils.waitForVisibility(locator);
    }

    /**
     * Scroll until the element is visible.
     */
    public static void scrollIntoView(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * JavaScript click.
     */
    public static void jsClick(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].click();", element);
    }

    /**
     * Highlight element for debugging.
     */
    public static void highlight(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript(
                        "arguments[0].style.border='3px solid red';",
                        element);
    }
}