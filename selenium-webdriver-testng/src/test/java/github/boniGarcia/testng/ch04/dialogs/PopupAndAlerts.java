package github.boniGarcia.testng.ch04.dialogs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PopupAndAlerts {
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
    public void popUp() throws InterruptedException {

        driver.get("https://www.primefaces.org/primeng/#/confirmpopup");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[text()='Confirm'])[1]")).click();
        driver.findElement(By.xpath("//span[text()='Yes']")).click();
    }

    @Test
    public void jSalert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        Thread.sleep(2000);
        alert.dismiss();

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        alert.sendKeys("Eurotech");
        alert.accept();
    }
}
