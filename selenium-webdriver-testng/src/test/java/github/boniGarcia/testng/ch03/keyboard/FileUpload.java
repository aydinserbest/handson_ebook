package github.boniGarcia.testng.ch03.keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUpload {
    WebDriver driver;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        // FIXME: pause for manual browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());
        driver.quit();
    }
    @Test
    public void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys("/Users/gebruiker/Desktop/HelloWorld.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualText,"File Uploaded!");
    }
}
