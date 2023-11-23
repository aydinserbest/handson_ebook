package github.boniGarcia.junit4.ch06.failure_analysis;

public class Explanations_Flow {
    /*
    Let's break down the functionality and flow of these three classes,
    focusing specifically on how they work together to take a screenshot
    when a test fails in a JUnit 4 test suite.

    Overview of the Three Classes

    FailureJUnit4Test:
    This is the JUnit test class where the actual tests are written and executed.
    FailureManager:
    This class is responsible for taking and saving the screenshot.
    FailureWatcher:
    A custom JUnit TestWatcher that listens for test failures and triggers the screenshot process using FailureManager.

    Interconnections and Flow
    1. Test Execution Begins
    FailureJUnit4Test is the starting point. When JUnit runs this class, it executes the tests defined within it.
    2. WebDriver Initialization
    Setup: Before any tests run, the @BeforeClass method (setup) is executed, initializing the WebDriver.
    This driver is used for browser interactions in the tests.
    3. TestWatcher Rule Setup
    FailureWatcher Initialization: The FailureJUnit4Test class declares a TestRule named testWatcher,
    which is an instance of FailureWatcher. This is initialized with the WebDriver,
    which is null at this point but will be non-null by the time it's needed.
    4. Test Execution and Failure
    Running Tests: JUnit runs the test methods in FailureJUnit4Test.
    Let's focus on the testFailure method, which is designed to fail.
    Test Failure: The testFailure method navigates to a webpage using the WebDriver
    and then deliberately fails the test using fail("Forced error").
    5. Detecting Test Failure
    Triggering FailureWatcher: Upon test failure, JUnit's TestWatcher mechanism kicks in.
    The overridden failed method in FailureWatcher is called because of the test failure.
    6. Screenshot Capture
    Inside FailureWatcher:
    When the failed method is invoked, it now has a non-null WebDriver.
    This is because, by the time a test fails, the WebDriver has been initialized in the @BeforeClass method.
    The failed method then instantiates FailureManager with the current WebDriver.
    FailureManager Takes Action:
    FailureManager's takePngScreenshot method is called. It captures the current state of the browser
    and saves it as a PNG file.
    The screenshot file is named after the test that failed, using description.getDisplayName().
    7. Screenshot File Location
    The screenshot is saved to the project's working directory
    (or a path specified in the takePngScreenshot method).
    The filename is derived from the failed test's name.
    8. Test Suite Completion
    Teardown: After all tests are executed (or upon failure), the @AfterClass method (teardown)
    is executed to close the WebDriver.
    Summary
    This design leverages JUnit's TestWatcher to listen for test failures. Upon a failure,
    it uses the WebDriver, which is guaranteed to be initialized by that time,
    to take a screenshot of the browser's current state. The FailureManager class encapsulates the screenshot logic,
    and the FailureWatcher serves as the bridge between the test failure event
    and the screenshot capture process.
     */
    /*
    Let's delve into what happens right after the fail("Forced error");
    line in the testFailure method and how it leads to the triggering of FailureWatcher:

    Step-by-Step Breakdown After fail("Forced error");
    Immediate Test Failure:

    The fail("Forced error"); line immediately causes the current test (testFailure) to fail.
    This is an explicit failure triggered by the fail method provided by JUnit.
    JUnit's Internal Test Execution Process:

    JUnit has an internal mechanism for running tests and handling their lifecycle events
    (like setup, teardown, success, and failure).
    When a test method throws an exception (like AssertionError from fail()), JUnit catches this exception.
    It recognizes this as a test failure.
    Interaction with TestWatcher (i.e., FailureWatcher):

    FailureWatcher extends TestWatcher, a special JUnit rule that provides methods
    that are called when tests succeed, fail, or are skipped.
    In your setup, you've defined FailureWatcher as a TestRule via the @Rule annotation in FailureJUnit4Test.
    JUnit's framework understands that when a test associated with this TestRule fails,
    it should call the corresponding methods of the rule.
    Calling the failed Method:

    Since FailureWatcher overrides the failed method of TestWatcher,
    this overridden method is called by JUnit when the test fails.
    This is where the connection happens. JUnit's framework knows about FailureWatcher
    because of the @Rule annotation and automatically calls the failed method on test failure.
    Executing FailureWatcher.failed Method:

    Inside the failed method, FailureWatcher now calls FailureManager to take a screenshot.
    At this point, the WebDriver is available and initialized,
    so FailureManager can successfully capture the screenshot.
    Summary
    The test fails because of fail("Forced error");.
    JUnit detects this failure and looks for any TestRule instances associated with the test.
    Since FailureWatcher is a TestRule (via @Rule), its failed method is called.
    FailureWatcher then uses FailureManager to take a screenshot.
    This process shows the integration of JUnit's testing lifecycle with custom rules,
    allowing for additional actions (like taking screenshots) upon test failures.
     */
    /*
    When the fail("Forced error") statement in the testFailure method is executed,
    it deliberately causes the test to fail.
    Here's what happens next, in more detail:

    How TestWatcher Works in JUnit
    JUnit's TestWatcher is a special type of TestRule used to add logic that occurs based on the outcome of test methods.
    When you add a TestWatcher to a test class (using the @Rule annotation),
    JUnit ensures that certain methods in the TestWatcher are called depending on whether a test passes or fails.

    The Flow After fail("Forced error"):
    Test Method Throws Exception:

    The fail("Forced error") method call throws an AssertionError.
    This is a type of exception that JUnit uses to indicate that a test has failed.
    JUnit Catches the Exception:

    JUnit catches this exception and recognizes that the test (testFailure method) has failed.
    JUnit Triggers TestWatcher:

    Since FailureWatcher is a TestWatcher and has been added to the FailureJUnit4Test class
    with the @Rule annotation, JUnit now calls the failed method of FailureWatcher.
    The failed method is a special method in TestWatcher designed to be invoked when a test fails.
    Execution Inside FailureWatcher:

    Within the failed method of FailureWatcher, the logic for taking a screenshot is executed.
    Since the WebDriver instance is now initialized (it was done in the @BeforeClass setup method),
    it can be used to take a screenshot of the current browser state.
    Screenshot Capture:

    FailureWatcher uses its FailureManager instance to capture and save the screenshot.
    This is done by calling the takePngScreenshot method of FailureManager.
    Test Execution Continues or Ends:

    After FailureWatcher has done its work, JUnit continues with the next test method
    or finishes the test class execution if there are no more tests.
    If there are any @After or @AfterClass methods, these are executed as part of the test lifecycle
    (e.g., to close the WebDriver).
    Summary
    The fail("Forced error") statement initiates a chain of events managed by JUnit's testing framework.
    The TestWatcher (FailureWatcher) is a key component that listens for test failures.
    Once a test fails,
    TestWatcher intercepts this event and executes its failed method, leading to the screenshot capture.
    This process is part of JUnit's test lifecycle management,
    allowing for additional actions (like taking screenshots) to be performed in response to test outcomes.
     */
}
