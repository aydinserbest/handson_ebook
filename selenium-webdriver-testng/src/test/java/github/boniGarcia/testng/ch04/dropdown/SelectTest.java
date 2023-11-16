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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void test1(){
        driver.get(
                "https://demoqa.com/select-menu");
        WebElement colorDropdown = driver.findElement(By.cssSelector("#oldSelectMenu"));
        Select select = new Select(colorDropdown);
        String optionValue = "1";
        select.selectByValue(optionValue);
        assertThat(select.getFirstSelectedOption().getText()).isEqualTo("Blue");

        String optionLabel = "White";
        select.selectByVisibleText(optionLabel);
        assertThat(select.getFirstSelectedOption().getText()).isEqualTo("White");
    }
    @Test
    public void test2(){
        driver.get(
                "https://demoqa.com/select-menu");
        WebElement colorDropdown = driver.findElement(By.cssSelector("#oldSelectMenu"));
        Select select = new Select(colorDropdown);

        List<WebElement> allColors = select.getOptions();
        for (WebElement color : allColors) {
            System.out.println("value of color " + color.getText() + " is: "+color.getAttribute("value"));
        }

        select.selectByVisibleText("Green");
        String actualColor= select.getFirstSelectedOption().getText();
        String expectedColor = "Green";
        assertEquals(actualColor, expectedColor, "verify the color is Green");
    }
}
