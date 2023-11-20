package github.boniGarcia.junit4.ch06.cross_browser;

public class Difference_Implementations_2 {
    /*
    n the second example, CrossBrowserByEnumJUnit4Test, the process is very similar to the first example,
    but instead of using class literals, it uses an enumeration (DriverManagerType)
    to manage the different types of drivers.
    */
    /*
    DriverManagerType is an enum from the WebDriverManager library,
    which is a tool that simplifies the management of binary drivers for different browsers for Selenium WebDriver.

    The enum DriverManagerType typically includes constants for each supported browser.
    Each constant represents a type of WebDriver that can be managed by the WebDriverManager.
    This can include:

    CHROME for Google Chrome's ChromeDriver
    FIREFOX for Mozilla Firefox's FirefoxDriver
    OPERA for Opera's OperaDriver
    EDGE for Microsoft Edge's EdgeDriver
    IE for Internet Explorer's IEDriver
    ...and possibly others, depending on the version of the WebDriverManager library.
    When you use WebDriverManager.getInstance(driverManagerType).create();,
    the WebDriverManager uses the provided DriverManagerType enum value
    to download (if necessary) and set up the appropriate driver binary for the browser you want to test with.

    So, in your data() method, when you return:

    return Arrays.asList(new Object[][] { { CHROME }, { EDGE }, { FIREFOX } });

    You are specifying that you want to run your tests on Chrome, Edge, and Firefox.
    The WebDriverManager will handle the instantiation of ChromeDriver, EdgeDriver, and FirefoxDriver respectively,
    when you call create() on the WebDriverManager instance.

    DriverManagerType is not a class from the core Java SDK or the Selenium WebDriver API itself;
    it is specific to the WebDriverManager library which serves as a companion to Selenium
    by making the driver setup process easier.

     */
    /*

    Here's what happens:

    Parameter Field: The field public DriverManagerType driverManagerType; is annotated with @Parameter(0),
    which indicates to JUnit that this field should be injected with the first parameter from the provided array
    (in this case, CHROME, EDGE, or FIREFOX from the DriverManagerType enum).

    Data Method: The data() method is marked with the @Parameters annotation, indicating that
    it provides the parameters for the test. It returns a collection of Object[] arrays,
    where each array contains a single element from the DriverManagerType enum.

    Parameter Injection: When the test runs, JUnit creates a new instance of CrossBrowserByEnumJUnit4Test
    for each of the parameter sets provided by the data() method.
    It injects the DriverManagerType value into the driverManagerType field of the test class instance.

    Driver Initialization: In the setup() method, which is called before each test,
    the driverManagerType field is used with WebDriverManager.getInstance(driverManagerType).create();
    to instantiate the WebDriver. The getInstance() method of WebDriverManager is
    designed to understand the DriverManagerType enum and create the appropriate WebDriver instance accordingly.

    Assignment to driver Field: The created WebDriver instance is then assigned to the driver field.
    The driver field is what your test methods will use to interact with the browser.

    Test Execution: The test method annotated with @Test is executed, using the driver instance
    to perform actions on the browser.

    Teardown: After the test method completes, the teardown() method is called to quit the driver and clean up resources.

    By using enums, the code becomes more maintainable and less prone to errors like typos,
    since enums enforce a fixed set of possible values
    (in this case, the types of drivers supported by the WebDriverManager).
    Each value in the enum corresponds to a specific WebDriver implementation that the WebDriverManager can provide.
     */
}
