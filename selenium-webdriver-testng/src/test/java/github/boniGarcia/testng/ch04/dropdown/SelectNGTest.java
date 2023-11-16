package github.boniGarcia.testng.ch04.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectNGTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void test() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement dropMenu = driver.findElement(By.name("my-select"));
        /*
        We find the select element by name and use the resulting WebElement to instantiate a Select object.
         */
        Select select = new Select(dropMenu);
        String optionLabel = "Three";
        /*
        We select one of the options available in this select, using a by-text strategy.
         */
        select.selectByVisibleText(optionLabel);

        assertThat(select.getFirstSelectedOption().getText()).isEqualTo(optionLabel);
    }
}
