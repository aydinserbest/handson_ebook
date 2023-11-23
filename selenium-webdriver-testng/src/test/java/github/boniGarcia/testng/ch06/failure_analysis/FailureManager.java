package github.boniGarcia.testng.ch06.failure_analysis;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class FailureManager {
     static final Logger log = getLogger(lookup().lookupClass());

     WebDriver driver;

     public FailureManager(WebDriver driver) {
          this.driver = driver;
     }

     public void takePngScreenshot(String filename) {
          TakesScreenshot ts = (TakesScreenshot) driver;
          File screenshot = ts.getScreenshotAs(OutputType.FILE);
          Path destination = Paths.get(filename + ".png");

          try {
               Files.move(screenshot.toPath(), destination);
          } catch (IOException e) {
               log.error("Exception moving screenshot from {} to {}", screenshot,
                       destination, e);
          }
     }
}
