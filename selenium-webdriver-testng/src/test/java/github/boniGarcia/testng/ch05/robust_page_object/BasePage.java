package github.boniGarcia.testng.ch05.robust_page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BasePage {
    static final Logger log = getLogger(lookup().lookupClass());
    WebDriver driver;
    /*
    We define an explicit wait (WebDriverWait) attribute in the base class.
    We instantiate this attribute in the constructor using a default timeout value (five seconds in this example).
     */
    WebDriverWait wait;
    int timeoutSec = 5; // wait timeout (5 seconds by default)

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait =new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }
    /*
     We create a setter method to change the default value for the wait timeout.
     For instance, we might need to adjust this timeout depending on the system response time.
     */
    public void setTimeoutSec(int timeoutSec){this.timeoutSec = timeoutSec;}
    /*
    We create several common methods that page classes can reuse, such as
    visit() (to open a web page), find() (to locate a web element),
    or type() (to send data to a writable element, such as an input field).
     */
    public void visit(String url){driver.get(url);}
    public WebElement find(By element){
        return driver.findElement(element);
    }
    public void click(By element){find(element).click();}
    public void type(By element, String text){find(element).sendKeys(text);}
    /*
    We implement a method to check if a web element is displayed or not.
    Notice that this method hides the complexity of waiting for this element,
    returning a simple boolean value that tests can use.
     */
    public boolean isDisplayed(By locator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (TimeoutException e){
            log.warn("Timeout of {} wait for {}", timeoutSec,locator);
            return false;
        }
        return true;
    }
}
