package github.boniGarcia.testng.ch06.cross_browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CrossBrowserNGTest {
    WebDriver driver;
    @DataProvider(name = "browsers")
    public static Object[][] data(){return new Object[][]{{"chrome"},{"firefox"}};}
    @AfterMethod
    public void teardown(){driver.quit();}
    @Test(dataProvider = "browsers")
    public void testCrossBrowser(String browserName){
        driver = WebDriverManager.getInstance(browserName).create();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }
}
