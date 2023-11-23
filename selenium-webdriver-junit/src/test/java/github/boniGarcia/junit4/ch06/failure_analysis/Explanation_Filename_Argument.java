package github.boniGarcia.junit4.ch06.failure_analysis;

public class Explanation_Filename_Argument {
    /*
    The fileName argument in the takePngScreenshot method of the FailureManager class
    is used to specify the name of the screenshot file that will be saved.
    The value for this argument is provided when the method is called from the FailureWatcher class,
    specifically in the failed method which is triggered upon a test failure.

    Here's how the name is determined:

    In FailureWatcher Class
    In the FailureWatcher class, within the overridden failed method,
    the takePngScreenshot method is called with a specific name:

    java
    Copy code
    failureManager.takePngScreenshot(description.getDisplayName());
    description.getDisplayName(): This is a method from JUnit's Description class.
    The Description object represents the test that has just failed.
    The getDisplayName method returns a string that typically includes
    both the name of the test method and the name of the class in which the test method is defined.
    Example
    Assume you have a test method named testExample in a class ExampleTest.
    When this test fails, description.getDisplayName() might return something like "testExample(ExampleTest)".

    Behavior During Test Execution
    When testFailure method in the FailureJUnit4Test class fails,
    the failed method in FailureWatcher is invoked.
    This failed method then calls takePngScreenshot with the name of the failed test
    (e.g., "testFailure(FailureJUnit4Test)").
    Inside takePngScreenshot, this name is used to create the file path (fileName + ".png"),
    resulting in a screenshot file named something like "testFailure(FailureJUnit4Test).png".
    Summary
    The fileName in takePngScreenshot is determined based on the test that failed.
    It usually contains the name of the test method and the class, which helps in identifying
    which test failure corresponds to which screenshot. This naming convention is particularly useful
    when running multiple tests, as it provides a clear and straightforward way
    to associate each screenshot with its respective failed test.
     */

    /*
    to change the name of screenshot:

    you can change how the screenshot file is named by modifying the FailureWatcher class,
    specifically the argument passed to the takePngScreenshot method within the failed method.

    Original FailureWatcher Implementation
    In the original implementation, the name of the screenshot file is based on the display name of the test:

    failureManager.takePngScreenshot(description.getDisplayName());

    Modifying File Naming
    Let's say you want to include a timestamp in the file name to make each screenshot name unique.
    You can modify the call to takePngScreenshot like this:

    import java.time.format.DateTimeFormatter;
    import java.time.LocalDateTime;

    public class FailureWatcher extends TestWatcher {
        // ... other members ...

        @Override
        protected void failed(Throwable e, Description description) {
            String timestamp = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
            String testName = description.getMethodName(); // Gets only the test method name
            String fileName = testName + "_" + timestamp;

            failureManager.takePngScreenshot(fileName);
        }
    }

    Explanation

    Timestamp Creation:

    LocalDateTime.now() gets the current date and time.
    DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(...) formats the date and time
    into a string like "20231123121530" for November 23, 2023, at 12:15:30.

    File Name Construction:

    description.getMethodName() is used to get only the name of the test method (without the class name).
    The fileName is then a combination of the test method name and the timestamp, separated by an underscore.
    For example, testFailure_20231123121530.
    Calling takePngScreenshot:

    This modified file name is then passed to takePngScreenshot, resulting in screenshot files
    with unique names based on the test method and the exact time of failure.
    Summary
    By modifying the FailureWatcher class, you can customize how the screenshot file names are generated,
    making them more informative or suited to your specific needs, such as adding timestamps for uniqueness.
     */
}
