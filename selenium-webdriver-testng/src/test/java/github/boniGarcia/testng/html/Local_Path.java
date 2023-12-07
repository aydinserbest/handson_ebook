package github.boniGarcia.testng.html;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class Local_Path {
    WebDriver driver;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        //Get the full path of the HTML file
        String localFilePath = Paths.get("/Users/gebruiker/Desktop/table.html").toUri().toString();
        //Load the HTML file with WebDriver
        driver.get(localFilePath);
    }
    @Test
    public void test(){
        //test codes
    }
}
