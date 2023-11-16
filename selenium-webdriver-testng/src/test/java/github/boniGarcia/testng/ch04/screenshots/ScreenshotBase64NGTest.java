package github.boniGarcia.testng.ch04.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class ScreenshotBase64NGTest {
    static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testScreenshotBase64() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        TakesScreenshot ts = (TakesScreenshot) driver;

        String screenshot = ts.getScreenshotAs(OutputType.BASE64);
        log.debug("Screenshot in base64 "
                + "(you can copy and paste it into a browser navigation bar to watch it)\n"
                + "data:image/png;base64,{}", screenshot);
        assertThat(screenshot).isNotEmpty();
    }
    /*
    We append the prefix data:image/png;base64, to the Base64 string and log it in the standard output.
    You can copy and paste this resulting string in a browser navigation bar to display the picture.
     */
}
