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

public class PromptNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void testPrompt() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("my-prompt")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("John Doe");
        assertThat(prompt.getText()).isEqualTo("Please enter your name");
        prompt.accept();
    }
    @Test
    public void testPrompt2() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("my-prompt")).click();
        Alert prompt = wait.until(ExpectedConditions.alertIsPresent());
        prompt.sendKeys("John Doe");
        assertThat(prompt.getText()).isEqualTo("Please enter your name");
        prompt.accept();
    }
    @Test
    public void testPrompt3(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.findElement(By.id("my-prompt")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("John Doe");
        assertThat(prompt.getText()).isEqualTo("Please enter your name");
        prompt.accept();
    }
    }
