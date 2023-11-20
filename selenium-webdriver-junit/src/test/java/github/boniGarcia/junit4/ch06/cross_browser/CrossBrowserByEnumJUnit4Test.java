package github.boniGarcia.junit4.ch06.cross_browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CrossBrowserByEnumJUnit4Test {
    WebDriver driver;
    @Parameter
    public DriverManagerType driverManagerType;
    @Parameters(name = "{index}: browser={0}")
    public static Collection<Object[]>data(){
        return Arrays
                .asList(new Object[][]{{CHROME},{FIREFOX}});
    }
    @Before
    public void setup(){
        driver = WebDriverManager.getInstance(driverManagerType).create();
    }
    @After
    public void teardown(){driver.quit();}
    @Test
    public void testCrossBrowser(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }
}
