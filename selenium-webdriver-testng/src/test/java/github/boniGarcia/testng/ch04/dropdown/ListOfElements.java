package github.boniGarcia.testng.ch04.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ListOfElements {
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
    public void test2() {

        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> menuList = driver.findElements(By.tagName("li"));

        System.out.println("menuList.size() = " + menuList.size());
        int expectedSize= 44;
        int actualSize=menuList.size();
        Assert.assertEquals(actualSize,expectedSize,"verify that size is 44");


        for (WebElement menu : menuList) {
            System.out.println(menu.getText());
        }
        System.out.println("menuList.get(8).getText() = " + menuList.get(8).getText());
    }

    @Test
    public void test1() {
        driver.get("https://demoqa.com/elements");
        List<WebElement> elements = driver.findElements(By.cssSelector(".header-text"));

        int expectedSize =6;

        System.out.println("elements.size() = " + elements.size());
        Assert.assertEquals(elements.size(),expectedSize,"verify that size is 6");

        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }

        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }
}
