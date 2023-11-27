package github.boniGarcia.junit4.ch04.grid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class StandaloneUrlAsPropertyJUnit4Test {
    WebDriver driver;

    @BeforeClass
    public static void setupAll() {
        int port = PortProber.findFreePort();
        WebDriverManager.chromedriver().setup();
        Main.main(
                new String[] { "standalone", "--port", String.valueOf(port) });

        System.setProperty("webdriver.remote.server",
                String.format("http://localhost:%d/", port));
    }

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(options);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @AfterClass
    public static void teardownClass() {
        System.clearProperty("webdriver.remote.server");
    }

    @Test
    public void testStandaloneUrlAsProperty() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }

}
