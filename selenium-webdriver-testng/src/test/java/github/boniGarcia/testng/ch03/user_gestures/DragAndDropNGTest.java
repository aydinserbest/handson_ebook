package github.boniGarcia.testng.ch03.user_gestures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DragAndDropNGTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    /*
    This sequence of actions would typically be part of a test case in an automated test suite,
     where the functionality of the drag-and-drop feature on a web page is being tested.
    The assertions are used to ensure that the expected outcomes of the actions are achieved.
     */
    /*
    First, the draggable element is moved in a square pattern by dragging it 100 pixels to the right, down, left,
    and then up.
    This action sequence returns the element to its original position.
    Next, the same draggable element is picked up and dropped onto a target element.
     */
    @Test
    public void testDragAndDrop() throws InterruptedException {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");
        //This line creates an instance of the Actions class,
        // which is used to build a chain of actions to perform, such as clicking, dragging, and dropping.
        Actions actions = new Actions(driver);

        //We locate the draggable element.
        //This line finds the web element with the ID draggable on the current page and assigns it to the variable draggable.
        // This element is supposed to be the one that we can drag and drop.
        WebElement draggable = driver.findElement(By.id("draggable"));
        // We use dragAndDropBy() to move this element a fixed number of pixels (100) four times
        // (right, bottom, left, and up).
        int offset = 100;
        //Before performing any drag-and-drop actions, this line retrieves the initial location
        // (x, y coordinates) of the draggable element and stores it in the variable initLocation.
        Point initLocation = draggable.getLocation();

        actions.dragAndDropBy(draggable, offset, 0)

                .dragAndDropBy(draggable, 0, offset)
                .dragAndDropBy(draggable, -offset, 0)
                .dragAndDropBy(draggable, 0, -offset).build().perform();

        Thread.sleep(1000); // Wait for 1 second
        //We assert the element position is the same as the beginning.
        assertThat(initLocation).isEqualTo(draggable.getLocation());

        // We find a second element (not draggable this time).
        WebElement target = driver.findElement(By.id("target"));
        // We use dragAndDrop() to move the draggable element to the second one.
        Thread.sleep(1000);

        actions.dragAndDrop(draggable, target).build().perform();
        // We assert the position of both elements is the same.
        /*
        This line is an assertion that checks if the location of the target element is now
        the same as the location of the draggable element.
        This assertion confirms that the drag-and-drop action was successful
        and that the draggable element is now at the same coordinates as the target element.
         */
        assertThat(target.getLocation()).isEqualTo(draggable.getLocation());
        /*
        With these commands, the draggable element is now picked up and dropped onto the target element.
        The dragAndDrop method is a convenience method provided by Selenium
        that encapsulates both the click-and-hold and release actions needed to perform a drag-and-drop.
         */

    }   /*
    By evaluating the complete sequence of actions, here is the combined logic:
    First, the draggable element is moved around in a square pattern to demonstrate the drag-and-drop functionality.
    Then, the draggable element is actually dragged and dropped onto the target element.
    /*
    The offset variable in the code represents the distance in pixels
    that a web element should be moved during a drag-and-drop operation.
    In the example, offset = 100;
    specifies that the web element identified as draggable should move 100 pixels horizontally
    or vertically with each drag action.

    In web pages,
    a pixel (px) is a basic unit of measurement used to define the size and position of elements.
    This unit is often relative to the screen resolution and the pixel density of the display device.
    For instance, if an element's width or height property is set to "100px",
    that element's width or height would be 100 pixels.

    In this case,
    with each drag operation defined by the offset value,
    the draggable element is shifted by 100 pixels in the specified direction.
    This is done as part of a test scenario to verify that the drag-and-drop functionality of the element works correctly.
     */

    /*
    This part of the code involves operations
    showing how to drag and drop a web element (an object on the page) using Selenium WebDriver.
    Here is a step-by-step explanation of this code snippet:

    actions.dragAndDropBy(draggable, offset, 0)

    This step drags the element identified as draggable horizontally to the right by 100 pixels (offset).
    The second parameter (0) indicates that the element will not move vertically.
    .dragAndDropBy(draggable, 0, offset)

    This step drags the draggable element vertically downwards by 100 pixels (offset).
    The first parameter (0) indicates that the element will not move horizontally.
    .dragAndDropBy(draggable, -offset, 0)

    This step drags the draggable element horizontally to the left by 100 pixels (-offset).
    The negative value indicates that the element will move from right to left.
    The second parameter (0) indicates that the element will not move vertically.
    .dragAndDropBy(draggable, 0, -offset)

    This step drags the draggable element vertically upwards by 100 pixels
    (-offset). The negative value indicates that the element will move from bottom to top.
    The first parameter (0) indicates that the element will not move horizontally.
    .build().perform();

    The final part of this chain builds a sequence of the defined drag-and-drop operations
    and then performs them (perform).
    To provide a concrete example,
    if we apply these operations to a small box,
    this code snippet would move the box following these steps:

    The box first moves 100 pixels to the right.
    Then the box moves 100 pixels down.
    Next, the box moves 100 pixels back to the left.
    And finally, the box moves 100 pixels up, returning to its starting point.
    By following these four steps, the box traces a square path with each side being 100 pixels long.
    These operations change the position of the dragged element
    and can be used in written tests to verify these changes.
     */
    /*
    to see the first dragAndDropBy move ;
    we can use Thread:
    actions.dragAndDropBy(draggable, offset, 0).build().perform();
        Thread.sleep(1000); // Wait for 1 second

// Drag down
        actions.dragAndDropBy(draggable, 0, offset).build().perform();
        Thread.sleep(1000); // Wait for 1 second

// Drag left
        actions.dragAndDropBy(draggable, -offset, 0).build().perform();
        Thread.sleep(1000); // Wait for 1 second

// Drag up
        actions.dragAndDropBy(draggable, 0, -offset).build().perform();
     */
}
