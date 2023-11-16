package github.boniGarcia.testng.ch03.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ByLinkTextNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        //driver = WebDriverManager.chromedriver().create();
        //driver = WebDriverManager.chromedriver().avoidShutdownHook().create();    }
        driver = WebDriverManager.chromedriver().create();    }
    /*
    The WebDriverManager.chromedriver().create(); line
    is actually not standard usage when it comes to initializing WebDriver instances.
    Typically, WebDriver instances are created and managed explicitly within the test code,
    which means that the programmer is responsible for both creating and destroying them,
    usually with driver.quit() in a teardown method.
     */
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        /*
        locate by exact and by partial text occurrence.

         */
        WebElement linkText = driver.findElement(By.linkText("Return to index"));
        assertThat(linkText.getTagName()).isEqualTo("a");
        String cursorStyle = linkText.getCssValue("cursor");
        System.out.println(cursorStyle); // It returns the browser's default cursor style.

        /*
        The line assertThat(linkText.getTagName()).isEqualTo("a");
        is used in Selenium WebDriver to assert that the HTML tag name of a web element is a specific value.

        Explanation of the Line:
        linkText.getTagName(): This method retrieves the tag name of the WebElement referred to as linkText.
        The tag name is returned as a string. For example,
        if linkText represents an anchor element (<a>), this method would return the string "a".

        assertThat(...):
        This function takes the string returned by linkText.getTagName()
        and returns an object that allows you to perform various assertions on it.

        .isEqualTo("a"):
        This method is called on the object returned by assertThat,
        and it checks
        if the string provided as an argument ("a") is equal to the string retrieved from linkText.getTagName().

        What Does This Line Do?
        This line of code is asserting that
        the tag name of the linkText element is "a", which corresponds to an anchor element in HTML.
        If the linkText element is indeed an anchor element,
        the assertion will pass, confirming that the element is of the correct type.
        If the tag name is anything other than "a",
        the assertion will fail, indicating that the element is not the expected type.

        This is useful in automated testing scenarios where you want to ensure that
        a specific web element is of a certain type, helping to validate the structure and semantics of the web page’s HTML.
         */

        WebElement partialLinkText = driver.findElement(By.partialLinkText("index"));
        assertThat(linkText.getLocation()).isEqualTo(partialLinkText.getLocation());

        /*
        The line of code you provided is used to assert that two web elements
        identified by different locator strategies have the same location on a web page.

        Explanation of the Line:
        linkByPartialText.getLocation():
        This method retrieves the location (coordinates) of the WebElement referred to as linkByPartialText.
        It returns a Point object representing the top-left corner of the element's rendering box,
        providing the x and y coordinates.

        linkByText.getLocation():
        Similarly, this method retrieves the location of the WebElement referred to as linkByText.

        assertThat(...):
        This function takes the Point object returned by linkByPartialText.getLocation()
        and returns an object that allows you to perform various assertions on it.

        .isEqualTo(linkByText.getLocation()):
        This method is called on the object returned by assertThat,
        and it checks if the Point object provided as an argument (the location of linkByText) is equal to the Point object retrieved from linkByPartialText.

        What Does This Line Do?
        This line of code is asserting that the location of the linkByPartialText element is
        exactly the same as the location of the linkByText element on the web page.
        If their locations (x and y coordinates) are the same, the assertion will pass,
        meaning that the test confirms they are at the same position.
        If their locations are different, the assertion will fail, indicating a potential issue
        or discrepancy in the layout or positioning of the elements on the page.

        This is useful in automated testing scenarios
         where you want to ensure that certain elements are positioned correctly relative to each other,
         maintaining the integrity of the web page's layout.
         */
        assertThat(linkText.getRect()).isEqualTo(partialLinkText.getRect());

        /*
        The line assertThat(linkByPartialText.getRect()).isEqualTo(linkByText.getRect()); is
        used in web automation with Selenium WebDriver to check
        whether the rectangular regions (including sizes and positions) of two WebElements are equal to each other.

        Parts of This Line:
        linkByPartialText.getRect(): This retrieves the rectangular region of the WebElement named linkByPartialText.
        The region includes the element’s position on the page (x and y coordinates)
        and its size (width and height), and it returns a Rectangle object.

        linkByText.getRect(): This retrieves the rectangular region of the WebElement named linkByText.

        assertThat(...): This takes the Rectangle object returned by linkByPartialText.getRect()
        and returns an object that allows you to perform various assertions on it.

        .isEqualTo(linkByText.getRect()): This is called on the object returned by assertThat,
        and it checks if the Rectangle object provided as an argument
        is equal to the Rectangle object returned by linkByPartialText.getRect().

        What Does This Line Do?
        This line compares the positions and sizes of two WebElements on the page.
        If the rectangular regions (position and size) of linkByPartialText
        and linkByText are exactly the same, the test will pass. If they are different,
        the test will fail and produce an error message.

        This type of assertion is useful for checking
        whether two elements are visually located at the same position
        and have the same size on the page.
        It is particularly used in situations where you want to validate that the layout of the web page is correct.
         */
    }
}
