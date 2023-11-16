package github.boniGarcia.testng.ch04.dropdown;

public class Explanation3 {
    /*
    --ABOUT THE TEST BELOW--

    This test scenario appears to work with a dropdown menu that does not use the <select> tag.
    Such menus are typically developed with custom JavaScript or CSS
    and require a different approach when testing with Selenium WebDriver.

    The steps of the scenario are as follows:

    An element that triggers the dropdown menu is located and clicked.
    An XPath expression is used to find all the items in the opened menu,
    and these items are gathered into a List<WebElement>.
    A loop is initiated for each WebElement in the list, and the text of these elements is printed to the console.
    After the loop, an indexed access to the list is performed,
    and the text of a specific item is printed to the console.
    Finally, a specific item is selected from the list by clicking on it.
    This scenario is a typical example of working with a customized dropdown menu
    rather than a <datalist>. In this case, the items within the WebElement list are directly clickable,
    and Selenium cannot process them as it would <option> elements in a <select> menu
    because they are HTML <li> tags or similar elements.
    Such menus are often preferred to provide a richer user experience and to enhance the visual design of the page.

    When writing tests with Selenium in this situation, the following approaches are used:

    Using the click() method to open the dropdown menu.
    Using locators such as CSS selectors or XPath to find the menu items.
    Utilizing lists and loops to navigate through the menu items and select an item.
    Using the click() method on the desired item to select it.
     */
    /*
    @Test
    public void testName() {

        driver.get("https://demo.aspnetawesome.com/");

        //once dropwdown menunun acilmasi icin element locate edilir ve click yapilir.
        driver.findElement(By.xpath("(//div[text()='Papaya'])[1]")).click();

        //butun elementleri goren locator bulunur ve list elemente atilir.
       List<WebElement> papaya = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[10]/li"));
        System.out.println("papaya.size() = " + papaya.size());


        for (WebElement webElement : papaya) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }

        System.out.println(papaya.get(1).getText());
        papaya.get(1).click();

        System.out.println("papaya.get(4).isDisplayed() = " + papaya.get(4).isDisplayed());

        List<WebElement> legumes = driver.findElements(By.xpath("(//*[text()='Tomato'])[3]/../../li"));
        System.out.println("legumes.size() = " + legumes.size());

    }
     */
}
