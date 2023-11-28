package github.boniGarcia.testng.ch06.docker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static io.github.bonigarcia.wdm.WebDriverManager.isDockerAvailable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class DockerChromeNGTest {
    WebDriver driver;
    String containerId;


    WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker().enableVnc();

    @BeforeMethod
    public void setupTest() {
        assumeThat(isDockerAvailable()).isTrue();
        driver = wdm.create();
        containerId = wdm.getDockerBrowserContainerId();
        System.out.println("Docker Container ID: " + containerId);


    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        if (driver != null) {
            System.out.println("Docker Container ID: " + containerId);
            String noVncUrl = wdm.getDockerNoVncUrl().toString();
            System.out.println("noVNC URL: " + noVncUrl);

            Thread.sleep(100000);
            driver.quit(); // WebDriver'ı kapat
        }

        // Docker konteynerının loglarını al
        try {
            String command = "docker logs " + containerId;
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Logları konsola yazdır
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (wdm != null) {
            wdm.quit(); // WebDriverManager'ı kapat
        }
    }

    @Test
    public void testDockerChrome() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String pageTitle = driver.getTitle();
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }
}
