package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import logger.FrameworkLogger;
import utils.AssertionUtils;

public class BaseTest {

    @BeforeMethod
    public void setUp() {


        DriverFactory.initDriver();

        FrameworkLogger.info("Browser initialized");

        DriverManager.getDriver()
                .get(ConfigReader.getApplicationUrl());

        FrameworkLogger.pass("Application launched successfully");
        FrameworkLogger.info(
                "Thread ID : " + Thread.currentThread().threadId());

        FrameworkLogger.info(
                "Driver Hash : " + DriverManager.getDriver().hashCode());

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        try {

            AssertionUtils.assertAll();

        } finally {

            if (DriverManager.getDriver() != null) {
                DriverManager.getDriver().quit();
            }

            DriverManager.unloadDriver();
            AssertionUtils.unload();
        }
    }

}
