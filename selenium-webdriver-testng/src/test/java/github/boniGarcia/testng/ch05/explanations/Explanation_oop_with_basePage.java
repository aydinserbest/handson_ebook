package github.boniGarcia.testng.ch05.explanations;

public class Explanation_oop_with_basePage {
    /*
    our SUT is likely to have several web pages, not only one.
    For this reason, a common strategy is to follow an object-oriented approach
    and create a base page class that encapsulates the common logic for all the page classes.
     */
    /*
    Let's break down the concept of using an object-oriented approach to create a base page class
    in the context of robust Page Objects in test automation.

    Object-Oriented Approach
    An object-oriented approach is a programming paradigm that uses "objects" to design and build applications.
    Objects are instances of classes,
    and classes are blueprints that define the structure and behavior of these objects.
    This approach is characterized by several key principles:

    Encapsulation: Bundling data (attributes) and methods (functions) that operate on the data into a single unit, or class.
    This helps in hiding the internal state of the object from the outside world,
    only allowing interaction in a controlled manner.

    Inheritance: Allowing a new class to inherit properties and methods from an existing class.
    This is crucial for reusing code and creating hierarchical relationships among classes.

    Polymorphism: Enabling objects of different classes to be treated as objects of a common super class,
    primarily through the use of interfaces and abstract classes.
    This allows for flexible and interchangeable use of objects.

    Abstraction: Providing a simplified, high-level view of an entity,
    hiding complex details and only showing the necessary aspects.

    Base Page Class
    In the context of Selenium WebDriver and the Page Object Model (POM),
    a base page class is a general class that encapsulates common functionalities, properties, or methods
    that are shared across multiple page classes.
    This is where object-oriented principles, particularly inheritance and encapsulation, play a crucial role.

    Logic Behind Creating a Base Page Class
    Reusability (Inheritance):
    By creating a base page class, you define common methods and properties that are applicable
    to all or most of the pages you will be testing.
    For example, methods to find web elements, wait for elements, or navigate to URLs can be common.
    Other page classes (specific to each web page) can then inherit from this base class,
    gaining all its common functionalities without having to write them again.

    Maintainability (Encapsulation):
    Since the common logic is encapsulated in one place, it's easier to maintain and modify.
    If there's a change in the common functionality (e.g., how elements are located),
    you only need to update the base class.

    Design Clarity (Abstraction):
    The base class provides a clear abstraction layer.
    Specific page classes don't need to know how the common functionalities are implemented;
    they just know they are available and can use them.

    Reduced Complexity:
    It simplifies the design of specific page classes, as they don't get cluttered with common, repetitive code.

    In summary, applying an object-oriented approach to create a base page class in test automation with POM
    aligns with the goal of making your tests more modular, maintainable, and scalable.
    It leverages the principles of
    encapsulation and inheritance to provide a clean, reusable structure for your automated tests.
     */
    /*
    The text you're referring to delves into the concept of using an object-oriented approach
    to enhance the robustness of page objects in test automation. Let's break down the key points for clarity:

    Object-Oriented Approach
    Object-Oriented Programming (OOP): This is a programming paradigm based on the concept of "objects,"
    which can contain data and code: data in the form of fields (often known as attributes or properties), and code,
    in the form of procedures (often known as methods).

    Why OOP?:
    OOP is particularly powerful in situations where you have multiple entities (in this case, web pages)
    that share common characteristics and behaviors.
    By using OOP, you can create a more organized and modular code structure, making it easier to maintain, extend, and manage.

    Base Page Class
    Base Page Class Concept:
    In the context of test automation and POM,
    a base page class serves as a foundational class from which other specific page classes inherit.
    This base class contains common logic, elements, and methods that are shared across different web pages.

    Encapsulation of Common Logic:
    The base class encapsulates (wraps) common functionalities, such as methods for finding web elements,
    waiting for elements to be visible, and interacting with the browser.
    This avoids the need to repeat these common functionalities in each page-specific class.

    Inheritance:
    Specific page classes inherit from this base class.
    This means they automatically have access to the common functionalities defined in the base class,
    which promotes code reuse and reduces redundancy.

    The Logic Behind the Strategy
    Efficiency and Reusability:
    By creating a base page class, you're centralizing common functionalities,
    which makes the code more efficient and reusable. When a new page class is created,
    it doesn't need to redefine these common functionalities;
    it simply inherits them from the base class.

    Ease of Maintenance:
    When there's a need to update common functionalities
    (like a change in the way elements are located or a new browser interaction method),
    you only need to update the base class.
    This change then automatically propagates to all page classes that inherit from it.

    Scalability:
    As the system under test (SUT) grows and includes more web pages,
    this approach scales well.
    You can add new page classes that extend the base class, leveraging the already established common functionalities.

    In summary, the "object-oriented approach" in this context refers to using principles of OOP
    (like inheritance, encapsulation, and polymorphism) to create a base page class
    that serves as a foundation for other page-specific classes.
    This approach enhances the maintainability, scalability, and robustness of your test automation code.
     */
}
