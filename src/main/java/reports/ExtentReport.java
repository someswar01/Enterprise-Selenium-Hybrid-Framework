package reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ExtentReport {

    private static final ExtentReports extentReports = ExtentManager.getExtentReports();

    private ExtentReport() {
        throw new UnsupportedOperationException(
                "ExtentReport is a utility class and cannot be instantiated.");
    }

    private static boolean isInitialized = false;

    //without timestamp
    public static void initReports() {

        if (isInitialized) {
            return;
        }

        String reportPath =
                "test-output/ExtentReports/AutomationReport.html";

        File reportFile = new File(reportPath);
        reportFile.getParentFile().mkdirs();

        if (reportFile.exists()) {
            reportFile.delete();
        }

        ExtentSparkReporter spark =
                new ExtentSparkReporter(reportPath);

        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Selenium Hybrid Framework");
        spark.config().setTheme(Theme.STANDARD);

        extentReports.attachReporter(spark);

        extentReports.setSystemInfo("Framework", "Selenium Hybrid");
        extentReports.setSystemInfo("Language", "Java");
        extentReports.setSystemInfo("Tester", "Somesh C");

        isInitialized = true;
    }

    //with timestamp
//    public static void initReports() {
//
//        String timestamp = LocalDateTime.now()
//                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
//
//        String reportPath = System.getProperty("user.dir")
//                + "/test-output/ExtentReports/AutomationReport_" + timestamp + ".html";
//
//
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
//
//        sparkReporter.config().setReportName("Selenium Automation Report");
//        sparkReporter.config().setDocumentTitle("Automation Execution Report");
//
//        extentReports.attachReporter(sparkReporter);
//
//        extentReports.setSystemInfo("Framework", "Selenium + Java + TestNG");
//        extentReports.setSystemInfo("Tester", "Somesh");
//        extentReports.setSystemInfo("Environment", "QA");
//        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
//        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
//    }

    public static void flushReports() {
        extentReports.flush();
    }


    public static ExtentReports getExtentReports() {

        if (extentReports == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            FrameworkConstants.REPORT_FOLDER + "ExtentReport.html");

            spark.config().setReportName("Automation Execution Report");
            spark.config().setDocumentTitle("Selenium Hybrid Framework");

            extentReports.attachReporter(spark);

            extentReports.setSystemInfo("Tester", "Somesh");
            extentReports.setSystemInfo("Framework", "Selenium + Java");
            extentReports.setSystemInfo("Environment", "QA");
        }

        return extentReports;
    }
}
