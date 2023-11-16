package github.boniGarcia.testng.ch05.basicPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Explanation_BasicLoginPage {
    /*
    We declare a WebDriver class attribute.
    This variable is used in the page object to implement the interaction with the web page.
    This attribute holds a reference to the WebDriver, which manages interactions with the web browser.

     */
    /*
    WebDriver: WebDriver is an interface in Selenium,
    a popular tool for automating web browsers.
    It provides a way to launch and interact with web browsers programmatically.
    Browsers: WebDriver can interact with various browsers like Chrome, Firefox, Safari, etc.,
    using their respective driver executables.
     */
    /*
    Class Attribute: In the code snippet, WebDriver driver;
    is a declaration of a class attribute.
    This means that driver is a variable that belongs to the BasicLoginPage class
    and can be used by all methods in the class.
    Purpose: The purpose of this driver variable is to interact with a web browser.
    You can use it to navigate to web pages, find web elements,
    interact with them (like clicking buttons, entering text), and gather information from the web page
     */
    /*
    Page Object Model: The code follows a design pattern known as the Page Object Model,
    commonly used in Selenium WebDriver for creating more maintainable and reusable code.
    Page Objects: Each page object class, like BasicLoginPage, represents a web page or a part of a web page.
    It encapsulates the web page's structure and behavior.

    Advantages
    Reusability:
    By encapsulating browser interactions in the page object,
    the code becomes more organized and reusable.
    Maintenance: Changes in the web page's UI only require updates in the page object,
    not in the tests that use the page object.
     */
    WebDriver driver;
    /*
    We declare all the required locators as additional attributes.
    In this case, we locate
     the text input for the username and password,
     the Submit button,
     and the success box.

     These attributes represent locators for identifying UI elements on the web page.
     */
    By usernameInput = By.id("username");
    By passwordInput = By.id("password");
    By submitButton = By.cssSelector("button");
    By successBox = By.id("success");

    /*
    The constructor defined by this page class accepts the WebDriver object.
    We use the constructor to load the page under test.
        The constructor initializes the class with a WebDriver instance and navigates to the login page.

     */
    /*
    Constructor: In the constructor public BasicLoginPage(WebDriver driver),
    the WebDriver instance is passed from outside and assigned to the class attribute this.driver.
    This allows the class to control a browser instance.
    Interactions: Methods like with(String username, String password)
    use the driver to interact with the web page elements like input fields and buttons.
     */
    public Explanation_BasicLoginPage(WebDriver driver){
        this.driver = driver;
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }
    /*
    We declare a method to model the required interaction to log in,
    i.e., type the username and password, and click on the Submit button.

    This method performs a login action using the provided username and password.
    It fills in the login form and clicks the submit button.
     */
    /*
    Interact with Page: Methods like with(...) and successBoxPresent()
    perform actions and checks on the page using the driver.
     */
    public void with(String username, String password){
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
    }
    // We declare another method to check if the success box is visible.
    // This method checks whether the success box is displayed, indicating a successful login.
    public boolean successBoxPresent(){
        return driver.findElement(successBox).isDisplayed();
    }
    /*
    when we say "class attribute" in the context of your code,
    we're referring to the fields (like WebDriver driver) that store data for the class instances,
    as well as the methods that define what actions those instances can perform.
     */
    /*
    In summary, the WebDriver class attribute in the BasicLoginPage class is fundamental
    for enabling the interaction with the web browser and automating actions on the specified web page,
    adhering to the principles of the Page Object Model for better code organization and maintainability.

    Instantiate BasicLoginPage: When an instance of BasicLoginPage is created,
    it is provided with a WebDriver instance.
    Open Web Page: The constructor navigates to the specified URL using driver.get(...).
    Interact with Page: Methods like with(...) and successBoxPresent() perform actions
    and checks on the page using the driver.
     */
    /*
    in the context of object-oriented programming,
    a "class attribute" can refer to either a field (variable) or a method (function) associated with a class.
    These are two fundamental components of a class. Let's differentiate between them:

    Fields (or Class Variables)
    Definition: Fields are variables that are declared within a class.
    They represent the state or data of the objects created from the class.
    Example in Your Code: In your code snippet, WebDriver driver; is a field.
    It's a variable that holds a reference to a WebDriver instance,
    and it's used to store the state of the web browser interactions within each BasicLoginPage object.
    Methods (or Class Functions)
    Definition: Methods are functions that are declared within a class.
    They define the behavior of the objects created from the class.
    Example in Your Code: Methods in your code include public BasicLoginPage(WebDriver driver),
    public void with(String username, String password), and public boolean successBoxPresent().
    These methods define the actions that a BasicLoginPage object can perform,
    such as initializing the object, logging in with a username and password,
    and checking if a success box is present.
    Object-Oriented Programming Context
    Class: A blueprint for creating objects.
    It defines the state and behavior that the objects (instances of the class) will have.
    Object: An instance of a class. It has the state defined by the fields
    and can perform the behaviors defined by the methods.
    In summary, when we say "class attribute" in the context of your code,
    we're referring to the fields (like WebDriver driver) that store data for the class instances,
    as well as the methods that define what actions those instances can perform
     */
    /*
    A class in object-oriented programming can have both fields and methods, among other components.

    1. Fields (Attributes or Properties)
    Purpose: Fields represent the state or data of an object.
    Example: In your BasicLoginPage class, WebDriver driver is a field.
    It's used to store a reference to a WebDriver instance which is crucial for browser interactions.
    2. Methods (Functions or Behaviors)
    Purpose: Methods define the behavior or functionality of the objects created from the class.
    Example: In your class, methods like with(String username, String password)
    and successBoxPresent() are methods that define what a BasicLoginPage object can do.
    Other Components of a Class
    In addition to fields and methods, a class can also include:

    Constructors: Special methods used to initialize new objects.
    In your case, public BasicLoginPage(WebDriver driver) is a constructor.
    Static Fields and Methods: Belong to the class itself rather than to instances of the class.
    Inner Classes or Interfaces: Classes or interfaces defined within another class.
    Blocks: Initializer blocks (both static and non-static) for initializing fields.
    Summary
    In essence, a class is a blueprint that encapsulates data (fields) and actions (methods)
    that objects of that class can perform.
    It can also include other elements for more complex behaviors and structures.
    Your understanding of a class having fields and methods is fundamentally correct
    and forms the core of object-oriented programming.





     */
}
