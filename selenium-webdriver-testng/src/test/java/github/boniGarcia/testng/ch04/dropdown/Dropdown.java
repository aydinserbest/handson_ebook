package github.boniGarcia.testng.ch04.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class Dropdown {
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
    public void withoutSelect() {
        driver.get(
                "https://demo.aspnetawesome.com/");
        WebElement dropdownList = driver.findElement(By.xpath("//input[@id='AllMeals']/ ..//div[@class='o-cptn']"));
        String firstItem = dropdownList.getText();
        log.debug("Default item: {}", firstItem);

        dropdownList.click();
        WebElement apple = driver.findElement(By.xpath("//div[text()='Apple']"));
        apple.click();
        String secondItem = dropdownList.getText();
        log.debug("after clicking apple, new item: {} ", secondItem);

        assertThat(firstItem).isNotEqualTo(secondItem);
    }
}
