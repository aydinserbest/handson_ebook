package github.boniGarcia.testng.ch05.basicPageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicLoginTest {
    WebDriver driver;
    BasicLoginPage loginPage;

    @BeforeMethod
    void setup(){
        driver = WebDriverManager.chromedriver().create();
        loginPage = new BasicLoginPage(driver);
    }
    @AfterMethod
    void teardown(){
        driver.quit();
    }
    @Test
    void testBasicLoginSuccess(){
        loginPage.with("user", "user");
        assertThat(loginPage.successBoxPresent()).isTrue();
    }
    //Test using the basic page class to implement a failed login
    @Test
    void testBasicLoginFailure() {
        loginPage.with("bad-user", "bad-password");
        assertThat(loginPage.successBoxPresent()).isFalse();
    }
    /*
    This approach is a handy start for improving the maintainability of our tests because now,
    all the logic related to the login web page is centralized as a reusable class.

    The principle of the POM design pattern is to separate the logic for handling UI elements
    in separate classes (called page classes) from the test logic.

    In other words, we model the appearance and behavior of our SUT following an object-oriented paradigm,
    i.e., as page objects. Then, these page objects are used by Selenium WebDriver tests.
     */
    /*
    POM separates the UI handling logic (locating elements, interacting with elements)
    into separate classes called "page classes" or "page objects".
    Each page object class represents a specific page or a component of a web application.
     */
    /*
    They help in creating software that is modular, easy to maintain,
    and scalable, with a focus on reusing existing code.
     */
    /*
    Separation of Concerns: POM separates the code that interacts
    with the user interface (UI) of a website from the code that contains the test logic.
    This means we create special classes, called "page classes," for each page of the website we want to test.
     These classes model the appearance and behavior of the web pages.
     */
    /*
     In the Page Object Model (POM),
     each page of the application is represented by a class
     that contains methods for interacting with the elements of that page.
     These methods encapsulate the actions that can be performed on the page,
     hiding the implementation details from the tests themselves.
     */
    /*
    Design Clarity (Abstraction):
    The base class provides a clear abstraction layer.
    Specific page classes don't need to know how the common functionalities are implemented;
    they just know they are available and can use them.
     */
    /*
    POM is a design pattern in which we separate the logic to interact with web pages and the test code.

    This way, page classes contain the logic related to web locators and page layout,
    and test classes determine how to exercise and verify the SUT.

     */
    /*
     The LoginPage is the actual page object that you will interact with in your tests.
    It encapsulates all the details of the login page so that the tests can be written in a higher level of abstraction
    without worrying about the underlying implementation details.
     */
    /*
    In summary,
    ***** the "page class" refers to a class that models a web page for the purposes of testing. *****
    It's part of the Page Object Model,
    where each significant page in the application has a corresponding class that provides a high-level API
    to interact with that page's UI elements.
    The page class (LoginPage in this example) hides the implementation details of the interactions with the web page,
    allowing the test cases to be written in a more readable and maintainable way.
     */

}
