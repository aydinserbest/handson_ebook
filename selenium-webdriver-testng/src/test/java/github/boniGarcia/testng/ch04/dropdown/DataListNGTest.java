package github.boniGarcia.testng.ch04.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class DataListNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void testDatalist() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement dataList = driver.findElement(By.name("my-datalist"));
        dataList.click();

        WebElement option = driver.findElement(By.xpath("//datalist/option[2]"));
        String optionValue = option.getAttribute("value");
        dataList.sendKeys(optionValue);

        assertThat(optionValue).isEqualTo("New York");
    }
    /*
    <datalist> Elements:
    The <datalist> mentioned by the author provides a suggestion list associated with an <input> element.
    To test a <datalist> element with Selenium, you first need to click on the <input> element
    and then either select a value from the suggestion list or send a value using the sendKeys() method.
    Since the <option>s within a <datalist> are generally not directly visible, they usually can't be selected directly.
    Instead, we send the text that the user enters, which triggers the autocomplete feature.
     */

    /*
    The <datalist> element offers a different usage compared to a classic dropdown menu
    (the <select> element). Here are the key differences:

    User Input Flexibility:

    <select>: Users must choose from the specific <option> tags provided.
    It is not possible for users to enter a value from outside this predefined list.
    <datalist>: Users can select a value from the suggested <option> tags or enter a completely new value.
    This provides users with greater flexibility.

    HTML Structure and Usage:

    <select>: This element provides a fixed list from which the user can make a selection.
    The HTML structure is simple and contains <option> tags within the <select> tag.
    <datalist>: This element is used in conjunction with an <input> field.
    When a user types something into the <input> field, they receive suggestions from matching <option> tags.

    Visual Presentation:

    <select>: Presented to the user as a fixed list, and the user can only make a selection from this list.
    <datalist>: Works like an autocomplete feature, offering suggestions as the user types.
    These features highlight the use of <datalist> elements in situations where improving user experience
    and providing more dynamic user interfaces are desired. For example,
    in a form where a user needs to enter a city name, a <datalist> could suggest popular cities,
    but the user is not limited to these suggestions and can also type in their own entry.

    In Selenium tests, addressing this situation gives the test writer more control
    over the use of <datalist> elements.
    It's possible to simulate users not only selecting recommended values
    but also entering their unique values. However, there is no direct high-level API provided
    for <datalist> like the Select class for <select> elements,
    so lower-level operations are needed when writing the test.
     */

    /*
    //CLICK  <input>  element
driver.findElement(By.id("inputWithDatalist")).click();
// send a value to the <input>  element
driver.findElement(By.id("inputWithDatalist")).sendKeys("New York");

     */
    @Test
    public void dataList2() {
        driver.get(
                "https://demoqa.com/select-menu");
        WebElement dataList = driver.findElement(By.xpath("//div[text()='Select Title']"));
        dataList.click();
        WebElement option = driver.findElement(By.xpath("//div[.='Mrs.']"));
        String choice = option.getText();
        option.click();
        WebElement selectedLabel =driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));
        String resultText = selectedLabel.getText();
        assertThat(resultText).isEqualTo(choice);
    }
}
