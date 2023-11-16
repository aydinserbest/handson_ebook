package github.boniGarcia.testng.ch03.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ByCssSelectorNGTest {
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
    public void testByCssSelectorBasic(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        //We locate the hidden field in the practice web.
        WebElement hidden = driver.findElement(By.cssSelector("input[type=hidden]"));
        //We verify this element is not visible to the user.
        assertThat(hidden.isDisplayed()).isFalse(); //We check the hidden field is not visible.
    }
    @Test
    public void testByCssSelectorAdvanced(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        //the first selected checkbox on the page.
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]:checked"));
        /*
         :checked is correctly termed as a CSS pseudo-class.
         :checked is a pseudo-class and is used in conjunction with input[type="checkbox"]
         to target all selected checkboxes.
        The :checked pseudo-class targets the state of a form element
        (typically a checkbox or radio button) when it is selected.
        */
        assertThat(checkbox1.getAttribute("id")).isEqualTo("my-check-1");
        /*
        This line is checking that the id attribute of the selected checkbox is equal to "my-check-1".
        It's making sure that you have selected the correct checkbox element.
         */
        assertTrue(checkbox1.isSelected());
        assertThat(checkbox1.isSelected()).isTrue();
        /*
        The first assertion is checking the element's id attribute,
        and the other two are checking the selection state of the checkbox
         */
    }@Test
    public void testCheckedList(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        //all the selected checkbox on the page.
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]:checked"));
        //when we open the page, by default it is checked only 1 checkbox
        //so the assert below will fail
        //assertThat(checkboxes).hasSize(2);
        /*
        hasSize is a method provided by AssertJ, a library for fluent assertions in Java.
        It is used to assert the size of a collection, array, or any other iterable.
         */
        /*
        The hasSize method checks that the checkboxes list has exactly 2 elements.
        If the list has a different number of elements, the assertion will fail, providing a descriptive error message.

        size() is a method provided by the List interface in Java to get the number of elements in the list.
        It does not perform any assertion; it just returns the size.

        So, the key difference is:

        size() is a method of the List interface and returns the size of the list.
        hasSize is an AssertJ assertion method used to assert the size of a collection, array, or iterable.
        You could achieve a similar result using size() with a standard JUnit assertion like this:
         */
        assertEquals(1, checkboxes.size());


        assertThat(checkboxes.get(0).getAttribute("id")).isEqualTo("my-check-1");

        //checkboxes ihas 1 element, so below code will give error:  Index 1 out of bounds for length 1
        //assertThat(checkboxes.get(1).getAttribute("id")).isEqualTo("my-check-2");
    }
    @Test
    public void testNotChecked(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement checkbox2 = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        assertThat(checkbox2.isSelected()).isFalse();
    }
}
