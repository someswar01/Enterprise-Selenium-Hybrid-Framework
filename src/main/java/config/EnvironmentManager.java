package config;

public final class EnvironmentManager {

    private EnvironmentManager() {
        throw new UnsupportedOperationException(
                "Utility class");
    }

    /**
     * Returns execution environment.
     *
     * Priority:
     * Maven Parameter
     * ↓
     * Default QA
     */
    public static String getEnvironment() {

        return System.getProperty(
                "env",
                "qa");
    }

    /**
     * Returns config file name.
     */
    public static String getConfigFile() {

        return "config-"
                + getEnvironment()
                + ".properties";
    }
}