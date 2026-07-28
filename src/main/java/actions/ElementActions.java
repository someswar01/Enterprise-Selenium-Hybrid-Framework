package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.WaitUtils;

public final class ElementActions {

    private ElementActions() {
        throw new UnsupportedOperationException(
                "Utility class");
    }

    public static void click(By locator) {
        WaitUtils.waitForClickable(locator).click();
    }

    public static void type(By locator, String text) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(By locator) {
        return WaitUtils.waitForVisibility(locator).getText();
    }

    public static boolean isDisplayed(By locator) {
        return WaitUtils.waitForVisibility(locator).isDisplayed();
    }

    public static boolean isEnabled(By locator) {
        return WaitUtils.waitForVisibility(locator).isEnabled();
    }

    public static boolean isSelected(By locator) {
        return WaitUtils.waitForVisibility(locator).isSelected();
    }

    public static String getAttribute(By locator, String attribute) {
        return WaitUtils.waitForVisibility(locator)
                .getAttribute(attribute);
    }

    public static List<WebElement> getElements(By locator) {
        return WaitUtils.waitForAllElements(locator);
    }

    public static int getElementCount(By locator) {
        return getElements(locator).size();
    }
}