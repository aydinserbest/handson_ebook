package github.boniGarcia.testng.ch04.tabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class MultipleWindows {
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
    public void multipleWindows1() {

        // go to webpage
        driver.get("https://the-internet.herokuapp.com/windows");

        // get the title of current page
        System.out.println("Title Before New Window = " + driver.getTitle());

        // get the id of current page
        System.out.println("Id of First Window = " + driver.getWindowHandle());

        // click on "Click Here"
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //driver.findElement(By.linkText("Click Here"));


        // assign the id of the current tab to a String variable
        String currentTab = driver.getWindowHandle();

        // assign the ids of the tabs to a Set variable
        Set<String> windowHandles = driver.getWindowHandles();

        // take the ids of the tabs and compare them one by one to the id of the current tab
        // then switch to the new tab that is different to teh current tab
        for (String tab : windowHandles) {
            if(!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        System.out.println("Title After New Window = " + driver.getTitle());
        System.out.println("Id of Second Tab = " + driver.getWindowHandle());
    }

    @Test
    public void multipleWindows2() {

        // go to webpage
        driver.get("https://the-internet.herokuapp.com/windows");

        // get the title of current page
        System.out.println("Title Before New Window = " + driver.getTitle());

        // get the id of current page
        System.out.println("Id of First Window = " + driver.getWindowHandle());

        // click on "Click Here"
        //driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        driver.findElement(By.linkText("Click Here")).click();

            //if we have a BrowserUtils class, we can put the process below inside a method -switchToWindow-
        //BrowserUtils.switchToWindow("New Window");
        //System.out.println(driver.getTitle()+"TESSSSSSTTTTT");

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {

            driver.switchTo().window(tab);

            if(driver.getTitle().equals("New Window")) {
                break;
            }
        }
        System.out.println("Title After New Window = " + driver.getTitle());
        System.out.println("Id of Second Tab = " + driver.getWindowHandle());
    }
}
