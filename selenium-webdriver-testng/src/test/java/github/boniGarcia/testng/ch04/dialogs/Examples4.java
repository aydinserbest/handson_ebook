package github.boniGarcia.testng.ch04.dialogs;

public class Examples4 {
    /*
     interacting with a modal dialog on a webpage is different from handling a JavaScript alert popup.
     Let's go through the test step by step to understand how it works and how it differs from a JavaScript alert.

     Test Steps Explained:
    Navigate to the Web Page:

    driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
    This line directs the WebDriver to load a specific URL.
    This page contains different types of dialog boxes, including modals for testing.

    Initialize WebDriverWait:

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    This creates an instance of WebDriverWait, which is used for explicit waits,
    meaning WebDriver will wait for a certain condition (up to 5 seconds) before throwing an exception.

    Trigger the Modal Dialog:

    driver.findElement(By.id("my-modal")).click();
    Here, the script clicks a button or link with the ID "my-modal".
    The click action is expected to open a modal dialog on the page.

    Find the Close Button within the Modal:

    WebElement close = driver.findElement(By.xpath("//button[text() = 'Close']"));
    This line locates the "Close" button inside the modal dialog using an XPath expression.
    The XPath //button[text() = 'Close'] is looking for a button element with the text "Close".

    Assert the Tag Name of the Close Button:

    assertThat(close.getTagName()).isEqualTo("button");
    The script checks that the tag name of the found element is "button", ensuring that the correct element was located.

    Wait for the Close Button to be Clickable:

    wait.until(ExpectedConditions.elementToBeClickable(close));
    This line uses WebDriverWait to wait until the "Close" button inside the modal is clickable.
    It's an important step to ensure that the button is ready for interaction.

    Click the Close Button:

    close.click();
    Finally, the script clicks the "Close" button to close the modal dialog.

    Differences from a JavaScript Alert:

    Type of Dialog:
    A modal dialog is a part of the webpage's HTML content,
    while a JavaScript alert is a browser-generated dialog that is not part of the HTML DOM.
    Interaction:
    You can interact with elements inside a modal (like buttons or forms) using standard WebDriver commands.
    In contrast, for JavaScript alerts, you need to switch the WebDriver's context to the alert to interact with it.
    Closing Mechanism:
    Modals are typically closed by clicking a button or a close icon within the dialog.
    JavaScript alerts are closed using the alert's accept() or dismiss() methods.
    Presence in DOM:
    Since modals are part of the DOM, you can use locators like ID, XPath, or CSS selectors to find elements within them.
    JavaScript alerts are not part of the DOM and require a different approach for interaction.
    ou cannot use XPath or CSS selectors to find or interact with the JavaScript alert.
    Instead, you switch to the alert using driver.switchTo().alert() and then interact with it using the Alert interface.

    the key difference is in how you locate and interact with these elements.
    Modals are part of the DOM and can be interacted with using standard Selenium locators and methods.
    In contrast, JavaScript alerts are not part of the DOM and require switching the WebDriver's context to interact with them.

    In summary, this test demonstrates how to handle a modal dialog on a webpage using Selenium WebDriver,
    which involves locating and interacting with elements within the modal,
    contrasting with the way JavaScript alerts are handled
     */
}
