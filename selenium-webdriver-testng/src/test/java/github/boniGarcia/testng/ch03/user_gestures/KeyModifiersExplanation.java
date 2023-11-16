package github.boniGarcia.testng.ch03.user_gestures;



public class KeyModifiersExplanation {
    /*
    Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;
        actions.sendKeys(inputText, "hello world").keyDown(modifier)
                .sendKeys(inputText, "a").sendKeys(inputText, "c")
                .sendKeys(textarea, "v").build().perform();
     */
    /*
    Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;
        String openInNewTab = Keys.chord(modifier, Keys.RETURN);
        driver.findElement(By.linkText("Web form")).sendKeys(openInNewTab);

        Set<String> windowHandles = driver.getWindowHandles();
        assertThat(windowHandles.size()).isEqualTo(2);
     */

    /*
        It then determines the correct key modifier to use based on the operating system.
        For Mac OS, it uses the Command key (Keys.COMMAND), and for other systems,
        it uses the Control key (Keys.CONTROL). This is necessary for the next step, which involves a keyboard shortcut.

        This line checks the operating system you are using. If it's a Mac OS,
        it assigns Keys.COMMAND to the modifier variable;
        if it's not Mac OS, meaning you're on a system like Windows or Linux, it assigns Keys.CONTROL to the modifier variable.
        This determines which modifier key the shortcut will include for the next step.


        Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;

     */
    /*
        String openInNewTab = Keys.chord(modifier, Keys.RETURN);

        The test creates a keyboard shortcut (Keys.chord(modifier, Keys.RETURN))
        that simulates pressing the modifier key (Control or Command) with the Return (Enter) key.
        This keyboard combination is used in browsers to open a link in a new tab when clicked.

        This line creates a keyboard shortcut that simulates pressing the determined modifier key (Command or Control) together
        with the Return key.
        The Keys.chord function represents multiple keys being pressed at the same time.

     */
    /*
    driver.findElement(By.linkText("Web form")).sendKeys(openInNewTab);

    Here, WebDriver finds a link on the webpage with the text "Web form"
    and sends the keyboard shortcut we created earlier (Command+Return or Control+Return) to this element.
    This action passes a command to the browser as if the user had physically pressed this key combination on the keyboard,
    which typically causes the browser to open the link in a new tab.

    This piece of code automates what would usually be a manual action of opening a link in a new tab
    by Command+Click or Control+Click.
    The sendKeys function is used to simulate this key combination through WebDriver.
     */

    /*
    Imagine you're sitting in front of your computer.
    If you're using a Mac, the Command key is the one with the little looped square symbol (⌘) on it,
    often found next to the space bar.
    On other computers, like those running Windows or Linux, you have a Control key,
    usually labeled as 'Ctrl', also typically located near the space bar.

    Now, when you want to do something quickly, like copy or paste text,
    you use these keys in combination with others—for example, Command+C or Ctrl+C to copy.
    They're your go-to for shortcuts.

    In this test, the Selenium WebDriver needs to simulate a keyboard shortcut that you, as a user, might use.
    But since people use different keys for shortcuts depending on their computer's operating system,
    the test first figures out whether to use Command or Control.

    So, it's like the WebDriver is putting its finger on either the Command key (for Mac users)
    or the Control key (for others) and getting ready to press another key at the same time,
    to open a link in a new tab.
    It's programming mimicking what you might physically do with your own fingers on the keyboard.
     */
}
