package github.boniGarcia.testng.ch04.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.invoke.MethodHandles.lookup;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class ScreenshotPngNGTest {
    static final Logger log = getLogger(lookup().lookupClass());
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();}
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void testScreenshotPng() throws IOException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        /*
        It casts the WebDriver instance to a TakesScreenshot type in order to use the getScreenshotAs method.
        This method is part of the TakesScreenshot interface, which WebDriver does not directly implement.
         */
        /*
        The driver object, which controls the browser, is cast to the TakesScreenshot interface.
        This is necessary because the WebDriver interface alone does not have the capability
        to take screenshots,
        but the underlying driver (such as ChromeDriver or FirefoxDriver) implements TakesScreenshot
        to provide this functionality.
         */
        TakesScreenshot ts = (TakesScreenshot) driver;

        /*
        Save the Screenshot: The getScreenshotAs method captures the screenshot and returns it as a File object.
        This file is temporarily created in the system's default temporary file directory.
         */
        /*
        This line captures the screenshot and stores it as a temporary file on the disk
         */

        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        log.debug("Screenshot created on {}", screenshot);
        /*
        Move the Screenshot: The test then moves the screenshot file from its temporary location
        to a more permanent location with the filename "screenshot.png".
        This is done using the Files.move method, and the REPLACE_EXISTING option
        indicates that if a file with the same name already exists at the destination,
        it should be replaced.
         */
        /*
        The screenshot file is moved from its temporary location to a specified destination
        with the filename screenshot.png.
        If a file with the same name already exists at the destination, it is replaced with the new file.
         */
        /*
         If you provide just the filename without any directory information,
         as in Paths.get("screenshot.png"),
         it implies that the file is located in the default directory of your Java application,
         which is typically the current working directory from where your application was started.
         */
        /*
        When Paths.get() is used with just a filename,
        it's a shorthand for when the file is expected to be in the current directory,
         */

        Path destination = Paths.get("screenshot.png");
        /*
        Example:
        Path path = Paths.get("subdir", "example.txt");
        Path path = Paths.get("/home/user/documents", "example.txt");
        or:
        Path path = Paths.get(System.getProperty("user.home"), "example.txt");
        This will find example.txt in the home directory of the current user, which is system independent.

         */
        /*
        After creating the Path object, the following line:
        uses the Files.move method from the Java NIO package to move the temporary screenshot file
        to the desired destination. The screenshot.toPath() converts the File object screenshot to a Path object.
        This move operation will replace any existing file at the destination path
        with the name "screenshot.png" because of the REPLACE_EXISTING option.
         */
        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
        log.debug("Screenshot moved to {}", destination);
        /*
        Finally, the test asserts that the screenshot file exists at the intended destination
        using assertThat(destination).exists().
        This is a fluent assertion from a library like AssertJ, which provides readable assertion syntax.
         */
        /*
        Finally, an assertion is made to verify that the screenshot file actually exists at the specified destination.
        This is a check to ensure that the screenshot was successfully saved and moved.
         */
        assertThat(destination).exists();
    }
}
