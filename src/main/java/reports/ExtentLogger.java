package reports;

import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

public final class ExtentLogger {

    private static final ThreadLocal<ExtentTest> EXTENT_TEST = new ThreadLocal<>();

    private ExtentLogger() {}

    public static void setTest(ExtentTest test) {
        EXTENT_TEST.set(test);
    }

    private static ExtentTest getSafeTest() {
        return EXTENT_TEST.get();
    }

    public static void info(String message) {
        if (getSafeTest() != null) {
            getSafeTest().info(message);
        }
    }

    public static void pass(String message) {
        if (getSafeTest() != null) {
            getSafeTest().pass(message);
        }
    }

    public static void warn(String message) {
        if (getSafeTest() != null) {
            getSafeTest().warning(message);
        }
    }

    public static void skip(String message) {
        if (getSafeTest() != null) {
            getSafeTest().skip(message);
        }
    }

    public static void fail(String message) {
        if (getSafeTest() != null) {
            getSafeTest().fail(message);
        }
    }

    public static void fail(Throwable throwable) {
        if (getSafeTest() != null) {
            getSafeTest().fail(throwable);
        }
    }

    public static void attachScreenshot(String path) {

        if (getSafeTest() != null && path != null) {
            getSafeTest().addScreenCaptureFromPath(path);
        }
    }

    public static void addScreenshot(String path) {

        if (getSafeTest() != null && path != null) {

            getSafeTest().addScreenCaptureFromPath(path);
        }
    }

    public static void unload() {
        EXTENT_TEST.remove();
    }


}