package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver.DriverManager;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
        throw new UnsupportedOperationException(
                "Utility class");
    }

    public static String captureScreenshot(String testName) {

        WebDriver driver = DriverManager.getDriver();

        if (driver == null) {
            return null;
        }
        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String destination =
                System.getProperty("user.dir")
                        + "/test-output/screenshots/"
                        + testName
                        + "_"
                        + timestamp
                        + ".png";

        try {

            Files.createDirectories(
                    new File(destination).getParentFile().toPath());

            Files.copy(
                    source.toPath(),
                    new File(destination).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to capture screenshot", e);
        }

        return destination;
    }

}
