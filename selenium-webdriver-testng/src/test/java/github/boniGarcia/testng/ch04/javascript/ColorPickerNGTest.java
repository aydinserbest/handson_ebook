package github.boniGarcia.testng.ch04.javascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

        /*
        A color picker in HTML is an input type that allows users to select a color
        by clicking and dragging the cursor using a graphical area.
        The practice web form contains one of these elements,
        and it illustrates how to interact with this color picker.
         */

public class ColorPickerNGTest {
    static final Logger log = getLogger(lookup().lookupClass());
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        //FIXME: pause for manuel browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }

    @Test
    public void testColorPicker() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        String initColor = colorPicker.getAttribute("value");
        log.debug("The initial color is {}", initColor);

         /*
        A Color object is created to represent the color red with an RGBA value of 255, 0, 0, 1.
         */
        Color red = new Color(255, 0, 0, 1);
         /*
        A JavaScript command is constructed as a string.
        This command will change the value attribute of the first argument
        (which will be the color picker element) to the hexadecimal representation of the red color.
         */
        String script = String.format(
                "arguments[0].setAttribute('value', '%s');", red.asHex());
        js.executeScript(script, colorPicker);

        String finalColor = colorPicker.getAttribute("value");
        log.debug("The final color is {}", finalColor);
        /*
        The test asserts that the final color is not the same as the initial color,
        confirming that the color has been changed.
         */
        assertThat(finalColor).isNotEqualTo(initColor);
        /*
        Furthermore, it asserts that the final color value is equivalent to the red color
        defined by the Color object.
         */
        assertThat(Color.fromString(finalColor)).isEqualTo(red);
    }
}
