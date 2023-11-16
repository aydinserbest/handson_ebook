package github.boniGarcia.testng.ch03.locators_compound;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ByAllNGTest {
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
    @Test
    public void testByAll(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        /*
        The ByAll locator strategy in Selenium will search for elements
        that match any of the locators provided as arguments,
        regardless of their order or hierarchy.
        It essentially combines the results from all the individual locator strategies.
         */
        List<WebElement> rowsInForm = driver.findElements(new ByAll(By.tagName("form"), By.className("row")));
        /*
        It finds all elements on the page that are <form> tags.
        It finds all elements on the page that have the class "row".
        It combines the results from steps 1 and 2 into a single list of elements.
        It returns this combined list of elements.
        The important thing to note is that
        ByAll doesn’t care about the hierarchical relationship between the elements,
        it simply finds all elements that match any of the provided locators.
        So if an element matches any one of the locators, it will be included in the result set.
         */
        /*
        When you use ByAll(By.tagName("form"), By.className("row")),
        Selenium will find all elements that are either <form> tags or have the class "row".
         */
        /*
        So, it will return a list of elements that includes all <form> tags on the page
        and
        all elements with the class "row" on the page,
        regardless of their hierarchy or relationship to each other.
         */
        /*
        If you have 2 <form> tags and 3 elements with class "row" on your page
        (regardless of whether these elements are inside a form or not),
        the above line of code would return a list of 5 elements,
         */
        assertThat(rowsInForm.size()).isEqualTo(5);
        /*
        We find five elements, since the locator matches a <form> element plus four <div class="row"> available on the page.

         */

        /*
        ByAll is another locator strategy provided by Selenium
        that is used to find elements that match any of the given locators.
        Unlike ByChained,
        which requires each subsequent locator to find an element inside the result of the previous locator,
        ByAll will find elements that match any of the provided locators.
         */
        /*
        Differences between ByChained and ByAll:
        ByChained: Requires a hierarchical relationship between the locators.
        Each locator finds elements based on the results of the previous locator.
        It's more specific
        and is used when you need to find an element with a specific hierarchy or nested structure.

ByAll: Finds elements that match any of the given locators, regardless of their hierarchy or relationship to each other. It’s more general and is used when you want to find elements that match any of a set of criteria.
         */
    }
}
