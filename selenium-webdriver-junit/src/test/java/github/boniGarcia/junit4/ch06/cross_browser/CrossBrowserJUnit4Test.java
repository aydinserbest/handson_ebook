package github.boniGarcia.junit4.ch06.cross_browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CrossBrowserJUnit4Test {
    WebDriver driver;
    @Parameter
    String browserName;

    @Parameters(name = "{index}: browser={0}")
    public static Collection<Object[]>data(){
        return Arrays.asList(
                new Object[][] {{"chrome"},{"firefox"}});
    }
    @Before
    public void setup(){driver = WebDriverManager.getInstance(browserName).create();
    }
    @Test
    public void testCrossBrowser() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }
}
/*
    if we write like this:
     public static Collection<Object[][]>data(){
     gives error
 */
/*
    In Java, when you define a method that is supposed to return a collection of arrays,
    the type of the collection should match the type of the arrays you are returning.
    In the method signature:

    public static Collection<Object[]> data() { ... }

    Collection<Object[]> indicates that the method will return a collection,
    and each item in this collection will be an Object array.
    The Object[] represents a single-dimensional array of Objects.

    If you change the method signature to:

    public static Collection<Object[][]> data() { ... }

    This now indicates that the method will return a collection of two-dimensional arrays (Object[][]).
    In this case, each item in the collection should itself be an array of Object arrays.

    However, the data you are returning:

    return Arrays.asList(new Object[][] {{"chrome"}, {"firefox"}});

    is a single-dimensional array of Object arrays, where each Object array contains a single String.
    Therefore, the method signature Collection<Object[][]> is incorrect
    because it expects each item in the collection to be a two-dimensional array.

    To fix this, you should use Collection<Object[]> as the return type
    since you are returning a list of one-dimensional Object arrays.
    Here's the correct way to write your method:


    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"chrome"},
            {"firefox"}
        });
    }


    Method Explanation and Example
    In the data method, we define a collection of arrays with the return type Collection<Object[]>.
    This indicates that the method returns a collection
    where each element is a one-dimensional array of objects (Object[]).

    When we specify new Object[][] {{"chrome"}, {"firefox"}}, we're creating a one-dimensional array of Object arrays.
    Each inner array contains one element. In this context, {"chrome"} and {"firefox"} are one-dimensional arrays.

    Here's the correct method definition:

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"chrome"},
            {"firefox"}
        });
    }
    In this example, we use Arrays.asList to create a collection from our array of Object arrays.
    Each inner array is treated as a separate element in the collection.

    If we were to change the method signature to Collection<Object[][]>,
    Java would expect each element of the collection to be a two-dimensional array,
    which is not what we are returning. Hence, we use Collection<Object[]>
    to match the type of the data we are providing.

    This explanation provides a clear understanding of how the types correspond
    to the data structure being returned by the method.
 */
