package github.boniGarcia.junit4.ch06.failure_analysis;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

public class FailureWatcher extends TestWatcher {
    FailureManager failureManager;

    public FailureWatcher(WebDriver driver) {
        failureManager = new FailureManager(driver);
    }

    @Override
    public void failed(Throwable throwable, Description description) {
        failureManager.takePngScreenshot(description.getDisplayName());
    }
}
