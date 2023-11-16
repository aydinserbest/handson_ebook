package github.boniGarcia.testng.ch04.javascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScrollIntoViewNGTest {
    /*
    this example shows another test using scrolling
    and the same example web page as before.
    This time, instead of moving a fixed number of pixels,
    we move the document scroll until the last paragraph in the web page.
     */
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        // FIXME: pause for manual browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }

    @Test
    public void testScrollIntoView() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        /*
        The cast (JavascriptExecutor) driver: Here you're telling the Java compiler,
        "I know that this driver object is not just a WebDriver, but also a JavascriptExecutor.
        Please treat it as such." This allows you to call JavascriptExecutor methods on the driver object.
         */
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement lastElement = driver.findElement(By.cssSelector("p:last-child"));
        String script = "arguments[0].scrollIntoView();";
        js.executeScript(script, lastElement);
    }
    /*
    In CSS, p:last-child selects the last <p> element among a group of siblings,
    only if it is the last child of its parent.

    To translate this to XPath, you would write:
    //p[last()]

    This XPath selects the last <p> element within its parent.
    However, this is not entirely equivalent to the CSS p:last-child selector.
    The CSS selector only selects a paragraph that is the last child,
    regardless of its type, while the XPath //p[last()] selects the last <p> element,
    but doesn't ensure it's the last child of any type.

    If you want to ensure that the <p> is indeed the last child,
    similar to p:last-child,
    you'd need a more complex XPath:

    //p[not(following-sibling::*)]
    This means "select a <p> element
    that does not have any following siblings," which is effectively what p:last-child does in CSS.

     */
}
