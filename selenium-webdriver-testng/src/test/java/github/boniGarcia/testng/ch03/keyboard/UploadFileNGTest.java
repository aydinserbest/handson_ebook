package github.boniGarcia.testng.ch03.keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class UploadFileNGTest {
    static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @Test
    public void testUploadFile() throws IOException {
        String initUrl = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
        driver.get(initUrl);

        WebElement inputFile = driver.findElement(By.name("my-file"));
        //We create a temporal file using standard Java.
        Path tempFile = Files.createTempFile("tempfiles", ".tmp");
        String filename = tempFile.toAbsolutePath().toString();
        log.debug("Using temporal file {} in file uploading", filename);
        inputFile.sendKeys(filename);

        driver.findElement(By.tagName("form")).submit();
        //We verify that the resulting page (defined in action form attribute) is different from the initial web page.
        assertThat(driver.getCurrentUrl()).isNotEqualTo(initUrl);
    }
    /*
        If you already have a file on your MacBook that you want to use with Selenium WebDriver,
        you don't need to create a temporary file.
        Instead, you would use the File class to create a File object that points to your existing file.
        Then you can use the File object
        to verify the file's existence, get its absolute path, and create a URL to use with driver.get().
     */
    @Test
    public void fromPcAsUrl(){
        String filePath = "/Users/gebruiker/Desktop";
        File file = new File(filePath);
        String fileUrl = "file://"+file.getAbsolutePath();
        driver.get(fileUrl);
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void fromPcToWebPage(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement inputFile = driver.findElement(By.name("my-file"));

        String filePath = "/Users/gebruiker/Desktop/html.html";

        inputFile.sendKeys(filePath);
        driver.findElement(By.tagName("form")).submit();
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void fromPcToWebPage2(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement inputFile = driver.findElement(By.name("my-file"));

        String filePath = "/Users/gebruiker/Desktop/html.html";
        File file = new File(filePath);
        String fileName = file.getAbsolutePath();
        if (file.exists()) {
            inputFile.sendKeys(fileName);

        } else {
            throw new RuntimeException("File not found: " + fileName);
        }
        driver.findElement(By.tagName("form")).submit();
        System.out.println(driver.getCurrentUrl());
    }
    /*
    the last method above, includes a check to ensure that the file exists
    before attempting to send it to the input field.
    This is good practice because it allows your test to fail with a clear error message if the file does not exist,
    rather than failing at a later point with a potentially less clear error.
    In this method, a File object is created with the file path.
    The File object's getAbsolutePath() method is used to ensure that you have a valid, absolute path to the file.
    it checks if the file exists, and it gives you the tools to do so if you choose.
     */
    /*
    The .exists() method is a method of the File class in Java,
    and it can only be called on instances of File.
    It checks if the file or directory denoted by the File object actually exists in the filesystem.

    A String in Java does not have a .exists() method
    because a String is just a sequence of characters
    and does not have filesystem context by itself.
    To check if the path represented by the String refers to a file that exists,
    you need to create a File object with that path and then call .exists() on that File object.
    file.exists() checks if there is a file at the path specified when the File object was created.
    If you try to call .exists() on a String,
    you'll get a compile-time error because the method does not exist for String objects.
     */
}

