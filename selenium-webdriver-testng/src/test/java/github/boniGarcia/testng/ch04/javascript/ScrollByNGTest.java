package github.boniGarcia.testng.ch04.javascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScrollByNGTest {
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
        //Open a practice web page containing very long text
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        /*
        This line casts the driver object to a JavascriptExecutor.
        This is possible because the driver object inherits from RemoteWebDriver,
        which implements the JavascriptExecutor interface. This casting is necessary
        to access methods that allow us to execute JavaScript within the page loaded in the browser.
         */
        /*
        Cast the driver object to JavascriptExecutor.
        We will use the variable js to execute JavaScript in the browser.

         */
        JavascriptExecutor js = (JavascriptExecutor)driver;
        /*
        Here, a string variable named script is being declared and initialized with a JavaScript command.
        The command window.scrollBy(0, 1000);
        is JavaScript that tells the browser to scroll down the window by 1000 pixels along the Y-axis.
         */
        String script = "window.scrollBy(0,1000)";
        /*
        This line uses the executeScript method from the JavascriptExecutor interface
        to run the JavaScript code contained in the script variable.
        When this line is executed, the browser will scroll down the page by 1000 pixels.
         */
        js.executeScript(script);
        /*
        Execute a piece of JavaScript code.
        In this case, we call the JavaScript function scrollBy() to scroll the document
        by a given amount (in this case, 1,000 px down).
        Notice that this fragment does not use return, and therefore,
        we do not receive any returned object in the Java logic.
        In addition, we are not passing any argument to the script.

         */
    }
    /*
    When you type String script = "window.scrollBy(0,1000)";,
    the IDE recognizes String as a data type
    and script as a variable name.
    The text within the quotes is a string literal, and most IDEs will color it differently to reflect this.

    However, when you type js.executeScript(script);,
    executeScript is recognized as a method call.
    IDEs often color method names differently to distinguish them from variables,
    literals, or other elements in the code.

    The reason the color might change after typing the second line (js.executeScript(script);)
    is that the IDE is context-aware. It understands
    that the string script is being used as an argument to a method,
    and the method is part of an object that has specific types (in this case, JavascriptExecutor).

    Here's a step-by-step breakdown of what typically happens:

    Before Typing the Second Line:
    String script = "window.scrollBy(0,1000)";
    The IDE doesn't have enough context to understand how the script variable will be used.
    The string literal "window.scrollBy(0,1000)" is highlighted as a string.
    After Typing the Second Line:
    js.executeScript(script);
    The IDE now understands that script is used as an argument to the executeScript method.
    The executeScript method is part of the JavascriptExecutor interface, and the IDE highlights it accordingly.
    The IDE also now knows that script is not just any string; it's a JavaScript command. Depending on the IDE's intelligence and features, it may highlight script to reflect its usage in executing JavaScript.
    The visual change you observe is due to the real-time parsing and syntax highlighting capabilities of your IDE, which are designed to give you immediate feedback about the code you're writing.
     */
    /*
        Any driver object that inherits from the class RemoteWebDriver
     also implements the JavascriptExecutor interface.
     Therefore, when using a major browser (e.g., ChromeDriver, FirefoxDriver, etc.)
     declared using the generic WebDriver interface, we can cast it to JavascriptExecutor
     as shown in the following snippet.
     Then, we can use the executor (using variable js in the example) to invoke the methods presented in.

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

      any driver that is a subclass of RemoteWebDriver also implements the JavascriptExecutor interface.
      This is crucial
      because it tells us that we have the capability to execute JavaScript on the browser
      through our WebDriver instance.

    In the context of the test:

    WebDriver driver = new ChromeDriver(); creates a new instance of ChromeDriver,
    which is used for automating the Chrome browser. This instance is stored in a variable of type WebDriver.
    JavascriptExecutor js = (JavascriptExecutor) driver; casts this WebDriver instance to a JavascriptExecutor,
    enabling us to use the executeScript method
    and other methods that allow us to run JavaScript commands in the browser.

    The test code provided uses this relationship by casting the WebDriver instance
    to JavascriptExecutor
    and then running a JavaScript command to scroll the browser window.
    This illustrates how you can extend the functionality of your WebDriver
    to interact with the page in ways that are not directly provided by the WebDriver API, like scrolling,
    which is typically a part of user interaction not covered by WebDriver's standard commands.

     */
}
