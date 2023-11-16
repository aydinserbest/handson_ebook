package github.boniGarcia.testng.ch03.user_gestures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickAndHoldNGTest {
    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    //This page uses an open source JavaScript library called Signature Pad to draw signatures in HTML canvas using the mouse.
    //This Selenium WebDriver test performs a series of actions to draw a shape on an HTML canvas element.

    @Test
    public void testClickAndHold() {
        /*
        Open the Page:
        The driver.get() method navigates to a specific URL where the canvas drawing will take place.
        The web driver navigates to the specified URL that contains a HTML canvas element.
         */

        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/draw-in-canvas.html");
        /*
        Initialize Actions:
        An Actions object is instantiated.
        This object is used to queue up a series of actions that can be performed on web elements.
        An Actions object is created. This object is used to chain together complex sequences of user interactions.

         */
        Actions actions = new Actions(driver);
        /*
        Find the Canvas Element:
        The driver.findElement() method locates the canvas element on the page using its tag name "canvas".
        The canvas element is located by its tag name. This element is where the drawing will occur.
         */

        WebElement canvas = driver.findElement(By.tagName("canvas"));
        /*
        Click and Hold:
        The actions.moveToElement(canvas).clickAndHold() methods move the mouse to the center of the canvas element
        and simulate holding down the mouse button. This is the beginning of the drawing action.

        The moveToElement method moves the mouse pointer to the center of the canvas.
        Then, clickAndHold simulates the action of pressing the mouse button down without releasing it.

         */
        actions.moveToElement(canvas).clickAndHold();
        /*
        Draw a Shape:
        The loop creates a series of points to form a shape.
        This specific code is set up to draw a polygon with numPoints sides (in this case, 10 sides).
        The script enters a loop to calculate the points of a shape. This shape will have numPoints number of points,
        and the distance from the center of the shape to any point (the radius) is radius pixels.
        This is the moment to start drawing.
         */
        int numPoints = 10;  //sets the number of points or vertices the shape will have.
        int radius = 30;  //sets the radius of the shape. This is essentially how far from the center of the canvas each point will be.

        /*
        Inside the loop,
        Inside the loop:

        The angle for each point is calculated in radians
        because trigonometric functions in Java's Math library use radians.
        The x and y positions for each point are calculated using sine and cosine functions,
        which gives us the coordinates for each vertex of the polygon based on the angle and radius.

        it calculates the x and y offsets for each point of the shape using trigonometry.
        The angle for each point is determined by dividing a full circle (360 degrees) by the number of points,
        converting this angle to radians, and then using sin for the x-coordinate and cos for the y-coordinate.
         */
        for (int i = 0; i <= numPoints; i++) {
            double angle = Math.toRadians(360 * i / numPoints);
            double x = Math.sin(angle) * radius;
            double y = Math.cos(angle) * radius;
            actions.moveByOffset((int) x, (int) y); /*moves the mouse to each calculated point relative to the last position.
            Since the mouse button is held down, this will draw a line from point to point on the canvas.
            the mouse moves to each calculated point, relative to the last position.
            Since the mouse button is held down, this creates a line from point to point on the canvas,
            We use the circumference points (x and y) to move the mouse by offset (moveByOffset()).
            Since the click is held from the previous step,
            the resulting compound action will move the mouse while the click button is pressed.

            */

        }
        /*
        After calculating the position of each point,
        the moveByOffset method is used to move the mouse from its current position
        by the calculated x and y offsets.
        This action will draw lines between the points because the mouse button is held down.

        Finally,
        after the loop has completed and the shape has been drawn,
        the release method is called to release the mouse button.
        This is equivalent to lifting the mouse button up, completing the drawing action.
         */
        actions.release(canvas).build().perform();
        //It tells the actions builder that the mouse button needs to be released, thus ending the drawing action on the canvas.
        // tells the actions builder that the mouse button should be released, ending the drawing action on the canvas.
        /*
        The end result of running this test would be a ten-sided polygon drawn on the canvas element,
        with each side approximately radius pixels long. The polygon is inscribed within a circle with a radius of 30 pixels.
        This demonstrates interacting with a canvas element using Selenium WebDriver to simulate mouse movements and clicks.
         */
        /*
        The entire sequence is built using the build method and executed using the perform method.
        This test effectively draws a polygon with numPoints sides on the canvas element.
        If numPoints is set to 10 and radius is 30,
        it should draw a decagon with each side being approximately the same length
        due to the uniform distribution of points around a circle with a radius of 30 pixels.
         */
        /*
        When you run this test, the result will be a ten-sided polygon drawn on the canvas element,
        with each side being approximately radius pixels in length.
        This polygon will be inscribed within a circle with a 30-pixel radius.
        This demonstrates the capability of Selenium WebDriver to interact with a canvas element by simulating mouse movements and clicks.
         */
    }
}

