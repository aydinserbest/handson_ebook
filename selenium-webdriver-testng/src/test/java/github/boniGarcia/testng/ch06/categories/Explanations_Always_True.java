package github.boniGarcia.testng.ch06.categories;

public class Explanations_Always_True {
    /*
    The alwaysRun = true attribute in TestNG annotations like @BeforeMethod and @AfterMethod
    can be quite important depending on the structure and needs of your test suite.

    Let's break down what it does and how it relates to your use of @Test(groups = ...).

    What alwaysRun = true Does:

    This attribute ensures that the annotated method (setup() and teardown() in your case) is
    always run regardless of whether the previous methods in the test sequence passed or failed,
    and regardless of the inclusion or exclusion of the groups in the test run.
    It's particularly useful for setup and teardown methods
    because it guarantees that your environment is correctly prepared before each test (@BeforeMethod)
    and properly cleaned up after each test (@AfterMethod), irrespective of the test outcome or the groups it belongs to.

    Relationship to Test Groups (@Test(groups = ...)):

    TestNG allows you to categorize tests into groups. In your case, you have two groups: "WebForm" and "HomePage".
    When running tests, you can include or exclude specific groups. This means that if a particular group is
    excluded from the test run, tests in that group won't be executed.
    However, if you have alwaysRun = true in your @BeforeMethod or @AfterMethod,
    these methods will execute regardless of whether the tests they are setting up or tearing down are
    included in the test run or not.

    Do You Need alwaysRun = true?

    If you want to ensure that your WebDriver is always instantiated before any test (regardless of its group)
    and always quits after any test, then alwaysRun = true is beneficial.
    This is especially relevant in scenarios where certain tests might be skipped
    due to test dependencies or group exclusions. Without alwaysRun = true,
    there's a risk that setup() or teardown() might not execute,
    which can lead to inconsistent test states or resource leaks (like not closing the browser).

    Best Practices:

    In most cases, it's good practice to use alwaysRun = true for setup and teardown methods
    to maintain a consistent test environment and ensure proper resource management.
    In summary, using alwaysRun = true in your case is a good practice
    as it ensures your WebDriver is correctly managed before and after each test,
    regardless of the specific groups being tested. This contributes to more reliable and maintainable test automation.
     */
}
