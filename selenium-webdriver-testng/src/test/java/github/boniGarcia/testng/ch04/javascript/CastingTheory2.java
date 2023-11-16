package github.boniGarcia.testng.ch04.javascript;

public class CastingTheory2 {
    /*
    In Selenium WebDriver's architecture,
    the casting you're seeing in these examples is used to access functionality
    that is not available in the WebDriver interface by default. Let's go through each case:
  */
  /*
    1. Taking Screenshots with TakesScreenshot
    In the first test example:

        @Test
    public void testScreenshotPng() throws IOException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        TakesScreenshot ts = (TakesScreenshot) driver;
    }

    Here, driver is an instance of WebDriver,
    which is the main interface for interacting with browsers in Selenium.
    By itself, WebDriver does not have the capability to take screenshots.

    TakesScreenshot:
    This is an interface in Selenium
    that adds the ability to capture a screenshot
    and store it in different ways. It has a method called getScreenshotAs,
    which allows you to specify the output type of the screenshot (e.g., file, base64, etc.).

    Casting to TakesScreenshot:
    The driver instance is being cast to TakesScreenshot
    because the actual object referenced by driver is an instance of a class
    that implements both WebDriver and TakesScreenshot interfaces (like ChromeDriver, FirefoxDriver, etc.).
    This cast is necessary to call the methods defined in the TakesScreenshot interface,
    which are not available in the WebDriver interface.
     */
    /*


    2- Executing JavaScript with JavascriptExecutor
    In the second test example:

    @Test
    public void testScrollBy() {

        driver.get("http://example.com");

    // Cast the driver to JavascriptExecutor
    JavascriptExecutor js = (JavascriptExecutor) driver;}
    */
    /*


        JavascriptExecutor:
        This is another interface in Selenium that provides the ability to execute JavaScript
        in the context of the current page.
        This can be necessary for a variety of reasons, such as interacting with elements that are not easily accessible through the WebDriver API or performing actions like scrolling, which are not directly supported by the WebDriver API.

        Casting to JavascriptExecutor:
        As with TakesScreenshot, the actual object referenced by driver is
        capable of executing JavaScript because it's an instance of a class
        that implements both WebDriver and JavascriptExecutor interfaces.
        By casting driver to JavascriptExecutor, you gain access to the executeScript
        and executeAsyncScript methods that allow you to run JavaScript commands within the browser.

        Why Cast in Selenium Architecture?
        Interface Segregation:
        Selenium uses interfaces to segregate different functionalities.
        This is part of its design pattern, adhering to the Interface Segregation Principle,
        one of the SOLID principles in object-oriented programming.
        It means that the WebDriver interface is kept simple and specific to browser automation commands.

        Flexibility:
        Not all drivers or browser implementations may support all features.
        By separating capabilities like taking screenshots or executing JavaScript
        into separate interfaces, Selenium allows for flexible driver implementations
        that can offer only the functionality they can support.

        Enhanced Capabilities:
        When you know that your driver supports these extended capabilities,
        you can cast to the specific interfaces and use the additional methods they provide.
        This is a way to extend the functionality of the driver without modifying the core WebDriver interface.

        In summary, in the Selenium architecture, the classes that implement the WebDriver interface
        can often implement additional interfaces to provide extra functionality,
        such as TakesScreenshot and JavascriptExecutor. Casting is a way to access this extended functionality
        when you need it.

        */
}
