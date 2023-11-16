package github.boniGarcia.testng.ch03.locators_compound;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ByChainedNGTest {
    WebDriver driver;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testByChained(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        /*
        In the XPath query:
                driver.findElement(By.xpath("//form//div[@class='row']"));

        //form: Finds the <form> tag throughout the entire page.
        //: Searches for any sub-elements at any depth following the found <form> tag.
        div[@class='row']: Searches for the <div> tag with the class attribute "row".

        This XPath query locates all <div> tags with the class attribute "row" inside a <form> tag on the page
        (it doesn't have to be directly under it; it can be at any sub-level).
         */

        List<WebElement> rowsInForm = driver.findElements(new ByChained(By.tagName("form"), By.className("row")));
        /*
        Using ByChained:
        By utilizing ByChained(By.tagName("form"), By.className("row")),
        you can find elements under the <form> tag that have the class attribute "row".
        This method is more specific for finding elements under a particular parent element.
        It first finds the <form> tag, and then searches for <div> tags with the class attribute "row" under this tag.
        ByChained(By.tagName("form"), By.className("row")) initially locates all <form> tags.
        Subsequently, it searches for elements with the class attribute "row" among the children of each of these <form> tags.
         */
        /*
        ByChained(By.tagName("form"), By.className("row")) performs a similar search. It first finds the <form> tag
         and then searches for <div> tags with the class attribute "row" under this tag.

         */

        assertThat(rowsInForm.size()).isEqualTo(1);
        /*
        The line is used to verify that there is only one element that meets these conditions.
        In other words,
        this test checks whether there is exactly one <div> tag
        with the class attribute "row" inside a <form> tag on the page.
         */
    }
}
