package github.boniGarcia.junit4.ch06.order;

public class Order_explanation {
    /*
    FROM THE E-BOOK:
    The test execution order is unknown beforehand in the unit testing frameworks used in this book.
    Nevertheless, there are mechanisms to select a given execution order.
    One possible use of this feature in the Selenium WebDriver arena is
    to reuse the same browser session (i.e., use the same WebDriver instance) by different tests,
    interacting with the SUT in a given order.
     */
    /*
    Test Execution Order is Unknown:
    In many unit testing frameworks, the order in which individual tests are run is not predetermined or guaranteed.
    This means that each test should ideally be independent of others,
    capable of running in any sequence without affecting the outcome.

    Mechanisms to Select Execution Order: Despite the default behavior,
    these frameworks often provide ways to specify the order in which tests should be executed.
    This could be important for certain types of tests or testing strategies.

    Application in Selenium WebDriver: Selenium WebDriver is a tool used for automating web application testing.
    In this context, the author is suggesting a specific use case for setting a test execution order.

    Reusing the Same Browser Session: The author mentions reusing the same browser session
    (i.e., the same instance of WebDriver) across different tests. In many cases,
    each test might start a new browser session, which can be time-consuming and resource-intensive.

    Interacting with the System Under Test (SUT) in a Given Order:
    By reusing the same browser session and specifying the test order,
    the tests can interact with the system under test (SUT) in a specific sequence.
    This can be useful when the state of the web application from one test
    is required as a starting point for the next test.

    In summary, the author is discussing how,
    in the context of using Selenium WebDriver for web testing,
    one might benefit from specifying the order of test execution to allow for more efficient use of resources
    (like browser sessions) and to ensure tests interact with the web application in a specific, deliberate sequence.
     */
    /*
    Test Execution Order:

    in some unit testing frameworks, the execution order of tests is not predetermined.
    However, mechanisms exist to specify an order.
    In your test class, @FixMethodOrder(MethodSorters.NAME_ASCENDING) is used to define the execution order
    based on the method names.
    This aligns with the author's mention of such mechanisms.

    Your test class is designed to execute tests in a specific order,
    dictated by the @FixMethodOrder(MethodSorters.NAME_ASCENDING) annotation.
    This annotation ensures that the test methods within the class are executed in alphabetical order by their names.
    In your case, the execution order will be testA -> testB -> testC.
     */
    /*
    Reusing the Same Browser Session:

    The author talked about the advantage of reusing the same browser session across different tests.
    In your class, static WebDriver driver is initialized once in setup() and terminated in teardown().
    All tests (testA, testB, testC) use this single instance of WebDriver.
    This is a direct application of the concept of reusing the browser session,
    as mentioned by the author.
     */
    /*
    Interacting with the System Under Test (SUT) in a Given Order:

    The tests in your class are designed to interact with a web application in a specific sequence.
    testA navigates to a page and checks its content.
    testB then clicks on a link labeled "2" and checks the new content.
    This test depends on the browser state left by testA.
    Similarly, testC clicks on a link labeled "3" and checks the content.
    It relies on the state left by testB.
     */
    /*
    Efficiency and Sequence:

    The approach of using a single browser session and ordered tests is efficient
    because it avoids the overhead of launching and closing the browser for each test.
    The sequence of the tests also simulates a user journey through the web application,
    checking the correctness of the application's responses at each step.
     */
    /*
    Conclusion
    Your OrderJUnit4Test class is a practical example of the concepts discussed by the author.
    It demonstrates how to enforce a specific execution order of tests in a JUnit 4 framework
    and how to leverage a single browser session across multiple tests
    to efficiently test a sequence of actions in a web application.
     */
}
