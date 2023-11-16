package github.boniGarcia.testng.ch05.explanations;

public class Explanations_POM {
    /*
    POM is a design pattern in which we separate the logic to interact with web pages and the test code.
     */
    /*
     In the Page Object Model (POM),
     each page of the application is represented by a class
     that contains methods for interacting with the elements of that page.
     These methods encapsulate the actions that can be performed on the page,
     hiding the implementation details from the tests themselves.
     */
    /*
    By making a field or method private, you signal to other developers (and remind yourself)
    that this is an implementation detail of how the LoginPage handles something.
    Other parts of the program don't need to know about how waiting is implemented;
    they just need to use the public methods of LoginPage
     */
    /*
    encapsulation:
    1-
    The find and click methods are private and used internally by the public methods of the class.
    This hides the complexity of waiting for elements and handling exceptions from the tests.
    2-
    The public methods such as enterUsername, enterPassword, and clickLogin
    provide a clear interface to perform actions on the LoginPage.
    These methods can be called directly in test cases without knowledge of the underlying implementation details.
    3-
    In the LoginTest class:

    The test case testLogin uses the public methods of the LoginPage class
    without having to deal with WebDriver or WebElement directly, making the test clean and easy to read.
    4-
    It shows the encapsulation of actions by interacting with the page through the methods defined in the LoginPage class,
    which handle the details of finding elements and clicking buttons.
    This is a typical example of encapsulation in the Page Object Model,
    where the implementation details of interacting with page elements are hidden within the page object,
    allowing for cleaner and more maintainable test cases.

     */
}
