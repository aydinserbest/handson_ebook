package github.boniGarcia.testng.ch03.locators_compound;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ByIdOrNameNGTest {
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
    public void testByIdOrName(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        /*
        Here, we are using the ByIdOrName class
        to find the element with either an id or name attribute value of "my-file".
        In this case, the element does not have an id property, but its name property is "my-file".
         */
        WebElement fileElement = driver.findElement(new ByIdOrName("my-file"));
        /*
        Next, we perform some checks using the AssertJ library:
        This line checks if the id property is blank. Since the element does not have an id property,
        this assertion will pass.
        Even when the id attribute is not explicitly defined in the HTML,
        you can still use the isBlank() method for validation.
        The getAttribute("id") method will return null if the id attribute is not present on the HTML element.
        The isBlank() method from AssertJ is capable of handling this scenario,
        as it checks if a string is null, empty (""), or consists solely of whitespace characters.
         */
        assertThat(fileElement.getAttribute("id")).isBlank();

        //This line checks if the name property is not blank.
        // In this case, since the name property is "my-file", this assertion will pass.
        //We check the element has the attribute name.
        //We verify the absence of the attribute name in the same element.
        assertThat(fileElement.getAttribute("name")).isNotBlank();

        /*
        The isBlank() method checks if a string is null, empty, or only consists of whitespace characters.
        On the contrary, isNotBlank() checks that a string is not blank.
         */
    }
}
