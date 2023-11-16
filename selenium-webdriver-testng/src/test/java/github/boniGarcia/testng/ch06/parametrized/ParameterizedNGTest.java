package github.boniGarcia.testng.ch06.parametrized;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParameterizedNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @DataProvider(name = "LoginData")
    public static Object[][] data(){
        return new Object[][]{{"user","user","Login successful"},
                {"bad-user", "bad-user", "Invalid credentials"}};
    }
    @Test(dataProvider = "LoginData")
    public void testParameterized(String username, String password,
                                  String expectedText){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText).contains(expectedText);
    }
}
/*
    A notable difference between JUnit 4 and TestNG regarding parameterized tests is that
    the parameters (username, password, and expected test in this example) are injected in TestNG
    as test method parameters.
 */
/*
    We can use the annotation @DataProvider to decorate the method that provides the test parameters
    in a parameterized TestNG test. As you can see above,
    this method returns a double array of general Java objects.
    The annotation @DataProvider should provide a name as an attribute.
    This name is later used in the @Test method to specify the data provider.
    Finally, the parameters are injected into the test method.
 */
