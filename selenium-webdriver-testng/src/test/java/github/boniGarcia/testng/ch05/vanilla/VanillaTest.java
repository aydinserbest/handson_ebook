package github.boniGarcia.testng.ch05.vanilla;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VanillaTest {
    WebDriver driver;

    @BeforeMethod
    void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    void teardown(){
        driver.quit();
    }
    @Test
    void testBasicLoginSuccess(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("user");
        driver.findElement(By.cssSelector("button")).click();

        assertThat(driver.findElement(By.id("success")).isDisplayed()).isTrue();
    }
}
/*
    The test directly interacts with web elements
    using the basic Selenium WebDriver commands like get, findElement, sendKeys, and click.

    No Advanced Frameworks or Libraries: It doesn't use any additional testing frameworks or
    libraries that abstract or extend the basic functionality of Selenium WebDriver.
 */
