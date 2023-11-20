package github.boniGarcia.junit4.ch06.cross_browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Enum_Example {
    WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
    }
}
/*
    We're using WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
    to download and set up the ChromeDriver binary if it's not already present.
    This is an alternative to setting the path to the ChromeDriver binary manually.

    Then we create an instance of ChromeDriver as usual with new ChromeDriver();
    and use it in our test.

    The getInstance() method combined with DriverManagerType is more flexible
    because it allows you to specify the driver type at runtime,
    which is why it's useful in parameterized tests.
 */
