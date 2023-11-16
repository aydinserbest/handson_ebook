package github.boniGarcia.testng.ch04.window;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class WindowNGTest {
    static final Logger log = getLogger(lookup().lookupClass());
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel invspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void testWindow() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        WebDriver.Window window = driver.manage().window();
        //We read the window position.
        Point initialPosition = window.getPosition();
        //We read the window size.
        Dimension initialSize = window.getSize();
        log.debug("initial window : position {} --size {}", initialPosition,
                initialSize);
        //We maximize the browser window.
        window.maximize();

        Point maximizedPosition = window.getPosition();
        Dimension maximizedSize = window.getSize();

        log.debug("mazimized window: position {} --size{}",maximizedPosition,
                maximizedSize);
        /*
        We verify that the maximized position (and size, in the following line)
        is different from the original window.
         */
        assertThat(initialPosition).isNotEqualTo(maximizedPosition);
        assertThat(initialSize).isNotEqualTo(maximizedSize);
    }
    }

    /*
    The Selenium WebDriver API allows manipulating browser size and position very easily using the Window interface.
     */
