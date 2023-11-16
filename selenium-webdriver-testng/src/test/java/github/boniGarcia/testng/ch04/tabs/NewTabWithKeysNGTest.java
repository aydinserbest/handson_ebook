package github.boniGarcia.testng.ch04.tabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static java.lang.invoke.MethodHandles.lookup;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class NewTabWithKeysNGTest {
    static final Logger log = getLogger(lookup().lookupClass());

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
    public void testNewTabWithKeys() {
        String initPage = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(initPage);
        /*
        It then determines the correct key modifier to use based on the operating system.
        For Mac OS, it uses the Command key (Keys.COMMAND), and for other systems,
        it uses the Control key (Keys.CONTROL). This is necessary for the next step, which involves a keyboard shortcut.
         */

        Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;
        /*
        The test creates a keyboard shortcut (Keys.chord(modifier, Keys.RETURN))
        that simulates pressing the modifier key (Control or Command) with the Return (Enter) key.
        This keyboard combination is used in browsers to open a link in a new tab when clicked.
         */
        String openInNewTab = Keys.chord(modifier, Keys.RETURN);
        /*
        Here, WebDriver finds a link on the webpage with the text "Web form"
    and sends the keyboard shortcut we created earlier (Command+Return or Control+Return) to this element.
    This action passes a command to the browser as if the user had physically pressed this key combination on the keyboard,
    which typically causes the browser to open the link in a new tab.
         */
        driver.findElement(By.linkText("Web form")).sendKeys(openInNewTab);

        /*
        This line retrieves all the current window handles (which are unique identifiers for each open window or tab)
        and stores them in a Set called windowHandles.
        A Set is a collection that contains no duplicate elements,
        and in this case, it will contain the window handles for all the browser windows or tabs that are currently open.
         */

        Set<String> windowHandles = driver.getWindowHandles();
        /*
        Here, the code is asserting that the size of the windowHandles Set is exactly 2,
        which means there should be two tabs or windows open in the browser:
        the initial one and the new one that was opened with the sendKeys command.
         */
        assertThat(windowHandles.size()).isEqualTo(2);
        /*
        Inside the loop:
        This condition checks if the current window handle (the one where WebDriver is currently focused)
        is equal to the windowHandle from the Set. If it is, it means we are still in the original tab/window.
         */
        /*
        This loop iterates through all open window handles. The goal is to find the new window handle
        that is different from the original window handle. Once found, we switch the WebDriver's focus
        to this new window. This is necessary because Selenium does not automatically switch focus
        to a newly opened window.
         */
        for (String windowHandle : windowHandles) {
            if (driver.getWindowHandle().equals(windowHandle)) {
                log.debug("Current window handle {}", windowHandle);
                assertThat(driver.getCurrentUrl()).isEqualTo(initPage);
                //If the current window handle does not match the windowHandle from the Set,
                // it means we've found the new tab/window.
            } else {
                log.debug("Switching to window handle {}", windowHandle);
                driver.switchTo().window(windowHandle);
                assertThat(driver.getCurrentUrl()).isNotEqualTo(initPage);
            }
        }
        driver.close();
        assertThat(driver.getWindowHandles().size()).isEqualTo(1);


    }
}
