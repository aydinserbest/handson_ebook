package github.boniGarcia.testng.ch04.cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadCookiesNGTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());
        driver.quit();
    }

    @Test
    public void testReadCookies() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
        WebDriver.Options options = driver.manage();
        Set<Cookie> cookies = options.getCookies();
        //Set<Cookie> cookies1 = driver.manage().getCookies();
        System.out.println(cookies.size());
        assertThat(cookies).hasSize(2);

        Cookie username = options.getCookieNamed("username");
        assertThat(username.getValue()).isEqualTo("John Doe");
        assertThat(username.getPath()).isEqualTo("/");

        driver.findElement(By.id("refresh-cookies")).click();
    }
}
