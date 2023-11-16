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

public class NoSelectDropdown {
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
    public void testName() {

        driver.get("https://demo.aspnetawesome.com/");
        driver.findElement(By.xpath("(//div[text()='Papaya'])[1]")).click();

        List<WebElement> papaya = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[10]/li"));
        System.out.println("papaya.size() = " + papaya.size());


        for (WebElement webElement : papaya) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }

        System.out.println(papaya.get(1).getText());
        papaya.get(1).click();

        System.out.println("papaya.get(4).isDisplayed() = " + papaya.get(4).isDisplayed());

        List<WebElement> legumes = driver.findElements(By.xpath("(//*[text()='Tomato'])[3]/../../li"));
        System.out.println("legumes.size() = " + legumes.size());
    }
}
