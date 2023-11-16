package github.boniGarcia.testng.ch04.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.assertj.core.api.Assertions.assertThat;

public class ScreenshotExplanations {
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
        TakesScreenshot ts = (TakesScreenshot) driver;
         /*
        We make the browser screen a PNG file.
     */

        /*
        The getScreenshotAs method captures the screenshot and returns it as a File object.
        This file is temporarily created in the system's default temporary file directory.
         */
        /*
        This line captures the screenshot and stores it as a temporary file on the disk
         */
        /*
         line captures the screenshot and saves it as a file.
         This file is stored in a temporary location managed by the Selenium WebDriver.
         */

        File screenshot = ts.getScreenshotAs(OutputType.FILE);

        /*
        The test then moves the screenshot file from its temporary location
        to a more permanent location with the filename "screenshot.png".
         */
       /*
       the destination is a Path object that represents the new location (in the root project folder)
       (and potentially the new name) of the screenshot file after it's moved. It is defined earlier in the code as:
        */
        /*
        line creates a Path object that represents
            -the path and
            -filename where you want to save the screenshot permanently.
        The name of the file will be "screenshot.png",
        and since no directory path is specified, it implies that
        the file will be saved in the root directory of your project (the current working directory).
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
        /*
         line moves the temporary file to the new location defined by the destination Path.
         It also renames the file to "screenshot.png" in the process.
         */
        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
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
    /*
    The destination object is a Path representation of where we want our screenshot to be stored.
    The name we've chosen for this location is "screenshot.png".
     */
    /*
    When we move our File object (the screenshot) to this destination,
    the File object doesn't exactly "become" a Path object.
    Instead,
    the file that the File object points to
    is
     moved to the location
     that the destination Path object points to.
     */
    /*
    After the move operation,
    the actual file on the disk that was temporarily represented by the File object is now
    permanently stored at the location specified by the destination Path, with the name "screenshot.png".
    The File object itself doesn't change; it's the file on the disk that's moved and renamed.
     */
    /*
    the File object (the screenshot) is being moved to a new "home" (the destination),
    and in the process, it's getting a new "name tag" (the file name "screenshot.png")
    that reflects its new location in the root directory of the project.
     */
    /*
    The screenshot file is being moved to the location specified by the destination Path object,
    and during this move operation, it is being renamed to "screenshot.png".
    Here's the breakdown:

    1-The File object named screenshot represents the actual screenshot file stored temporarily on the file system.
            -File screenshot = ts.getScreenshotAs(OutputType.FILE);-
    2-The Path object named destination represents the target location and
    filename ("screenshot.png") where we want to store the screenshot permanently.
            -Path destination = Paths.get("screenshot.png");-

    3-The Files.move() method is used to move the file from its temporary location
    to the target location (destination),
    and in doing so, it also renames the file to match the name specified in the destination Path object.
        -Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);-

       There will be a file named "screenshot.png" in the root directory of your project,
       which is the screenshot that was originally captured and stored in the screenshot File object
     */
    /*
    Let's clarify the concept of objects and what's happening during the file move operation.

    In Java, a File object is an abstract representation of file and directory pathnames.
    It doesn't contain the file data itself; rather, it points to where the data is located on the file system.
    Similarly, a Path object is another representation of file
    and directory pathnames but is part of the newer Java NIO API, which provides more flexible file I/O operations.

    When the line of code:

    File screenshot = ts.getScreenshotAs(OutputType.FILE);
    executes, it creates a File object named screenshot that points to the actual screenshot file on the disk.
    The screenshot data is stored in a temporary location on the file system.

    Next, when you create a Path object like this:

    Path destination = Paths.get("screenshot.png");
    you're creating a new object that represents a path within the file system.
    This path is where you want to store the screenshot file, and you've named it "screenshot.png".
    At this point, you have two objects:

    screenshot: A File object pointing to the temporary file.
    destination: A Path object representing the desired final location and filename.
    Now, during the move operation:

    Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
    the Files.move() method is instructed to take the file on the disk that screenshot points to
    and move it to the location that destination points to. In doing so, the method also renames the file
    to "screenshot.png", as specified by destination.

    The screenshot File object is just a Java object that remains in memory and doesn't change during this process.
    What changes is the actual file on the disk. After the move operation, the file data that was
    at the temporary location is now at the new location with the new name.
    The screenshot File object still exists, but it's now pointing to a file location that has been moved,
    so the original file it pointed to doesn't exist anymore at that location.
     */
}
