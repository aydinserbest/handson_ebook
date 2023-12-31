package github.boniGarcia.junit4.ch04.remote;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static io.github.bonigarcia.wdm.WebDriverManager.isOnline;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class RemoteFirefoxJUnit4Test {
    WebDriver driver;
    /*
    Alternatively, we can also use WebDriverManager to create an instance of RemoteWebDriver.
    To that aim, we need to invoke the method remoteAddress() of a given manager to pass the Selenium Server URL.
    this example shows a test setup using this feature and Firefox as the remote browser.
     */
    @Before
    public void setup() throws MalformedURLException {
        URL seleniumServerUrl = new URL("http://localhost:4444/");
        assumeThat(isOnline(seleniumServerUrl)).isTrue();

        driver = WebDriverManager.firefoxdriver()
                .remoteAddress(seleniumServerUrl).create();
    }
    //or
    //String seleniumServerUrl = "http://localhost:4444/";

    @After
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
