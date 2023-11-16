package github.boniGarcia.testng.ch04.dialogs;

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

import static org.assertj.core.api.Assertions.assertThat;

public class ModalNGTest {
    /*
    Modal windows are dialog boxes built with basic CSS and HTML.
    For this reason, Selenium WebDriver does not provide any specific utility for manipulating them.
    Instead, we use the standard WebDriver API (locators, waits, etc.) to interact with modal windows.

    You can interact with elements inside a modal (like buttons or forms) using standard WebDriver commands.
    In contrast, for JavaScript alerts, you need to switch the WebDriver's context to the alert to interact with it.
     */
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void testModal() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.id("my-modal")).click();
        WebElement close = driver
                .findElement(By.xpath("//button[text() = 'Close']"));
        assertThat(close.getTagName()).isEqualTo("button");
        wait.until(ExpectedConditions.elementToBeClickable(close));
        close.click();
    }
}
