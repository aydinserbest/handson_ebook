package github.boniGarcia.testng.ch03.user_gestures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class ContextAndDoubleClickNGTest {
    /*
    On this page,
    the first dropdown menu appears when clicking on its button,
    the second one uses the right-click,
    and the third one requires a double-click.

     */
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        // FIXME: pause for manual browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void testContextAndDoubleClick() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
        Actions actions = new Actions(driver);
        WebElement dropdown2 = driver.findElement(By.id("my-dropdown-2"));
        //We use contextClick() in the middle dropdown menu.
        actions.contextClick(dropdown2).build().perform();
        WebElement contextMenu2 = driver.findElement(By.id("context-menu-2"));
        //We verify the middle menu is correctly displayed.
        assertThat(contextMenu2.isDisplayed()).isTrue();

        WebElement dropDown3 = driver.findElement(By.id("my-dropdown-3"));
        //We use doubleClick() in the right dropdown menu.
        actions.doubleClick(dropDown3).build().perform();
        WebElement contextMenu3 = driver.findElement(By.id("context-menu-3"));
        //We verify the right menu is correctly displayed.
        assertThat(contextMenu3.isDisplayed()).isTrue();
    }
    /*
    Selenium WebDriver provides the class Actions,
    a powerful asset to automate different user actions, both for keyboard and mouse.
    This class follows the builder pattern. This way, you can chain several methods
    (i.e., different actions) and perform all of them at the end by calling build().

     */
}
