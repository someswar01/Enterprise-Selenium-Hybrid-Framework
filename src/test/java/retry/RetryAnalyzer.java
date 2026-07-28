package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import logger.FrameworkLogger;
import config.ConfigReader;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {

        int maxRetryCount = ConfigReader.getRetryCount();

        if (retryCount < maxRetryCount) {

            retryCount++;

            FrameworkLogger.warn(
                    String.format(
                            "Retrying Test [%s] - Attempt %d of %d",
                            result.getMethod().getMethodName(),
                            retryCount,
                            maxRetryCount));

            return true;
        }

        FrameworkLogger.error(
                "Retry attempts exhausted for Test : "
                        + result.getMethod().getMethodName());

        return false;
    }
}