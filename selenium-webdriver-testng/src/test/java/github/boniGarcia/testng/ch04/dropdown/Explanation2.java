package github.boniGarcia.testng.ch04.dropdown;

public class Explanation2 {
    /*
    In web applications, various HTML/CSS and JavaScript techniques are used to create dropdown menus. Each of these techniques requires a different approach when writing automated tests with Selenium. Let's discuss two common approaches:

    1-
    Dropdown Menus Using the <select> Tag:
    These dropdown menus use the standard HTML <select> and <option> tags.
    In Selenium, the Select class is used to test these types of menus. The usage is as follows:

    Select dropdown = new Select(driver.findElement(By.id("dropdown")));
    dropdown.selectByVisibleText("Option 1");

    Here, the Select class is used to locate the dropdown's <select> element and then choose an <option> within it.

    2-
    Dropdown Menus Without the <select> Tag:
    Many modern websites use custom JavaScript libraries or HTML/CSS techniques instead of the <select> tag
    for more flexible styles and behaviors.
    These types of dropdown menus are typically created with tags like <div>, <ul>, <li>,
    and their appearance can be fully customized.
    When testing such a menu with Selenium, the approach usually follows:

    // Clicking on the element that represents the dropdown menu to open it
    driver.findElement(By.id("dropdownButton")).click();

    // Clicking on an item from the opened list to select it
    driver.findElement(By.xpath("//li[text()='Option 1']")).click();

    Here, XPath, CSS selectors, or other locators are used to find the correct elements.

    3-
    <datalist> Elements:
    The <datalist> mentioned by the author provides a suggestion list associated with an <input> element.
    To test a <datalist> element with Selenium,
    you first need to click on the <input> element and then either select a value from the suggestion list
    or send a value using the sendKeys() method.
    Since the <option>s within a <datalist> are generally not directly visible,
    they usually can't be selected directly. Instead, we send the text that the user enters,
    which triggers the autocomplete feature.

    // Clicking on the <input> element
    driver.findElement(By.id("inputWithDatalist")).click();

    // Sending a value to the <input> element and selecting from the suggestion list
    driver.findElement(By.id("inputWithDatalist")).sendKeys("New York");

    For dropdown menus without the <select> tag,
    test scenarios are usually written by examining the HTML structure of these menus
    and clicking on the appropriate elements.
    For these cases, more complex XPath or CSS selectors might need to be used in Selenium.
    Sometimes, it may also be necessary to use the JavascriptExecutor class to interact with JavaScript.
     */
}
