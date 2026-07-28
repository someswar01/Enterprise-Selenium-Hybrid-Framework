package listeners;

import config.ConfigReader;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import reports.ExtentLogger;
import reports.ExtentReport;
import utilities.ScreenshotUtils;

import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        ExtentReport.initReports();
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getDescription();

        if (testName == null || testName.isBlank()) {
            testName = result.getMethod().getMethodName();
        }

        ExtentTest test = ExtentReport
                .getExtentReports()
                .createTest(testName);

        ExtentLogger.setTest(test);

        ExtentLogger.info("Test Started : " + result.getMethod().getMethodName());
        ExtentLogger.info(
                "Running on Thread : " + Thread.currentThread().threadId());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (ConfigReader.captureScreenshotOnPass()) {

            String path =
                    ScreenshotUtils.captureScreenshot(result.getName());

            ExtentLogger.addScreenshot(path);
        }
        ExtentLogger.pass(
                result.getMethod().getMethodName()
                        + " executed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentLogger.fail(result.getThrowable());

        if (ConfigReader.captureScreenshotOnFailure()) {

            try {

                String path = ScreenshotUtils.captureScreenshot(
                        result.getMethod().getMethodName());

                ExtentLogger.addScreenshot(path);

            } catch (Exception e) {

                ExtentLogger.warn(
                        "Unable to capture screenshot : "
                                + e.getMessage());
            }
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentLogger.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentReport.flushReports();

        ExtentLogger.unload();
    }

}
