package github.boniGarcia.testng.ch04.javascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    @Test
    public void clickWithJS() {

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.cssSelector("#sp-cc-accept")).click();
        WebElement linkTurkey = driver.findElement(By.linkText("Turkey"));


        //   linkTurkey.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", linkTurkey); //click yapiyor
    }

    @Test
    public void sendKeysWithJS() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text="Hello world!";
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);
    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    @Test
    public void scrollDownAndUp2() throws InterruptedException {

        driver.get("https://www.amazon.co.uk/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }
    }

    @Test
    public void scrollToElement() {
        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement linkTurkey = driver.findElement(By.linkText("Turkey"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", linkTurkey);
        //  jse.executeScript("arguments[0].click();", linkTurkey);
    }
}
