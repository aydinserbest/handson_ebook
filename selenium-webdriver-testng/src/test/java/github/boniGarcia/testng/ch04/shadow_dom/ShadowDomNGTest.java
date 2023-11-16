package github.boniGarcia.testng.ch04.shadow_dom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShadowDomNGTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testShadowDom() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        WebElement content = driver.findElement(By.id("content"));
        SearchContext shadowRoot = content.getShadowRoot();
        WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
        assertThat(textElement.getText()).contains("Hello Shadow DOM");
    }
}
    /*
    In recent versions of Selenium, there's indeed an improved way to interact with elements inside a Shadow DOM.
    The getShadowRoot() method was introduced to simplify the process of accessing the shadow DOM.
     */
    /*
    We locate the shadow host element. We get the shadow root from the host element.
    As a result, we get an instance of SearchContext,
    an interface implemented by WebDriver and WebElement,
    that allows us to find elements using the methods findElement() and findElements().

     */
    /*
    With this shadowRoot object,
    you can call findElement or findElements to search for elements inside the Shadow DOM
    in the same way you would search for elements in the main DOM using a WebElement or WebDriver object.
     */
/*
    The shadowRoot here represents the shadow tree,
    and the findElement method will search for elements specifically within this tree.
    When you call findElement on shadowRoot,
    it is scoped to the elements inside the Shadow DOM of the content element.
 */