package github.boniGarcia.testng.ch04.timeouts;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ImplicitAndPageLoadWait {
    /*
    Implicit Wait Timeout
    The implicit wait tells the WebDriver to wait for a certain amount of time when trying to find an element
    if it's not immediately available. The default setting is 0.
    Once set, the implicit wait is set for the life of the WebDriver object.


    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    In this example,
    we're telling the WebDriver to wait up to 10 seconds for an element
    to appear before it throws a NoSuchElementException.

    Implicit waits and page load timeouts are different mechanisms in Selenium for waiting,
    but they serve related yet distinct purposes:

    Implicit Wait
    Purpose: Waits for elements to become available.
    How it works: When you try to find an element on the page and it's not immediately visible,
    the implicit wait will tell the WebDriver to poll the DOM for a certain amount of time
    when trying to find any elements. It will wait for the specified time before throwing a NoSuchElementException.
    Scope:
    It is set for the entire duration of the WebDriver object and applies to all findElement and findElements calls.
    Default Behavior: The default setting is 0 seconds, meaning if the element is not found immediately,
    the WebDriver will not wait and throw an exception.

    Page Load Timeout
    Purpose: Waits for a page to fully load.
    How it works: This timeout sets the amount of time to wait for a page load to complete
    before throwing a TimeoutException. It's specifically for the time a browser takes to load the entire page.
    Scope: It applies to the driver.get or driver.navigate().to calls and is only relevant during page loads.
    Default Behavior: By default, WebDriver will wait for the page load to complete indefinitely
    unless a page load timeout is set.
    So yes, implicit wait is for waiting for elements to become available
    or interactable on the page, while page load timeout is specifically for waiting for the entire page to finish loading. They both are waiting strategies, but they apply to different aspects of interacting with a web page.

     */
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    /*
    Before interacting with the elements, we specify an implicit wait strategy.
    In this case, we set up a timeout of 10 seconds.

     */
    @Test
    public void testImplicitWait(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
        if we comment out this wait line, it will givae error:
        NoSuchElementException: no such element:
        Unable to locate element: {"method":"css selector","selector":"#landscape"}
        or-another same explanation:
        You can play with this feature by dropping the implicit wait from the test (step 1).
        If you do that, you will notice that the test fails in step 2 due to a NoSuchElementException.
         */
        WebElement landscape = driver.findElement(By.id("landscape"));
        assertThat(landscape.getAttribute("src")).containsIgnoringCase("landscape");
    }
    @Test
    public void testPageLoadTimeout(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));

        assertThatThrownBy(() -> driver
                .get("https://bonigarcia.dev/selenium-webdriver-java/"))
                .isInstanceOf(TimeoutException.class);
    }


}
