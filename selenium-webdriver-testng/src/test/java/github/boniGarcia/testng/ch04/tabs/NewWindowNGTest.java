package github.boniGarcia.testng.ch04.tabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class NewWindowNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    /*
    The test testNewWindow() appears to be a Selenium WebDriver test written in Java,
    which automates browser actions to test web applications.
     */
    @Test
    public void testNewWindow()  {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        //We get the current window handle.
        String initHandle = driver.getWindowHandle();
        /*
        here we have an open browser window,
        the line below will open another browser window, completely separate from the one you're currently looking at,
        at the same time you will have two separate browser windows.
        so, We open another web page

         */
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(driver.getWindowHandles().size()).isEqualTo(2);

        driver.switchTo().window(initHandle);
        //We close only the current window.(actually the first opened page)
        //The second tab remains open.
        driver.close();
        assertThat(driver.getWindowHandles().size()).isEqualTo(1);
    }
    @Test
    public void newTab() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/");
        String initHandle = driver.getWindowHandle();
        /*
        instead of opening a new browser window,
        Selenium WebDriver will open a new tab in the existing browser window.
        and change the focus to it.
         */
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(driver.getWindowHandles().size()).isEqualTo(2);
        /*
        We change the focus to the initial window (using its handle).
         */

        driver.switchTo().window(initHandle);
        //We close only the current window.(actually the first opened page)
        //The second tab remains open.
        driver.close();
        assertThat(driver.getWindowHandles().size()).isEqualTo(1);
    }
}
