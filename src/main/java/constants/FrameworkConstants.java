package constants;

import java.time.Duration;

public final class FrameworkConstants {

    private FrameworkConstants() {}

    public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);
    public static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(30);

    public static final String CONFIG_DIRECTORY =
            "src/test/resources/";

    public static final String SCREENSHOT_FOLDER =
            "test-output/screenshots/";

    public static final String REPORT_FOLDER =
            "test-output/reports/";
    public static final String HOME_PAGE_URL =
            "https://rahulshettyacademy.com/angularpractice/shop";

    public static final String HOME_PAGE_TITLE =
            "ProtoCommerce";

}