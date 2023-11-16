package github.boniGarcia.testng.ch03.wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class ImplicitWaitNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    /*
    Before interacting with the elements, we specify an implicit wait strategy.
    In this case, we set up a timeout of 10 seconds.

     */
    @Test
    public void testImplicitWait(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
        if we comment out this wait line, it will givae error:
        NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"#landscape"}
        or-another same explanation:
        You can play with this feature by dropping the implicit wait from the test (step 1).
        If you do that, you will notice that the test fails in step 2 due to a NoSuchElementException.
         */
        WebElement landscape = driver.findElement(By.id("landscape"));
        assertThat(landscape.getAttribute("src")).containsIgnoringCase("landscape");
    }
}
