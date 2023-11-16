package github.boniGarcia.testng.ch04.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectDropdown {
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
    public void test1() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");

        WebElement colourDropDown = driver.findElement(By.cssSelector("#oldSelectMenu"));

        Select colour = new Select(colourDropDown);

        List<WebElement> colourList = colour.getOptions();

        for (WebElement option : colourList) {
            System.out.println("option.getText() = " + option.getText());
        }

        //verify that default colour is Red
        String expectedOption = "Red";
        String actualOption = colour.getFirstSelectedOption().getText();
        //  System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption, expectedOption, "verify that default colour is RED");



        //1 using visible text
        Thread.sleep(2000);
        colour.selectByVisibleText("Purple"); //purple a tiklayan line burasi

        expectedOption = "Purple";
        actualOption = colour.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colour is Purple");

        //2 select using index
        Thread.sleep(2000);

        colour.selectByIndex(1);
        expectedOption = "Blue";
        actualOption = colour.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colour is Blue");

        //3 select by value
        colour.selectByValue("8");
        expectedOption = "Indigo";
        actualOption = colour.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption);
    }
}
