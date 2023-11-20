package github.boniGarcia.junit4.ch06.cross_browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CrossBrowserByClassJUnit4Test {
    WebDriver driver;
    @Parameter
    public Class<? extends WebDriver> webdriverClass;
    @Parameters(name = "{index}: browser={0}")
    public static Collection<Object[]>data(){
        return Arrays
                .asList(new Object[][]{ { ChromeDriver.class },
                        { FirefoxDriver.class } });
    }
    @Before
    public void setup() {
        driver = WebDriverManager.getInstance(webdriverClass).create();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testCrossBrowserByClass() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }

}
