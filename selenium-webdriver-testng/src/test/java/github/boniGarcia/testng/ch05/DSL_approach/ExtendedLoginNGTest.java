package github.boniGarcia.testng.ch05.DSL_approach;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
    /*
    Notice that this test does not contain any single call to Selenium WebDriver or WebDriverManager.
    The page class encapsulates all the low-level details of the interaction with the browser,
    exposing a high-level, readable API used in the test.
     */

public class ExtendedLoginNGTest {
    ExtendedLoginPage loginPage;
    //We instantiate the page object, simply specifying the browser type to be used (chrome in this case).
    @BeforeMethod
    public void setup(){
        loginPage = new ExtendedLoginPage("chrome");
    }
    @AfterMethod
    public void teardown(){
        loginPage.teardown();
    }
    @Test
    public void testLoginSuccess(){
        loginPage.with("user","user");
        assertThat(loginPage.successBoxPresent()).isTrue();
    }
    @Test
    public void testLoginFailure(){
        loginPage.with("bad-user","bad-user");
        assertThat(loginPage.successBoxPresent()).isFalse();
    }
}
