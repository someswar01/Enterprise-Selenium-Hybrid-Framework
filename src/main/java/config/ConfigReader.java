package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FrameworkConstants;
import enums.BrowserType;
import exceptions.ConfigReaderException;

import static java.lang.System.getProperty;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    // Static block to load configuration only once
    static {
        loadProperties();
    }

    // Private constructor to prevent object creation
    private ConfigReader() {
        throw new UnsupportedOperationException("ConfigReader is a utility class and cannot be instantiated.");
    }
    /**
     * Loads the configuration properties file based on the
     * execution environment.
     *
     * Example:
     * mvn test -Denv=qa
     * mvn test -Denv=dev
     * mvn test -Denv=uat
     * mvn test -Denv=prod
     */
    private static void loadProperties() {

        String configFile =
                FrameworkConstants.CONFIG_DIRECTORY
                        + EnvironmentManager.getConfigFile();

        try (FileInputStream fis =
                     new FileInputStream(configFile)) {

            properties.load(fis);

        } catch (IOException e) {

            throw new ConfigReaderException(
                    "Unable to load configuration file : "
                            + configFile,
                    e);
        }
    }
    /**
     * Returns the property value for the given key.
     *
     * @param key Configuration key
     * @return Property value
     */
    public static String get(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            throw new ConfigReaderException(
                    "Configuration key '" + key + "' is missing in config.properties.");
        }

        return value.trim();
    }

    // =========================
    // Typed Getter Methods
    // =========================

    public static String getApplicationUrl() {
        return get("app.url");
    }

    public static String getUsername() {
        return get("username");
    }

    public static String getPassword() {
        return get("password");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public static boolean shouldMaximize() {
        return Boolean.parseBoolean(get("maximize"));
    }

    public static long getImplicitWait() {
        return Long.parseLong(get("implicit.wait"));
    }

    public static long getExplicitWait() {
        return Long.parseLong(get("explicit.wait"));
    }

    public static long getPageLoadTimeout() {
        return Long.parseLong(get("page.load.timeout"));
    }

    public static boolean captureScreenshotOnFailure() {
        return Boolean.parseBoolean(get("screenshot.on.failure"));
    }

    public static boolean captureScreenshotOnPass() {
        return Boolean.parseBoolean(get("screenshot.on.pass"));
    }

    public static BrowserType getBrowser() {

        String browser = getProperty("browser");

        if (browser == null || browser.isBlank()) {
            browser = get("browser");
        }

        return BrowserType.valueOf(browser.toUpperCase());
    }
    public static int getRetryCount() {
        return Integer.parseInt(get("retryCount"));
    }

    public static String getDownloadPath() {

        return getProperty("download.path");
    }


}