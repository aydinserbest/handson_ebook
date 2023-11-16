package github.boniGarcia.testng.ch02.helloworld;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class HelloWorldEdgeNGTest {
    static final Logger log = getLogger(lookup().lookupClass());
    WebDriver driver;

    @BeforeClass
    public void setUpClass(){
        WebDriverManager.edgedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver = new EdgeDriver();
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

        //verify
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
    }
}
