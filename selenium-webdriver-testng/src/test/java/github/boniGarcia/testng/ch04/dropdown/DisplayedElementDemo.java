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

public class DisplayedElementDemo {
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
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement helloBtn = driver.findElement(By.xpath("//h4[text()='Hello World!']")); //element burada

        // System.out.println("helloBtn.isDisplayed() = " + helloBtn.isDisplayed());
        Assert.assertFalse(helloBtn.isDisplayed());
        WebElement startBtn = driver.findElement(By.xpath("//*[text()='Start']"));

        startBtn.click();
        Thread.sleep(5000);
        Assert.assertTrue(helloBtn.isDisplayed());
        String actualText = helloBtn.getText();
        String expectedText="Hello World!";

        Assert.assertEquals(actualText,expectedText);
    }
}
