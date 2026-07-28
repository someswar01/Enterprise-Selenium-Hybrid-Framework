package utilities;

import driver.DriverManager;
import logger.FrameworkLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

import java.time.Duration;

public final class AlertUtils {

    private AlertUtils() {
        throw new UnsupportedOperationException(
                "AlertUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Wait for alert and return Alert object.
     */
    private static Alert getAlert() {

        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(ConfigReader.getExplicitWait()));

        return wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Accept alert.
     */
    public static void acceptAlert() {

        getAlert().accept();
        FrameworkLogger.info("Alert accepted.");
    }

    /**
     * Dismiss alert.
     */
    public static void dismissAlert() {

        getAlert().dismiss();
        FrameworkLogger.info("Alert dismissed.");
    }

    /**
     * Get alert text.
     */
    public static String getAlertText() {

        String text = getAlert().getText();

        FrameworkLogger.info("Alert Text : " + text);

        return text;
    }

    /**
     * Type text into prompt alert.
     */
    public static void enterText(String text) {

        getAlert().sendKeys(text);

        FrameworkLogger.info("Entered text into alert.");
    }

    /**
     * Check whether alert is present.
     */
    public static boolean isAlertPresent() {

        try {

            DriverManager.getDriver()
                    .switchTo()
                    .alert();

            return true;

        } catch (NoAlertPresentException e) {

            return false;
        }
    }

    /**
     * Accept alert if present.
     */
    public static void acceptIfPresent() {

        if (isAlertPresent()) {

            acceptAlert();
        }
    }

    /**
     * Dismiss alert if present.
     */
    public static void dismissIfPresent() {

        if (isAlertPresent()) {

            dismissAlert();
        }
    }
}