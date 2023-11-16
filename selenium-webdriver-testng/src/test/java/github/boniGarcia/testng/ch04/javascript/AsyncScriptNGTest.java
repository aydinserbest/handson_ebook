package github.boniGarcia.testng.ch04.javascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class AsyncScriptNGTest {
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
    public void testAsyncScript() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Duration pause = Duration.ofSeconds(2);
        String script = "const callback = arguments[arguments.length - 1];"
                + "window.setTimeout(callback, " + pause.toMillis() + ");";

        long initMillis = System.currentTimeMillis();
        js.executeAsyncScript(script);
        Duration elapsed = Duration
                .ofMillis(System.currentTimeMillis() - initMillis);
        log.debug("The script took {} ms to be executed", elapsed.toMillis());
        assertThat(elapsed).isGreaterThanOrEqualTo(pause);
    }
}
