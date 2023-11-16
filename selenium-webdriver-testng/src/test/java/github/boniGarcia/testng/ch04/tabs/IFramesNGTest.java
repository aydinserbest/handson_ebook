package github.boniGarcia.testng.ch04.tabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class IFramesNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void testIFrames(){
        //We open a web page that contains a frameset
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/iframes.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        /*
            We wait for the frame to be available.
            Note that steps 2 and 3 in testFrame of class-FramesNGTest are equivalent to this step.
         */
        wait.until(ExpectedConditions     //(2)
                .frameToBeAvailableAndSwitchToIt("my-iframe"));   //(3)
        By pName = By.tagName("p");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pName, 0));
        List<WebElement> paragraphs = driver.findElements(pName);
        assertThat(paragraphs).hasSize(20);

                /*
                 wait.until(ExpectedConditions
                .presenceOfElementLocated(By.name(frameName)));
        driver.switchTo().frame(frameName);
                 */
    }
    /*
    ExpectedConditions.numberOfElementsToBeMoreThan example below
     */
    @Test
    public void testInfiniteScroll() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By plocator = By.tagName("p");

        List<WebElement> paragraphs = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(plocator, 0));

        int initParagraphsNumber = paragraphs.size();
        System.out.println(initParagraphsNumber);

        WebElement lastParagraph = driver.findElement(By.xpath(String.format("//p[%d]",initParagraphsNumber)));

        String script = "arguments[0].scrollIntoView()";

        js.executeScript(script,lastParagraph);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(plocator,initParagraphsNumber));
        System.out.println(initParagraphsNumber);
    }
}
