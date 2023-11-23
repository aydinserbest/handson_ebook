package github.boniGarcia.junit4.ch06.failure_analysis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.fail;
@Ignore("Disabled to avoid breaking the build in CI")
public class FailureJUnit4Test {
    static WebDriver driver;

    @Rule
    public TestRule testWatcher = new FailureWatcher(driver);
    @BeforeClass
    public static void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void testFailure() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        fail("Forced error");
    }
}
    /*
    TestRule Initialization:

    The TestRule (testWatcher) is initialized inline with the class field declaration.
    This means it is initialized when an instance of FailureJUnit4Test is created,
    which occurs before any test method or @BeforeClass method is executed.
    At the time of testWatcher initialization, the WebDriver (driver) is indeed null.
    However, this does not directly cause an issue because driver is not used immediately.
    It is passed to FailureWatcher, which holds onto it until needed.
     */
    /*
    The key point is that while the WebDriver reference is null at the time of FailureWatcher's initialization,
    it is not null when it is actually used (i.e., when the failed method is called upon test failure).
    This explains why the screenshot functionality is working as expected.

    it works because the WebDriver is not used by FailureWatcher
    until after it has been initialized in the @BeforeClass method.
    This means that by the time a test fails and FailureWatcher needs to take a screenshot,
    the WebDriver is valid and properly initialized.

    When a test fails, the failed method of FailureWatcher is invoked.
    At this point, it uses the WebDriver instance to take a screenshot.
    If the test execution reaches this point,
    it means the WebDriver has already been initialized in the @BeforeClass method, so it is no longer null
     */
