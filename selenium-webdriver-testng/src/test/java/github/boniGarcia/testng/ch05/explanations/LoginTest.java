package github.boniGarcia.testng.ch05.explanations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
        loginPage = new LoginPage(driver);
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://example.com/login");
        loginPage = new LoginPage(driver);
    }
    @Test
    public void testLogin() {
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("testpass");
        loginPage.clickLogin();
        // Further assertions to verify the login was successful could follow here
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
