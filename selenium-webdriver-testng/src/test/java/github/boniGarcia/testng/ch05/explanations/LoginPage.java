package github.boniGarcia.testng.ch05.explanations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    WebDriverWait wait;
    // Locators for the login page
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("loginButton");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Encapsulated method to find elements
    private WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // Encapsulated method to perform click action
    private void click(By locator) {
        find(locator).click();
    }
    // Public methods that use the encapsulated find and click methods
    public void enterUsername(String username) {
        WebElement usernameField = find(usernameLocator);
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password) {
        WebElement passwordField = find(passwordLocator);
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLogin() {
        click(loginButtonLocator);
    }
}
