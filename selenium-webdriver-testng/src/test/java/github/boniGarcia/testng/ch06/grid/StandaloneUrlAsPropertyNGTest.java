package github.boniGarcia.testng.ch06.grid;

import com.sun.tools.javac.Main;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StandaloneUrlAsPropertyNGTest {
    WebDriver driver;

    @BeforeClass
    public void setupAll() throws Exception {
        int port = PortProber.findFreePort();
        WebDriverManager.chromedriver().setup();
        Main.main(
                new String[] { "standalone", "--port", String.valueOf(port) });

        System.setProperty("webdriver.remote.server",
                String.format("http://localhost:%d/", port));
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(options);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @AfterClass
    public void teardownClass() {
        System.clearProperty("webdriver.remote.server");
    }

    @Test
    public void testStandaloneUrlAsProperty() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }
}
