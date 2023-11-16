package github.boniGarcia.testng.ch04.javascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class InfiniteScrollNGTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    @Test
    public void testInfiniteScroll() {
        /*
        The test begins by instructing the WebDriver
        to load a specific web page designed to test infinite scrolling features.
         */
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
        /*
        This line casts the driver to a JavascriptExecutor,
        which allows you to execute JavaScript code within the context of the current page.
        This is necessary because scrolling is often handled by the browser's JavaScript engine.
         */

        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*
        Here, a WebDriverWait is instantiated, which will be used to wait for certain conditions
        (ExpectedConditions) to be true before proceeding.
        The maximum time to wait is set to 10 seconds.

        A WebDriverWait object is created to efficiently pause the test
        until certain conditions are met. This avoids using static waits
        (e.g., Thread.sleep), which are less efficient and can lead to brittle tests.
         */
        //We define an explicit wait since we need to pause the test until the new content is loaded.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*
        This line creates a locator that will find elements by their tag name,
        specifically <p> tags, which are typically used for paragraphs.

        These tags typically contain the text content of a page
        and are expected to increase in number as the page is scrolled.
         */
        By plocator = By.tagName("p");
        /*
        The code then waits until there is at least one paragraph
        (<p> element) on the page.
        Once the condition is met (at least one paragraph is present),
        it retrieves a list of all paragraph elements found.

        This ensures that the page has loaded enough content for the test to proceed.
         */
        List<WebElement> paragraphs = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(plocator, 0));
        /*
        This line stores the initial number of paragraph elements on the page
        in a variable called initParagraphsNumber.

        The number of paragraphs currently on the page is counted.
        This serves as a baseline for the test to confirm that new paragraphs appear after scrolling.
         */
        int initParagraphsNumber = paragraphs.size();
        System.out.println(initParagraphsNumber);
        /*
        This command finds the last paragraph on the page by using an XPath expression.
        The expression //p[n] locates the nth paragraph,
        where n is the total number of paragraphs initially present on the page.

        The last paragraph currently on the page is located. This will be the element the test scrolls into view,
        triggering the infinite scroll mechanism to load more content.
         */
        WebElement lastParagraph = driver.findElement(By.xpath(String.format("//p[%d]",initParagraphsNumber)));
        /*
        A JavaScript snippet is defined as a string.
        This code will be used to scroll the page
        such that the element provided as an argument is scrolled into the view.

        A JavaScript command is prepared to scroll the last paragraph into view.
        This simulates the user scrolling to the bottom of the page.
         */
        String script = "arguments[0].scrollIntoView()";
        /*
        The previously defined JavaScript code is executed with the last paragraph element as the argument.
        This should cause the browser to scroll down so that the last paragraph is visible,
        which in the context of an infinite scrolling page should trigger the loading of more content.

        The JavaScript command is executed, scrolling the last paragraph into view.
        We scroll down into this element.
         */
        js.executeScript(script,lastParagraph);
        /*
        Finally, the code waits again, this time for the number of paragraph elements
        to be greater than the initial count.
        This would confirm that new content has been loaded as a result of the scroll action.

        After triggering the scroll, the test waits for the number of paragraphs
        to increase beyond the initial count.
        This confirms that new content has been loaded as a result of the scroll.

        We wait until more paragraphs are available on the page.
         */

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(plocator,initParagraphsNumber));
        System.out.println(initParagraphsNumber);
    }
}
        /*
        String script = "arguments[0].scrollIntoView();"
    defines a JavaScript command as a string.
    This command, when executed,
    will scroll the web page until the specified element is in the visible area of the web browser's viewport.
    Here's the breakdown:

    arguments[0]:
    In JavaScript, arguments is an array-like object that contains all the arguments passed to a function.
    arguments[0] refers to the first argument passed to the function.
    In this case, when the script is executed via executeScript, the first (and only) argument
    will be the WebElement that represents the last paragraph on the page.

    .scrollIntoView():
    This is a method available on elements in the DOM (Document Object Model)
    that scrolls the element into the visible area of the browser window.
    It has an optional parameter to align the element to the top or bottom of the window,
    but in its simplest form (as used here), it scrolls the element to the top of the viewport.

    When js.executeScript(script,lastParagraph); is called, the script is executed with lastParagraph
    passed as the first argument.
    So
    arguments[0].scrollIntoView();
    will effectively scroll the lastParagraph element into view.
    This is intended to trigger any lazy-loading mechanisms that may be present on the page,
    which would then load new content as the user appears to scroll down.

         */
        /*
        The two waits in the code serve different purposes
        and are crucial for handling asynchronous behavior on web pages,
        especially when dealing with dynamic content such as infinite scrolling.
        Here's why each wait is necessary:

    First Wait (wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(plocator, 0));):

    Purpose:
    This wait ensures that the web page has loaded its initial content before the test proceeds.
    When a page first loads, especially if it contains dynamic or lazily-loaded content,
    it might not display all its elements immediately.
    This wait makes sure that at least one paragraph (<p>) element is present on the page,
    indicating that the page is ready for interaction.

    Logic:
    The test waits until the condition that there are more than zero paragraph elements on the page is true.
    It ensures that the page has finished the initial loading phase
    and that there is content to interact with.

    Second Wait (wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(plocator, initParagraphsNumber));):

    Purpose:
    After scrolling to the bottom of the page,
    this wait ensures that new content has been loaded as a result of the scroll action.
    Infinite scrolling pages often fetch new content asynchronously when the user reaches the bottom of the page.
    This wait confirms that the expected behavior occurs by waiting for the number of paragraph elements
    to exceed the initial count.
    Logic:
    The test waits for the number of <p> elements to be greater than the count before the scroll.
    This confirms that new paragraphs have been added to the DOM, which would mean
    the infinite scroll is working as expected and new content is being dynamically loaded.
    In both cases, these waits are a better practice than using static sleep times
    because they make the test more robust and faster. They wait exactly as long as necessary
    for the conditions to be met, rather than waiting for a predetermined amount of time
    that may be too long (slowing down the test) or too short
    (not allowing enough time for the condition to become true).
    This dynamic waiting is especially important in an environment
    where network latency or server response times can vary.


         */
