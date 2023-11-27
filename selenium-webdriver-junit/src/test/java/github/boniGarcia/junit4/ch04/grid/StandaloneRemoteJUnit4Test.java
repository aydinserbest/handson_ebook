package github.boniGarcia.junit4.ch04.grid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class StandaloneRemoteJUnit4Test {
    WebDriver driver;

    static URL seleniumServerUrl;

    @BeforeClass
    public static void setupAll() throws MalformedURLException {
        int port = PortProber.findFreePort();
        WebDriverManager.chromedriver().setup();
        Main.main(
                new String[] { "standalone", "--port", String.valueOf(port) });

        seleniumServerUrl = new URL(
                String.format("http://localhost:%d/", port));
    }

    @Before
    public void setup() {
        driver = new RemoteWebDriver(seleniumServerUrl, new ChromeOptions());
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testStandaloneRemote() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }

}
