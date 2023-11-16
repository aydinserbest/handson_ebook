package github.boniGarcia.testng.ch04.dialogs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class Examples {
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
    public void testAlert() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        //instead of WebDriverWait line:
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Click on the button to trigger the JavaScript alert
        driver.findElement(By.id("my-alert")).click();
        /*
        Instead of creating a separate WebDriverWait object, use WebDriverWait directly
        in the line where we're waiting for the alert to be present. This one-liner
        approach combines the creation of WebDriverWait and the application of the
        waiting condition into a single statement.
         */
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        assertThat(alert.getText()).isEqualTo("Hello world!");
        alert.accept();
    }
    /*
    In these comments, I've explained the one-liner approach for using WebDriverWait directly
    where the condition is applied.
    This style can make the code more concise,
    especially when the wait object is used only once. It's a matter of preference and readability;
    some developers may prefer the one-liner for its brevity,
    while others might choose to declare a separate WebDriverWait object for clarity or reuse.
     */
}
