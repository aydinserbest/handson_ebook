package github.boniGarcia.junit4.ch06.parametrized;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class JUnit4ParameterizedWithConstructorTest {
    WebDriver driver;
    private String username;
    private String password;
    private boolean success;
    @Before
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @After
    public void teardown(){driver.quit();}

    public JUnit4ParameterizedWithConstructorTest(String username, String password, boolean success) {
        this.username = username;
        this.password = password;
        this.success = success;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"user1", "pass1", true},
                {"user2", "pass2", false}
        });
    }

    @Test
    public void testLogin() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        if (success) {
            assertThat(bodyText).contains("Login successful");
        } else {
            assertThat(bodyText).contains("Invalid credentials");
        }
        /*
        n the first approach (ParameterizedJUnit4Test), the expected text
        (such as "Login successful" or "Invalid credentials") is directly provided as a parameter
        and stored in expectedText.
        The assertion directly checks if bodyText contains expectedText.
        This approach is more flexible as it allows each test case to specify exactly what text it expects.

    In the second approach (JUnit4ParameterizedWithConstructorTest),
    the expected outcome is determined based on a boolean (success). The test checks the success flag,
    and based on its value, it asserts different expected texts. This approach is slightly less flexible,
    as it assumes only two possible outcomes and ties them to the success flag.

    I chose the second approach to demonstrate an alternative way to handle assertions based on a condition
    (success in this case). However, if you prefer the flexibility of the first approach,
    you can modify the second class to use an expectedText parameter instead of the boolean success
         */
    }
    }
    /*
    I defined the variables as private because I wanted to demonstrate parameter passing through the constructor,
    and in this case, there is no need for external access to the variables.

    However, in the ParameterizedJUnit4Test class, the method of directly injecting into class variables
    with annotations has been used.
    In this case, it is usually necessary for the variables to be public,
    because the test runner directly accesses and assigns values to these variables.

    There is a difference between the example I provided in my previous answers and the one you presented.
    In your example, the class variables are marked with the @Parameter annotation
    and an index is assigned to each of these variables. The JUnit test runner
    takes each array of objects provided by the @Parameters and assigns each value in these arrays
    to the variables marked with @Parameter(0), @Parameter(1), etc., respectively.

    This is an alternative way of writing parameterized tests in JUnit 4.
    Structurally, it serves the same function: it provides a way to run your tests with different parameters.
    However, this method allows you to inject your test data directly into the fields of the class
    and does not pass parameters through the constructor. This can provide cleaner
    and more readable code in some cases.
    Both methods are valid for conducting parameterized tests with JUnit 4.
     */
    /*
    I set the variables in my class to be private
    because my goal was to showcase how parameters can be passed through a constructor;
    this approach doesn't require the variables to be accessible from outside the class.

    On the other hand, in the ParameterizedJUnit4Test class,
    the technique of directly injecting values into class variables via annotations is employed.
    With this technique, class variables need to be public since the test runner will directly access
    and assign values to them.

    To explain the difference with an example:
    in your case, each class variable is tagged with the @Parameter annotation
    and assigned a specific index. The JUnit test runner then assigns each value from the data collection
    provided by @Parameters to the corresponding class variable marked with @Parameter(0), @Parameter(1), etc.

    This method is just another way to write parameterized tests in JUnit 4,
    offering a direct way to inject data into class fields without using a constructor,
    potentially leading to neater and more straightforward code. Both this method
    and the constructor-based approach are acceptable for creating parameterized tests in JUnit 4.

     */