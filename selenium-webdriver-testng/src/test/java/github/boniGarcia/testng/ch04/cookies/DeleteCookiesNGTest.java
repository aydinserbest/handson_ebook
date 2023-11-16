package github.boniGarcia.testng.ch04.cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteCookiesNGTest {
    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        // FIXME: pause for manual browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void testDeleteCookies() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/cookies.html");

        WebDriver.Options options = driver.manage();
        Set<Cookie> cookies = options.getCookies();
        Cookie username = options.getCookieNamed("username");
        options.deleteCookie(username);

        assertThat(options.getCookies()).hasSize(cookies.size() - 1);

        driver.findElement(By.id("refresh-cookies")).click();
    }
}
