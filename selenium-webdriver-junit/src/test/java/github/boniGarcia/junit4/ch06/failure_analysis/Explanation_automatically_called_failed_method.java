package github.boniGarcia.junit4.ch06.failure_analysis;

public class Explanation_automatically_called_failed_method {
    /*
    how the @Rule in the FailureJUnit4Test class triggers the failed method in the FailureWatcher class,
    without explicitly calling testWatcher.failed();.

    Working Principle of TestWatcher Mechanism
    Automatic Triggering: In the JUnit framework,
    TestWatcher is used to monitor whether a test method succeeds or fails.
    The TestWatcher class contains several methods that can intervene at different stages of the test lifecycle
    (failure, success, before starting, after finishing).

    failed Method: When a test method fails (like due to a fail() call),
    the JUnit framework automatically invokes the failed method in TestWatcher.
    This is an integrated behavior within JUnit's test lifecycle.

    How Does It Work?
    On Test Failure: When the test method in the FailureJUnit4Test class (testFailure()) fails
    (for instance, due to the fail("Forced error"); line),
    JUnit detects this failure.

    TestWatcher is Triggered: The testWatcher object, defined with @Rule,
    is an instance of TestWatcher and is managed automatically by JUnit.
    When the test fails, JUnit calls the failed method of the testWatcher object.

    FailureWatcher's failed Method Executes: The failed method overridden in the FailureWatcher class
    becomes active with this trigger
    and executes the line failureManager.takePngScreenshot(description.getDisplayName());.

    Conclusion
    In this process, there's no need for a direct method call like testWatcher.failed();.
    The JUnit framework automatically invokes the appropriate methods of TestWatcher
    according to the test lifecycle. This makes your test code cleaner and more manageable,
    as you don't have to manually check
    if the test succeeds or fails. JUnit provides this functionality automatically for you.
     */
}
