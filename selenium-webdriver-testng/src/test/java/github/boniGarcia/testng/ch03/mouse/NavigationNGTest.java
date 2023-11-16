package github.boniGarcia.testng.ch03.mouse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationNGTest {
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
    public void testNavigation(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.findElement(By.xpath("//a[text()='Navigation']")).click();
        driver.findElement(By.xpath("//a[text()='Next']")).click();
        driver.findElement(By.xpath("//a[text()='3']")).click();
        driver.findElement(By.xpath("//a[text()='2']")).click();
        driver.findElement(By.xpath("//a[text()='Previous']")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println(bodyText);
        assertThat(bodyText).contains("Lorem ipsum");
    }
    @Test
    public void linksOnPage(){
        String initialUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(initialUrl);
        WebElement chapter3 = driver.findElement(By.xpath("//h5[text()='Chapter 3. WebDriver Fundamentals']/.."));
        List<WebElement> chapter3Links = chapter3.findElements(By.tagName("a"));
        System.out.println(chapter3Links.size());
        for (WebElement chapter3Link : chapter3Links) {
            System.out.println(chapter3Link.getText());
        }
        chapter3.findElement(By.xpath("//a[text()='Navigation']")).click();
        driver.findElement(By.xpath("//nav//li/a[text()='3']")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println(bodyText);
        assertThat(bodyText).contains("Excepteur sint occaecat");
    }
      /*
        //a[text()='Navigation']

        //a[contains(text(),'Navigation')]

         */
/*
    check urls:
        System.out.println(driver.getCurrentUrl());
        assertThat(driver.getCurrentUrl()).isEqualTo(initialUrl);
 */
        /*
        If a page change occurs without opening a new tab or window,
        and the URL is simply updated within the current tab/window,
        you do not need a new tab or window handle.
        Selenium WebDriver follows the URL of the current browser window,
        and even if the URL changes, it continues to operate on the same browser window or tab.

        In your test scenario,
        as you mentioned,
        if the page change happens with driver.get()
        or during a click() action within the same tab,
        there's no need for any additional operations.
        WebDriver will automatically wait for the new page to load after such actions
        (there's a default timeout period for this).

        For instance, when you click a link:
        driver.findElement(By.xpath("//nav//li/a[text()='3']")).click();

        If this click leads to a new page being loaded in the current tab,
        WebDriver will wait for the new page to load.
        You don't need to handle any new tabs or windows unless you observe that the click action actually opens one.

        If you notice that a new tab or window has been opened as a result of the click,
        then you would need to switch to the new tab or window using driver.switchTo().window(handle).
        But based on the scenario you've described, it doesn't seem like that is the case.
         */

}
