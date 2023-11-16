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

public class ConfirmNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();}
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    /*
    this example is quite similar to the previous one,(AlertNG class)
    but in this case, we can invoke the method dismiss()
    to click on the Cancel button available on the confirm dialog.
     */
    @Test
    public void testConfirm() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("my-confirm")).click();
        Alert confirm = wait.until(ExpectedConditions.alertIsPresent());
        assertThat(confirm.getText()).isEqualTo("Is this correct?");
        confirm.dismiss();
    }
    @Test
    public void testConfirm2() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("my-confirm")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirm = driver.switchTo().alert();
        assertThat(confirm.getText()).isEqualTo("Is this correct?");
        confirm.dismiss();
    }
}
