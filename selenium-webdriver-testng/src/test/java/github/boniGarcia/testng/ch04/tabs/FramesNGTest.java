package github.boniGarcia.testng.ch04.tabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FramesNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void testFrames(){
        //We open a web page that contains an iframe
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/frames.html");

        //We use an explicit wait for waiting for the frame and switching to it.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String frameName = "frame-body";

        //We use another explicit wait to pause until the paragraphs contained in the iframe are available.
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.name(frameName)));
        driver.switchTo().frame(frameName);

        By pName = By.tagName("P");

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pName, 0));
        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));

        //We assert the number of paragraphs is as expected.
        assertThat(paragraphs).hasSize(20);
    }
    /*
    above there is a wait line,
    like that another example for window handles:

    // Wait for the new window or tab
    new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
     */
}
