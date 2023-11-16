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

import static org.assertj.core.api.Assertions.assertThat;

public class ByXpathNGTest {
    WebDriver driver;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
    @Test
    public void testBasic(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        //We locate the hidden field in the practice web.
        WebElement hidden = driver.findElement(By.xpath("//input[@type='hidden']"));
        //We verify this element is not visible to the user.
        assertThat(hidden.isDisplayed()).isFalse();
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
