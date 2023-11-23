package github.boniGarcia.junit4.ch06.categories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesJUnit4Test {
    WebDriver driver;
    @Before
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @After
    public void teardown(){driver.quit();}
    //WebForm is an empty interface
    @Test
    @Category(WebForm.class)
    public void testCategoriesWebForm(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(driver.getCurrentUrl()).contains("web-form");
    }
    //HomePage is an empty interface
    @Test
    @Category(HomePage.class)
    public void testCategoriesHomePage() throws InterruptedException {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getCurrentUrl()).doesNotContain("web-form");
    }
}
/*
    Then we can use the command line to execute tests based on their groups.
    For instance, the following commands show the Maven command for running the tests
    that belong to the HomePage category.

    mvn test -Dgroups=
        github.boniGarcia.junit4.ch06.categories.HomePage

    We can combine this filtering with the Maven support for selecting tests based on the class name.
    We can use these tags to include or exclude tests when executing tests using the command line.
    For instance, the following commands execute those tests belonging to the HomePage category
    but only in the test class CategoriesJUnit4Test.

    mvn test -Dtest=CategoriesJUnit4Test -DexcludedGroups=
        github.boniGarcia.junit4.ch06.categories.HomePage
 */
