package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;
import driver.DriverManager;

public final class WaitUtils {

    private WaitUtils() {
        throw new UnsupportedOperationException(
                "WaitUtils is a utility class and cannot be instantiated.");
    }

    private static WebDriverWait getWait() {
        WebDriver driver = DriverManager.getDriver();

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getExplicitWait()));
    }

    public static WebElement waitForVisibility(By locator) {
        return getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return getWait().until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForInvisibility(By locator) {
        return getWait().until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean waitForTitleContains(String title) {
        return getWait().until(
                ExpectedConditions.titleContains(title));
    }

    public static boolean waitForUrlContains(String url) {
        return getWait().until(
                ExpectedConditions.urlContains(url));
    }

    public static WebElement waitForPresence(By locator) {
        return getWait().until(
                ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static List<WebElement> waitForAllElements(By locator) {
        return getWait().until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static boolean waitForText(By locator, String text) {

        return getWait().until(
                ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static boolean waitForAttributeContains(By locator,
                                                   String attribute,
                                                   String value) {

        return getWait().until(
                ExpectedConditions.attributeContains(locator, attribute, value));
    }


    /**
     * Waits until an alert is displayed.
     */
    public static void waitForAlert() {

        getWait().until(
                ExpectedConditions.alertIsPresent());
    }

    public static List<WebElement> waitForNumberOfElements(By locator,
                                                           int count) {

        getWait().until(
                ExpectedConditions.numberOfElementsToBe(locator, count));

        return DriverManager.getDriver().findElements(locator);
    }

    public static void waitForPageLoad() {

        getWait().until(driver ->
                ((String)((org.openqa.selenium.JavascriptExecutor)driver)
                        .executeScript("return document.readyState"))
                        .equals("complete"));
    }
}