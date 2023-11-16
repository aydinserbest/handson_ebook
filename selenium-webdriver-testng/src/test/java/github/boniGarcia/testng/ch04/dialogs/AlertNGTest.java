package github.boniGarcia.testng.ch04.dialogs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }
    @Test
    public void testAlert() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //We click on the left button to launch a JavaScript alert.
        driver.findElement(By.id("my-alert")).click();
        //We wait until the alert dialog is displayed on the screen.
        wait.until(ExpectedConditions.alertIsPresent());    // 3
        //We change the focus to the alert pop-up.
        Alert alert = driver.switchTo().alert();           // 3
        //We verify that the alert text is as expected.
        assertThat(alert.getText()).isEqualTo("Hello world!");
        //We click on the OK button of the alert dialog.
        alert.accept();
    }
    /*
    We can replace steps 3 and 4 with a single explicit wait statement, as follows,
    The line Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    in the testAlert2 method might appear to be doing two things at once – waiting for the alert and switching to it,
     it's actually a clever use of the WebDriverWait and ExpectedConditions classes in Selenium.
     */
    @Test
    public void testAlert2() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.id("my-alert")).click();
        /*
        Handling the Alert:
    When ExpectedConditions.alertIsPresent() becomes true (i.e., when the alert is displayed on the web page),
    it doesn't just return true; instead, it returns the Alert object that represents the currently active alert dialog.
    This is a key point: the condition itself is responsible
    for both checking for the presence of the alert and returning the Alert object.
         */
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertThat(alert.getText()).isEqualTo("Hello world!");
        alert.accept();
    }
    /*
    By writing Alert alert = wait.until(ExpectedConditions.alertIsPresent());,
    you're instructing Selenium to wait until the alert is present
    and then assign the returned Alert object to the variable alert.
    This effectively combines the waiting and the switching to the alert into a single step.

    In summary,
    this approach doesn't explicitly use the driver.switchTo().alert() method
    because the ExpectedConditions.alertIsPresent() condition implicitly handles the switching
    as part of its implementation. When this condition is met,
    it returns the Alert object, which can then be used to interact with the alert (e.g., getting its text or accepting it).
    This makes the code more concise without sacrificing clarity or functionality.
     */
    @Test
    public void testAlert3()  {
        driver.get("https://demoqa.com/alerts");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("#alertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();
    }
}
