package github.boniGarcia.testng.html;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Get_Directly {
    WebDriver driver;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }
    @Test
    public void withoutToString(){
        //Get the full path of the HTML file
        //Load the HTML file with WebDriver
        driver.get("/Users/gebruiker/Desktop/table.html");
    }
}
