package github.boniGarcia.testng.ch02.helloworld_selenium_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class HelloWorldChromeNGTest {
    static final Logger log = getLogger(lookup().lookupClass());

    /*
    Selenium Manager automatically downloads and sets up the necessary driver, similar to WebDriverManager.
    When using Selenium Manager,
    there's no need to add dependency into the pom.xml, it comes in-built
    and also
    there is no need to write anything like --> the WebDriverManager.chromedriver().setup() method.
     */
    /*
   Selenium WebDriver's automatic driver management feature does not engage
   when you manually specify the driver location using System.setProperty()
   or when you configure the driver setup using the WebDriverManager library.

        If you use System.setProperty("webdriver.chrome.driver", "/path/to/your/downloaded/chromedriver");,
        Selenium will directly use the chromedriver located at the file path you've specified.

        If you use WebDriverManager.chromedriver().setup();,
        the WebDriverManager library will find and set up the appropriate driver version,
        and Selenium will use these settings.

        In both cases,
        the internal automatic driver management feature of Selenium WebDriver
        remains inactive because the driver location has already been determined.
        This is preferred when you want to test with a specific driver version
        or when you wish to have more detailed control over driver management.
     */

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void test() {
        // Exercise
        String url = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(url);
        String title = driver.getTitle();
        log.debug("The title of {} is {}", url, title);

        // Verify
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
    }
}
