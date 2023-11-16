package github.boniGarcia.testng.ch03.wait;

public class WaitTimeCheck {
    /*
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement landscape = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));

                    Thread.sleep(Duration.ofSeconds(3).toMillis());
        /*
        you will discover a pause in the teardown method using Thread.sleep().
        this type of wait is usually considered a bad smell
        (i.e., a characteristic in the source code that can lead to undesirable effects).
    /*
        Both Thread.sleep(3000) and Thread.sleep(Duration.ofSeconds(3).toMillis())
        are Java statements that pause the execution of the current thread for 3 seconds.
        However, they differ in terms of code readability and the approach to specifying the duration:

        Thread.sleep(3000):
        This directly tells the thread to sleep for 3000 milliseconds.
        The duration is specified as a literal number, and it's up to the reader
        to recognize that 3000 milliseconds equate to 3 seconds.

        Thread.sleep(Duration.ofSeconds(3).toMillis()):
        This uses the Duration class from the java.time API to express the sleep time.
        Duration.ofSeconds(3) creates a Duration instance representing 3 seconds, and toMillis()
        converts this duration into milliseconds.
        The result is the same—3000 milliseconds—but the code is more readable
        because it explicitly states that the duration is 3 seconds.

        Here are the key differences:

        Readability:
        The Duration API version is more readable, as it specifies the time unit (seconds) explicitly,
        which can make the code easier to understand at a glance.

        Maintainability:
        If you need to change the duration, using the Duration API can make the code easier to maintain,
        especially if the durations are calculated dynamically or configured externally.

        Consistency:
        If your codebase already uses the java.time API for managing time-related operations,
        using Duration for thread sleeping keeps the code consistent.

        Functionally,
        there is no difference between the two statements in terms of what they do:
        they both pause the thread for the same amount of time.
        The choice between them often comes down to coding style, readability,
        and the specific context of the code they are used in.
         */
}
