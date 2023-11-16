package github.boniGarcia.testng.ch04.dialogs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TaskAlert {
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
    public void testAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.cssSelector("#alertButton")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();
    }

    @Test
    public void testAlert2() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.cssSelector("#confirmButton")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        driver.findElement(By.id("promtButton")).click();
        System.out.println("alert.getText() = " + alert.getText());
        alert.sendKeys("Hello World!");
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");
        driver.findElement(By.xpath("(//div[text()='Papaya'])[1]")).click();
        driver.findElement(By.xpath("(//*[text()='Legumes'])[3]")).click();
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("(//*[text()='Onion']//..)[9]//../li"));
        System.out.println("elements.size() = " + elements.size());

        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }
    }
}
