package github.boniGarcia.testng.ch04.cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AddCookiesNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();}
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());
        driver.quit();
    }
    @Test
    public void testAddCookies() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/cookies.html");

        Cookie newCookie = new Cookie("new-cookie-key", "new-cookie-value");
        driver.manage().addCookie(newCookie);
        String readValue = driver.manage().getCookieNamed(newCookie.getName())
                .getValue();
        assertThat(newCookie.getValue()).isEqualTo(readValue);

        driver.findElement(By.id("refresh-cookies")).click();
    }
}
