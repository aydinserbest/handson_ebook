package github.boniGarcia.junit4.ch06.order;

public class Error_explanation {
    /*we should define static
        -driver,
        -@BeforeClass and @AfterClass Methods
      otherwise we will get that error:
     */
    /*
    InvalidTestClassError: Invalid test class 'github.boniGarcia.junit4.ch06.order.OrderJUnit4Test':
  1. Method setup() should be static
  2. Method teardown() should be static

  The error you're encountering is related to how the JUnit framework handles lifecycle methods in test classes.
  In JUnit 4, methods annotated with @BeforeClass and @AfterClass are expected to be static.
  This is because these methods are designed to be run once before and after all the tests in the class,
  respectively, and not before or after each individual test method.

    Here's why they need to be static:

    @BeforeClass and @AfterClass Methods:
    These methods are intended to set up and tear down resources that are common to all tests in the test class.
    Since they are run without an instance of the test class being created, they must be static.
    This ensures that they can be invoked without needing an instance of the class.

    Typical Usage:
    Typically, @BeforeClass and @AfterClass are used for expensive operations that don't need to be repeated
    before and after each test, such as setting up a database connection,
    starting a server, or in your case, initializing a WebDriver.

    In your code, to comply with JUnit 4's expectations,
    you should change the setup() and teardown() methods to be static.
    Also, because these methods are static,
    any fields they interact with directly also need to be static.
    This includes your WebDriver instance.
     */
}
