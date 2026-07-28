package base;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.ElementActions;
import utilities.JavaScriptUtils;
import utilities.WaitUtils;

public abstract class BasePage {

    /**
     * Click on an element.
     */
    protected void click(By locator) {
        ElementActions.click(locator);
    }

    /**
     * Enter text into an element.
     */
    protected void type(By locator, String text) {
        ElementActions.type(locator, text);
    }

    /**
     * Get visible text.
     */
    protected String getText(By locator) {
        return ElementActions.getText(locator);
    }

    /**
     * Clear text field.
     */
    protected void clear(By locator) {
        ElementActions.clear(locator);
    }

    /**
     * Check whether element is displayed.
     */
    protected boolean isDisplayed(By locator) {
        return ElementActions.isDisplayed(locator);
    }

    /**
     * Wait until element becomes visible.
     */
    protected WebElement waitForVisibility(By locator) {
        return WaitUtils.waitForVisibility(locator);
    }

    /**
     * Wait until element becomes clickable.
     */
    protected WebElement waitForClickable(By locator) {
        return WaitUtils.waitForClickable(locator);
    }

    /**
     * JavaScript click.
     */
    protected void jsClick(By locator) {
        JavaScriptUtils.click(locator);
    }

    /**
     * Scroll to element.
     */
    protected void scrollIntoView(By locator) {
        JavaScriptUtils.scrollIntoView(locator);
    }

    /**
     * Returns page title.
     */
    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    /**
     * Returns current URL.
     */
    protected String getCurrentUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }
}