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
import java.util.Set;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class ForAndIteratorExplanations {
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
    public void testNewTabWithKeys() {
        String initPage = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(initPage);
        Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;
        String openInNewTab = Keys.chord(modifier, Keys.RETURN);
        driver.findElement(By.linkText("Web form")).sendKeys(openInNewTab);

        Set<String> windowHandles = driver.getWindowHandles();
        assertThat(windowHandles.size()).isEqualTo(2);
        /*
        Inside the loop:
        This condition checks if the current window handle (the one where WebDriver is currently focused)
        is equal to the windowHandle from the Set. If it is, it means we are still in the original tab/window.
         */
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
    /*
    So to sum up, after opening a link in a new tab, this code is confirming that
    there are now two tabs open and then iterates through both tabs to check their URLs,
    making sure that the original tab is still on the initPage and the new tab has navigated to a different page.
    This is a typical check in automated testing to ensure that actions
    like opening a link in a new tab have worked correctly.
     */
    /*
    In Java, the Set collection is an unordered collection type,
    which means you cannot access its elements with an index number (like get[0], get[1], etc.).
    To access elements within a Set, one must use an Iterator or iterate over the elements with a for-each loop.

    If you need one of the window handles from the Set<String> named windowHandles,
    and you know this Set has only two elements,
    assuming the first element is the current window handle (usually the main window),
    you can find the other using the following methods:

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
