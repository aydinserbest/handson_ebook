package github.boniGarcia.junit4.ch06.failure_analysis;

public class Why_is_static_driver_inFailureJunitTest {
    /*
    Imagine you're sitting in front of your MacBook, about to write the FailureJUnit4Test.
    Here's how you might think about using a static WebDriver:

    The Scenario: Writing FailureJUnit4Test
    1. Planning the Test Suite
    Your Goal: You're creating a set of tests that interact with a web browser.
    These tests might be checking different features of a website, but they're all related.
    Efficiency in Mind: You know that starting up a browser and closing it down takes time.
    If you have, let’s say, 10 tests, opening and closing a browser 10 times can really slow down the whole testing process.
    2. Deciding on a Static WebDriver
    One Browser for All Tests: You think, "What if I just start the browser once, run all my tests,
    and then close it at the end?" That way, you only open and close the browser once,
    no matter how many tests you have.
    Static Keyword Comes to Mind: To make this happen, you decide to use the static keyword with your WebDriver.
    This means no matter how many test methods you write in this class,
    they all share the same single browser instance.
    BeforeClass and AfterClass: You use @BeforeClass and @AfterClass annotations for setup and teardown methods.
    Since these are static (they run once per class, not per test method),
    your WebDriver also needs to be static to be accessible in these methods.
    3. Writing the Test
    Creating Tests: As you write your test methods, each one just tells the already-open browser what to do.
    There's no waiting for the browser to start up each time.
    Trade-Offs: You understand that this approach has a trade-off. Since all tests use the same browser,
    what you do in one test could affect the next. But for your current scenario, that’s okay.
    Maybe your tests are meant to follow a sequence, like first logging in,
    then navigating through a series of steps on the website.
    4. Why Not Non-Static?
    Comparison: You also know that if you had used a non-static WebDriver, each test would have its own browser.
    This is great for when tests don’t need to know about each other, ensuring they're totally independent.
    Your Choice: For your current test suite, though, the static approach suits better.
    It’s all about being efficient and having a series of tests that work more like a journey through the website.
    In Simple Terms
    Think of the static WebDriver like a shared car for a road trip (your test suite).
    Everyone (each test method) gets in, does their part of the driving (testing),
    and then passes the car to the next person. The car only needs to be started once at the beginning
    and stopped at the end of the trip.

    On the other hand, a non-static WebDriver is like giving each person their own car.
    They can go wherever they want independently, but it means more cars (browsers) to start and stop.

    Summary
    In FailureJUnit4Test, you choose a static WebDriver for efficiency and a smooth,
    continuous testing flow across related tests. This approach fits well when your tests are
    like a connected journey rather than isolated destinations.
     */

    /*
    You can certainly use driver.get() in different tests within the same test class,
    even when using a shared, static WebDriver.
    The key point here is not whether the tests are related in terms of functionality,
    but rather how they interact with the shared browser state. Let's clarify this with your MacBook scenario:

    Scenario: Using driver.get() in Multiple Tests
    1. Multiple Tests, One Browser
    Situation: You're still sitting with your MacBook, writing tests in FailureJUnit4Test.
    Using driver.get(): You can use driver.get("someURL") in each test method to navigate to different web pages
    or even the same page with different states.
    2. Understanding Shared Browser State
    Continuity: With a static WebDriver, the state of the browser carries over from one test to the next.
    Example:
    Test 1: Navigates to a login page and logs in.
    Test 2: Directly starts on the homepage (post-login)
    because the browser is still in the state left by Test 1.
    Implication: This can be useful or problematic, depending on what you're testing.
    If your tests need a fresh start each time, this shared state might lead to issues.
    3. Tests Don’t Have to Be Functionally Related
    Flexibility: You can still navigate to entirely different pages or perform different actions in each test.
    The tests don't have to be part of a logical sequence.
    Isolation Consideration: Just remember that any changes made to the browser's state in one test
    (like logging in, navigating to a page, or changing settings) will be present in the subsequent tests.
    4. When to Use Static WebDriver
    Scenario 1: Sequential Flow: Ideal if you're testing a flow where one test naturally leads to the next,
    like steps in a process.
    Scenario 2: Independent but Resource-Efficient: You can still use it for independent tests,
    but you might need to manually reset the state at the start of each test (like navigating back to a home page
    or logging out).
    Summary
    In FailureJUnit4Test, using a static WebDriver means all tests use the same browser instance.
    You can navigate to different URLs in each test method, but the state of the browser
    (like cookies, local storage, session state) persists across these tests.
    The choice of a static WebDriver is more about managing resources and the browser state
    rather than the functional relationship between tests. You have the flexibility to navigate to different URLs,
    but you need to be mindful of the shared browser state and how it might affect the outcome of your tests.
     */

