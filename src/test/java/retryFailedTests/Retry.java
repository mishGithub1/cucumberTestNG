package retryFailedTests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class Retry implements IRetryAnalyzer {

    int maxTry = 1;
    ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count.get() < maxTry) {
                count.set(count.get() + 1);
                return true;
            }
        }
        return false;
    }

}