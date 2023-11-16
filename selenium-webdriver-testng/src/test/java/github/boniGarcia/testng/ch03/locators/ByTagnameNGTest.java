package github.boniGarcia.testng.ch03.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ByTagnameNGTest {
    WebDriver driver;

    /*
    Using WebDriverManager.chromedriver().create()
    does the job of both
    WebDriverManager.chromedriver().setup();
    and
    WebDriver driver = new ChromeDriver(); in one line.
    So, you can replace those two lines with just WebDriverManager.chromedriver().create();
    to make your code shorter and cleaner.
     */
    @BeforeMethod
    public void setup(){
        //driver = WebDriverManager.chromedriver().create();
        driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
    }
    /*
    the create() method from the WebDriverManager might be handling the WebDriver lifecycle automatically,
    which would include shutting down the WebDriver instance once the test finishes
    When you use WebDriverManager.chromedriver().create(),
    WebDriverManager adds a shutdown hook to ensure these objects are correctly released before the JVM shuts down,
    closing the browser automatically without calling driver.quit().
    To prevent this,
    you can use avoidShutdownHook() like so: driver = WebDriverManager.chromedriver().avoidShutdownHook().create();.
    However, if you use WebDriverManager.chromedriver().setup(),
    this automatic browser closing behavior doesn't happen.
     */
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement textarea = driver.findElement(By.tagName("textarea"));
        assertThat(textarea.getDomAttribute("rows")).isEqualTo("3");
    }

    /*
    getAttribute retrieves the rendered value of the attribute,
    which may change due to dynamic updates like JavaScript.

    getDomAttribute gets the current value from the DOM, which is the original value in the HTML.

    Use getAttribute for rendered values, and getDomAttribute for original values in the DOM.
     */
}
