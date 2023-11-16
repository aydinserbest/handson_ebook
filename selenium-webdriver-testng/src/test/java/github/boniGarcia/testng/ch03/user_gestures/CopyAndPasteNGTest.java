package github.boniGarcia.testng.ch03.user_gestures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class CopyAndPasteNGTest {
    WebDriver driver;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    //This last example for user gestures automates a pervasive user action: copy and paste using the keyboard.
    //This Selenium WebDriver test performs actions on a web form to demonstrate how to use keyboard shortcuts
    // for copying and pasting text between form fields.
    @Test
    public void testCopyAndPaste() {
        //Navigate to the Web Form:
        //The driver.get() method navigates to the URL hosting the web form that will be interacted with.
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        /*
        Initialize Actions:
        An Actions object is created. This object is used to queue complex actions like key presses and mouse movements.
         */
        Actions actions = new Actions(driver);
        /*
        Locate Form Elements:
        The inputText WebElement is located by its name attribute "my-text", representing a text input field.
        The textarea WebElement is also located by its name attribute "my-textarea",
        representing a larger area where text can be entered.
         */

        WebElement inputText = driver.findElement(By.name("my-text"));
        WebElement textarea = driver.findElement(By.name("my-textarea"));
        /*
        Determine Modifier Key:
        The modifier key is determined based on the operating system.
        For Mac OS, it uses the COMMAND key, while for other operating systems, it uses the CONTROL key.
        This is because keyboard shortcuts like copy and paste use different modifier keys depending on the OS.
         */
        /*
        We use a modifier key for sending the combination Ctrl + C for copying (in Windows and Linux)
        or Cmd + C for copying (in macOS). To this aim, we use the class SystemUtils,
        available in the open source library Apache Commons IO (this dependency is used transitively in the Maven/Gradle project).
         */
        Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;
        actions.sendKeys(inputText, "hello world").keyDown(modifier)
                .sendKeys(inputText, "a").sendKeys(inputText, "c")
                .sendKeys(textarea, "v").build().perform();
        /*
        Send the char sequence hello world to the input text.
        Press the key modifier (Ctrl or Cmd, depending on the operating system).
        Remember that this key remains pressed until we explicitly release it.
        We send the key a to the input text. Since the modifier is active,
        the resulting combination is Ctrl + A (or Cmd + A), and as a result,
        all the text present in the input text is selected. We send the key c to the input text.
        Again, since the modifier is active, the combination is Ctrl + C (or Cmd + C),
        and the input text is copied to the clipboard. We send the key v to the text area.
        This means sending Ctrl + V (or Cmd + V), and the clipboard content is pasted to the text area.

         */
        /*
        Perform Text Entry and Shortcuts:
        The actions object queues the following keyboard actions:

        sendKeys(inputText, "hello world") types "hello world" into the text input field.

        keyDown(modifier) presses and holds the modifier key (Command or Control).

        sendKeys(inputText, "a") presses "a" while the modifier key is held down,
        which is the shortcut for "Select All" in the text field.

        sendKeys(inputText, "c") then presses "c"
        while the modifier key is still held down, which is the shortcut for "Copy".

        sendKeys(textarea, "v") moves the focus to the textarea and then presses "v"
        while the modifier key is still held down, which is the shortcut for "Paste".

        The build().perform() method compiles and executes the queued actions.
         */
           /*
        actions.sendKeys(inputText, "hello world"):
        This is like telling the computer, "Hey, go to that text input field and type out 'hello world' for me."

        .keyDown(modifier):
        Next, it's like saying, "Now hold down the 'Command' key
        if we're on a Mac, or the 'Control' key if we're on another operating system.
        Just keep it held down for the next few steps."

        .sendKeys(inputText, "a"):
        While the modifier key is still being held down,
        it's like instructing, "With that key still pressed, hit 'A'.
        On most systems, this will select all the text we just typed."

        .sendKeys(inputText, "c"):
        Continuing with the modifier key still held down,
        this is like saying, "Now hit 'C'. That's the shortcut for copying whatever we've selected,
        which in this case, is the 'hello world' text."

        .sendKeys(textarea, "v"):
        Then we switch focus to the text area and say, "Hit 'V'
        while still holding down that modifier key.
        This should paste the 'hello world' text we just copied into this new area."

        .build().perform();:
        Finally, it's like telling the computer,
        "Okay, go ahead and do all the steps we just talked about in the exact order we said them."

        So, in essence, this script is automating a little typing and copying-pasting task.
        It types out some text in one field, copies it, and then pastes it into another field,
        just like you might do manually when filling out forms or moving text around in your own computer.
         */

        assertThat(inputText.getAttribute("value"))
                .isEqualTo(textarea.getAttribute("value"));
        /*
        Assertion Check:
        The assertThat method is used to assert that the value in the inputText field is the same as the value in the textarea.
        This checks that the copy and paste operation was successful.

        By the end of this test,
        "hello world" should be both in the text input field and in the textarea,
        demonstrating that the text was successfully copied from the former and pasted into the latter.
         */
    }
}
