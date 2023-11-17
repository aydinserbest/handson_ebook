package github.boniGarcia.testng.ch03.keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class SliderNGTest {
    static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        // FIXME: pause for manual browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    /*
    The tearDown() method in the SliderNGTest class is designed to be executed after each test method in the test class.
    The purpose of this method is
    to perform cleanup actions, which typically include closing the browser and ending the WebDriver session.
     */
    @Test
    public void testSlider(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement slider = driver.findElement(By.name("my-range"));
        String initValue = slider.getAttribute("value");
        log.debug("The initial value of the slider is {}", initValue);

        for (int i = 0; i < 5; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        String endValue = slider.getAttribute("value");
        log.debug("The final value of the slider is {}",endValue);

        assertThat(initValue).isNotEqualTo(endValue);
    }
    @Test
    public void horizontalSlider(){
        driver.get(
                "https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        double initialValue = Double.parseDouble(slider.getAttribute("value"));
        log.debug("The initial value of the slider is {}", initialValue);
        double maxValue = Double.parseDouble(slider.getAttribute("max"));
        log.debug("The max value of the slider is {}", maxValue);

        for (double i = initialValue; i<=maxValue; i +=0.5){
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        double finalValue = Double.parseDouble(slider.getAttribute("value"));
        log.debug("The final value of the slider is {}",finalValue);
        assertThat(initialValue).isNotEqualTo(finalValue);
    }
}
    /*
        The line Thread.sleep(Duration.ofSeconds(3).toMillis());
        is causing the executing thread to sleep for 3 seconds.
        This sleep is likely there to allow the developer
        to visually check the state of the web page or for some temporary synchronization reason,
        such as waiting for an element to appear or for a page to finish loading
        when no better synchronization mechanism is implemented.

        However,
        using Thread.sleep() is generally discouraged in automated tests
        because it creates brittle tests that may fail if the expected state takes longer
        than expected to be reached.
        It can also slow down test execution,
        as it waits for the full duration even if the desired state is reached earlier.
        A more robust approach is to use explicit waits provided by the WebDriver
        to wait for specific conditions to be met.
        The FIXME tag
             suggests that the author is aware that this is not an ideal solution
             and plans to replace it with a better synchronization strategy later on.

        FIXME: This is a conventional tag used by programmers to indicate that the line of code following it
        is not a final solution or best practice and should be revised in the future.
        It's like a "todo" note for code improvements.

        pause for manual browser inspection:
        This explains the purpose of the FIXME tag.
              The code is intentionally introducing a delay so that a developer
              can manually inspect the state of the browser before the program continues.
              This can be useful for debugging or reviewing the behavior of a web application
              in a browser during automated tests with tools like Selenium WebDriver.
    */
/*
        you will discover a pause in the teardown method using Thread.sleep().
        this type of wait is usually considered a bad smell
        (i.e., a characteristic in the source code that can lead to undesirable effects).

 */
/*
WebDriverManager resolves the required driver (chromedriver in this case)
and creates an instance of the proper WebDriver type (ChromeDriver in this case) in a single line.
 */
    /*
        The WebDriverManager.chromedriver().create(); command,
         as previously mentioned, sets up a shutdown hook that will automatically close the browser
         when the JVM shuts down. This means that the browser would typically be closed at the end of the test execution
         when the JVM exits, not necessarily right after the test method finishes.

        To ensure we're on the same page, let's clarify how this affects your tearDown() method:
        If tearDown() is being called while the JVM is still running
        (which is the usual behavior of test frameworks like TestNG or JUnit),
        then Thread.sleep(Duration.ofSeconds(3).toMillis()); will indeed pause the execution for 3 seconds
        before driver.quit(); is called. The browser will remain open during this sleep period,
        allowing for manual inspection if desired.

        After the sleep duration passes,
        driver.quit(); will explicitly close the browser.
        This is redundant if the shutdown hook from WebDriverManager is also trying to close the browser,
        but it doesn't conflict; it just attempts to close an already closed browser
        or does nothing if the browser is still open.

        If for some reason tearDown() is not being called (which would be abnormal for test frameworks),
        the browser would still be closed by the shutdown hook when the JVM exits.

        In conclusion,
        if tearDown() is called as expected by the testing framework,
        you will have your 3-second pause, and then driver.quit();
        will close the browser. If you were to remove driver.quit();,
        the shutdown hook from WebDriverManager would still close the browser once the JVM exits.
        The avoidShutdownHook() method is there
        if you want to manage the browser lifecycle manually without relying on the JVM's shutdown behavior.

    */
