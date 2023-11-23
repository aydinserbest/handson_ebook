package github.boniGarcia.testng.ch05.basicPageObjects;

public class Explanation3 {
    /*
    The term "object-oriented classes" in this context refers to the
    application of object-oriented programming (OOP) principles to model web pages for testing purposes.
    Let's break it down:

    Object-Oriented Programming (OOP):
    OOP is a programming paradigm based on the concept of "objects." Objects are instances of classes,
    which can contain data (in the form of fields or attributes) and methods (functions) to operate on the data.

    Page Object Model (POM):
    POM is a design pattern in test automation where each web page (or significant part of a web page) is
    represented as a class. These classes, often referred to as "Page Objects," encapsulate the elements of the page
    and the operations you can perform on them.

    For example, consider a login page:

    The page might have text fields for a username and password, and a submit button.
    The corresponding Page Object class would have attributes representing these elements and methods
    to perform actions like entering text into the fields and clicking the submit button.
    Benefits of Using POM with Object-Oriented Classes:

    Ease of Maintenance:
    By encapsulating page details in a class,
    if there are changes to the page (like an element's ID changes),
    you only need to update the class, not every test that interacts with that page.
    Reduce Code Duplication: Instead of writing repetitive code to find and interact with page elements in every test,
    you can just use the methods from the Page Object.
    Readability: Tests written using the POM pattern are typically more readable
    because they abstract away the low-level details of interacting with page elements.
     */
    /*
    Example:

    Here's a basic example to illustrate:
    public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}
    In this example, the LoginPage class represents a login page.
    It has methods to interact with the page's elements. When writing tests,
    instead of directly interacting with the WebDriver,
    you'd interact with this class, making your tests cleaner and more maintainable.

    In summary, when the author mentions "modeling web pages using object-oriented classes,"
    they are referring to the practice of representing web pages as classes (using OOP principles)
    to improve the structure, maintainability, and clarity of test automation code.

     */
    /*
    in the example provided, LoginPage is an object-oriented class. Here's why:

    Encapsulation:
    The LoginPage class encapsulates (or bundles together) the attributes and behaviors
    specific to the login page. The attributes (or fields) are the locators for the page elements
    (usernameField, passwordField, submitButton), and the behaviors are the methods
    that interact with those elements (enterUsername, enterPassword, clickSubmit).

    Abstraction:
    The class provides an abstract representation of the login page.
    When using the class in tests, you don't need to know the details of how the username
    is entered or how the button is clicked; you just call the appropriate method.

    Constructor:
    The LoginPage class has a constructor that initializes the WebDriver instance.
    This is a common OOP concept where an object is initialized with certain values or configurations
    when it's created.

    Instantiation:
    While the class itself is a blueprint,
    you can create multiple instances (or objects) of this class for different tests or scenarios.
    Each instance represents a specific interaction with the login page.

    By applying these object-oriented principles,
    the LoginPage class provides a structured and reusable way to interact with the login page in your Selenium tests.
     */
}
