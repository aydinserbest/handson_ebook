package github.boniGarcia.junit4.ch04.remote;

import static io.github.bonigarcia.wdm.WebDriverManager.isOnline;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteChromeJUnit4Test {
    WebDriver driver;

    /*
     is essentially telling Selenium that you intend to use the Chrome browser.
     It's like initializing a configuration object for Chrome.
     While it doesn't specify any additional desired capabilities by default,
     it serves as a way to inform Selenium that your intention is to control a Chrome browser,
     and you can later customize options with specific desired capabilities
     to configure the behavior of that Chrome browser instance.
     So, it's the starting point for configuring how Selenium interacts with the Chrome browser.
     */
    /*
    We use a ChromeOptions object without any particular setup to specify the required capabilities in the  example.
    In other words, we request to use a remote Chrome browser using its default behavior.
     */
    @Before
    public void setup() throws MalformedURLException {
        URL seleniumServerUrl = new URL("http://localhost:4444/");
        /*
        We assume this URL is online.
        For that, we create an AssertJ assumption by invoking the static method isOnline available on WebDriverManager.
        As a result, the test is skipped when the Selenium Server is offline.
         */
        assumeThat(isOnline(seleniumServerUrl)).isTrue();
        //We instantiate a ChromeOptions object to specify the required capabilities.

        ChromeOptions options = new ChromeOptions();
        //We invoke the RemoteWebDriver constructor using the Selenium Server URL and the Chrome options as arguments.
        driver = new RemoteWebDriver(seleniumServerUrl, options);
    }
    @After
    public void teardown(){
        if (driver != null){
            driver.quit();
        }
    }
    @Test
    public void testRemote(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }
    /*
    An alternative way to specify the required capabilities in a RemoteWebDriver object is
    using an instance of DesiredCapabilities.
    // Instead of options we can use:
     */
    /*
    @Before
    public void setup() throws MalformedURLException {
        URL seleniumServerUrl = new URL("http://localhost:4444/");
        assumeThat(isOnline(seleniumServerUrl)).isTrue();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        driver = new RemoteWebDriver(seleniumServerUrl, capabilities);

          ... or:

         capabilities.setCapability(CapabilityType.BROWSER_NAME,
         Browser.CHROME);
    }
     */
}
