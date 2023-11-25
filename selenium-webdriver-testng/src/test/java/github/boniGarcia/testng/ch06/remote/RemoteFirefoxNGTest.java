package github.boniGarcia.testng.ch06.remote;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static io.github.bonigarcia.wdm.WebDriverManager.isOnline;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class RemoteFirefoxNGTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        URL seleniumServerUrl = new URL("http://localhost:4444/");
        assumeThat(isOnline(seleniumServerUrl)).isTrue();

        driver = WebDriverManager.firefoxdriver()
                .remoteAddress(seleniumServerUrl).create();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testRemote() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }
}
