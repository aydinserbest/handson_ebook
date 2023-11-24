package github.boniGarcia.testng.ch06.retry;

public class Explanations {
    /*
    Step-by-Step Process
    First Test Execution

    The @Test method (testRandomCalculator) is executed for the first time.
    Let's assume the test fails during this initial run.
    Invoking the Retry Logic

    Upon failure, TestNG checks if the test method is associated with a retry analyzer
    (in this case, RetryAnalyzer.class is specified in the @Test annotation).
    TestNG then invokes the retry(ITestResult result) method of the RetryAnalyzer class.
    Inside the Retry Method (First Call)

    Initially, retryCount is 0 (as it's the first time the test is being executed).
    The retry method checks if retryCount <= MAX_RETRIES. Since retryCount is 0 and MAX_RETRIES is 5,
    the condition is true.
    retryCount is incremented, changing from 0 to 1.
    The retry method returns true, indicating that the test should be retried.
    Second Test Execution

    TestNG sees that the retry method returned true, so it reruns the @Test method (testRandomCalculator).
    Let's assume the test fails again on this second attempt.
    Inside the Retry Method (Second Call)

    Now, retryCount is 1.
    Again, the retry method checks if retryCount <= MAX_RETRIES. Since retryCount is 1
    and MAX_RETRIES is 5, the condition is still true.
    retryCount is incremented again, now becoming 2.
    The method returns true once more, signaling another retry.
    Continuation of the Process
    This process continues until one of two things happens:

    The Test Passes: If the test passes on any retry, the retry process stops, and the test is marked as passed.
    Maximum Retries Reached: If the test continues to fail
    and retryCount exceeds MAX_RETRIES (becomes greater than 5 in this case),
    the retry method will return false, indicating no further retries.
    The test will then be marked as failed.
    Summary
    The connection between the @Test method and the retry method
    is governed by the retryAnalyzer attribute in the @Test annotation.
    Each time the test fails, the retry method is called.
    It decides whether to retry the test based on the number of attempts already made.
    The retryCount keeps track of how many times the test has been retried.
    It starts at 0 and is incremented each time the test is retried.
    The test is re-executed immediately if the retry method returns true.
    This cycle continues until the test passes or the maximum number of retries is reached.
     */
}
