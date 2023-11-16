package github.boniGarcia.testng.ch03.mouse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxAndRadioNGTest {
    /*
    Checkboxes and Radio Buttons Examples shows another basic use of the click() method
    for manipulating checkboxes and radio buttons.
    To verify the expected state of these elements after the click action,
    we use an assertion based on the result of the isSelected() method.

     */
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromiumdriver().create();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        // FIXME: pause for manual browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void testCheckboxAndRadio(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement checkbox2 = driver.findElement(By.id("my-check-2"));
        checkbox2.click();

        assertThat(checkbox2.isSelected()).isTrue();

        WebElement radio2 = driver.findElement(By.id("my-radio-2"));
        radio2.click();

        assertThat(radio2.isSelected()).isTrue();
    }
    @Test
    public void testByXPathAdvanced(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        //We use XPath to locate the checked radio buttons.
        WebElement radio1 = driver.findElement(By.xpath("//*[@type='radio' and @checked]"));
        //We check the element id is as expected.
        assertThat(radio1.getAttribute("id")).isEqualTo("my-radio-1");
        //We confirm the selected is checked.
        assertThat(radio1.isSelected()).isTrue();

        WebElement radio2 = driver.findElement(By.xpath("//*[@type='radio' and not(@checked)]"));
        //We check the element id is as expected.
        assertThat(radio2.getAttribute("id")).isEqualTo("my-radio-2");
        //We confirm the selected is unChecked.
        assertThat(radio2.isSelected()).isFalse();
    }
}
