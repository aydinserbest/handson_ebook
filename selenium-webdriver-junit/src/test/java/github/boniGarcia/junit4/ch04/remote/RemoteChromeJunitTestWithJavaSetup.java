package github.boniGarcia.junit4.ch04.remote;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoteChromeJunitTestWithJavaSetup {
    static URL seleniumServerUrl;
    WebDriver driver;

    @BeforeClass
    public static void setupAll() throws Exception {
/*
    We find a free port on the localhost. For that, we use the class PortProber,
    available on Selenium WebDriver API.
     */        int port = PortProber.findFreePort();
        WebDriverManager.chromedriver().setup();
        Main.main(new String[] { "standalone", "--port", String.valueOf(port) });
        seleniumServerUrl = new URL(String.format("http://localhost:%d/", port));

        // Wait until Grid is started (for example, 10 seconds)
        System.out.println("Starting the Grid, please wait...");
        Thread.sleep(10000);  // 10 saniye bekletmek için

        // Automatically open a browser session
        System.out.println("Tarayıcıyı otomatik olarak açıyorum...");
        Runtime.getRuntime().exec(new String[]{"open", seleniumServerUrl.toString()});
        /*
        The line Runtime.getRuntime().exec(new String[]{"open", seleniumServerUrl.toString()});
        uses Java's Runtime class to execute a system command.
        The exec method is called on the Runtime object to run an operating system command.

        The "open" command is specific to MacOS and is used to open the specified URL with the default web browser.
        seleniumServerUrl.toString() converts the seleniumServerUrl object to its string representation,
        which is the URL where the Selenium Grid is listening.

        In summary, this command opens the URL where the Selenium Grid is running in the default web browser on MacOS.
        If you were using Windows, you would need to use a Windows-specific command
        like "cmd", "/c", "start" to achieve the same result.
         */
    }

    @Before
    public void setup() {
        driver = new RemoteWebDriver(seleniumServerUrl, new ChromeOptions());
    }
    @Test
    public void testRemote() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        Thread.sleep(10000);
        System.out.println("The title of the page is: " + driver.getTitle());

        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }
    @After
    public void tearDown() {
        // This will run after each test
        if (driver != null) {
            System.out.println("Quitting the driver.");

            driver.quit();
        }
    }
}
