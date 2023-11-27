package github.boniGarcia.testng.ch06.grid;

public class Core_explanation2 {
    /*
    The architecture and flow of commands in both local and remote browser automation with Selenium are similar,
    but with some key differences related to where the browser is executed and how the commands are routed.

    Selenium WebDriver Architecture (Local Browsers):

    Your test script directly interacts with the browser drivers
    (like chromedriver for Chrome, geckodriver for Firefox, etc.) on the same machine.
    The drivers receive commands from your test script and perform actions in the browser locally.
    There is no intermediary between your test script and the browser drivers.
    Selenium Grid Architecture (Remote Browsers):

    Your test script communicates with the Selenium Server (the hub).
    The hub receives the test commands and forwards them to a node that matches the desired capabilities
    (like browser version, platform, etc.).
    The node has the browser drivers installed, and these drivers will
    then communicate with the actual browser to execute the commands.
    In this case, the hub acts as an intermediary, routing commands from your test script to the appropriate node.
    For a Selenium Grid node (remote machine):

    The node must have the necessary WebDriver binaries to communicate with the browsers installed on that node.
    The hub does not execute tests but passes them to the nodes. Each node is similar to a local setup,
    having both the WebDriver executables and the browser.
    When you initiate a test, you send it to the hub, and then the hub sends the commands to
    one of its nodes where the actual browser instance is launched and controlled.
    So, in essence, while the fundamental architecture of command flow remains the same
    (test script → driver → browser), in a grid setup, the test script does not talk directly to the driver.
    Instead, it communicates through the hub, which then talks to the driver on the node.
     */
}
