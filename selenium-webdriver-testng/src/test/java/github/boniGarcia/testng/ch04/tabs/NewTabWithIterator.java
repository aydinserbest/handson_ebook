package github.boniGarcia.testng.ch04.tabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class NewTabWithIterator {
    static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void testWithForLoop() {
        String initPage = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(initPage);
        Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;
        String openInNewTab = Keys.chord(modifier, Keys.RETURN);
        driver.findElement(By.linkText("Web form")).sendKeys(openInNewTab);

        Set<String> windowHandles = driver.getWindowHandles();
        assertThat(windowHandles.size()).isEqualTo(2);

        for (String windowHandle : windowHandles) {
            if (driver.getWindowHandle().equals(windowHandle)) {
                log.debug("Current window handle {}", windowHandle);
                assertThat(driver.getCurrentUrl()).isEqualTo(initPage);
                //If the current window handle does not match the windowHandle from the Set,
                // it means we've found the new tab/window.
            } else {
                log.debug("Switching to window handle {}", windowHandle);
                driver.switchTo().window(windowHandle);
                assertThat(driver.getCurrentUrl()).isNotEqualTo(initPage);
            }
        }
        driver.close();
        assertThat(driver.getWindowHandles().size()).isEqualTo(1);
    }
    @Test
    public void testWithShortFor() {
        String initPage = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(initPage);
        Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;
        String openInNewTab = Keys.chord(modifier, Keys.RETURN);
        driver.findElement(By.linkText("Web form")).sendKeys(openInNewTab);

        Set<String> windowHandles = driver.getWindowHandles();
        assertThat(windowHandles.size()).isEqualTo(2);

        String currentHandle = driver.getWindowHandle();
        String newTabHandle = null;
        for (String handle : windowHandles) {
            if (!handle.equals(currentHandle)) {
                newTabHandle = handle;
                // Exit the loop once we find the handle of the new tab.
                break;
            }
        }
        if (newTabHandle != null) {
            // Switch to the new tab.
            log.debug("Switching to window handle {}", newTabHandle);
            driver.switchTo().window(newTabHandle);
            assertThat(driver.getCurrentUrl()).isNotEqualTo(initPage);
        }
            driver.close();
            assertThat(driver.getWindowHandles().size()).isEqualTo(1);
        }

    @Test
    public void testWithIterator() {
        String initPage = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(initPage);
        Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;
        String openInNewTab = Keys.chord(modifier, Keys.RETURN);
        driver.findElement(By.linkText("Web form")).sendKeys(openInNewTab);

        Set<String> windowHandles = driver.getWindowHandles();
        assertThat(windowHandles.size()).isEqualTo(2);

        Iterator<String> windowIterator = windowHandles.iterator();

        /*
        iterator will return the first element in the collection with the first call to next(),
        at first call-next(), you get the first element,
        when you call it again,
        it will return the second element.
         */
        /*
        The first call to next() will give you one of the window handles,
        but you can't be sure if it's the original window or the new tab without further context.
        so one of the window handles will return but to be sure
        we use if (!setHandle.equals(currentHandle))
        setHandle is first element of the collection,
        we ask whether it is equal to the current window handle.
         */

        String currentHandle = driver.getWindowHandle();
        String setHandle = windowIterator.next();
        String newTabHandle;
        if (!setHandle.equals(currentHandle)) {
            // If the first handle is not the same as the handle of the current window,
            // it is the handle of the new window.
            newTabHandle = setHandle;
        } else {
            // If the first handle is the same as the handle of the current window,
            // the next handle from the iterator is the handle of the new window.
            newTabHandle = windowIterator.next();
        }
        // Switch to the new tab.
        log.debug("Switching to window handle {}", newTabHandle);
        driver.switchTo().window(newTabHandle);
        assertThat(driver.getCurrentUrl()).isNotEqualTo(initPage);
        driver.close();
        assertThat(driver.getWindowHandles().size()).isEqualTo(1);
        /*
        This Java code performs the operation of opening a new tab on a web page within a Selenium WebDriver automation scenario
        and then transferring the control of WebDriver to the newly opened tab. Here is a step-by-step explanation:

    The WebDriver directs the browser to the URL defined as initPage.

    The system determines the appropriate keyboard shortcut modifier based on the operating system
    it is running on (Command for Mac, Control for other systems).

    The Keys.chord() function creates a shortcut that simulates pressing the specified modifier key and the Return key together.

    This shortcut is sent to an element on the page with the link text "Web form," which opens it in a new tab.

    The driver.getWindowHandles() command collects all the current window/tab handles into a Set collection,
    and it checks that the number of elements in this collection is 2, indicating that a new tab has been successfully opened.

    Usage of Iterator and if block:

    While iterating through the handles in the windowHandles collection, an Iterator is used.
    The Iterator is used to retrieve the next elements within the Set.

    The first handle obtained with windowIterator.next() (setHandle) is compared with the handle of the window
    that WebDriver is currently focused on (currentHandle).

    If setHandle is not the same as currentHandle, then it is the handle of the new window
    and is assigned to the newTabHandle variable.

    If setHandle is the same as currentHandle, then the next handle from the iterator is the handle of the new window,
    and it is also assigned to the newTabHandle variable.

    At the end of the code, the driver.switchTo().window(newTabHandle) statement switches WebDriver's focus
    to the new tab, and it verifies that the URL of the new tab is different from the URL of the initial page.

    The if block only runs once, depending on whether the specified condition is met.
    If the if condition (!setHandle.equals(currentHandle)) is true, the code inside the if block runs,
    and it does not enter the else block. If the condition is false, meaning setHandle and currentHandle are the same,
    the else block runs. In this case, a value for newTabHandle is assigned for both conditions,
    and then the switch to the new tab is made using this handle. Any code written after the if or else block,
    outside these blocks, and meant to run in both conditions, will definitely run. However, in the above code snippet,
    there is no common code to run after the if and else blocks. NOTE: Within an if-else block,
    if the if condition (!setHandle.equals(currentHandle)) is true, the code inside the if block runs
    and then the else block is skipped. If the if condition is false, then the if block is skipped,
    and the code inside the else block runs. Only one block runs in both cases;
    either if or else. The code inside both blocks never runs at the same time.
         */
    }


    /*


    With Iterator:

        Iterator<String> windowIterator = windowHandles.iterator();
    String firstHandle = windowIterator.next();
    String secondHandle = windowIterator.next();

    With an advanced for loop:
    String currentHandle = driver.getWindowHandle();
    String otherHandle = null;
    for (String handle : windowHandles) {
        if (!handle.equals(currentHandle)) {
            otherHandle = handle;
            break;
        }
    }


    In the example above, currentHandle is the handle of the current window,
    and otherHandle is used to store the handle of the other window.
    This loop breaks as soon as it finds the first handle that is not the current handle
    and assigns this handle to the otherHandle variable.

    This way, you can cyclically check the elements within the Set
    and easily find the handle for the window other than the current one.
    However, since the order of elements in a Set is not guaranteed,
    if multiple new windows or tabs have been opened, additional checks may be needed to understand
    which handle belongs to which window.


     */
    /*
    The line Set<String> windowHandles = driver.getWindowHandles();
    collects the handles of all open tabs or windows into a Set collection,
    and at this point, WebDriver is still in the first window (or tab).

    Using an Iterator to retrieve handles does not tell you which handle belongs to which window
    because there is no ordered structure. That is, an additional check is needed to determine
    whether the first handle obtained with the iterator.next() method is for the current window.
    Therefore, if you know which window WebDriver is currently in and which window you want to switch to,
    you can do this using Iterator. However, if you do not know which handle is for the newly opened window,
    then a control mechanism is required.

    The way to provide this control is usually to assign WebDriver's current handle to a variable,
    loop through the Set, compare it with the current handle, and find the unmatched handle.
    This is why the use of the advanced for loop is preferred
    because this method allows you to find out which handle belongs to the newly opened window.

    Directly retrieving and using handles with an Iterator is useful if you know which handle belongs to which window.
    However, in general, when working with a newly opened window or tab,
    an additional control mechanism is needed to determine which handle is for the new window,
    and in this case, the advanced for loop is more useful.

    When using an Iterator, an extra step is required to verify which handle belongs to which window.
    Here is an example of how this check can be performed:

    Iterator<String> windowIterator = windowHandles.iterator();
    String originalHandle = driver.getWindowHandle(); // Mevcut pencerenin handle'ı
    String firstHandle = windowIterator.next();

if (!firstHandle.equals(originalHandle)) {
    // If the first handle is not the same as the handle of the current window,
    then it is the handle of the new window.
    String newTabHandle = firstHandle;
} else {
    // If the first handle is the same as the handle of the current window,
    then the handle following the iterator is the handle of the new window.
    String newTabHandle = windowIterator.next();
}


    This code checks if the first handle in the windowHandles set is the handle of the current window.
    If it is not the handle of the current window, it is the handle of the newly opened window.
    If it is the handle of the current window, we move to the next handle with iterator.next(),
    and we consider this to be the handle of the newly opened window.

    The use of the advanced for loop makes this check in a more readable and straightforward manner,
    which is why it is the preferred method in most cases. However, when there are only two windows
    and you know which handle belongs to the current window,
    it is possible to directly retrieve both handles with an Iterator and switch to the relevant window.
     */
}
