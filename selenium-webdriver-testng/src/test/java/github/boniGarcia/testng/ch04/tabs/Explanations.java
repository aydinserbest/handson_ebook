package github.boniGarcia.testng.ch04.tabs;

public class Explanations {
    /*
    the term "window handle" is indeed associated with Selenium,
    specifically within the context of Selenium WebDriver.
    It's a concept Selenium uses to manage and switch control between different windows or tabs
    within a browser during automated web testing. Each window or tab opened by the WebDriver
    in a browser session will have a unique window handle. This allows the automated test script
    to switch focus from one window or tab to another as needed, to perform actions
    like inputting data, clicking links, or verifying that certain actions
    lead to expected outcomes in different windows or tabs.
     */
    /*
        String initHandle = driver.getWindowHandle();

        instead of opening a new browser window,
        Selenium WebDriver will open a new tab in the existing browser window.

        ////

        driver.switchTo().newWindow(WindowType.WINDOW);

        In this case, we open a new window (instead of a tab) and focus on it.
        we have an open browser window,the line above will open another browser window,
        completely separate from the one you're currently looking at,
        at the same time you will have two separate browser windows-two page-not two tab on the same screen.
        so, We open another web page

     */
    /*
    A window handle in the context of Selenium WebDriver is a unique identifier assigned to each window or tab
    that the browser has opened. When you use WebDriver to interact with a web browser,
    each window or tab is given a string value that serves as its handle. This handle is used to uniquely identify
    and switch control between different windows or tabs within the browser.

    For example, if you have a single browser window open, it will have one window handle.
    If you open a new tab or window, a new handle is created for that new window/tab.
    By storing these handles, you can instruct WebDriver to switch context to a different window or tab,
    allowing you to control it to perform actions like navigating to a URL, closing the window,
    or interacting with the elements within that window.

    String initHandle = driver.getWindowHandle();

    This command gets the handle of the currently active window or tab
    and stores it in the variable initHandle.

    The getWindowHandle() method returns the handle as a string.

    driver.switchTo().window(initHandle);

    Later in the code, this command switches control back to the window or tab
    that is identified by the handle stored in initHandle.
    The window() method is used here to switch to the window
    that has the handle matching the provided string.
     */
    /*
    The line driver.switchTo().newWindow(WindowType.WINDOW);
    specifically instructs Selenium WebDriver to open a new browser window, not a tab.

    The WindowType.WINDOW argument passed to the newWindow() method is
    what determines the type of window to be opened.
    If you wanted to open a new tab instead, you would use WindowType.TAB.

    Here's the distinction:

    WindowType.WINDOW: Opens a new browser window.
    WindowType.TAB: Opens a new tab in the existing browser window.

    So, with the given line of code, a completely new browser window will open,
    separate from the existing one.

    imagine you're sitting at your computer and you've just clicked on your browser icon.
    It springs to life and shows you your homepage, or maybe it loads up the last page you were looking at.
    That's your first window - your starting point.

    Now, let's say you're on that page and you want to look at something else
    without closing or navigating away from this page.
    Here's where that WindowType.WINDOW command comes into play. When you use this command,
    it's like you're asking your browser to open up a brand new window,
    completely separate from the one you're currently looking at.

    So you click something that triggers this command, and suddenly,
    you see a new browser window pop up.
    It's like having a second browser open. You can move it around independently, resize it, minimize it,
    all separate from the first window. And in each of these windows, you can load a different webpage.
    It's handy for comparing information from two different sites
    or multitasking without mixing up your tabs in one window.

    When you use the WindowType.WINDOW command, it's like telling your computer
    to open up another instance of your browser. So now you have two separate browser windows.
    Each window is independent of the other, and you can view a different webpage in each one.

    For instance, if you were reading an article in the first window
    and then decided to look at your email without leaving the article,
    you could use the WindowType.WINDOW command. This would open a new browser window
    where you could go to your email site. Now you can switch between the article
    and your email just by clicking on the different windows,
    rather than clicking through tabs in the same window. It helps keep things organized and separate.
     */
}
