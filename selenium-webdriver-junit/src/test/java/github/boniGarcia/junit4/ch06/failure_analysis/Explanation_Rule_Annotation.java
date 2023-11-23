package github.boniGarcia.junit4.ch06.failure_analysis;

public class Explanation_Rule_Annotation {
    /*
    the author says:We define the rule at the class level, passing the driver instance as a parameter
    for the line
    :@Rule
    public TestRule testWatcher = new FailureWatcher(driver);
     */
    /*
    The statement you're referring to involves the use of
    JUnit's @Rule annotation,
    which is a way to add behavior to test methods in a test class.
    Let's break it down in the context of your FailureJUnit4Test class.

    Understanding the @Rule Annotation
    Purpose: The @Rule annotation in JUnit is used to modify or add behavior to each test method in a test class.
    It's a way to encapsulate common test logic, such as setting up resources, handling exceptions,
    or performing clean-up tasks, without having to repeat the code in each test method.

    How It Works: When a test method is executed, JUnit checks for any fields annotated with @Rule.
    If such fields are found, JUnit ensures that the behavior defined in these rule objects
    is applied around the execution of each test method.

    The TestRule Interface
    Definition: The TestRule interface in JUnit is what allows you to define custom rules.
    Classes that implement this interface can define specific behavior that is applied to each test method.
    Your Specific Rule: FailureWatcher
    Custom Rule: In your case, FailureWatcher is a custom rule that extends TestWatcher,
    which is a convenient base implementation of TestRule.

    Behavior Defined: The FailureWatcher class is designed to take a screenshot when a test fails.
    This is done by overriding the failed method from TestWatcher. When a test method fails,
    this failed method is automatically called, capturing a screenshot of the current state of the browser.

    The FailureWatcher Rule in Action
    Field Declaration: In your FailureJUnit4Test class, you create an instance of FailureWatcher
    and annotate it with @Rule.

    @Rule
    public TestRule testWatcher = new FailureWatcher(driver);
    Passing the Driver: You pass the WebDriver instance to the FailureWatcher.
    This allows FailureWatcher to interact with the browser and take screenshots upon test failure.

    Expected Behavior: With this setup, whenever a test method in FailureJUnit4Test fails,
    the FailureWatcher rule kicks in, executing its overridden failed method,
    and takes a screenshot of the browser's current state.

    Summary
    The @Rule annotation with FailureWatcher defines a custom behavior that automatically takes a screenshot
    when any test method in the FailureJUnit4Test class fails.
    This setup enhances your test suite by automatically capturing the browser's state at the moment of failure,
    which is invaluable for debugging and understanding why a test failed.
     */
}
