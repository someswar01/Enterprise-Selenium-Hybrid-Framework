package utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class FileUploadUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private FileUploadUtils() {
        throw new UnsupportedOperationException(
                "FileUploadUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Uploads a file using Selenium sendKeys().
     * This works only for input elements of type="file".
     *
     * @param locator Input file locator
     * @param filePath Absolute file path
     */
    public static void uploadUsingSendKeys(By locator, String filePath) {

        WebElement uploadElement = WaitUtils.waitForPresence(locator);

        uploadElement.sendKeys(filePath);
    }

    /**
     * Uploads a file using Java Robot.
     * Use this method when a native OS file chooser is displayed.
     *
     * @param filePath Absolute file path
     */
    public static void uploadUsingRobot(String filePath) {

        try {

            StringSelection selection =
                    new StringSelection(filePath);

            Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(selection, null);

            Robot robot = new Robot();

            robot.delay(1000);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(500);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to upload file using Robot.", e);
        }
    }

    /**
     * Returns the absolute path of a file inside the project's resources folder.
     *
     * @param relativePath Relative path under src/test/resources
     * @return Absolute file path
     */
    public static String getFilePath(String relativePath) {

        return System.getProperty("user.dir")
                + "/src/test/resources/"
                + relativePath;
    }
}