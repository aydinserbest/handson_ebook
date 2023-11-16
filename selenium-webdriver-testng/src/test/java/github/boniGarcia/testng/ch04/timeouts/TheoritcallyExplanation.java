package github.boniGarcia.testng.ch04.timeouts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TheoritcallyExplanation {
    /*
    Timeouts in Selenium WebDriver
    Imagine you have a remote control for a robot.
    This robot is like your web browser,
    and you can tell it to go to different web pages.
    Now, this remote (which in our case is the Selenium WebDriver) has some special buttons
    that tell the robot how long it should try to do something before giving up.
    These are called "timeouts."

    In Selenium WebDriver, you have three kinds of timeouts:

    Implicit Wait:
    This is like telling the robot to keep looking for something on the page for a certain amount of time
    before it decides it's not there.

    Page Loading Timeout:
    This is like setting a timer for the robot to wait for a page to load completely.
    If the page doesn't load in time, the robot stops and tells you it couldn't do it.

    Script Loading Timeout:
    Similar to page loading,
    but this time it's about waiting for a script (a set of instructions or a program) to finish running.
    */

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    /*

    Page Loading Timeout
    Let's say you tell the robot to go to a page, but you only give it 1 millisecond to get there and back.
    That's not enough time, right?
    It's like blinking; you can't even do that so fast!
    So, when the robot can't do it, it gives up and raises its hand (in our case, it throws an exception),
    saying, "I couldn't do it!"

    In the code example you have, we're doing just that.
    We set the page loading timeout to 1 millisecond, which is way too short,
    and then we try to load a page. It's guaranteed to fail, and when it does,
    the code is set up to expect that failure. It's a way to test if the timeout is working correctly.

    */
    /*
    In that example, we're deliberately setting the page loading timeout to an impossibly short time of 1 millisecond. It's like we're giving the robot a test we know it can't pass. Why would we do that? Because we want to make sure that the robot does what it's supposed to do when it can't complete a task in the given time.

    This is a common practice in software testing known
    as a "negative test" or "failure test."
    The purpose is to confirm that the system (in this case, the Selenium WebDriver)
    behaves correctly when it encounters conditions that are bound to fail,
    such as not being able to load a page in 1 millisecond.

    So when the robot (WebDriver) can't load the page in that tiny amount of time,
    it will "throw an exception," which is the robot's way of telling us that it couldn't do what we asked.
    In our test, we're expecting this to happen; we're expecting the robot to fail
    because we've set it up to be impossible. This lets us check that
    the timeout is working properly and that the robot is communicating its failure as it should.

     */
    /*
    The page loading timeout provides a time limit to interrupt a navigation attempt.
    In other words, this timeout limits the time in which a web page is loaded.
    When this timeout (which has a default value of 30 seconds) is exceeded, an exception is thrown.

     */

    @Test
    public void testPageLoadTimeout(){
        /*
        We specify the minimum possible page loading timeout, which is one millisecond.
         */
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));
        //driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS); // Set timeout before navigation

        /*
        We load a web page.
        This invocation (implemented as Java lambda) will fail
        since it is impossible to load that web page in less than one millisecond.
        For this reason, the exception TimeoutException is expected to be thrown in the lambda,
        using the AssertJ method assertThatThrownBy.
         */

        assertThatThrownBy(() -> driver
                .get("https://bonigarcia.dev/selenium-webdriver-java/"))
                .isInstanceOf(TimeoutException.class);
    }
    /*
    In that example, we're deliberately setting the page loading timeout to an impossibly short time of 1 millisecond.
    It's like we're giving the robot a test we know it can't pass.
    Why would we do that? Because we want to make sure that the robot does what it's supposed to do
    when it can't complete a task in the given time.

    This is a common practice in software testing known as
    a "negative test" or "failure test."
    The purpose is to confirm that the system (in this case, the Selenium WebDriver)
    behaves correctly when it encounters conditions that are bound to fail,
    such as not being able to load a page in 1 millisecond.

    So when the robot (WebDriver) can't load the page in that tiny amount of time,
    it will "throw an exception," which is the robot's way of telling us
    that it couldn't do what we asked. In our test, we're expecting this to happen;
    we're expecting the robot to fail because we've set it up to be impossible.
    This lets us check that the timeout is working properly
    and that the robot is communicating its failure as it should.

     */
    /*
    The pageLoadTimeout should be set before you call driver.get("URL")
    because it tells the WebDriver how long to wait for the page load to complete for any subsequent get calls.
    If you set it after driver.get("URL"),
    it won't affect the loading of the page for that specific get call,
    but it will take effect for any page load initiated after the timeout is set.

    Here's how the order should be:

    Set the timeout.
    Navigate to the page with driver.get("URL").
    Here's an example to clarify:

    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS); // Set timeout before navigation
    driver.get("http://example.com"); // Navigate to the page

     */
    /*
    When you comment out the assertion and run your Selenium WebDriver test with a pageLoadTimeout set,
    and you see a TimeoutException in the console like the one you've described,
    it indicates that the page did not finish loading within the specified timeout period.
    The WebDriver threw a TimeoutException as expected when the page load did not complete in time.
     */
    /*
    The ideal time to wait for a page to load is not one-size-fits-all; it depends on several factors,
    including the complexity of the web page, the performance of the server,
    the speed of the network, and the expected user experience.

    However, in the context of automated testing with Selenium, here are some considerations:

    Default Behavior:
    By default, Selenium waits for the load event to be fired, which means it waits
    until the page is completely loaded. This does not usually require an explicit page load timeout
    unless you are dealing with a known slow-loading page or you want to enforce a strict performance requirement.

    Practical Timeout:
    In practice, a common timeout value that many testers use ranges from 10 to 60 seconds.
    This is a reasonable range that accommodates most use cases, from fast-loading pages
    to those that are more resource-intensive.

    Performance Testing:
    If you are conducting performance testing,
    you might set stricter timeouts to ensure pages load within the performance criteria you have established.

    Slow Networks or Servers:
    When you're testing under conditions that simulate slow networks or during peak load times
    when the server might be slower, you might need to extend the timeout
    to avoid false negatives (where the test fails because the page is slow, not because of a functional issue).

    Continuous Integration (CI) Environments:
    In CI environments where tests run automatically,
    you may want to adjust timeouts based on the average load times you observe.
    This can prevent CI jobs from failing due to temporary network or server issues.

    Here's a common way to set the page load timeout in Selenium WebDriver:

    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    In this line,
    30 seconds is used as a balance between not having tests fail unnecessarily
    due to slight variations in page load times and not waiting too long for a page that has issues loading.

    Ultimately, the timeout should be set based on the specific requirements
    and context of the application being tested.
    It's often a good idea to monitor the actual load times and adjust the timeout accordingly
    as you learn more about the performance characteristics of the site under test.

     */


    @Test
    public void testPageLoadTimeout2(){
       // driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS); // Set timeout before navigation


        assertThatThrownBy(() -> driver
                .get("https://bonigarcia.dev/selenium-webdriver-java/"))
                .isInstanceOf(TimeoutException.class);
    }
    /*
    here is a difference between these two lines of code in how they specify the duration
    for the page load timeout in Selenium WebDriver:

    driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));
    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

    Here are the differences explained:

    Duration vs. TimeUnit:
    The first line uses the Duration class to specify the timeout duration,
    which is a part of the java.time package introduced in Java 8.
    It allows you to specify a time duration in a more readable and type-safe manner.
    Duration.ofMillis(1) creates a Duration instance representing a duration of 1 millisecond.

    Milliseconds vs. Seconds:
    The first line specifies the timeout duration in milliseconds (ofMillis(1) sets the timeout to 1 millisecond),
    while the second line specifies the duration in seconds (15, TimeUnit.SECONDS sets the timeout to 15 seconds).
    Milliseconds and seconds are units of time, with 1 second equal to 1000 milliseconds.

    Granularity:
    The Duration class can be more flexible and precise as it allows for nanosecond granularity if needed,
    whereas using TimeUnit with an integer value limits you to whole units of the specified TimeUnit
    (seconds, milliseconds, etc.).

    Readability:
    Some might argue that using Duration can make the code more readable
    because it's immediately clear what time unit is being used (Duration.ofSeconds(15) vs. 15, TimeUnit.SECONDS).
    It's more of a stylistic choice, as both are clear, but Duration aligns with modern Java practices.

    The second line of code is using an older API that has been around before Java 8,
    which uses the TimeUnit enum along with a numeric value to specify the duration.

    In practical terms,
    the most significant difference is the duration you're setting.
    One millisecond is an extremely short amount of time and is typically not practical for a page load timeout,
    as most web pages take much longer than that to load.
    It's likely used in this context to ensure that the timeout is triggered almost immediately for testing purposes.
    On the other hand, 15 seconds is a reasonable amount of time that might be used in a real-world scenario.

    So, while both lines of code set a page load timeout,
    the Duration approach is more modern and may be preferable
    if you're using Java 8 or newer, and the actual durations they're setting are for different purposes
    (a test condition vs. a real-world timeout setting).

     */
    /*
    and also for the second older version, intellij will warn:
    Warning:(199, 36) 'pageLoadTimeout(long, java.util.concurrent.TimeUnit)' is deprecated
    The warning indicates that the pageLoadTimeout(long, java.util.concurrent.TimeUnit) method has been marked as deprecated
    in the version of Selenium WebDriver you're using.
    Deprecated means that the method is still present and functional,
    but its use is discouraged because there's a newer,
    preferred way of doing the same thing, and the deprecated method may be removed in future versions.

    In recent updates to Selenium WebDriver,
    the way to set timeouts has been standardized to use java.time.Duration for specifying time durations.
    This change is part of an effort to modernize the API and make it more consistent with the Java Standard Library,
    particularly with the improvements in date and time handling introduced in Java 8.

    To resolve this warning, you should update your code to use the Duration class, like this:

    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    Here's what's happening in this line of code:

    Duration.ofSeconds(15): This creates a Duration instance representing a duration of 15 seconds.
    pageLoadTimeout(Duration): This is the updated method that takes a Duration instance as its argument.
    This newer method using Duration is not deprecated and is the preferred way
    to set timeouts in the latest versions of Selenium WebDriver.
    It's more flexible and clear, as it allows for durations to be defined in terms of
    days, hours, minutes, seconds, milliseconds, and even nanoseconds, all using the same Duration type.


     */
    @Test
    public void withoutTimeouts(){
        /*
        You can play with this test by removing the timeout declaration
        (i.e., step 1).
        If you do that, the test will fail since an exception is expected but not thrown.
         */
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));

        assertThatThrownBy(() -> driver
                .get("https://bonigarcia.dev/selenium-webdriver-java/"))
                .isInstanceOf(TimeoutException.class);

        /*
        this test will give an error in the console like this:
            java.lang.AssertionError:
            Expecting code to raise a throwable.
         */
    }
    /*
    Let's break down the assertThatThrownBy assertion and explain it in a more straightforward way.

    Understanding assertThatThrownBy
    The assertThatThrownBy is an assertion method provided by AssertJ,
    a library for fluent assertions in Java.
    It's designed to make it easy to assert that a particular piece of code throws an expected exception.

    Here's what the code snippet you provided is doing:

    assertThatThrownBy(() -> driver.get("https://bonigarcia.dev/selenium-webdriver-java/"))
        .isInstanceOf(TimeoutException.class);
    assertThatThrownBy: This is telling the test "I expect the following piece of code to throw an exception."

    () -> driver.get("URL"):
    This part is a lambda expression, which is essentially a small piece of code or a function.
    It's saying "when we navigate to this web page using Selenium WebDriver..."

    .isInstanceOf(TimeoutException.class):
     ... then we're checking to make sure the type of exception thrown is a TimeoutException.
     This is the specific type of exception Selenium throws when something takes too long, like a page load.

    So if we put it all together in plain English:

    "We're checking to ensure that
    when we try to go to this specific web page,
    it will take too long, and as a result,
    Selenium will throw a TimeoutException. We're expecting this to happen,
    and if it does, then the test will pass because it behaved as expected."

    Comparison with assertThat
    The assertThat you might be more familiar with is another AssertJ assertion method
    used for a different kind of check. It's used when you want to assert something about the state of an object
    or a value.

    For example:

    assertThat(someValue).isEqualTo(expectedValue);

    This assertion is saying "I expect someValue to be equal to expectedValue."
    It's a straightforward comparison, not dealing with exceptions.

    The key difference here is that
    assertThatThrownBy is specifically designed for asserting that an exception is thrown,
    while assertThat is used for asserting that a value meets some condition
    (like being equal to another value, being null, being in a list, etc.).

    In summary, assertThatThrownBy is used for exception handling assertions,
    whereas assertThat is used for asserting properties or conditions of values and objects.

     */

      /*

    Script Loading Timeout
    Now, for the script loading timeout,
    think about giving the robot a puzzle that takes at least 5 seconds to solve,
    but you only allow it 3 seconds to work on it.
    That's not fair, and the robot will fail. In the code example,
    we're setting the script loading timeout to 3 seconds and then
    running a script that we know will take 5 seconds.
    This is again a test to see if the robot will correctly stop trying after 3 seconds
    and let us know that it didn't finish the task.

    Both of these examples are negative tests.
    In testing, a "negative test" is when you're trying to make sure the system properly handles situations
    where things go wrong. So, in both cases, we're making sure the robot knows
    how to give up when it doesn't have enough time to do its job.
     */

}
