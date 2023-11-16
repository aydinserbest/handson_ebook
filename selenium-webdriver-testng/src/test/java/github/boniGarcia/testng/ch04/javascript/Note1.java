package github.boniGarcia.testng.ch04.javascript;

public class Note1 {
    /*
    Selenium WebDriver is a tool used for automating web application testing.
    It allows you to control a web browser programmatically.
    When you're running tests or automating tasks, there might be scenarios
    where you need to interact with the web page in ways that are not directly supported by Selenium's standard API.
    That's where JavaScript execution comes in handy.

    Here's an explanation tailored for someone not deeply versed in technical jargon:

    Imagine you have a remote control (Selenium WebDriver) for a very sophisticated robot (the web browser).
    Normally, you press buttons on the remote (use Selenium's commands)
    to make the robot perform tasks like moving forward and backward (navigate web pages),
    picking up objects (click on links, buttons), or reading sensor data (extract text from web pages).

    However, sometimes you want the robot to do something very specific that
    there isn't a button for on your remote. This is like wanting to interact with a web page
    in a way that Selenium doesn't have a built-in command for.

    In these cases, you can write a little script (JavaScript code)
    and use the remote to make the robot read and execute this script directly.
    In the context of web browsers, executing JavaScript can do just about anything
    that could be done manually within a web page, because modern web applications rely heavily on JavaScript
    for their functionality.

    For example, you might write a script to:

    Scroll the page to a specific position.
    Make adjustments to the styles of elements to see if your web application can handle dynamic style changes.
    Retrieve information that's calculated by JavaScript on the page.
    Perform complex calculations or operations that are easier to do with JavaScript.
    Interact with AJAX calls directly if you need to trigger or test the outcomes of asynchronous requests.
    When you use the JavascriptExecutor interface in Selenium,
    you're basically inserting your own custom JavaScript into the page
    and executing it as if it were part of the page's natural script.
    This can be incredibly powerful for testing or automating tasks
    that are outside the normal range of Selenium commands.

     */
    /*
    In the examples I mentioned, where you might want to scroll the page or retrieve information, the JavaScript code would look something like this:

    For scrolling the page by 1000 pixels vertically:

    String script = "window.scrollBy(0,1000);";
    js.executeScript(script);

    Here, window.scrollBy(0,1000) is the JavaScript code
    that tells the browser to scroll down by 1000 pixels.
    The first number (0) is the horizontal scroll offset
    and the second number (1000) is the vertical scroll offset.

    For retrieving the title of the page using JavaScript:
    String title = (String) js.executeScript("return document.title;");
    In this line, return document.title is the JavaScript
    that gets the title of the web page. The title is then cast to a String in Java
    because the document.title is known to be a string.
    The executeScript method is used to run the JavaScript within the context of the current page

     */
}
