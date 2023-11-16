package github.boniGarcia.testng.ch03.locators_relative;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class DatePickerNGTest {
    static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;
    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testDatePicker(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        LocalDate today = LocalDate.now();
        System.out.println(today);
        int currentYear= today.getYear();
        int currentDay= today.getDayOfMonth();

        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.click();

        WebElement monthElement = driver.findElement(By.xpath(String.format("//th[contains(text(), '%d')]", currentYear)));
        monthElement.click();

        // Click on the left arrow using relative locators
        WebElement arrowLeft = driver.findElement(
                RelativeLocator.with(By.tagName("th")).toRightOf(monthElement));
        /*
        instead of above code, we can delete the part of (RelativeLocator.)
        and import it:
        WebElement arrowLeft = driver.findElement(
                with(By.tagName("th")).toRightOf(monthElement));
         */
        arrowLeft.click();
        System.out.println("Tag name: " + arrowLeft.getTagName());
        System.out.println("Class attribute: " + arrowLeft.getAttribute("class"));

        // Click on the current month of that year
        WebElement monthPastYear = driver.findElement(RelativeLocator
                .with(By.cssSelector("span[class$=focused]")).below(arrowLeft));
        monthPastYear.click();

        // Click on the present day in that month
        WebElement dayElement = driver.findElement(By.xpath(String.format(
                "//td[@class='day' and contains(text(),'%d')]", currentDay)));
        dayElement.click();

        // Get the final date on the input text
        String oneYearBack = datePicker.getAttribute("value");
        log.debug("Final date in date picker: {}", oneYearBack);

        // Assert that the expected date is equal to the one selected in the
        // date picker
        LocalDate previousYear = today.minusYears(1);
        DateTimeFormatter dateFormat = DateTimeFormatter
                .ofPattern("MM/dd/yyyy");
        String expectedDate = previousYear.format(dateFormat);
        log.debug("Expected date: {}", expectedDate);

        assertThat(oneYearBack).isEqualTo(expectedDate);
    }
}

