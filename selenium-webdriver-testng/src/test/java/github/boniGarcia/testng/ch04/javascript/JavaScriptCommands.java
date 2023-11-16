package github.boniGarcia.testng.ch04.javascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptCommands {
    /*
        These examples demonstrate how you might use each JavaScript snippet
        in a Selenium test case.
        They assume that you have already instantiated the driver
        and js (JavascriptExecutor) objects appropriately.
        Remember, for the last example involving asynchronous JavaScript,
        Selenium provides better ways to wait for elements, such as WebDriverWait.
        The use of executeAsyncScript for waiting conditions is generally not recommended
        because it is more complex and error-prone compared to the built-in wait mechanisms provided by Selenium.

         */

    @Test
    public void examples() {


        WebDriver driver = WebDriverManager.chromedriver().create();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Changing Element Attributes:
        //1-
        WebElement element = driver.findElement(By.id("someId"));
        js.executeScript("arguments[0].setAttribute('type', 'button');", element);
        //2-
        // Define the attribute name and value you want to set
        String attributeName = "type"; // for example, "type"
        String value = "button"; // for example, "button"

        // Format the JavaScript command with the attribute name and value
        String script = String.format("arguments[0].setAttribute('%s', '%s');", attributeName, value);
        // Execute the JavaScript command
        js.executeScript(script, element);

        //3-Scrolling Into View:
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        //4-Scrolling by Pixels:
        js.executeScript("window.scrollBy(0, 1000);");

        //5-Scrolling to the Top of the Page:
        js.executeScript("window.scrollTo(0, 0);");

        //6-Scrolling to the Bottom of the Page:
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //7-Clicking an Element:
        WebElement button = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", button);

        //8-Getting the Value of an Element:
        WebElement input = driver.findElement(By.id("inputField"));
        String name = (String) js.executeScript("return arguments[0].value;", input);

        //9-Setting the Value of an Input Field:
        js.executeScript("arguments[0].value = 'new value';", input);

        //10-Hiding an Element:
        WebElement hide = driver.findElement(By.id("someDiv"));
        js.executeScript("arguments[0].style.visibility = 'hidden';", hide);

        //11-Showing a Hidden Element:
        WebElement element1 = driver.findElement(By.id("someDiv"));
        js.executeScript("arguments[0].style.visibility = 'visible';", element1);

        //12-Removing an Element:
        WebElement element2 = driver.findElement(By.id("someDiv"));
        js.executeScript("arguments[0].remove();", element2);

        //13- Getting the Inner HTML of an Element:
        WebElement element3 = driver.findElement(By.id("someDiv"));
        String innerHTML = (String) js.executeScript("return arguments[0].innerHTML;", element3);

        //14-Getting the Outer HTML of an Element:
        WebElement element4 = driver.findElement(By.id("someDiv"));
        String outerHTML = (String) js.executeScript("return arguments[0].outerHTML;", element4);

        //15- Executing a Mouse Hover:
        WebElement element5 = driver.findElement(By.id("menu"));
        js.executeScript("var event = new MouseEvent('mouseover', { 'view': window, 'bubbles': true, 'cancelable': true }); arguments[0].dispatchEvent(event);", element5);


        //16-Getting the Display Style of an Element:
        WebElement element6 = driver.findElement(By.id("someDiv"));
        String display = (String) js.executeScript("return window.getComputedStyle(arguments[0]).display;", element6);

        //17-Waiting for an Element to be Visible (with a specific timeout):
        // This is a more complex example that might require setting up an asynchronous script execution.
        // It's not a common pattern and generally should be replaced with Selenium's built-in wait mechanisms.
        WebElement element8 = driver.findElement(By.id("someDiv"));
        js.executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                        "var el = arguments[0];" +
                        "window.setTimeout(function() {" +
                        "  if (window.getComputedStyle(el).visibility !== 'hidden') {" +
                        "    callback(true);" +
                        "  } else {" +
                        "    callback(false);" +
                        "  }" +
                        "}, 2000);", element8
        );

    }
}
