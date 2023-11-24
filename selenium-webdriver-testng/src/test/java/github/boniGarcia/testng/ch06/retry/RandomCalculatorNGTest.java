package github.boniGarcia.testng.ch06.retry;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomCalculatorNGTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testRandomCalculator() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/random-calculator.html");
        // 1 + 3
        driver.findElement(By.xpath("//span[text()='1']")).click();
        driver.findElement(By.xpath("//span[text()='+']")).click();
        driver.findElement(By.xpath("//span[text()='3']")).click();
        driver.findElement(By.xpath("//span[text()='=']")).click();

        // ... should be 4
        String result = driver.findElement(By.className("screen")).getText();
        assertThat(result).isEqualTo("4");
    }
}
    /*
    The retry(ITestResult result) method in the RetryAnalyzer class
    implements the IRetryAnalyzer interface from TestNG, and it is designed to determine whether
    a particular test should be retried upon failure.
    The ITestResult argument provides context about the test execution, including its status,
    the test method that was executed, and any exceptions thrown.

    In the provided implementation of the retry method,
    the ITestResult result parameter is not explicitly used within the method body.
    This is because the decision to retry the test is
    based solely on the number of attempts made so far (retryCount),
    compared to the maximum allowed retries (MAX_RETRIES).

    In the RetryAnalyzer class, the retry(ITestResult result) method is designed
    to decide whether a test should be retried after it fails.
    The key decision factor in this specific implementation
    is the number of retry attempts that have already been made, which is tracked by the retryCount variable.

    Here's a breakdown of how the method works:

    Parameter: ITestResult result

    This parameter provides information about the test execution,
    such as whether it passed, failed, the exceptions thrown, etc.
    However, in this particular implementation of the retry method,
    none of this information is being used to make the decision.
    Decision Logic:

    The method checks if the current retryCount is less than or equal to MAX_RETRIES.
    If retryCount is less than or equal to MAX_RETRIES,
    it means the test has not yet reached the maximum number of allowed retry attempts.
    In this case, retryCount is incremented (retryCount++) and the method returns true,
    indicating that the test should be retried.
    If retryCount exceeds MAX_RETRIES, the method returns false,
    indicating no more retries should be attempted.

     */
