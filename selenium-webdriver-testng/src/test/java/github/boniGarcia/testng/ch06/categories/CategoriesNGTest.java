package github.boniGarcia.testng.ch06.categories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesNGTest {
    WebDriver driver;
    /*
    We set to true the attribute alwaysRun to indicate that
    the setup and teardown methods are not filtered during test execution.
     */
    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = WebDriverManager.chromedriver().create();
    }
    @AfterMethod(alwaysRun = true)
    public void teardown(){driver.quit();}
    //We assign the group name WebForm to the first test of this class.
    @Test(groups = { "WebForm" })
    public void testCategoriesWebForm(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(driver.getCurrentUrl()).contains("web-form");
    }
    //We set the group name HomePage to the second test.
    @Test(groups = { "HomePage" })
    public void testCategoriesHomePage(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getCurrentUrl()).doesNotContain("web-form");
    }
}
/*
Then we can use the command line to filter the test execution based on these categories.

The following snippet first shows how to execute the test that belongs to the HomePage group.

The second illustrates how to combine this grouping with the Maven  filtering mechanism based on the class name.

        mvn test -Dgroups=HomePage
        mvn test -Dtest=CategoriesNGTest -DexcludedGroups=HomePage

 */
