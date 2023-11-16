package github.boniGarcia.testng.ch03.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ByHtmlAttributesNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testByName(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        //By name
        WebElement textByName = driver.findElement(By.name("my-text"));
        // assertTrue(textByName.isEnabled());
        // or
        assertThat(textByName.isEnabled()).isTrue();

        /*
        using isTrue() is necessary in this context.
        The isEnabled() method checks if a WebElement is enabled or not, returning a boolean value.
        It returns true if the element is enabled, and false otherwise.

        The assertThat method
        takes a value and returns an object that allows you to perform various assertions on it.
        However, even if assertThat receives a boolean value directly,
        it doesn’t perform any check by itself.
        In other words, the expression assertThat(textByName.isEnabled()) by itself
        doesn’t have a meaning and doesn’t perform any check.

        That’s why you need to use the isTrue() method
        to explicitly check the boolean value returned by isEnabled() on the object returned by assertThat.
        This way, you explicitly assert that the value returned by isEnabled() should be true.
         */
    }
    @Test
    public void testByID(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement textById = driver.findElement(By.id("my-text-id"));
        //we check the element type is expected
        assertThat(textById.getAttribute("type")).isEqualTo("text");
        assertThat(textById.getDomAttribute("type")).isEqualTo("text");
        assertThat(textById.getDomProperty("type")).isEqualTo("text");


        /*
        These three assertions are indeed checking different aspects of the WebElement,
        and while they might appear to be doing the same thing, there are subtle differences between them.

        getAttribute("type"):
        This method gets the attribute value of the HTML element directly.
        It retrieves the value of the attribute from the HTML source code.
        For example, if you have <input type="text">, this method will return "text".
        However, it’s worth noting that getAttribute can also
        retrieve the value of some properties that are automatically reflected as attributes.

        getDomAttribute("type"):
        This method is more specific.
        It gets the value of the attribute directly from the DOM.
        It doesn’t retrieve properties that are calculated by the browser.
        So, if the attribute value is explicitly set in the HTML or through JavaScript,
        this method will return that value. If the attribute is not present, it will return null.

        getDomProperty("type"):
        This method gets the property value of the HTML element from the DOM.
        In HTML, attributes and properties can be different.
        Attributes are the values set in the HTML source code,
        whereas properties are the values that are in the DOM,
        which can be changed with JavaScript. This method will return the current property value, not the attribute value.
         */

        //you can use System.out.println() to print the values returned by these methods to the console.
        // This is an effective way to see what each method returns.

        System.out.println("getAttribute: " + textById.getAttribute("type"));  // Expected to return "text"
        System.out.println("getDomAttribute: " + textById.getDomAttribute("type"));  // Expected to return "text"
        System.out.println("getDomProperty: " + textById.getDomProperty("type"));  // Expected to return "text"

            /*
        This piece of code will print the values returned by each method to the console.
        In this example, all three methods are expected to return "text"
        because the type is both an HTML attribute and a DOM property, and it is directly set in the HTML.

        However,
        if a property is dynamically changed by JavaScript,
        or if an attribute is only present in the DOM, these methods might return different values.
         */
        assertThat(textById.getAttribute("myprop")).isEqualTo("myvalue");
        assertThat(textById.getDomAttribute("myprop")).isEqualTo("myvalue");
        assertThat(textById.getDomProperty("myprop")).isNull();

        assertThat(textById.getAttribute("myprop")).isEqualTo("myvalue");
        assertThat(textById.getDomAttribute("myprop")).isEqualTo("myvalue");
        assertThat(textById.getDomProperty("myprop")).isNull();
    }
    @Test
    public void asserttWithMessage(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement textById = driver.findElement(By.id("my-text-id"));
//        assertThat(textById.getAttribute("type"))
//                .withFailMessage("The 'type' attribute of the element with ID '%s' should be 'text'", textById.getAttribute("id"))
//                .isEqualTo("text1");


        /*
        when you use withFailMessage with assertThat,
        it completely overrides the default error message generated when the assertion fails.
        This can be useful when you want to provide a custom error message,
        but it also means you lose the provided "expected" and "actual" value information
        that is normally included in the error message.

        If you want to see both your custom error message and
        the "expected" and "actual" value information,
        you can use the describedAs method instead.
        This method allows you to add additional information to the error message
        while still retaining the "expected" and "actual" value information.
         */
        assertThat(textById.getAttribute("type"))
                .describedAs("The 'type' attribute of the element with ID '%s' should be 'text'", textById.getAttribute("id"))
                .isEqualTo("text1");
    }
    @Test
    public void testByClassName(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        List<WebElement> byClassName = driver.findElements(By.className("form-control"));
        assertThat(byClassName.size()).isPositive();
        //we check the element name is expected
        assertThat(byClassName.get(0).getAttribute("name")).isEqualTo("my-text");
    }
}
