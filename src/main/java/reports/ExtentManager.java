package reports;

import com.aventstack.extentreports.ExtentReports;

public final class ExtentManager {

    private static ExtentReports extentReports;

    private ExtentManager() {
        throw new UnsupportedOperationException(
                "ExtentManager is a utility class and cannot be instantiated.");
    }

    public static ExtentReports getExtentReports() {

        if (extentReports == null) {
            extentReports = new ExtentReports();
        }

        return extentReports;
    }

}