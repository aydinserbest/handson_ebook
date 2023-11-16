package github.boniGarcia.testng.ch04.javascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExecuteJavaScript {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());
        driver.quit();
    }

    @Test
    public void testScrollBy() {
    /*
        any driver that is a subclass of RemoteWebDriver also implements the JavascriptExecutor interface.
        This is crucial because it tells us that
        we have the capability to execute JavaScript on the browser through our WebDriver instance.
        The phrase "have the capability to execute JavaScript on the browser through our WebDriver instance" means
        that we can use the WebDriver to run JavaScript code directly within the web browser
        that the WebDriver is controlling.
        This is particularly useful for actions that are not directly supported by the WebDriver API.
        For example, while WebDriver can click buttons and fill out forms,
        it might not have a built-in method for scrolling down the page or adjusting the zoom level of the browser.
        This is where executing JavaScript comes in handy.

        Here is an example in Java that demonstrates how you can use WebDriver
        to execute JavaScript to perform a scroll action on a web page:
     */

        // Navigate to a web page
        driver.get("http://example.com");

        // Cast the driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript to scroll down the window by 1000 pixels
        js.executeScript("window.scrollBy(0, 1000);");

        // Perform any other actions if needed
    }

    /*
    When we say "have the capability to execute JavaScript on the browser through our WebDriver instance,"
    it means that the WebDriver API allows us to run JavaScript code directly in the browser
    that the WebDriver is controlling.
    This is done using the JavascriptExecutor interface provided by the WebDriver API.
     */
    @Test
    public void secondExample(){
        // Navigate to a website, for example, a sample page
        driver.get("https://www.example.com");

        // Cast the driver instance to the JavascriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Define the JavaScript code to be executed
        String script = "return document.title;"; // JavaScript code to get the page title

        // Execute the JavaScript code and store the result
        String pageTitle = (String) js.executeScript(script);

        // Print the page title to the console
        System.out.println("The page title is: " + pageTitle);

        // Close the browser
        driver.quit();
    }
    /*
    In this example, the JavaScript code return document.title;
    is executed within the context of the current page loaded in the browser.
    The executeScript method returns the result of the JavaScript execution,
    which in this case is the title of the page. The result is then cast to a String
    (since we know the title is a string) and printed out to the console.

    The document.title property in JavaScript returns the title of the current document, which is always a string.
    This is defined by the JavaScript language and the DOM (Document Object Model) API that browsers implement.

    When you execute a script with JavascriptExecutor in Selenium,
    the return type is Object because the executeScript method is designed to handle any JavaScript
    that could be executed in the browser, which might return different types of data
    (strings, numbers, booleans, objects, arrays, etc.). Since Java is a statically typed language,
    you need to explicitly cast the returned Object to the specific type you are expecting.

    Here's the process:

    The JavaScript snippet return document.title; is executed in the browser context.
    The browser evaluates the script and returns the title of the document as a string.
    This string is then returned to the Selenium WebDriver.
    Since WebDriver's executeScript method can return any type of JavaScript value,
    it is typed as returning an Object in Java.
    You then cast this Object to a String in Java, because you know that in this context,
    document.title can only be a string.
    The casting is necessary because Java needs to know what type of object it is dealing with at compile time.
    This casting tells Java, "I am certain the value returned here will be a string, so treat it as such."

     */
    }


