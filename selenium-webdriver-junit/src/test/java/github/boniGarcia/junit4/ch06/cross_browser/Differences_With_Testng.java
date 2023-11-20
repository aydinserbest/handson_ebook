package github.boniGarcia.junit4.ch06.cross_browser;

public class Differences_With_Testng {
    /*
     We need to create the WebDriver instance in the test logic
    since the test parameters are injected in the test method when using TestNG.

    The author's statement pertains to the difference in how test parameters are handled in JUnit and TestNG,
    and how this affects the creation of the WebDriver instance in each framework.

    JUnit
    In the JUnit example (CrossBrowserJUnit4Test),
    the test parameters are defined using the @Parameter and @Parameters annotations.
    The parameters are loaded before the execution of the test method.
    This allows for the initialization of the WebDriver instance in a setup method (@Before),
    which is executed before each test method. Here, the browserName parameter is
    already available to be used in the setup method.

    TestNG
    In the TestNG example (CrossBrowserNGTest), parameters are provided
    to the test method using a DataProvider. In TestNG, parameters from a DataProvider are
    injected directly into the test method at runtime.
    This means that the parameters (browserName in this case) are
    only available within the scope of the test method itself,
    not in any setup or initialization methods like @BeforeMethod.

    Key Differences
    Parameter Availability:

    JUnit: Parameters are available before the test method is executed, allowing for their use in setup methods.
    TestNG: Parameters are injected directly into the test method, making them unavailable in setup methods.
    WebDriver Instance Creation:

    JUnit: The WebDriver instance can be created in the setup method because the browserName parameter is already loaded.
    TestNG: The WebDriver instance must be created within the test method (testCrossBrowser)
    because that's where the browserName parameter is available.
    Implication
    The author is highlighting that when using TestNG,
    you often have to include some initialization logic (like creating the WebDriver instance)
    within the test method itself, rather than in separate setup or initialization methods.
    This is a direct consequence of how TestNG handles parameter injection with DataProvider.
     */
}
