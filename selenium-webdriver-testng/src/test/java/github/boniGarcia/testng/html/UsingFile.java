package github.boniGarcia.testng.html;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class UsingFile {
    WebDriver driver;
    String fileUrl;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        getFileUrl("yourFileName.html"); // Replace with your actual file name
    }

    private String getFileUrl(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            return "file://" + file.getAbsolutePath();
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
