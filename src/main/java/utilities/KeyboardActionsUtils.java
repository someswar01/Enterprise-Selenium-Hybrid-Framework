package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.DriverManager;

public final class KeyboardActionsUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private KeyboardActionsUtils() {
        throw new UnsupportedOperationException(
                "KeyboardActionsUtils is a utility class and cannot be instantiated.");
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
     * Presses ENTER on an element.
     *
     * @param locator Element locator
     */
    public static void pressEnter(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        element.sendKeys(Keys.ENTER);
    }

    /**
     * Presses TAB on an element.
     *
     * @param locator Element locator
     */
    public static void pressTab(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        element.sendKeys(Keys.TAB);
    }

    /**
     * Presses ESCAPE key.
     */
    public static void pressEscape() {

        getActions()
                .sendKeys(Keys.ESCAPE)
                .perform();
    }

    /**
     * Presses BACKSPACE on an element.
     *
     * @param locator Element locator
     */
    public static void pressBackspace(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        element.sendKeys(Keys.BACK_SPACE);
    }

    /**
     * Selects all text (Ctrl + A).
     *
     * @param locator Element locator
     */
    public static void selectAll(By locator) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        element.click();

        getActions()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();
    }

    /**
     * Copies selected text (Ctrl + C).
     */
    public static void copy() {

        getActions()
                .keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();
    }

    /**
     * Pastes copied text (Ctrl + V).
     */
    public static void paste() {

        getActions()
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();
    }

    /**
     * Cuts selected text (Ctrl + X).
     */
    public static void cut() {

        getActions()
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .keyUp(Keys.CONTROL)
                .perform();
    }

    /**
     * Refreshes the page using F5.
     */
    public static void refresh() {

        getActions()
                .sendKeys(Keys.F5)
                .perform();
    }

    /**
     * Presses a custom key on an element.
     *
     * @param locator Element locator
     * @param key Selenium key
     */
    public static void pressKey(By locator, Keys key) {

        WebElement element = WaitUtils.waitForVisibility(locator);

        element.sendKeys(key);
    }

    /**
     * Presses and holds the specified keyboard key.
     *
     * @param key Keyboard key to hold down
     */
    public static void keyDown(Keys key) {

        getActions()
                .keyDown(key)
                .perform();
    }

    /**
     * Releases the specified keyboard key.
     *
     * @param key Keyboard key to release
     */
    public static void keyUp(Keys key) {

        getActions()
                .keyUp(key)
                .perform();
    }

    /**
     * Sends one or more keyboard keys to the active element.
     *
     * @param keys Keyboard keys to send
     */
    public static void sendKeys(CharSequence... keys) {

        getActions()
                .sendKeys(keys)
                .perform();
    }
}