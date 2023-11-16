package github.boniGarcia.testng.ch03.user_gestures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class MouseOverNGTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){driver = WebDriverManager.chromedriver().create();}
    @AfterMethod
    public void tearDown(){driver.quit();}
    @Test
    public void testMouseOver() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
        Actions actions = new Actions(driver);
        List<String> imageList = Arrays.asList("compass", "calendar", "award", "landscape");
        // We iterate a string list to locate the four images of the page.
        for (String imageName : imageList) {
            //img/compass.png -->  //img[@src='img/%s.png']
           // driver.findElement(By.xpath(String.format("//img[@src='%s.png",imageName)));
            String xpath = String.format("//img[@src='img/%s.png']", imageName);
            WebElement image = driver.findElement(By.xpath(xpath));
            //We use moveToElement() to move the mouse pointer to the middle of each image.
            actions.moveToElement(image).build().perform();

            WebElement caption = driver.findElement(with(By.tagName("div")).near(image));
            assertThat(caption.getText()).containsIgnoringCase(imageName);
            System.out.println("caption: "+caption.getText() + " imageName: "+imageName);
        }
    }
    @Test
    public void testHover1(){
        driver.get(
                "https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        List<WebElement> hovers = driver.findElements(By.xpath("//div[@class='example']//img"));
        List<String> list = Arrays.asList("user1", "user2", "user3");
        for (int i=0; i< hovers.size();i++) {
                actions.moveToElement(hovers.get(i)).build().perform();
                String xpath = String.format("//h5[contains(text(),'%s')]",list.get(i));
                WebElement image = driver.findElement(By.xpath(xpath));
                System.out.println(image.getText());
            }
        }
    @Test
    public void testHover2(){
        driver.get(
                "https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        List<WebElement> hovers = driver.findElements(By.xpath("//div[@class='example']//img"));
        for (int i=0; i< hovers.size();i++) {
            actions.moveToElement(hovers.get(i)).build().perform();
           // String xpath = String.format("//h5[text()='name: user%d']",i+1);
            String xpath2 = "//h5[text()='name: user"+(i+1)+"']";
            WebElement image = driver.findElement(By.xpath(xpath2));
            System.out.println(image.getText());
        }
    }
    }
    /*
        String.format() and -regular String-
            String xpath = String.format("//h5[text()='name: user%d']",i+1);

            String xpath2 = "//h5[text()='name: user"+(i+1)+"']";
     */

    /*
    driver.findElement(By.xpath(String.format("//th[contains(text(), '%d')]", currentYear)));
    driver.findElement(By.xpath(String.format("//img[@src='%s.png",imageName)));
    %s    %d

        The String.format method in Java is used to format a string and contains placeholders like %d, %s, etc.
        These placeholders are used to insert certain types of values into their corresponding positions in the string.
        Here's what each placeholder signifies:

        %d:
        This is used for formatting integers.
        For example, String.format("%d", 5) would produce the output "5".
        %s:
        This is used for formatting strings.
        For example, String.format("%s", "test") would produce the output "test".

        Let's consider the two examples you provided:

        driver.findElement(By.xpath(String.format("//th[contains(text(), '%d')]", currentYear)));

        In this snippet, the %d placeholder is used,
        expecting an integer variable named currentYear (like 2023).
        String.format will take this integer and replace the %d in the XPath expression with it.
        If currentYear is 2023, then the resulting XPath would be //th[contains(text(), '2023')].

        driver.findElement(By.xpath(String.format("//img[@src='%s.png",imageName)));
        In this snippet, the %s placeholder is used, expecting a string variable named imageName.
        String.format will take this string and replace the %s in the XPath expression with it.
        If imageName is example, then the resulting XPath would be //img[@src='example.png'.

        In summary, %d is used for integers and %s for string values.
        This depends on the type of data passed to the format method.
     */

