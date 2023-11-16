package github.boniGarcia.testng.ch04.dialogs;

public class Explanation2 {
    /*
    In Selenium WebDriver, when you switch to a different context,
    such as an alert or a frame,
    you're effectively changing the focus of WebDriver from the main web page to that new context.
     However, the behavior after dealing with an alert is a bit different from handling frames or windows.

    Alert:
    When you handle an alert (by accepting or dismissing it),
    the focus automatically returns to the main web page.
    There's no need to manually switch back to the main content after dealing with an alert.
    Once you've called alert.accept() or alert.dismiss(),
    you can continue interacting with the main page elements as usual.

    Frame or Window:
    On the other hand, when you switch to a frame or a new window,
    you need to switch back manually if you want to interact with the main page or another frame/window again.
    This is done using driver.switchTo().defaultContent()
    for frames or by switching to the specific window handle for windows.

    In summary, for alerts,
    there's no need for an additional step to switch back to the main content,
    but for frames or windows, you do need to manage the context switches explicitly.
     */
    /*
    Here are examples in Java with Selenium WebDriver for handling alerts,
    iframes (frames), and windows. Each example demonstrates how to switch to and from these contexts.

    1. Handling an Alert:
    // Assume driver is already initialized
    driver.get("https://example.com/page-with-alert");

    // Trigger an alert on the page
    driver.findElement(By.id("trigger-alert")).click();

    // Switch to the alert
    Alert alert = driver.switchTo().alert();

    // Perform operations on the alert, like accepting it
    alert.accept();

    // After handling the alert, the focus automatically returns to the main page
    // Now you can continue interacting with the main page
    driver.findElement(By.id("some-element")).click();

    2. Handling an Iframe (Frame):
    // Assume driver is already initialized
    driver.get("https://example.com/page-with-iframe");

    // Switch to the iframe
    driver.switchTo().frame("iframe-name-or-id");

    // Now interact with elements inside the iframe
    driver.findElement(By.id("inside-iframe-element")).click();

    // To interact with the main page again, you need to switch back
    driver.switchTo().defaultContent();

    // Now you can interact with elements on the main page
    driver.findElement(By.id("outside-iframe-element")).click();

    3. Handling Multiple Windows:
    // Assume driver is already initialized
    driver.get("https://example.com/page-with-links");

    // Store the current window handle
    String originalWindow = driver.getWindowHandle();

    // Click a link that opens a new window
    driver.findElement(By.id("new-window-link")).click();

    // Wait for the new window or tab
    new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.numberOfWindowsToBe(2));

    // Loop through until we find a new window handle
    for (String windowHandle : driver.getWindowHandles()) {
        if(!originalWindow.contentEquals(windowHandle)) {
            driver.switchTo().window(windowHandle);
            break;
        }
    }

    // Now you can interact with the new window
    driver.findElement(By.id("new-window-element")).click();

    // Close the new window and switch back to the original window
    driver.close();
    driver.switchTo().window(originalWindow);

    // Continue with the original window
    driver.findElement(By.id("original-window-element")).click();

    In these examples, the focus is explicitly managed when dealing with iframes and windows.
    For alerts, the focus automatically returns to the main page after the alert is handled.
     */
}
