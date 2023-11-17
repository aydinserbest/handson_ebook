package github.boniGarcia.junit4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ParameterizedJUnit4Test {
    WebDriver driver;
    @Parameter  // the default index is implied to be 0
    public String username;
    @Parameter(1)  // you can start indexing from 1 if you've omitted the index for the first parameter
    public String password;
    @Parameter(2)
    public String expectedText;

    @Before
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @After
    public void teardown(){driver.quit();}
    @Parameters(name = "{index}: username={0} password={1} expectedText={2}")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] { { "user", "user", "Login successful" },
                        { "bad-user", "bad-passwd", "Invalid credentials" } });
    }
    @Test
    public void testParameterized() {
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
    In JUnit, there are two separate methods:
    one through the constructor and the other by directly injecting into class variables with annotations.

    Constructor Method:
    Parameters are assigned to class variables using the constructor of the test class.
    In this method, variables are usually defined as private since access is provided through the constructor.

    Annotation Method:
    Using the @Parameter annotation, parameters determined by the JUnit test runner for each test
    are directly assigned to public class variables. In this method,
    it is usually necessary for the variables to be public,
    because the test runner directly accesses and assigns values to these variables.

    When conducting parameterized tests with JUnit,
    it is necessary for the variables of the test class to be accessible so that the test runner
    can inject parameter values into them.

    The test runner should be able to directly access these variables to inject the parameters,
    therefore, defining the variables as public usually meets this requirement.

    In TestNG, however, parameters are typically given as method parameters,
    and thus the access levels of the class variables can vary.
 */


