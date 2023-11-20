package github.boniGarcia.junit4.ch06.cross_browser;

public class Difference_Implementations_1 {
    /*
    The three JUnit4 test examples you provided are all
    aimed at performing cross-browser testing
    using Selenium WebDriver,
    but they differ in how they parameterize the driver setup for each test:
     */

    // 1. example:CrossBrowserByClassJUnit4Test
    /*
     @Parameter(0)
    public Class<? extends WebDriver> webdriverClass;
    This test class uses a class parameter (Class<? extends WebDriver>) to instantiate the WebDriver.
     */
    /*
    @Parameters(name = "{index}: browser={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { ChromeDriver.class },
                { EdgeDriver.class }, { FirefoxDriver.class } });
    }
    The @Parameters method returns a collection of class types (ChromeDriver.class, EdgeDriver.class, FirefoxDriver.class),
    which represent the different browser drivers.
     */
    /*
    There's no chance of instantiating a WebDriver class that is not a browser driver
    because the test specifies the exact classes to use
    (ChromeDriver.class, EdgeDriver.class, FirefoxDriver.class).
    There are no "unrelated" WebDriver classes in the parameters.
    JUnit does not automatically discover or instantiate subclasses of WebDriver;
    it only uses the ones explicitly provided in the data() method.
     */
    /*
    The data() method is returning a collection of object arrays,
    and each object array contains one item which is a class literal.
    These class literals (ChromeDriver.class, EdgeDriver.class, FirefoxDriver.class) are used to specify
    the type of WebDriver that will be instantiated for the tests.

    Here's what happens in more detail:

    The @Parameters annotation is used by JUnit to mark the data() method as the provider of parameters for the tests.
    The (name = "{index}: browser={0}") part of the annotation is
    used for naming the tests in a readable format.
    {index} will be replaced by the index of the parameter set,
    and {0} will be replaced by the first parameter in the array (which in this case is the class literal of the WebDriver).

    Inside the data() method,
    Arrays.asList() is used to create a list of object arrays.
    Each array is a set of parameters to be passed to the test.

    The items within the curly braces { { ChromeDriver.class }, { EdgeDriver.class }, { FirefoxDriver.class } } are
    the actual parameters.
    Each array contains one parameter,
    and each parameter is a class that extends WebDriver.

    You are limiting the test
    to only use these specified driver classes.
     When JUnit runs the parameterized test,
     it will only instantiate WebDriver objects from these classes.
     It will not consider any other classes that are not listed in this collection.

    Each array is passed to the constructor or fields of the test class
    (depending on how the test class is set up)
    before each test execution. In this case,
    it's passed to the webdriverClass field, which is then used in the setup() method
    to instantiate the actual WebDriver object.

    So, by defining the parameters as { { ChromeDriver.class }, { EdgeDriver.class }, { FirefoxDriver.class } },
    you ensure that the test is run once for each of these three web driver classes,
    and no other classes will be used for the tests.
     */
    /*
    @Parameter(0)
    public Class<? extends WebDriver> webdriverClass;
    For each element in the collection returned by data(),
    JUnit creates a new instance of the test class (CrossBrowserByClassJUnit4Test).
    It then injects the Class object from the array into the webdriverClass field of the test class.
     */
    /*
    When JUnit runs the test,
    it first calls the data() method to get the parameters, which are the different WebDriver class types.

    For each set of parameters from the data() method,
    JUnit will create a new instance of the CrossBrowserByClassJUnit4Test class.
    It will then set the webdriverClass field with the class type from the parameters (e.g., ChromeDriver.class).

    Before each test method is run, JUnit calls the setup() method. Inside this method,
    the webdriverClass is used with WebDriverManager.getInstance(webdriverClass).create();
    to instantiate the actual driver object. The getInstance() method of the WebDriverManager probably uses
    reflection to instantiate an object of the class provided by webdriverClass.

    The result of the create() method is assigned to the driver field, which means driver now
    holds an instance of ChromeDriver, EdgeDriver, or FirefoxDriver,
    depending on which class was provided by webdriverClass.

    Now the driver field is no longer null; it's a fully initialized WebDriver object that
    you can use to interact with a browser in your test method.

    After the test method completes, the teardown() method is called, where driver.quit() is
    invoked to close the browser and free up resources.

    This process (starting from setting webdriverClass) repeats for each set of parameters provided by the data() method,
    which means the setup() and teardown() methods are run for each browser type specified.
     */

    /*
     @Before
    public void setup() {
        driver = WebDriverManager.getInstance(webdriverClass).create();
    }
     Before each test method is run, JUnit calls the setup() method (annotated with @Before).
     This method uses the webdriverClass field
     to create an instance of the WebDriver
     using WebDriverManager.getInstance(webdriverClass).create();.
     Because webdriverClass is guaranteed to be a Class object that represents a subclass of WebDriver
     (such as ChromeDriver or FirefoxDriver),
     the manager creates the appropriate driver instance for the test.
     */
    /*
     @Test
    public void testCrossBrowserByClass() {
    The testCrossBrowserByClass() method (annotated with @Test) is then run using the instantiated driver.
     */
}
