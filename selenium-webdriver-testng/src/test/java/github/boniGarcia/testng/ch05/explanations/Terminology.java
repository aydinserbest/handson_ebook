package github.boniGarcia.testng.ch05.explanations;

public class Terminology {
    /*
    In the context of Selenium and the Page Object Model (POM),
    a "page object" is a class that serves as an interface to a specific page of your application.

    The LoginPage would be a page object for the login page of your application,
    It is tailored for interactions specific to the login page.
    For example, it could contain methods to enter a username, password, and click the submit button.

    When you create an instance of LoginPage in your test class,
     *** you're initializing the page object for the login page.  ***
    This instance will then be used to interact with the login page during the tests.

    The LoginPage is the actual page object that you will interact with in your tests.
    It encapsulates all the details of the login page so that the tests can be written in a higher level of abstraction
    without worrying about the underlying implementation details.
    In the context of the Page Object Model (POM) in Selenium, when I mention "initializing the page object for the login page," I'm referring to creating an instance of the ExtendedLoginPage class, which represents the login page of your web application.

    The LoginPage class encapsulates the elements and interactions specific to the login page,
    such as input fields for username and password, and the submit button.
    When you create an instance of this class and use it in your tests,
    *** you are effectively using the page object to interact with the login page in the browser.***
    This approach promotes more maintainable and readable test code
    by abstracting the details of the web page structure and Selenium WebDriver commands.
     */
    /*
    the author says: -Finally, we can use the page class to implement a Selenium WebDriver test.--
    he refers to test by using LoginPage,

    The term "page class" in the context of Selenium WebDriver and the Page Object Model refers to a Java class
    that represents a specific web page in the application under test.
    It's a design pattern that creates an object representing a web page,
    encapsulating all the functional elements and behaviors of that page. This object is called a "page object."

    Here's what the author means in the given context:

    "Implement the page class, using the login sample page in the practice site":
    Here, "implement the page class" means
    to create a new class, LoginPage,
     which extends from the BasePage class
     and adds specific elements and methods needed to interact with the login page of the application.

    "Finally, we can use the page class to implement a Selenium WebDriver test":
    This means that once the LoginPage class (the page class) is created,
    you can utilize it to write test cases.
    The LoginPage provides methods to interact with the web page,
    such as logging in, which can be used in test scripts to automate the process of testing the login functionality.

    In summary,
    ***** the "page class" refers to a class that models a web page for the purposes of testing. *****
    It's part of the Page Object Model,
    where each significant page in the application has a corresponding class that provides a high-level API
    to interact with that page's UI elements.
    The page class (LoginPage in this example) hides the implementation details of the interactions with the web page,
    allowing the test cases to be written in a more readable and maintainable way.


    In the context of Selenium WebDriver and the Page Object Model (POM),
    the terms "page object" and "page class"
    are often used interchangeably and refer to the same concept:

    A "page object" is an instance of a "page class."
    A "page class" is a template or blueprint that defines how to interact with a specific page in your application
    (like the login page), including the elements on the page and the actions you can perform on those elements
    (like entering text into a field or clicking a button).
    When we talk about "initializing the page object,"
    we mean that we are creating an instance of the "page class."
    This instance encapsulates the functionality of the specific page a
    nd can be used in test scripts to perform actions on that page,
    which allows for more readable, maintainable, and reusable tests.

     */
}
