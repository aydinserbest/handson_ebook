package github.boniGarcia.testng.ch03.wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class ExplicitWaitNGTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    /*
    a test using an explicit wait.
    In the example, we use the presenceofElementLocated condition to wait
    until one of the images is available on the practice web page.
     */

    /*
    In the case of the example website,
    the images are loaded onto the page dynamically,
    perhaps with a delay to simulate slow network conditions or a heavy server load.
    This is a common scenario for modern web applications where elements are not always present immediately upon page load
    due to various reasons like animations, AJAX calls, or, in this case, deliberate delays.
     */

    @Test
    public void testExplicitWait() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement landscape = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        assertThat(landscape.getAttribute("src")).containsIgnoringCase("landscape");
    }
    /*
    We create the wait instance. In this case, the selected timeout is 10 seconds.

    We explicitly wait for a given condition
    (in this case, the presence of a given element)
    by invoking the until() method in the WebDriverWait object.
    To achieve a more readable statement,
    you can also statically import this expected condition (presenceOfElementLocated).
    In this example, I decided to keep the class name (ExpectedConditions) in these conditions
    to ease the autocomplete feature in IDEs as described before.

     */
    /*
    In summary,
    the explicit wait is set up to wait for the specific element of the third image to be present in the DOM.
    The presence of other images in the DOM
    and their visual loading state do not impact the wait condition for the third image.
    Once the third image's <img> tag is present in the DOM,
    the explicit wait is satisfied, and the test can assert on the src attribute of that image element.
     */
    /*
    When you navigate to a page with Selenium,
    the WebDriver will start interacting with the page as soon as it's loaded.
    However, "loaded" in this context means that the HTML document has been received and parsed by the browser,
    not necessarily that all resources (like images, CSS, or JavaScript) have been downloaded and rendered.
    This is an important distinction in web development between the DOMContentLoaded event,
    which fires when the HTML is fully parsed, and the load event, which fires when all resources have finished loading.

    In the case of the example website,
    the images are loaded onto the page dynamically,
    perhaps with a delay to simulate slow network conditions
    or a heavy server load. This is a common scenario for modern web applications
    where elements are not always present immediately upon page load due to various reasons
    like animations, AJAX calls, or, in this case, deliberate delays.
     */
    /*
    Now, when the Selenium test navigates to the page, it doesn't have to wait for all images to be loaded
    to start interacting with the DOM. The HTML structure of the page, including the img tags for the images,
    is already present.
    The src attribute of these img tags may be populated at a later time,
    but as far as the DOM is concerned, the elements are there.

    So here's what happens when the test runs:

    WebDriver navigates to the page and waits until the HTML document is loaded (the DOM is ready).
    Once the DOM is ready,
    WebDriver doesn't concern itself with whether the images have finished loading;
    it only cares about the presence of elements in the DOM.
    The WebDriverWait with the presenceOfElementLocated condition is then used.
    This condition waits for the specified element to be present in the DOM,
    not necessarily visible or displayed.
    Since the image elements are likely injected into the DOM immediately
    (but just hidden or without the src set until they load),
    the presenceOfElementLocated condition can find the third image element right away
    because the img tag exists in the DOM.
    The previous images do not affect the wait for the third image
    because Selenium's wait conditions are only looking for the specific element(s) you tell it to,
    in this case, the element with the ID of "landscape".
    As long as that element is present in the DOM,
    the wait condition will succeed regardless of the state of other elements on the page.
    The test script doesn't have to wait for the first and second images
    to load if the wait condition is solely for the third image's presence.
     */
    /*
    In the given scenario where a website has multiple images loading at different times,
    the WebDriverWait with ExpectedConditions.presenceOfElementLocated works well
    to wait for a specific element to appear in the DOM before proceeding.
    Here's why the test successfully waits for the third image and does not get confused by the previous two images:

        DOM Structure:
        When a web page is loaded, the browser creates a Document Object Model (DOM) of the page,
        which is a tree-like structure representing all the elements of the page.
        Even if the images are not yet visible or fully loaded, their corresponding <img> tags might already be present in the DOM.

        How presenceOfElementLocated Works:
        The presenceOfElementLocated condition checks if the specified element is present in the DOM.
        It does not check if the element is visible or if its contents are fully loaded.
        In the test, the third image has a unique identifier (e.g., By.id("landscape")).
        The wait condition checks for the presence of this specific element by its ID.

        Sequential Loading:
        Even if images are loading slowly, they typically appear in the DOM in the order they are defined in the HTML.
        The WebDriverWait in this case is specifically waiting for the third image's DOM element to be present,
        irrespective of the loading state of the other images.

        WebDriver Behavior:
        WebDriver operates on the DOM state and not on the visual representation of the page.
        So as long as the third image element is in the DOM (which it would be immediately upon page load,
        even if the actual image file hasn't been loaded), WebDriver can interact with it.

        Image Loading:
        Images on a webpage are loaded asynchronously,
        meaning that other operations on the page don't necessarily wait for the images to be fully loaded.
        This also means that the JavaScript and WebDriver commands can execute as soon as the elements are present in the DOM,
        regardless of whether the image files have finished loading.
     */
}
