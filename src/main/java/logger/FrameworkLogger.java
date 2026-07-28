package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import reports.ExtentLogger;

public final class FrameworkLogger {

    private static final Logger LOGGER = LogManager.getLogger(FrameworkLogger.class);

    private FrameworkLogger() {
        throw new UnsupportedOperationException(
                "FrameworkLogger is a utility class and cannot be instantiated.");
    }

    /**
     * Logs INFO message to Log4j and Extent Report.
     */
    public static void info(String message) {
        LOGGER.info(message);
        ExtentLogger.info(message);
    }
    /**
     * Logs PASS message to Extent Report and INFO to Log4j.
     */
    public static void pass(String message) {
        LOGGER.info(message);
        ExtentLogger.pass(message);
    }

    /**
     * Logs WARN message to Log4j and Extent Report.
     */
    public static void warn(String message) {
        LOGGER.warn(message);
        ExtentLogger.warn(message);
    }

    /**
     * Logs FAIL message to Log4j and Extent Report.
     */
    public static void error(String message) {
        LOGGER.error(message);
        ExtentLogger.fail(message);
    }

    /**
     * Logs exception to Log4j and Extent Report.
     */
    public static void error(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
        ExtentLogger.fail(throwable);
    }

    /**
     * Logs DEBUG message only to Log4j.
     */
    public static void debug(String message) {
        LOGGER.debug(message);
    }

    /**
     * Logs FATAL message.
     */
    public static void fatal(String message) {
        LOGGER.fatal(message);
        ExtentLogger.fail(message);
    }
}