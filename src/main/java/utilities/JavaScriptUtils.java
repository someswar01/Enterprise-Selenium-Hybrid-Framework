package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import driver.DriverManager;

public final class JavaScriptUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private JavaScriptUtils() {
        throw new UnsupportedOperationException(
                "JavaScriptUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Returns the JavaScriptExecutor instance.
     *
     * @return JavascriptExecutor
     */
    private static JavascriptExecutor getJsExecutor() {

        return (JavascriptExecutor) DriverManager.getDriver();
    }

    /**
     * Clicks on an element using JavaScript.
     * Useful when Selenium click() fails due to overlays,
     * intercepted clicks, or hidden elements.
     *
     * @param locator Element locator
     */
    public static void click(By locator) {

        WebElement element = WaitUtils.waitForClickable(locator);

        getJsExecutor().executeScript(
                "arguments[0].click();",
                element);
    }

    /**
     * Scrolls the page until the element is visible.
     * The element will be aligned at the center of the viewport.
     *
     * @param locator Element locator
     */
    public static void scrollIntoView(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        getJsExecutor().executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",
                element);
    }

    /**
     * Scrolls the page to the top.
     */
    public static void scrollToTop() {

        getJsExecutor().executeScript(
                "window.scrollTo(0,0);");
    }

    /**
     * Scrolls the page to the bottom.
     */
    public static void scrollToBottom() {

        getJsExecutor().executeScript(
                "window.scrollTo(0,document.body.scrollHeight);");
    }

    /**
     * Scrolls the page by the specified X and Y coordinates.
     *
     * @param x Horizontal pixels
     * @param y Vertical pixels
     */
    public static void scrollBy(int x, int y) {

        getJsExecutor().executeScript(
                "window.scrollBy(arguments[0], arguments[1]);",
                x,
                y);
    }

    /**
     * Highlights an element by applying a red border.
     * Useful while debugging or during demo execution.
     *
     * @param locator Element locator
     */
    public static void highlight(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        getJsExecutor().executeScript(
                "arguments[0].style.border='3px solid red';",
                element);
    }

    /**
     * Sets the value of an input field using JavaScript.
     * Useful when sendKeys() does not work.
     *
     * @param locator Element locator
     * @param value Value to enter
     */
    public static void setValue(By locator, String value) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        getJsExecutor().executeScript(
                "arguments[0].value=arguments[1];",
                element,
                value);
    }

    /**
     * Returns the page title using JavaScript.
     *
     * @return Page title
     */
    public static String getTitle() {

        return (String) getJsExecutor()
                .executeScript("return document.title;");
    }

    /**
     * Returns the current page URL using JavaScript.
     *
     * @return Current URL
     */
    public static String getUrl() {

        return (String) getJsExecutor()
                .executeScript("return document.URL;");
    }

    /**
     * Returns the current page loading state.
     * Possible values:
     * loading
     * interactive
     * complete
     *
     * @return Document ready state
     */
    public static String getPageReadyState() {

        return (String) getJsExecutor()
                .executeScript("return document.readyState;");
    }
}