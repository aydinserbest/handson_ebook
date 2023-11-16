package github.boniGarcia.testng.ch03.keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class SendKeysNGTest {

    /*
    two main methods in WebDriver objects allow impersonating keyboard user actions: sendKeys() and clear().
    We simulate a keyboard typing on it using the method sendKeys().
     */
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
    public void tearDown() throws InterruptedException {
        // FIXME: pause for manual browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());
        driver.quit();
    }
    @Test
    public void testSendKeys(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement inputText = driver.findElement(By.id("my-text-id"));
        String textValue = "Hello World";
        inputText.sendKeys(textValue);
        assertThat(inputText.getAttribute("value")).isEqualTo(textValue);

        inputText.clear();
        assertThat(inputText.getAttribute("value")).isEmpty();
        /*
        when you use sendKeys() on an input element, it simulates typing into the field,
        and this would also update the value attribute with the text that was "typed" in.

        Even though the value attribute might not be explicitly written in the HTML markup,
        it is implicitly part of the input element,
        and you can query it to get the current content of the input.
        That's what the getAttribute("value") method call does:
        it retrieves the value that's currently in the input field, which,
        after the sendKeys operation, should be "Hello World!".

        So the assertion is checking that the text that was sent to the input element
        is actually the text that's now in the input element. This is a common check
        in automated web tests to ensure that text fields are behaving as expected.
         */
    }
        /*
        assertThat(fileElement.getAttribute("id")).isBlank();
        The methods isEmpty() and isBlank() are used to check for different conditions on strings:

        isEmpty() checks if the string is empty,
        meaning it has a length of zero.
        It is equivalent to checking string.length() == 0.
        An empty string is a string instance like "", with nothing between the quotes.

        isBlank() checks if the string is blank,
        which means it is either empty or contains only white space characters (spaces, tabs, etc.).
        In other words, isBlank() returns true if the string is empty or if string.trim().isEmpty() would return true.

        Here's a demonstration of their differences:

        A string that is " " (a single space) would be considered non-empty
        (because it has a length of 1), but it would be considered blank
        because it does not contain any non-whitespace characters.
        A string that is "" (empty) would be considered both empty and blank.

        assertThat(inputText.getAttribute("value")).isBlank();
        This assertion will pass
        if the value attribute of inputText is either empty or contains only whitespace characters,
        meaning that the input field contains no text or only space-like characters.

        So,
        if you want to ensure that an input field is completely empty with no spaces,
        you would use isEmpty(). If you want to ensure that an input field
        has no meaningful input (not even spaces), you would use isBlank()

        Non-whitespace characters refer to
        any characters in a string that are not considered whitespace.

        Whitespace characters typically include:

        Space character (' ')
        Tab character ('\t')
        Newline character ('\n')
        Carriage return ('\r')
        Form feed ('\f')

        Any other character that is not one of these is considered a non-whitespace character.
        This includes letters, numbers, symbols, and punctuation marks—essentially anything
        that is visible and contributes to the content of the text.
        For example, in the string "Hello World!",
        all characters are non-whitespace characters.
        But in the string " Hello World! ",
        the leading and trailing spaces are whitespace characters,
        while the rest are non-whitespace characters.

        In many programming languages, including Java,
        there are methods to check for whitespace.
        For instance,
        the Character.isWhitespace(char) method
        can be used to determine if a specific character is a whitespace character.

        In the context of using isBlank(),
        a string is considered blank
        if all of its characters are whitespace characters.
        If a string contains at least one non-whitespace character, it is not blank.
         */
}       /*
        you will discover a pause in the teardown method using Thread.sleep().
        this type of wait is usually considered a bad smell
        (i.e., a characteristic in the source code that can lead to undesirable effects).
    /*
        Both Thread.sleep(3000) and Thread.sleep(Duration.ofSeconds(3).toMillis())
        are Java statements that pause the execution of the current thread for 3 seconds.
        However, they differ in terms of code readability and the approach to specifying the duration:

        Thread.sleep(3000):
        This directly tells the thread to sleep for 3000 milliseconds.
        The duration is specified as a literal number, and it's up to the reader
        to recognize that 3000 milliseconds equate to 3 seconds.

        Thread.sleep(Duration.ofSeconds(3).toMillis()):
        This uses the Duration class from the java.time API to express the sleep time.
        Duration.ofSeconds(3) creates a Duration instance representing 3 seconds, and toMillis()
        converts this duration into milliseconds.
        The result is the same—3000 milliseconds—but the code is more readable
        because it explicitly states that the duration is 3 seconds.

        Here are the key differences:

        Readability:
        The Duration API version is more readable, as it specifies the time unit (seconds) explicitly,
        which can make the code easier to understand at a glance.

        Maintainability:
        If you need to change the duration, using the Duration API can make the code easier to maintain,
        especially if the durations are calculated dynamically or configured externally.

        Consistency:
        If your codebase already uses the java.time API for managing time-related operations,
        using Duration for thread sleeping keeps the code consistent.

        Functionally,
        there is no difference between the two statements in terms of what they do:
        they both pause the thread for the same amount of time.
        The choice between them often comes down to coding style, readability,
        and the specific context of the code they are used in.
         */
