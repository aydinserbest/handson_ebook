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

public class DisableElementsDemo {
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

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        WebElement element = driver.findElement(By.cssSelector("#input-example>input"));
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example>button"));

        //  System.out.println(element.isEnabled());

        Assert.assertFalse(element.isEnabled(),"verify is disable");
        enableButton.click();
        Thread.sleep(6000);
        Assert.assertTrue(element.isEnabled(),"verify is enable");

        System.out.println("false");
    }
}
