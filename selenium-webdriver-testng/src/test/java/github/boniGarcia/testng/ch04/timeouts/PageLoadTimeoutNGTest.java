package github.boniGarcia.testng.ch04.timeouts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PageLoadTimeoutNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void testPageLoadTimeout(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));

        assertThatThrownBy(() -> driver
                .get("https://bonigarcia.dev/selenium-webdriver-java/"))
                .isInstanceOf(TimeoutException.class);
    }
}
