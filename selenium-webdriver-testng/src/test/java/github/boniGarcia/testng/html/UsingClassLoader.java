package github.boniGarcia.testng.html;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class UsingClassLoader {
    WebDriver driver;
    String fileUrl;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }


    private String getFileUrl(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceUrl = classLoader.getResource(fileName);
        if (resourceUrl != null) {
            return resourceUrl.toString();
        } else {
            throw new RuntimeException("File not found: " + fileName);
        }
    }

    @Test
    public void utilizeNearby() {
        driver.get(fileUrl);
        // ... Test codes
    }

    @Test
    public void useavaScript() {
        driver.get(fileUrl);
        // ... Test codes
    }
}
