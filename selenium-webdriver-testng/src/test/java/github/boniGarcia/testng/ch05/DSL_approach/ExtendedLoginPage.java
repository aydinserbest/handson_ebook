package github.boniGarcia.testng.ch05.DSL_approach;

import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtendedLoginPage extends ExtendedBasePage{
    By usernameInput = By.id("username");
    By passwordInput = By.id("password");
    By submitButton = By.cssSelector("button");
    By successBox = By.id("success");

    public ExtendedLoginPage(String browser) {
        super(browser);
        visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }
    public ExtendedLoginPage(String browser, int timeoutSec){
        this(browser);
        setTimeoutSec(timeoutSec);
    }
    public void with(String username, String password){
        type(usernameInput, username);
        type(passwordInput, password);
        click(submitButton);
    }
    public boolean successBoxPresent(){
        return isDisplayed(successBox);
    }
}
