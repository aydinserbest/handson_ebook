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

public class RadioButton {
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
    public void test1() {
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();

        //    driver.findElement(By.xpath("(//div[@class='o-chk '])[2]")).click();
        WebElement legume= driver.findElement(By.xpath("//div[text()='Legumes']"));
        WebElement vegetables= driver.findElement(By.xpath("//div[text()='Vegetables']/../div[1]"));

        legume.click();

        System.out.println("legume.isSelected() = " + legume.isSelected());
        System.out.println("vegetables.isSelected() = " + vegetables.isSelected());

    }

    @Test
    public void test2() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        System.out.println("element.isSelected() = " + element.isSelected());

        Assert.assertFalse(element.isSelected());

        WebElement element2 = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        System.out.println("element2.isSelected() = " + element2.isSelected());

        Assert.assertTrue(element2.isSelected());
    }
}
