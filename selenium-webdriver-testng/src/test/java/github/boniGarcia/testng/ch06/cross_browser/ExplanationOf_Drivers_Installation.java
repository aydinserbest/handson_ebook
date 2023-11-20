package github.boniGarcia.testng.ch06.cross_browser;

public class ExplanationOf_Drivers_Installation {
    /*
    //the browser-specific managers
    //  1-
    /*
    Each browser has its own driver.
    For example, we use chromedriver for controlling Chrome or geckodriver for Firefox,
    WebDriverManager provides a set of managers for different browsers,
    namely Chrome, Firefox, Edge, Opera, Chromium, and Internet Explorer.
    WebDriverManager internally executes a resolution algorithm to manage the drivers required by each browser.
     */
    /*
    As usual, before the actual WebDriver instantiation,
    we resolve the required driver (chromedriver in this example) using WebDriverManager.
         WebDriverManager.chromedriver().setup();
    it allows specifying the browser type (i.e., Chrome, Firefox, etc.) simply by selecting a specific manager
    (i.e., chromedriver(), firefoxdriver(), etc.).

    We create the WebDriver instance.
        WebDriver driver = new ChromeDriver();

    Since we want to use Chrome in this test,
    for.ex, if we want to use Edge,:
        WebDriverManager.edgedriver().setup();
    we use a ChromeOptions object as the capabilities argument (using the method oneOf()).
     */
    //  2-
    /*
    another way:
    WebDriverManager resolves the required driver (chromedriver in this case)
    and creates an instance of the proper WebDriver type (ChromeDriver in this case) in a single line.

        driver = WebDriverManager.chromedriver().create();

     */
    //  3-
    /*
    In addition to the browser-specific managers
    (e.g., chromedriver(), firefoxdriver(), etc.), WebDriverManager provides a generic manager,
    i.e., a manager that can be parameterized to act as a specific manager (for Chrome, Firefox, etc.).

        driver = WebDriverManager.getInstance().create();
        or
        driver = WebDriverManager.getInstance(browser).create();
     */
    /*
    There are different options to invoke this method:
    1-
    getInstance(String browserName)
    Where browserName is the browser name as case-insensitive string.
    The possible values are Chrome, Firefox, Edge, Opera, Chromium, IExplorer, and Safari.
    2-
    getInstance()
    When no parameter is specified,
    the configuration key wdm.defaultBrowser is used to select the manager (Chrome by default).
     */
    /*
    We use WebDriverManager to resolve the required driver and create the WebDriver instance.
    WebDriverManager allows the use of a parameterized manager by invoking the method getInstance().
    In this case, we use the browser name (e.g., chrome, firefox, etc.) to select the manager.
     */

}
