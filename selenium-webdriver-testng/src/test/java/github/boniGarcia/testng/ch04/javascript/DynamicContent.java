package github.boniGarcia.testng.ch04.javascript;

public class DynamicContent {
    /*
    Detecting dynamic or lazily-loaded content on a web page can be done through several indicators:

    Observation:

    Manually navigating through the web page can reveal whether content loads dynamically.
    For example, if more content appears as you scroll down without a page reload, it suggests lazy loading.

    Network Activity:

    Using browser developer tools,
    you can monitor network activity as you interact with the page.
    If new network requests are made in response to scrolling or other user actions,
    that indicates dynamic content loading.

    Source Code Inspection:

    Examining the page's source code can also provide clues.
    Look for JavaScript that binds event listeners to scroll events
    or that uses IntersectionObserver API, which is often used for lazy loading.

    API Endpoints:

    Many sites with dynamic content have API endpoints that are called asynchronously to fetch content as needed.
    These endpoints may be visible in the page's JavaScript code
    or through network monitoring in developer tools.

    Placeholders or Spinners:

    Visual indicators like loading spinners or placeholders can also suggest that
    content will be loaded dynamically.

    Selenium Tests:

    When writing Selenium tests, you can attempt to find elements
    that should be present after dynamic content is loaded.
    If these elements are not immediately present, it's likely due to lazy loading.

    Performance Metrics:

    Pages with lazy-loaded content may have performance metrics
    that indicate a lower initial page load time, with additional loading as the user scrolls.

    Documentation:

    If you're testing a known application,
    the documentation may specify that certain content is dynamically loaded.
    In the context of automated testing, you often have knowledge of the application under test,
    so you can plan for these scenarios.
    If you're testing a third-party or unfamiliar application,
    you would use a combination of the above techniques to understand the loading behavior.
    When writing tests, you assume that the content might be dynamically loaded
    if you know the application's behavior, or if you have observed such behavior during manual testing.
    This is why explicit waits like WebDriverWait are used to ensure that the elements are indeed present
    and interactable before proceeding with the test steps.

     */
    /*
    Asynchronous behavior on web pages and dynamic or lazily-loaded content are related concepts, but they are not exactly the same thing. Here's how they differ and relate to each other:

    Asynchronous Behavior on Web Pages
    General Concept:
    Asynchronous behavior refers to operations or processes that occur without a specific order in time;
    they don't block the execution while waiting for a response.
    In web pages, this behavior is often managed by JavaScript
    and allows the page to handle tasks like API calls, file uploads, animations, user interactions,
    and more without freezing the page or forcing the user to wait for each task to complete sequentially.
    Technical Implementation: JavaScript’s event loop and features
    such as callbacks, promises, and async/await are used to manage asynchronous operations.
    Scope:
    Asynchrony is a broad concept that applies to any non-blocking operations on a web page.

    Dynamic or Lazily-Loaded Content
    Specific Use Case:
    Dynamic content refers to content that is loaded into the page as needed,
    often in response to user actions (like scrolling) or other events.
    Lazy loading is a technique specifically designed to delay the loading of non-critical resources
    at page load time, instead loading them when they are needed (e.g., when they enter the viewport).
    Technical Implementation:
    This often involves asynchronous JavaScript and XML (AJAX), Fetch API calls,
    or the IntersectionObserver API to load content on-demand.
    Scope:
    This is a specific kind of asynchronous behavior, focused on the on-demand loading of resources and content.
    In essence, dynamic or lazily-loaded content is a subset of asynchronous behavior.
    It's a specific type of action that a webpage might perform asynchronously.
    All dynamically loaded content is loaded asynchronously,
    but not all asynchronous behavior is related to loading content;
    it could be related to other tasks as well.

     */

    /*

    To observe lazy loading via source code inspection, you can follow these steps:

    Open Developer Tools:

    Right-click on the webpage and select "Inspect"
    or use the keyboard shortcut Ctrl+Shift+I (or Cmd+Option+I on a Mac) to open the developer tools
    in most modern web browsers.
    Examine the Source Code:

    Go to the "Elements" tab to view the HTML source code currently loaded in the browser.
    You can check for data attributes that might indicate lazy loading,
    such as data-src instead of src for images.
    To view the JavaScript, you can go to the "Sources" tab where you can see the scripts
    that are loaded on the page. You can search for terms like
    "scroll", "load", "async", "fetch", "ajax", or "IntersectionObserver".
    Look for Event Listeners:

    Search for event listeners attached to scroll events.
    They might look something like window.addEventListener('scroll', functionName)
    or if using jQuery, something like $(window).scroll(functionName).
    Search for IntersectionObserver:

    Look for instances of the IntersectionObserver API.
    This is a more modern and efficient way to detect when an element enters the viewport.
    Code using this might look like new IntersectionObserver(callback).
    Search for AJAX or Fetch Calls:

    For AJAX, you might find something like $.ajax, $.get, $.post, or the XMLHttpRequest object.
    The Fetch API would be used via fetch() function calls.
    Network Activity:

    Switch to the "Network" tab and filter by XHR (XMLHttpRequest)
    or Fetch to observe any network requests that occur as you interact with the page (like scrolling).
    If new requests are made when you scroll, it's a sign of dynamic content loading.
    Console Logging:

    Sometimes, developers will use console.log() statements to debug lazy loading functionality.
    You can check the "Console" tab for any such messages that might indicate dynamic loading behavior.
    Debugging:

    You can also set breakpoints in the JavaScript code in the "Sources" tab
    to pause execution and step through the code to see exactly when and how content is being loaded.
    By performing these inspections,
    you can gain insights into how a webpage loads its content
    and whether it uses lazy loading or other dynamic loading techniques.

     */
}
