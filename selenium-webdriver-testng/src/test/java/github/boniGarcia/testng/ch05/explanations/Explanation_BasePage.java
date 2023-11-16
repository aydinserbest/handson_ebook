package github.boniGarcia.testng.ch05.explanations;

public class Explanation_BasePage {
    /*
    BasePage class seems to be a utility class for handling common web element interactions in automated tests,
     */
    /*
    our SUT is likely to have several web pages, not only one.
    For this reason, a common strategy is
    to follow an object-oriented approach
    and create a base page class that encapsulates the common logic for all the page classes.
     */
    /*
    BaseTest created custom find and click methods,
    given that Selenium WebDriver already provides these functionalities.
    There are several reasons why one might choose to define such methods in a base test class or a page object class:

    Abstraction and Readability:
    By defining these methods,
    the author is creating an abstraction layer over Selenium's native methods.
    This can make the test code more readable and easier to understand,
    especially for those who might not be familiar with all of Selenium's methods.

    Consistency and Convenience:
    Having a standard way of interacting with web elements (like find and click) in all tests
    can lead to more consistent code. It's also convenient for the test developers
    as they can use these methods without worrying about the underlying Selenium details.

    Error Handling:
    Custom methods can include additional error handling that's not provided by Selenium.
    For instance, the find method could be enhanced to wait for an element to be present or visible before returning it,
    thus reducing the chances of encountering NoSuchElementException.

    Extensibility:
    If in the future there's a need to modify how elements are found or clicked
    (perhaps to add logging, performance metrics, or additional checks),
    it's easier to do so in these custom methods rather than modifying every instance where raw Selenium methods are used.

    Encapsulation:
    In the context of a Page Object Model, encapsulating the actions (like clicking a button)
    inside methods provides a clear interface for each page object.
    This hides the implementation details and makes the tests that use these page objects simpler and cleaner.

    In summary, while Selenium does provide its own findElement and click methods,
     creating custom methods in a base class can add value in terms of
     code readability, maintainability, error handling, and extensibility.
     */
    /*
    The custom click method defined in the BaseTest class is
    an example of wrapping or encapsulating existing functionality to provide additional benefits such as:

    Simplified Syntax:
    It allows the user to call click directly with a By object without the need to first find the element and then click it.
    This can make the test code more concise and easier to read.

    Consistency:
    By using a consistent method throughout the test code, you ensure that
    every click action is performed in the same manner.
    This is useful if you want to extend the click behavior universally across all elements.

    Maintainability:
    If you want to change the way clicks are handled in the future
    (for example, adding logging, exception handling, or waiting mechanisms), you only need to change it in one place.

    Custom Logic:
    You might want to add some custom logic before or after the click action,
    such as waiting for the element to be clickable or logging the action for debugging purposes.

    Error Handling:
    You can implement standardized error handling within these methods.
    If an element is not found or is not clickable, you can catch exceptions and handle them accordingly,
    perhaps by retrying the action a certain number of times before failing.

    Improved Test Flow Control:
    By encapsulating the actions into methods, you have better control over the test flow.
    For instance, if an element is not immediately visible, you might want to wait for it before attempting to click.

    Abstraction:
    It abstracts away the direct usage of the Selenium API from the test code.
    This can make the transition smoother if the underlying library changes or if you decide to switch
    to a different one in the future.

    In summary, defining custom find and click methods in a base class or utility class is
    a design choice aimed at improving the readability, maintainability, and robustness of test scripts.
    It is a common practice in test automation to wrap basic actions
    like these to suit the specific needs of the test framework or the preferences of the development team.
     */
}
