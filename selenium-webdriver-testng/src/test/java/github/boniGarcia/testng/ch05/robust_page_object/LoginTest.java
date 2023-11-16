package github.boniGarcia.testng.ch05.robust_page_object;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    void testLoginSuccess() {
        loginPage.with("user","user");
        assertThat(loginPage.successBoxPresent()).isTrue();
    }
    @Test
    void testLoginFailure() {
        loginPage.with("bad-user","bad-user");
        assertThat(loginPage.successBoxPresent()).isFalse();
    }
}
