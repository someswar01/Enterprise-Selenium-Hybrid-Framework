package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import config.ConfigReader;
import enums.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

    private DriverFactory() {
        throw new UnsupportedOperationException(
                "DriverFactory is a utility class and cannot be instantiated.");
    }

    public static void initDriver() {

        BrowserType browser = ConfigReader.getBrowser();

        WebDriver driver;
        System.out.println("Browser = " + ConfigReader.getBrowser());
        switch (browser) {

            case CHROME -> {

                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();

                if (ConfigReader.isHeadless()) {
                    options.addArguments("--headless=new");
                }

                driver = new ChromeDriver(options);
            }

            case EDGE -> {

                WebDriverManager.edgedriver().setup();

                EdgeOptions options = new EdgeOptions();

                if (ConfigReader.isHeadless()) {
                    options.addArguments("--headless=new");
                }

                driver = new EdgeDriver(options);
            }

            case FIREFOX -> {

                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions options = new FirefoxOptions();

                if (ConfigReader.isHeadless()) {
                    options.addArguments("-headless");
                }

                driver = new FirefoxDriver(options);
            }

            default ->
                    throw new IllegalArgumentException("Unsupported Browser : " + browser);
        }

        DriverManager.setDriver(driver);

        configureBrowser(driver);
    }

    private static void configureBrowser(WebDriver driver) {

        if (ConfigReader.shouldMaximize()) {
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(ConfigReader.getImplicitWait()));

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(ConfigReader.getPageLoadTimeout()));

    }

}
