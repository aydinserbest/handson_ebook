package github.boniGarcia.testng.ch05.robust_page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    //We define the page locators as class attributes.
    By usernameInput = By.id("username");
    By passwordInput = By.id("password");
    By submitButton = By.cssSelector("button");
    By successBox = By.id("success");
    public LoginPage(WebDriver driver) {
        super(driver);
        visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }
    public LoginPage(WebDriver driver, int timeoutSec){
        this(driver);
        setTimeoutSec(timeoutSec);
    }
    public void with(String username, String password){
        type(usernameInput, username);
        type(passwordInput, password);
        click(submitButton);
    }
    public boolean successBoxPresent(){
        return isDisplayed(successBox);
    }
}
/*
    In summary, the LoginPage class uses constructor chaining to initialize page objects with specific browser settings
    and navigate to the login page URL.
    It extends a base page class that encapsulates common Selenium actions and initializations,
    allowing for clean and reusable code across different page objects in the test suite.
     */
/*
    This is an overloaded constructor that takes two parameters: browser and timeoutSec.
    this(browser); is a call to the other constructor in the same class that only takes a browser parameter.
    This is known as constructor chaining, where one constructor calls another constructor to reuse the initialization code.
 */
/*
    The design pattern used in the LoginPage class, where two constructors are provided,
    is a common practice in object-oriented programming, particularly in Java.
    It serves several purposes:

    Flexibility and Overloading:
    By providing multiple constructors,
    the class offers more flexibility for instantiation.
    In this case, there are two ways to create a LoginPage object:

    With just the WebDriver instance.
    With both the WebDriver instance and a custom timeout value.

    Constructor Chaining:
    Constructor chaining (where one constructor calls another) helps in reusing code.
    The LoginPage(WebDriver driver) constructor is always called, ensuring the base initialization is done consistently.
    The LoginPage(WebDriver driver, int timeoutSec) constructor adds additional behavior (setting the custom timeout)
    while still ensuring the base initialization is completed.

    Maintainability and Clarity:
    Separating constructors for different initialization scenarios can make the code more readable and easier to maintain.
    In your example, one constructor handles the default case (with a default timeout),
    while the other handles a special case (with a custom timeout).
    This separation can make it clearer what each constructor is meant to do.

    Default Values and Customization:
    The design allows for sensible defaults (like a default timeout)
    while still giving the option to customize these values if needed.
    Users of this class who don't care about the timeout can use the simpler constructor,
    while those who need to specify a different timeout can use the other constructor.

    Backward Compatibility:
    If this class is part of a library or a larger system,
    providing multiple constructors can help in maintaining backward compatibility.
    Users of the class who have been using the single-argument constructor
    can continue to do so without any changes to their code.

    In summary, the two constructors provide a balance between ease of use
    (by supplying sensible defaults) and flexibility (by allowing customization where necessary),
    while also ensuring code reusability and maintainability.
 */
/*
    The LoginPage class in your example has two constructors,
    which provide different ways to create an instance of the LoginPage class.
    Each constructor has a different set of parameters, allowing for different initialization options:

    Constructor with Just the WebDriver Instance:

        public LoginPage(WebDriver driver)
    This constructor takes only one argument: a WebDriver instance.
    When you create a LoginPage object using this constructor, it uses the default timeout value defined in the BasePage class.
    This is suitable for cases where the default timeout is sufficient,
    and there's no need to specify a different timeout value.
    Usage example:

    WebDriver driver = ...; // assume driver is initialized
    LoginPage loginPage = new LoginPage(driver);

    Constructor with Both the WebDriver Instance and a Custom Timeout Value:

        public LoginPage(WebDriver driver, int timeoutSec)
    This constructor takes two arguments: a WebDriver instance and an integer representing a custom timeout value in seconds.
    When you create a LoginPage object using this constructor,
    it not only initializes the WebDriver,
    but also sets a custom timeout value different from the default.
    This is suitable for cases where you need to customize the timeout value,
    perhaps due to specific requirements of the web page or the test environment.
    Usage example:

    WebDriver driver = ...; // assume driver is initialized
    int customTimeout = 10; // custom timeout in seconds
    LoginPage loginPage = new LoginPage(driver, customTimeout);

    In both cases, the LoginPage constructor internally calls the constructor of the BasePage class (its superclass)
    to perform common initializations, like setting up the WebDriver and the WebDriverWait.
    The second constructor (LoginPage(WebDriver driver, int timeoutSec)) additionally calls setTimeoutSec(timeoutSec)
    to customize the timeout value.

    This design provides flexibility,
    allowing users of the LoginPage class to either go with the default settings
    or specify their own settings for the timeout, as per their needs.
 */