    /*
    Comparing the WebDriver instances in the FailureJUnit4Test and HelloWorldChromeNGTest classes
    provides insight into different strategies for managing the WebDriver in automated tests.
    Let's examine the key differences:

    FailureJUnit4Test Class
    Static WebDriver:
    The WebDriver instance is declared as static.
    This means there is only one instance shared across all test methods in the class.
    It's initialized in a @BeforeClass method (setup) and terminated in an @AfterClass method (teardown).
    These methods are executed once each, before and after all tests in the class, respectively.
    Implications:
    All tests run in the same browser session.
    Useful for tests that are closely related or need to share the same browser state.
    Not ideal for tests that require isolation, as the actions in one test can affect others.
    HelloWorldChromeNGTest Class
    Non-static WebDriver:
    Here, the WebDriver is an instance variable (non-static). Each test method gets its own instance of WebDriver.
    It's initialized in the @BeforeMethod method (setUp) and terminated in an @AfterMethod method (tearDown).
    These methods are executed before and after each test method, respectively.
    Implications:
    Each test runs in a fresh browser session.
    Promotes test isolation, as the state of one test does not affect another.
    More resource-intensive, as it involves opening and closing the browser for each test.
    Key Differences and Considerations
    Test Isolation vs. Resource Efficiency:
    The static WebDriver in FailureJUnit4Test is more resource-efficient but at the cost of test isolation.
    The non-static WebDriver in HelloWorldChromeNGTest ensures test isolation but with increased resource usage.
    Test Context:
    If tests need to share context (like a logged-in session), a static WebDriver is beneficial.
    For independent tests where each test should start with a clean state, a non-static WebDriver is preferable.
    Test Suite Execution Time:
    A static WebDriver can reduce the total execution time of the test suite.
    A non-static WebDriver might increase the execution time due to the overhead of browser initialization
    and teardown for each test.
    Summary
    The choice between a static and non-static WebDriver depends on the testing requirements:

    Use a static WebDriver for efficiency and shared context among tests, knowing it may impact test independence.
    Use a non-static WebDriver for isolated, independent tests, accepting potentially higher resource usage
    and longer execution times.
     */
    /*
    'll provide two examples to illustrate these scenarios:
    one where tests are related and benefit from a shared browser state (using a static WebDriver),
    and another where tests are independent and require a fresh browser state (using a non-static WebDriver).

    Example 1: Related Tests with a Static WebDriver
    Imagine you're testing a web application where you have a sequence of actions that build upon each other.

    UserJourneyTest - Testing a User Journey
    public class UserJourneyTest {
        static WebDriver driver;

        @BeforeClass
        public static void setup() {
            driver = new ChromeDriver();
            // other setup code
        }

        @AfterClass
        public static void teardown() {
            driver.quit();
        }

        @Test
        public void testLogin() {
            driver.get("https://example.com/login");
            // Code to perform login
            // Assert login successful
        }

        @Test
        public void testAddItemToCart() {
            // Assuming user is already logged in from testLogin
            driver.get("https://example.com/shop");
            // Code to add item to cart
            // Assert item is added
        }

        @Test
        public void testCheckout() {
            // Assuming item is already in the cart from testAddItemToCart
            driver.get("https://example.com/checkout");
            // Code to perform checkout
            // Assert checkout successful
        }
    }
    Explanation
    Sequential Tests: Each test is part of a user journey. Logging in, adding an item to the cart, and checking out.
    Shared State: The state after each test (like being logged in, having items in the cart) is
    required for the subsequent tests.
    Static WebDriver: Efficient because it avoids reopening the browser for each step.
    Example 2: Independent Tests with a Non-static WebDriver
    Now, consider a scenario where you are testing different functionalities of a web application
    that do not depend on each other.

    IndependentFeaturesTest - Testing Independent Features
    public class IndependentFeaturesTest {
        WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            // other setup code
        }

        @AfterMethod
        public void teardown() {
            driver.quit();
        }

        @Test
        public void testSearchFunction() {
            driver.get("https://example.com");
            // Code to test search functionality
            // Assert search results are correct
        }

        @Test
        public void testUserSettings() {
            driver.get("https://example.com/settings");
            // Code to test user settings modification
            // Assert settings are updated
        }

        @Test
        public void testHelpPage() {
            driver.get("https://example.com/help");
            // Code to test help page content
            // Assert help page is as expected
        }
    }
    Explanation
    Independent Tests: Each test method is testing a different feature of the website.
    Isolated State: The state of one test does not affect the others.
    Non-static WebDriver: Each test starts with a fresh browser, ensuring no shared state between tests.
    Summary
    Related Tests (Example 1): Use a static WebDriver for a series of tests
    where each test builds upon the state left by the previous one.
    Independent Tests (Example 2): Use a non-static WebDriver when each test is independent,
    ensuring a fresh state for every test.
     */
}
