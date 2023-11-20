package github.boniGarcia.testng.ch06.cross_browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CrossBrowserNGTest {
    WebDriver driver;
    @DataProvider(name = "browsers")
    public static Object[][] data(){return new Object[][]{{"chrome"},{"firefox"}};}
    @AfterMethod
    public void teardown(){driver.quit();}
    @Test(dataProvider = "browsers")
    public void testCrossBrowser(String browserName){
        //We specify three browsers using their names.
        driver = WebDriverManager.getInstance(browserName).create();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }
    /*
    This test is executed two times, using a different browser (Chrome and Firefox) each time.

    We need to create the WebDriver instance in the test logic
    since the test parameters are injected in the test method when using TestNG.
     */
    /*
    In TestNG, you cannot directly use a DataProvider with a @BeforeMethod or @BeforeClass annotation.
    The DataProvider is specifically designed to supply data to test methods (annotated with @Test),
    not to setup methods.

    Why Not with @BeforeMethod or @BeforeClass?
    Purpose: DataProvider is intended to provide different sets of data to a test method,
    potentially causing the method to be run multiple times with different data each time.
    Scope: Setup methods like those annotated with @BeforeMethod or @BeforeClass are intended
    for preparing the test environment, not for running tests with multiple sets of data.

    Alternative Approaches in TestNG:
    Initialization within Test Method: As you've seen in your CrossBrowserNGTest class,
    you can initialize the necessary components directly
    within the test method using the data from the DataProvider.

    Using Parameters with XML Suite Files: TestNG allows you to pass parameters to your test methods
    (including @BeforeMethod and @BeforeClass) through your XML suite files.
    However, this approach doesn't offer the same flexibility
    as DataProvider in terms of dynamically generating data sets.

    Factory Method: If you need to create instances of your test class with different parameters,
    you can use a @Factory annotation. This is a more complex setup and is typically used
    when the parameters need to influence the entire test class, not just individual methods.

    In summary, while TestNG's DataProvider is a powerful tool for data-driven tests,
    it's specifically designed to work with @Test methods and doesn't directly apply
    to setup or teardown methods.
     */
}
