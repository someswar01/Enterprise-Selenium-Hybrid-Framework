package utilities;

import driver.DriverManager;
import logger.FrameworkLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public final class ShadowDomUtils {

    /**
     * Private constructor to prevent object creation.
     */
    private ShadowDomUtils() {
        throw new UnsupportedOperationException(
                "ShadowDomUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Returns the shadow root of a shadow host.
     *
     * @param shadowHostLocator Shadow host locator
     * @return SearchContext
     */
    public static SearchContext getShadowRoot(By shadowHostLocator) {

        WebElement shadowHost =
                WaitUtils.waitForVisibility(shadowHostLocator);

        FrameworkLogger.info(
                "Getting Shadow Root for : " + shadowHostLocator);

        return shadowHost.getShadowRoot();
    }

    /**
     * Returns an element inside Shadow DOM.
     *
     * @param shadowHostLocator Shadow host locator
     * @param elementLocator Element inside shadow root
     * @return WebElement
     */
    public static WebElement getShadowElement(
            By shadowHostLocator,
            By elementLocator) {

        FrameworkLogger.info(
                "Locating Shadow Element : " + elementLocator);

        return getShadowRoot(shadowHostLocator)
                .findElement(elementLocator);
    }

    /**
     * Clicks an element inside Shadow DOM.
     *
     * @param shadowHostLocator Shadow host locator
     * @param elementLocator Element locator
     */
    public static void click(
            By shadowHostLocator,
            By elementLocator) {

        getShadowElement(
                shadowHostLocator,
                elementLocator)
                .click();

        FrameworkLogger.info(
                "Clicked Shadow Element : " + elementLocator);
    }

    /**
     * Enters text into a Shadow DOM element.
     *
     * @param shadowHostLocator Shadow host locator
     * @param elementLocator Element locator
     * @param text Text to enter
     */
    public static void sendKeys(
            By shadowHostLocator,
            By elementLocator,
            String text) {

        WebElement element =
                getShadowElement(
                        shadowHostLocator,
                        elementLocator);

        element.clear();
        element.sendKeys(text);

        FrameworkLogger.info(
                "Entered text into Shadow Element : "
                        + elementLocator);
    }

    /**
     * Returns text from a Shadow DOM element.
     *
     * @param shadowHostLocator Shadow host locator
     * @param elementLocator Element locator
     * @return Text
     */
    public static String getText(
            By shadowHostLocator,
            By elementLocator) {

        String text =
                getShadowElement(
                        shadowHostLocator,
                        elementLocator)
                        .getText();

        FrameworkLogger.info(
                "Retrieved text from Shadow Element.");

        return text;
    }

    /**
     * Checks whether a Shadow DOM element is displayed.
     *
     * @param shadowHostLocator Shadow host locator
     * @param elementLocator Element locator
     * @return true if displayed
     */
    public static boolean isDisplayed(
            By shadowHostLocator,
            By elementLocator) {

        boolean displayed =
                getShadowElement(
                        shadowHostLocator,
                        elementLocator)
                        .isDisplayed();

        FrameworkLogger.info(
                "Shadow Element Displayed : "
                        + displayed);

        return displayed;
    }

    /**
     * Returns Shadow Root using JavaScript.
     * Useful for older browsers.
     *
     * @param shadowHostLocator Shadow host locator
     * @return SearchContext
     */
    public static SearchContext getShadowRootUsingJS(
            By shadowHostLocator) {

        WebElement shadowHost =
                WaitUtils.waitForVisibility(shadowHostLocator);

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        FrameworkLogger.info(
                "Getting Shadow Root using JavaScript.");

        return (SearchContext) js.executeScript(
                "return arguments[0].shadowRoot;",
                shadowHost);
    }
}