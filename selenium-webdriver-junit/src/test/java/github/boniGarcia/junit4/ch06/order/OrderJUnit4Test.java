package github.boniGarcia.junit4.ch06.order;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
/*
    This annotation ensures that the test methods within the class are executed in alphabetical order by their names.
    In your case, the execution order will be testA -> testB -> testC.

    We use the annotation @FixMethodOrder at the class level to fix the order of the tests available in this class.

    Since the test names are lexicographically ordered (testA, testB, and testC),
    the test execution will follow this sequence.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderJUnit4Test {
    static WebDriver driver;

    /*
    We create the driver instance before all tests (since we want to use the WebDriver session in all the tests).
     */
    @BeforeClass
    public static void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterClass
    public static void teardown(){driver.quit();}
    @Test
    public void testA() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/navigation1.html");
        assertBodyContains("Lorem ipsum");
    }
    @Test
    public void testB(){
        driver.findElement(By.linkText("2")).click();
        assertBodyContains("Ut enim");
    }
    @Test
    public void testC() {
        driver.findElement(By.linkText("3")).click();
        assertBodyContains("Excepteur sint");
    }
    void assertBodyContains(String text) {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText).contains(text);
    }
}
