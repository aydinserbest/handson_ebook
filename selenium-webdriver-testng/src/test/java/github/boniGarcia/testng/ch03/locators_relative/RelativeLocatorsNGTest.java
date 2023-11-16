package github.boniGarcia.testng.ch03.locators_relative;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RelativeLocatorsNGTest {
    WebDriver driver;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    /*The RelativeLocator class in Selenium provides a way
    to locate elements based on their positions relative to other elements,

    The RelativeLocator class is used to determine the position of a specific web element
    in relation to other web elements.
    Introduced with Selenium 4,
    this new feature allows you to check whether a web element is located
    above, below, to the left, or to the right of another web element,
    thereby enabling you to locate elements in this manner.
    It encompasses new locator methods for determining the visual positions of elements on web pages,
    providing an effective way to locate elements.
    For instance, it can be used to check if a certain element is located immediately above another element.

     */
    @Test
    public void testRelativeLocators(){
        //This line navigates to the specified URL using the WebDriver instance driver
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        /*
        You're finding a web element that has the link text "Return to index".
        This line locates an anchor element (<a>) with the link text "Return to index" on the web page
        and stores the WebElement reference in the variable link
        We locate the link whose text is Return to index.

         */
        WebElement link = driver.findElement(By.linkText("Return to index"));

        /*
        Defining the Relative Locator:
        The RelativeBy inner class is used to define the type of relative locator.
        We specify the relative locator type, which will be by tag name the input.
        This line creates a relative locator for elements with the tag name "input".
        The RelativeLocator.with method initializes a RelativeBy instance.
        You're creating a relative locator
        that will be used to locate elements based on their tag name, which in this case is "input".

         */
        RelativeLocator.RelativeBy relativeBy = RelativeLocator.with(By.tagName("input"));
        /*
        Using the Relative Locator:
        We use a relative locator to find a web element (which should be an input filed)
        above the original web element (i.e., a link).
        This line utilizes the above method of the RelativeBy instance to locate an input field
        that is positioned above the previously located link element.
        It stores the found input field element reference in the variable readOnly
        You're using the relative locator to find an input field that is located above the previously located link element.

         */
        WebElement readOnly = driver.findElement(relativeBy.above(link));
        /*
        This line verifies that the name attribute of the located input field element is "my-readonly" using an assertion.
        We verify the element above the reference link is a read-only field
        You're checking to ensure that the located input field is the read-only field by verifying its name attribute value.

         */
        assertThat(readOnly.getAttribute("name")).isEqualTo("my-readonly");

        /*
        -RelativeLocator.RelativeBy relativeBy = RelativeLocator.with(By.tagName("input"));

        This line defines a locator object using RelativeLocator,
        but it does not yet locate a specific element.
        This locator is set to target elements with an input tag,
        but at this point, it has not specified which input element to target.

        WebElement readOnly = driver.findElement(relativeBy.above(link));

        In this line, the relativeBy.above(link) expression is used to locate an input element
        located above the specified link element (i.e., the "Return to index" link).
        The above(link) method modifies the relativeBy locator to target the input element
        located immediately above the link element.

        In other words,
        the relativeBy definition in the second step creates a general locator,
        and this locator is modified to locate an input element at a specific position
        (in this case, above the link element). If you did not use the relativeBy.above(link) expression,
        it would remain unclear which input element you want to locate,
        as there could be multiple input elements on the page.

        In summary,
        by using the relativeBy.above(link) expression with RelativeLocator,
        you can specifically locate the input element located above a certain reference element
        (in this case, the link element). This demonstrates the ability of Selenium WebDriver to locate elements using its relative locating feature.

         */
    }
}
