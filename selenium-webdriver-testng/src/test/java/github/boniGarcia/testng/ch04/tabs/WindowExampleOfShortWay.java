package github.boniGarcia.testng.ch04.tabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowExampleOfShortWay {

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
    @Test
    public void testNewTabWithKeys() {
        String initPage = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(initPage);

        Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;
        String openInNewTab = Keys.chord(modifier, Keys.RETURN);

        driver.findElement(By.linkText("Web form")).sendKeys(openInNewTab);
    //instead of the line below:
        //Set<String> windowHandles = driver.getWindowHandles();
        /*
        Directly iterate over the set of window handles returned by driver.getWindowHandles()
        instead of storing them in a separate Set variable. This approach is more concise and
        eliminates the need for an extra variable when we only need to iterate over the window
        handles once to find and switch to the new window.
         */

        assertThat(driver.getWindowHandles().size()).isEqualTo(2);

        for (String windowHandle : driver.getWindowHandles()) {
            if (driver.getWindowHandle().equals(windowHandle)) {
                assertThat(driver.getCurrentUrl()).isEqualTo(initPage);
                //If the current window handle does not match the windowHandle from the Set,
                // it means we've found the new tab/window.
            } else {
                driver.switchTo().window(windowHandle);
                assertThat(driver.getCurrentUrl()).isNotEqualTo(initPage);
            }
        }
        driver.close();
        assertThat(driver.getWindowHandles().size()).isEqualTo(1);


    }
    @Test
    public void testNewWindow()  {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String initHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        //instead of the line below:
        //Set<String> windowHandles = driver.getWindowHandles();
        /*
        Directly iterate over the set of window handles returned by driver.getWindowHandles()
        instead of storing them in a separate Set variable. This approach is more concise and
        eliminates the need for an extra variable when we only need to iterate over the window
        handles once to find and switch to the new window.
         */
        assertThat(driver.getWindowHandles().size()).isEqualTo(2);

        driver.switchTo().window(initHandle);
        //We close only the current window.(actually the first opened page)
        //The second tab remains open.
        driver.close();
        assertThat(driver.getWindowHandles().size()).isEqualTo(1);
    }
}
/*
    inside the FramesNGTest  class, we used a wait line:

    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pName, 0));
    for window tabs we can use also like this:

    new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.numberOfWindowsToBe(2));
 */
