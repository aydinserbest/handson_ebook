package github.boniGarcia.testng.ch04.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class WebelementScreenshotNGTest {
    static final Logger log = getLogger(MethodHandles.lookup().lookupClass());
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown(){driver.quit();}
    @Test
    public void testWebElementScreenshot() throws IOException {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        //WebElement form = driver.findElement(By.tagName("form"));
        WebElement form = driver.findElement(By.xpath("//input[@id='my-check-1']/ ../ ../ .."));
        File screenshot = form.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("webelement-screenshot2.png");
        Files.move(screenshot.toPath(),destination,REPLACE_EXISTING);
        assertThat(destination).exists();
    }
    /*
    Starting with Selenium 4,
    individual web elements can have screenshots taken of just that element
    using the getScreenshotAs method directly on a WebElement object.

    This captures only the specified web element and not the entire page.

     as of Selenium 4, the WebElement interface has been extended to include the getScreenshotAs method directly.
     This means you can call getScreenshotAs on a WebElement instance without the need for casting
     */
}
