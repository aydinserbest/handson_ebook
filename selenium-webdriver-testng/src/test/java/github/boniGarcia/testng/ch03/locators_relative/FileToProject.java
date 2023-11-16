package github.boniGarcia.testng.ch03.locators_relative;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class FileToProject {
    WebDriver driver;
    String fileUrl;

    @BeforeMethod
    public void setupClass(){
        driver = WebDriverManager.chromedriver().create();
        fileUrl = getFileUrl("html.html");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
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
    public void utilizeNearby(){
        /*
        In this HTML, a button with the id of 'hiddenButton' is hidden with the style property of visibility: hidden;
        thus it's not interactable with Selenium.
        However, there's another button with the id of 'showButton' which is clickable,
        and clicking this button makes the 'hiddenButton' visible.
         */
       // driver.get("file:///Users/gebruiker/Desktop/html.html");
        driver.get(fileUrl);
        WebElement showButton = driver.findElement(By.id("showButton"));
        assertThat(showButton.isDisplayed()).isTrue();
        WebElement hiddenButton = driver.findElement(By.id("hiddenButton"));
        assertThat(hiddenButton.isDisplayed()).isFalse();

        //this line gives ElementNotInteractableException: element not interactable error
        //hiddenButton.click();
        /*
        Here are a few suggestions on how to handle this situation with Selenium:
        1- use another button to activate it
        Utilize Nearby Interactable Elements:
         */
        showButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hiddenButton")));
        assertThat(hiddenButton.isDisplayed()).isTrue();
        hiddenButton.click();
        /*
        The WebDriverWait constructor expects an argument of type Duration.
        In Java, to create a value of type Duration, you can use methods of the Duration class
        such as ofSeconds, ofMinutes, ofHours, etc.
        These methods return a Duration object representing a specific span of time.
        You should provide a Duration object to the WebDriverWait constructor.
         */
    }
    @Test
    public void useJavaScript(){
        // 2-Interact Using JavaScript:
        //driver.get("file:///Users/gebruiker/Desktop/html.html");
        driver.get(fileUrl);
        WebElement showButton = driver.findElement(By.id("showButton"));
        WebElement hiddenButton = driver.findElement(By.id("hiddenButton"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('hiddenButton').style.visibility = 'visible';");
        hiddenButton.click();

    }
    //the file inside @AfterMethod:
    /*
     It's interacting with a web page that contains a form with a file upload input.
     Here's what each line of code is doing:

     String initUrl = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";

    This line initializes a String variable initUrl with the URL of the web form you want to test.
    driver.get(initUrl);

    This command tells the WebDriver to navigate to the initUrl.
    This will open the web form in the browser that the WebDriver controls.
    WebElement inputFile = driver.findElement(By.name("my-file"));

    This line finds the file input element within the form by its name attribute ("my-file")
    and assigns it to a WebElement variable called inputFile.
    Path tempFile = Files.createTempFile("tempfiles", ".tmp");

    Here, a temporary file is being created using Java's Files.createTempFile method.
    The first argument ("tempfiles") is a prefix that will be added to the filename,
    and the second argument (.tmp) is the suffix or file extension.
    This temporary file is created in the default temporary-file directory.
    String filename = tempFile.toAbsolutePath().toString();

    This line converts the Path object tempFile to an absolute path
    (meaning the complete path from the root of the filesystem)
    and then converts that path to a String. This is the full path of the temporary file
    that was created in the previous step.
    log.debug("Using temporal file {} in file uploading", filename);

    inputFile.sendKeys(filename);

    This final line uses the sendKeys method on the inputFile WebElement to simulate typing the filename
    into the file input field. This is equivalent to a user clicking the file input field and selecting the filename to be uploaded. Since inputFile refers to a file upload input, sendKeys will result in the file at filename being prepared for upload when the form is submitted.
    This code snippet sets up a file upload in a web form using Selenium WebDriver
    by creating a temporary file and then sending its path to the file input element on the web page.
     */
    /*
    If you've created an HTML file and you want to open it in your browser using Selenium WebDriver,
    you'll need to convert the file path to a URL using the file:// scheme.
    You cannot directly pass a file system path to driver.get(); it has to be a properly formatted URL.
    It's important to ensure that you're using the correct format.
    The driver.get() method expects a string that is a valid URL,
    so simply passing the file path will not work.
    You must prepend file:// to the beginning of the absolute path to the file
    to convert it into a URL that the browser can understand and open,
    When opening a local HTML file with Selenium WebDriver,
    you must prepend file:// to the absolute path of the file to form a valid file URL.
    Here's an example of how it should look:
    // The absolute path to the HTML file on your desktop

    String filePath = "/Users/yourusername/Desktop/example.html";

    // Create a file URL by prepending "file://"
    String fileUrl = "file://" + filePath;

    // Now use driver.get() with the file URL to open the local HTML file in the browser
    driver.get(fileUrl);

     */
    /*
    Here, you're calling the getFileUrl method and passing the filename of your local HTML file.
    This method will check if the file exists and return its absolute path as a file:// URL.
    private String getFileUrl(String fileName) {
    File file = new File(fileName);
    if (file.exists()) {
        return "file://" + file.getAbsolutePath();
    } else {
        throw new RuntimeException("File not found: " + fileName);
    }
}
        The getFileUrl method constructs a file URL from the filename.
        It uses File to check if the file exists and then gets the absolute path to convert it into a file URL.
        driver.get(fileUrl);

        In the test method, you're using driver.get() with the fileUrl to open the local HTML file in the browser.
     */

    /*
    file.getAbsolutePath() will return the full absolute path to the file as a String.
    When you prepend "file://" to this path, you're creating a file URI that can be used by browsers
    and other tools that handle URIs to locate the file on the local filesystem.

    So, when you do this:
    File file = new File("/Users/yourusername/Desktop/HelloWorld.html");
    String newUrl = "file://" + file.getAbsolutePath();
    file.getAbsolutePath() will return "/Users/yourusername/Desktop/HelloWorld.html" if the file exists at that location,
    and after you prepend "file://" to it, newUrl will become:
    "file:///Users/yourusername/Desktop/HelloWorld.html"
    This is equivalent to manually concatenating "file://" with the file path.
    It's a full file URI that points to HelloWorld.html on your desktop,
    which you can use with driver.get() to open the file in a browser with Selenium.
    Using File file = new File("/path/to/file"); followed by "file://" + file.getAbsolutePath();
    is a common practice when the file path might vary depending on the environment in which the code is running,
    or when you want to ensure that the file actually exists before trying to use its path.
    It can also be part of a larger, more dynamic system where file paths might be constructed or discovered at runtime.

    Here are a few reasons you might choose to use the File object instead of hardcoding the path:

    Validation:
    Using File allows you to check if the file exists before trying to use it,
    preventing errors if the file is missing.

    Platform Independence:
    The File class handles differences in path separators between operating systems
    (\ for Windows, / for Unix-based systems). When you provide a hardcoded string,
    you need to ensure it's appropriate for the OS.

    Readability and Maintenance:
    It may be clearer to someone reading the code that a file on the filesystem is being referenced,
    and it can be easier to maintain if the path needs to be constructed dynamically or changed.

    Flexibility:
    Using File objects makes it easier to modify the file path programmatically,
    for instance, if the filename is determined at runtime,
    or if it's stored in a configuration file or environment variable.

    Directory Handling:
    File provides methods for working with directories,
    such as listing files, that could be useful if the file path isn't known in advance.

    However, if you are certain of the file path,
    it does not change, and the environment is controlled
    (e.g., you know the code will only run on a Mac),
     then hardcoding the path as a string can be simpler and more direct:

    String fileUrl = "file:///Users/yourusername/Desktop/HelloWorld.html";
    driver.get(fileUrl);
    This approach is perfectly acceptable for quick scripts
    or when the flexibility provided by the File class is not needed.


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
