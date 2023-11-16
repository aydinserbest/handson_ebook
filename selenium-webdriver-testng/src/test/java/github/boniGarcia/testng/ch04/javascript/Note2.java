package github.boniGarcia.testng.ch04.javascript;

public class Note2 {
    /*
    Execute a piece of JavaScript code.
     In this case, we call the JavaScript function scrollBy() to scroll the document
     by a given amount (in this case, 1,000 px down). Notice that this fragment does not use return,
     and therefore, we do not receive any returned object in the Java logic.
     In addition, we are not passing any argument to the script.
         js.executeScript(script);

         The author is explaining the process of executing a JavaScript command using Selenium WebDriver's JavascriptExecutor interface. In this context, the scrollBy() JavaScript function is used to scroll the webpage down by 1,000 pixels.

    Here are the key points the author is making:

    Execute a piece of JavaScript code:
    This refers to the ability of JavascriptExecutor
    to run JavaScript code within the context of the currently loaded page in the browser
    controlled by WebDriver.

    Calling the JavaScript function scrollBy():
    This is a built-in JavaScript function that scrolls the window
    by a specified number of pixels. In the given example, scrollBy(0, 1000)
    scrolls the window vertically down by 1,000 pixels.
    The first argument (0) is the horizontal scroll distance,
    and the second argument (1000) is the vertical scroll distance.

    Does not use return: Typically, JavaScript functions can return values,
    which can be captured by the calling Java code when using executeScript.
    However, in this case, the scrollBy() function does not return any value;
    it simply performs an action (scrolling the page). Since there is no return value,
    there is nothing for the Java logic to receive or process after execution.

    No returned object in the Java logic:
    Because the scrollBy() function does not return a value,
    the Java code that calls this JavaScript function will not have a returned object to handle.
    In other words, the executeScript method will not provide any output to store in a Java variable.

    Not passing any argument to the script: In this particular example,
    the author is not referring to passing any external arguments from the Java code to the JavaScript code.
    The scrolling amount is hardcoded in the JavaScript function call.

    So when you run this line of code in Java:
    js.executeScript("window.scrollBy(0, 1000);");

        It tells the browser to scroll down by 1,000 pixels,
        but there is no return value to handle in the Java code.
        The action is performed in the browser, and the script ends there.





     */
}
