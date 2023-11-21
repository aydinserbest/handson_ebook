package github.boniGarcia.testng.ch06.categories;

public class Explanations_CommandLine {
    /*
    from e-book:
        Then we can use the command line to filter the test execution based on these categories.
        The following snippet first shows how to execute the test that belongs to the HomePage group.
        The second illustrates how to combine this grouping with the Maven
        filtering mechanism based on the class name.

        mvn test -Dgroups=HomePage
        mvn test -Dtest=CategoriesNGTest -DexcludedGroups=HomePage
     */
    /*
    Using Command Line to Filter Test Execution Based on Categories:

    The author is discussing how to execute a subset of tests using TestNG groups and Maven commands.
    When you have a large test suite with mHany tests grouped into different categories (like "HomePage", "WebForm", etc.),
    you might not always want to run all the tests.
    Instead, you may wish to run only a specific group of tests based on your current testing needs.
    The command line options provided
    (mvn test -Dgroups=HomePage and mvn test -Dtest=CategoriesNGTest -DexcludedGroups=HomePage)
    are ways to selectively run tests.

    mvn test -Dgroups=HomePage:
    This command runs only the tests that are part of the "HomePage" group.

    mvn test -Dtest=CategoriesNGTest -DexcludedGroups=HomePage:
    This command runs tests in the CategoriesNGTest class but excludes those in the "HomePage" group.

    Using the command line in this way is not mandatory
    but is highly useful for managing larger test suites,
    where running all tests every time can be time-consuming and inefficient.
    It allows you to focus on a specific area of the application being tested,
    which is particularly useful during development or when investigating specific issues.

    Common Practice for Grouping Tests:

    In the real world of test automation, how you group tests depends on the application's structure
    and the testing strategy. A group (like "HomePage") can indeed have multiple tests associated with it.
    For instance, for a "HomePage" group, you might have several tests:
    Verifying the presence of key elements on the home page.
    Checking that navigation from the home page to other pages works correctly.
    Testing any specific functionality available directly on the home page.

    The idea is to logically group tests so that when you choose to run a specific group,
    all relevant tests for that aspect of the application are executed.
    This organization helps in maintaining tests, understanding test coverage,
    and efficiently running relevant tests as needed.
    In summary, using command line options to filter tests based on groups is
    a powerful feature in TestNG and Maven that helps in efficiently managing
    and executing large test suites.
    It's not mandatory but is highly recommended for better test suite management.
    As for grouping tests, it's common to have multiple tests under a single label or group,
    each focusing on different aspects or scenarios related to that part of the application.
     */
}
