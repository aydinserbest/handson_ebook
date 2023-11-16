package github.boniGarcia.testng.ch05.DSL_approach;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class ExtendedBasePage {
    static final Logger log = getLogger(lookup().lookupClass());
    WebDriver driver;
    WebDriverWait wait;
    int timeoutSec = 5; // wait timeout (5 seconds by default)
    /*in this case, this class also encapsulates the required logic to create a WebDriver instance.
    /*
    We use WebDriverManager to resolve the required driver and create the WebDriver instance.
    WebDriverManager allows the use of a parameterized manager by invoking the method getInstance().
    In this case, we use the browser name (e.g., chrome, firefox, etc.) to select the manager.
     */
    public ExtendedBasePage(String browser){
        this.driver = WebDriverManager.getInstance(browser).create();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }

    public void setTimeoutSec(int timeoutSec){
        if (timeoutSec < 0) {
            throw new IllegalArgumentException("Timeout cannot be negative.");
        }
        this.timeoutSec = timeoutSec;
        // Update the wait object with the new timeout
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }

    public void teardown(){
        if (driver != null){
            driver.quit();
        }
    }
    public void visit(String url){
        driver.get(url);
    }
    public WebElement find(By element){
        return driver.findElement(element);
    }
    public void click(WebElement element){element.click();}
    public void click(By element){click(find(element));}
    public void type(WebElement element, String text){element.sendKeys(text);}
    public void type(By element, String text){type(find(element), text);}
    public boolean isDisplayed(WebElement element) {
        return isDisplayed(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayed(By locator) {
        return isDisplayed(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public boolean isDisplayed(ExpectedCondition<?> expectedCondition) {
        try {
            wait.until(expectedCondition);
        } catch (TimeoutException e) {
            log.warn("Timeout of {} wait for element ", timeoutSec);
            return false;
        }
        return true;
    }
}
/*
    These methods abstract the underlying Selenium WebDriver details,
    making the test scripts more about the business logic
    and user interactions rather than the technical details of Selenium commands.
 */
