package github.boniGarcia.testng.ch05.DSL_approach;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactoryLoginPage extends ExtendedBasePage{
    @FindBy(id = "username")
    @CacheLookup
    WebElement userInput;
    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordInput;
    @FindBy(css = "button")
    @CacheLookup
    WebElement submitButton;
    @FindBy(id = "success")
    @CacheLookup
    WebElement successBox;
    /*
    PageFactory class used to initialize all the previously declared web elements with @FindBy (and @FindAll).
     */
    public FactoryLoginPage(String browser) {
        super(browser);
        PageFactory.initElements(driver, this);
        visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }
    public FactoryLoginPage(String browser, int timeoutSec){
        this(browser);
        setTimeoutSec(timeoutSec);
    }
    public void with(String username, String password){
        type(userInput,username);
        type(passwordInput, password);
        click(submitButton);
    }
    public boolean successBoxPresent(){
        return isDisplayed(successBox);
    }
}
    /*  above, a page class that uses these Selenium WebDriver support classes.
/*
    The Page Factory approach is only recommended
    when the web page tested with Selenium WebDriver is static.
    This approach can lead to undesirable effects such as stale web elements
    (i.e., old or no-longer-available elements) when using dynamic web pages.
 */
