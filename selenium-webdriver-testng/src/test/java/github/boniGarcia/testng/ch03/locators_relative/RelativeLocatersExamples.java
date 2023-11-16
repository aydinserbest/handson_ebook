package github.boniGarcia.testng.ch03.locators_relative;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RelativeLocatersExamples {

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
                "https://rahulshettyacademy.com/AutomationPractice/");

        WebElement course = driver.findElement(By.xpath("//th[contains(text(),'Course')]"));
        WebElement instructor=driver.findElement(
                RelativeLocator.with(By.tagName("th")).toRightOf(course));

        System.out.println(instructor.getText());
    }
    @Test
    public void testDate() {
        driver.get(
                "https://rahulshettyacademy.com/AutomationPractice/");

        WebElement sql = driver.findElement(By.xpath("//td[contains(text(),'Learn SQL in Practical + Database Testing from Scratch')]/.."));

        WebElement childSql=sql.findElement(By.xpath(".//td[2]"));

        System.out.println(childSql.getText());

//        WebElement sqlCourseElement = sql.findElement(By.xpath("./following-sibling::td"));

        WebElement instructor=driver.findElement(
                RelativeLocator.with(By.tagName("tr")).above(sql));
        System.out.println(instructor.findElement(By.xpath(".//td[2]")).getText());

//        WebElement appium = instructor.findElement(By.xpath("//td[2]"));
        /*
        What you're trying to do here is
        narrow down the scope to find another WebElement within a WebElement.
        However, there is a mistake in the expression sql.findElement(By.xpath("//td[2]")).
        This searches from the root of the document, not within the sql element,
        because it starts with //. This will return the first second td element
        it finds from the root of the document, which may not be the second td child of the tr element you are expecting.

        Therefore,
        you need to put a dot at the beginning of your XPath expression
        to search among the elements under the current element (in this case, sql).
        In XPath expressions,
        a statement that starts with // is used to search for a specified node anywhere from the root of the document.
        A statement starting with . (dot) is used to search within the subnodes of the current node or context.
         */
    }
    @Test
    public void testDate2() {
        driver.get(
                "https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        WebElement columnDriver=footerDriver.findElement(By.xpath("//td[1]/ul"));
        System.out.println("column links count "+columnDriver.findElements(By.tagName("a")).size());
    }
    }

