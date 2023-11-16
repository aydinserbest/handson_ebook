package github.boniGarcia.testng.ch04.javascript;

public class CastingTheory1 {
    /*
    In Java, casting is the process of converting one object type into another.
    In the context of Selenium WebDriver, casting is used
    when you want to use a more specific type of WebDriver than the one you have.

    Here's what's happening with this particular line:
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebDriver driver: This is the interface that all driver classes implement.
    It represents the browser being automated. When you instantiate a driver,
    like new ChromeDriver(), you're usually working with a WebDriver reference to it.

    JavascriptExecutor:
    This is another interface that extends WebDriver.
    It contains additional methods to execute JavaScript in the context of the current page.
    Not all WebDriver implementations may support executing JavaScript,
    but the major browsers like Chrome, Firefox, Internet Explorer, and Safari do.

    The cast (JavascriptExecutor) driver: Here you're telling the Java compiler,
    "I know that this driver object is not just a WebDriver, but also a JavascriptExecutor.
    Please treat it as such." This allows you to call JavascriptExecutor methods on the driver object.

    This is necessary because driver is declared as a WebDriver, and by default,
    you can only call WebDriver methods on it. To execute JavaScript,
    you need to access the methods defined in the JavascriptExecutor interface.
    The cast does not change the actual object or its capabilities; it merely informs the compiler
    how you intend to use it.

    If the driver object wasn't actually an instance of a class that implements JavascriptExecutor,
    this cast would fail at runtime with a ClassCastException. However, since the major browser driver classes
    (like ChromeDriver, FirefoxDriver, etc.) do implement JavascriptExecutor, the cast is safe and necessary
    to perform JavaScript execution through the driver instance.
     */
}
