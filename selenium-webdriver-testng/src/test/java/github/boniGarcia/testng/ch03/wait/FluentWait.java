package github.boniGarcia.testng.ch03.wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class FluentWait {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void testFluentWait() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        /*
        This is like saying, "I'm going to wait up to 10 seconds for these pictures to show up.
        But I'll check every second to see if they're here yet.
        If I look and the picture isn't there, no big deal, I'll just check again in a second."
         */
        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        /*
        Here, you're focusing on a specific picture called "landscape." You're waiting for it to show up in the photo album,
        checking every second, but you won't wait longer than 10 seconds.
         */
        WebElement landscape = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("landscape")));

        //Once the picture "landscape" is there, you're making sure it's the correct one by checking its name,
        // like confirming that the picture label says "landscape."
        assertThat(landscape.getAttribute("src"))
                .containsIgnoringCase("landscape");
    }
    /*
    What's happening in the background:
    While you wait for the "landscape" picture to show up, other pictures may be loading too.
    But you're not concerned about them.
    You're only looking for "landscape." If it's not there when you check,
    you'll wait a little bit and check again until it appears or your 10 seconds are up.

    The FluentWait setup is very patient and flexible,
    constantly checking at regular intervals (every second)
    and not getting upset if the picture isn't there yet (ignoring NoSuchElementException).
    This way, you're not staring at the photo album non-stop; instead,
    you glance at it every so often while doing other things.
     */
    /*
    In this instance, FluentWait is the class being instantiated.
    Fluent Wait in Selenium is one of the three types of waits provided by the WebDriver API.
    It's more advanced than an Implicit Wait
    and more flexible than an Explicit Wait
    because it allows you to configure the maximum amount of time to wait for a condition,
    as well as the frequency with which to check the condition (polling). Additionally,
    it lets you ignore specific types of exceptions while waiting, such as NoSuchElementException in this case.

    To break down the Fluent Wait configuration:

    .withTimeout(Duration.ofSeconds(10)) specifies the total time to wait for a condition before throwing an Exception.
    .pollingEvery(Duration.ofSeconds(1)) sets the frequency to check the condition before the timeout expires.
    .ignoring(NoSuchElementException.class) tells Fluent Wait to ignore NoSuchElementException exceptions
    while polling for the condition.
    This level of configurability is what distinguishes Fluent Wait from other types of waits.
     */
    /*
    Below is a comparison of how you might implement an Explicit Wait and a Fluent Wait in Selenium WebDriver using Java:

    Explicit Wait:
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("some-id")));

    Differences:

    Initialization:

    An Explicit Wait is initialized by creating an instance of WebDriverWait.
    A Fluent Wait is initialized by creating an instance of FluentWait.
    Configuration:

    An Explicit Wait is generally used with a fixed timeout period and has a default polling period of 500 milliseconds.
    A Fluent Wait allows for more granular control, letting you set the maximum timeout, the polling frequency,
    and what exceptions to ignore during the waiting period.
    Usage:

    An Explicit Wait is typically used when you need to wait for a specific condition to be met before proceeding.
    A Fluent Wait is more suitable when you need to configure custom waiting strategies, such as different polling intervals
    or ignoring specific types of exceptions that may occur during the waiting period.
    Flexibility:

    An Explicit Wait is less flexible than a Fluent Wait since it does not allow ignoring specific exceptions
    without extending the WebDriverWait class.
    A Fluent Wait is more flexible and customizable, offering methods to specify polling intervals,
    define exceptions to ignore, and set the total timeout.
    Both Explicit and Fluent Waits are used to wait for a certain condition to occur
    before proceeding with the next step in the test. However, the Fluent Wait is more powerful and can be customized
    to suit complex waiting conditions in web automation testing.

     */
}
