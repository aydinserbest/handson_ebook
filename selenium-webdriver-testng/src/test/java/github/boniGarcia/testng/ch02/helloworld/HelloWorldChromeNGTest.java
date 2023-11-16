package github.boniGarcia.testng.ch02.helloworld;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class HelloWorldChromeNGTest {
    static final Logger log = getLogger(lookup().lookupClass());
    WebDriver driver;

    @BeforeClass
    public void setUpClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(url);
        String title = driver.getTitle();
        log.debug("The title of {} is {}", url, title);

        // Verify
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
    }
}
