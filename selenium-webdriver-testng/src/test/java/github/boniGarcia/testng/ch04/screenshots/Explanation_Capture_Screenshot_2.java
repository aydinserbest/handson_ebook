package github.boniGarcia.testng.ch04.screenshots;

public class Explanation_Capture_Screenshot_2 {
    /*
    Let's break down the FailureManager class to understand how it captures screenshots.
    This class plays a crucial role in the screenshot-taking process when a test fails.

    Overview of FailureManager Class
    The FailureManager class is designed to handle the operation of taking a screenshot.
    It has a constructor that accepts a WebDriver instance and a method takePngScreenshot
    for capturing and saving the screenshot.

    Detailed Explanation of the takePngScreenshot Method
    1. Casting WebDriver to TakesScreenshot:
    TakesScreenshot ts = (TakesScreenshot) driver;
    The WebDriver instance is cast to TakesScreenshot.
    This is necessary because WebDriver itself does not have screenshot capabilities;
    the screenshot functionality is provided by the TakesScreenshot interface.
    Most WebDriver implementations (like ChromeDriver, FirefoxDriver, etc.) also implement TakesScreenshot.
    This cast allows you to use the screenshot methods provided by this interface.
    2. Taking the Screenshot:
    File screenshot = ts.getScreenshotAs(OutputType.FILE);
    This line captures the screenshot. The method getScreenshotAs is defined in the TakesScreenshot interface,
    and it can output the screenshot in different formats. Here, OutputType.FILE is used,
    which means the screenshot is saved as a file on disk.
    3. Defining the Destination Path:
    Path destination = Paths.get(fileName + ".png");
    This line creates a Path object representing where the screenshot file should be saved.
    The filename is derived from the fileName parameter, and .png is appended to make it a PNG file.
    4. Moving the Screenshot File:
    The Files.move(screenshot.toPath(), destination) method is called to move the screenshot
    from its temporary location to the desired destination.
    When a screenshot is captured, it's typically saved to a temporary location.
    This line moves it from there to the specified destination path.
    5. Exception Handling:
    The file-moving operation is enclosed in a try-catch block to handle potential IOExceptions.
    These exceptions can occur for various reasons, such as file permission issues or disk space limitations.
    If an exception occurs, it logs the error using a logger (log.error).
    This is important for debugging purposes if something goes wrong during the file-moving process.
    Summary
    The FailureManager class leverages the TakesScreenshot interface of Selenium WebDriver
    to capture screenshots. By casting the WebDriver to TakesScreenshot,
    it can use the getScreenshotAs method to capture the screen.
    The captured screenshot is initially stored in a temporary location and then moved to a specified path,
    where it's saved as a PNG file.
    Exception handling ensures that any issues during this process are logged for troubleshooting.
     */
    /*
    FailureManager Class Overview
    This class is designed to manage the screenshot-taking process.
    It encapsulates the logic necessary to capture a screenshot of the current state of the web page
    displayed in the WebDriver.

    Class Structure
    Logger: A logger is initialized for logging purposes. This is often used to record errors or important information.
    WebDriver Field: It holds a reference to a WebDriver instance, which is used to interact with a web browser.
    Constructor: The constructor accepts a WebDriver instance and assigns it to the class field.
    takePngScreenshot Method Analysis
    This method takes a screenshot using the provided WebDriver instance.

    1. Method Argument
    String fileName: The name of the file where the screenshot will be saved.
    2. Casting to TakesScreenshot
    Why Casting?: The WebDriver instance is cast to TakesScreenshot.
    This is necessary because WebDriver itself does not have the capability to take screenshots;
    however, most of its implementations (like ChromeDriver, FirefoxDriver, etc.) do.
    By casting, we are telling the compiler,
    "Treat this WebDriver as a TakesScreenshot," which allows us to use the screenshot functionality.
    How It's Done: (TakesScreenshot) driver.
    3. Taking the Screenshot
    Capture: The getScreenshotAs method of TakesScreenshot is used to capture the screenshot.
    The output type OutputType.FILE indicates that the screenshot should be saved as a file.
    File Handling: The method returns a File object, representing the temporary screenshot file.
    4. Saving the Screenshot
    Defining Destination: A Path object is created for the destination file,
    using the provided fileName and adding the ".png" extension.
    Moving File: The screenshot file is moved from its temporary location to the desired destination
    using Files.move. This effectively saves the screenshot to the specified location.
    5. Exception Handling
    Try-Catch Block: The file operation is wrapped in a try-catch block to handle potential IOExceptions.
    Logging: If an IOException occurs, it is logged using the class's logger.
    This is important for debugging and understanding why a screenshot might not have been saved properly.
    Summary
    The FailureManager class is responsible for the actual screenshot capture
    and storage using the WebDriver instance.
    It casts the WebDriver to TakesScreenshot to access the screenshot functionality,
    captures the screenshot, and then saves it to the specified location.
    Exception handling ensures robustness, and logging provides visibility
    into any issues that may arise during this process.
     */
}
