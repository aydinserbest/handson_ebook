package github.boniGarcia.junit4.ch06.retry;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomCalculatorJUnit4Test {
    static WebDriver driver;
    //This is a JUnit 4 rule that allows the test to be retried up to 5 times in case of failure.
    @Rule
    public RetryRule retryRule = new RetryRule(5);
    /*
    This method is annotated with @BeforeClass, meaning it runs once before all the test methods in the class.
    It initializes the WebDriver.
     */
    @BeforeClass
    public static void setup(){driver = WebDriverManager.chromedriver().create();
    }
    /*
    Annotated with @AfterClass, this method runs after all test methods have completed.
    It closes the browser window and ends the WebDriver session.
     */
    @AfterClass
    public static void  teardown(){driver.quit();}
    /*
    This is the actual test case. It opens a webpage, performs some actions
    (clicking buttons to simulate a calculation),
    and then checks if the result is as expected. If the result is not as expected, the test fails.
     */
    @Test
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
