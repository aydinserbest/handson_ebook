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

public class CastingTheory2_Webelement {
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
    /*
    The WebElement interface extends the TakesScreenshot interface.
    This way, it is possible to make partial screenshots of the visible content of a given web element.
    Notice that this test is very similar to the previous one using PNG files,
    but in this case, we invoke the method getScreenshotAs() directly using a web element.

     */

    /*
    In Selenium WebDriver, the ability to take a screenshot is not limited to the entire page;
    you can also take a screenshot of a particular web element.
    This functionality is provided through the TakesScreenshot interface.

    Initially, the WebDriver interface didn't include the ability to take screenshots directly.
    To access this functionality, you would cast the WebDriver instance to the TakesScreenshot interface,
    as shown in your first code snippet:


    TakesScreenshot ts = (TakesScreenshot) driver;
    File screenshot = ts.getScreenshotAs(OutputType.FILE);
    However, as of Selenium 4,
    the WebElement interface has been extended to include the getScreenshotAs method directly.
    This means you can call getScreenshotAs on a WebElement instance without the need for casting,
    as shown in your second code snippet:

    WebElement form = driver.findElement(By.tagName("form"));
    File screenshot = form.getScreenshotAs(OutputType.FILE);

    This improvement simplifies the code and makes it more intuitive to take screenshots of individual elements
    on the page. It's a part of the evolution of the Selenium API to make it more user-friendly
    and to provide richer functionality for browser automation tasks.

    Screenshot of Entire Page:
    When you cast the WebDriver to TakesScreenshot and use the getScreenshotAs method,
    it takes a screenshot of the entire browser window.

    TakesScreenshot ts = (TakesScreenshot) driver;
    File screenshot = ts.getScreenshotAs(OutputType.FILE);

    This captures everything that is currently rendered in the web browser's viewport.

    Screenshot of a Specific WebElement:
    Starting with Selenium 4,
    individual web elements can have screenshots taken of just that element
    using the getScreenshotAs method directly on a WebElement object.

    WebElement element = driver.findElement(By.someLocator());
    File screenshot = element.getScreenshotAs(OutputType.FILE);

    This captures only the specified web element and not the entire page.
    It's useful if you're only interested in a particular section of the webpage,
    such as a form or a navigation menu.

    In both cases,
    the screenshot is saved to a file on the disk.
    The ability to take a screenshot of a specific WebElement allows for more granular control in visual testing,
    letting you focus on particular components of the web page.





     */


}
