package github.boniGarcia.testng.ch05.DSL_approach;

public class Explanation_constructors {
    /*
    This design provides flexibility,
    allowing users of the LoginPage class
    to either go with the default settings or specify their own settings for the timeout, as per their needs.
     */
    /*
    The constructors in the ExtendedLoginPage class are designed to initialize instances of this class
    with different parameters and behaviors.
    Let's break down each constructor to understand their purposes and how they work:

    Constructor 1: ExtendedLoginPage(String browser)
    This is the simpler of the two constructors.
    It takes a single argument, browser, which presumably indicates the type of web browser that
    the WebDriver should use (e.g., Chrome, Firefox).

    Here's what happens inside this constructor:

    Call to super(browser):
    This line calls the constructor of the superclass (ExtendedBasePage).
    The superclass constructor is responsible for initializing the WebDriver and WebDriverWait objects
    based on the given browser type.
    Visit a URL:
    After the superclass constructor has finished,
    this constructor calls the visit method (inherited from ExtendedBasePage) to navigate to a specific URL,
    which in this case is "https://bonigarcia.dev/selenium-webdriver-java/login-form.html".
    This URL is presumably the login page that this ExtendedLoginPage class is designed to interact with.
    Constructor 2:
    ExtendedLoginPage(String browser, int timeoutSec)
    This constructor allows for the specification of both the browser type and a custom timeout value.
    It works as follows:

    Call to this(browser):
    This line invokes the first constructor (ExtendedLoginPage(String browser)).
    This means it will perform all the steps in that constructor: calling the superclass constructor
    to initialize WebDriver and navigating to the login page URL.
    Set Timeout:
    After calling the first constructor, it sets a custom timeout value
    by calling setTimeoutSec(timeoutSec). This method is defined in the ExtendedBasePage class
    and allows changing the timeout value used by WebDriverWait. By setting this,
    you're customizing how long the driver should wait for conditions (like element visibility) before timing out.

    In summary:

    The first constructor initializes the class with a specific browser and defaults
    to navigating to a predetermined login page.
    The second constructor provides additional functionality by allowing the user
    to specify both the browser type and a custom timeout value, which can be useful
    for pages that may take longer to load or for tests under different network conditions.
     */

    /*
    In Java, the keyword this is used as a reference to the current object —
    the object whose method or constructor is being called.
    When you use this with parameters, like this(browser);,
    it refers to another constructor in the same class that matches the given parameters.
    This usage is known as "constructor chaining."

    In the context of the ExtendedLoginPage class:

    this(browser);
    within the ExtendedLoginPage(String browser, int timeoutSec) constructor is
    calling the other constructor in the same class, ExtendedLoginPage(String browser).
    This line effectively delegates part of the initialization process to the other constructor.
    This approach allows you to avoid repeating code.
    The ExtendedLoginPage(String browser) constructor already contains the code
    to handle the browser setup and navigation to the login page. By calling this constructor using this(browser);,
    the ExtendedLoginPage(String browser, int timeoutSec) constructor reuses this functionality,
    ensuring that both constructors share the same initialization logic for these parts.
    After this delegation, the ExtendedLoginPage(String browser, int timeoutSec) constructor
    then adds its own specific behavior, which in this case is setting a custom timeout.
    So, in summary, this(browser); is a way to call another constructor of the same class
    (constructor chaining) to reuse its initialization code.
     */
    /*
    The design pattern used in the LoginPage class,
    where two constructors are provided, is a common practice in object-oriented programming,
    particularly in Java. It serves several purposes:

    Flexibility and Overloading:
    By providing multiple constructors, the class offers more flexibility for instantiation.
    In this case, there are two ways to create a LoginPage object:

    With just the WebDriver instance.
    With both the WebDriver instance and a custom timeout value.
    Constructor Chaining:
    Constructor chaining (where one constructor calls another) helps in reusing code.
    The LoginPage(WebDriver driver) constructor is always called, ensuring the base initialization is done consistently.
    The LoginPage(WebDriver driver, int timeoutSec) constructor adds additional behavior
    (setting the custom timeout) while still ensuring the base initialization is completed.

    Maintainability and Clarity:
    Separating constructors for different initialization scenarios can make the code more readable and easier to maintain.
    In your example, one constructor handles the default case (with a default timeout),
    while the other handles a special case (with a custom timeout). This separation can make it clearer
    what each constructor is meant to do.

    Default Values and Customization:
    The design allows for sensible defaults (like a default timeout)
    while still giving the option to customize these values if needed.
    Users of this class who don't care about the timeout can use the simpler constructor,
    while those who need to specify a different timeout can use the other constructor.

    Backward Compatibility:
    If this class is part of a library or a larger system,
    providing multiple constructors can help in maintaining backward compatibility.
    Users of the class who have been using the single-argument constructor can continue to do
    so without any changes to their code.

    In summary, the two constructors provide a balance between ease of use (by supplying sensible defaults)
    and flexibility (by allowing customization where necessary), while also ensuring code reusability and maintainability.
     */
    /*
    The LoginPage class in your example has two constructors,
    which provide different ways to create an instance of the LoginPage class.
    Each constructor has a different set of parameters, allowing for different initialization options:

    Constructor with Just the WebDriver Instance:

    public LoginPage(WebDriver driver)
    This constructor takes only one argument: a WebDriver instance.
    When you create a LoginPage object using this constructor, it uses the default timeout value defined in the BasePage class.
    This is suitable for cases where the default timeout is sufficient, and there's no need to specify a different timeout value.
    Usage example:

    WebDriver driver = ...; // assume driver is initialized
    LoginPage loginPage = new LoginPage(driver);

    Constructor with Both the WebDriver Instance and a Custom Timeout Value:

    public LoginPage(WebDriver driver, int timeoutSec)

    This constructor takes two arguments: a WebDriver instance and an integer representing a custom timeout value in seconds.
    When you create a LoginPage object using this constructor, it not only initializes the WebDriver,
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

    This design provides flexibility, allowing users of the LoginPage class
    to either go with the default settings or specify their own settings for the timeout, as per their needs.
     */
}
