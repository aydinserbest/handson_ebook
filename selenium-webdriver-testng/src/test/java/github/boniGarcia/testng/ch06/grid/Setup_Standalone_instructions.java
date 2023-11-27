package github.boniGarcia.testng.ch06.grid;

public class Setup_Standalone_instructions {
    /*
    the practical steps to set up Selenium Grid in standalone mode using your terminal.
    Please follow these steps:

    You will need
    1-the selenium-server-4.15.0.jar file for the Selenium server.
    2-the webdrivermanager-5.6.2-fat.jar file (to manage the WebDriver binaries-executable drivers of related browsers)

    Now, let's open your terminal and write the commands step by step:

    First, navigate to the directory where you have downloaded the files.
    If they are in your Downloads folder, for example, you would do:

    cd ~/Downloads
    Then, use WebDriverManager to resolve the drivers.
    Replace ~/Downloads with the path to the directory where your JAR files are if it's different:
    (We use WebDriverManager CLI to resolve chromedriver and firefox driver )

    java -jar webdrivermanager-5.6.2-fat.jar resolveDriverFor chrome
    java -jar webdrivermanager-5.6.2-fat.jar resolveDriverFor firefox

    These commands will download the necessary WebDriver binaries for Chrome and Firefox,
    WebDriverManager will automatically add them to your PATH

     or you can do it manually by placing them in the same directory.

    After resolving the drivers, you can start the Selenium Server in standalone mode:
    (We start Selenium Grid in standalone mode in the same folder (which contains chromedriver and geckodriver). )
    java -jar selenium-server-4.15.0.jar standalone

    This command will start the Selenium Grid server in standalone mode,
    making it ready to accept connections from your tests.

    Remember, every time you download a new version of the Selenium Server or WebDriverManager,
    you will need to update the version in your command to match the file name you have downloaded.

     */
    /*
    After these commands, the standalone Selenium Server listens to incoming HTTP requests in port 4444 of the localhost.
    Therefore, we can create an instance of RemoteWebDriver using that URL
    (e.g., http://localhost:4444/ if the test executes in the same host)
    and the required capabilities (for Chrome or Firefox, in this case).

    WebDriver driver = new RemoteWebDriver("http://localhost:4444/",
        new ChromeOptions());
     */
    /*
    Another helpful feature provided by Selenium Grid is its web console.
    This console is a web UI accessible in the Selenium Server URL that allows
    monitoring of the available browsers registered in the grid and the sessions in execution.
     */
    /*
    note:in the link, there is also a .zip file is for the Java bindings, which you don't need for this purpose.

    The .zip file has Java code libraries for writing Selenium tests in Java.
    You use these when you are programming your tests in Java.
    The .jar file is the Selenium Server itself. It listens for test commands and sends them
    to the browser for you, regardless of the programming language your tests are written in.
    For just running tests (especially from different programming languages or machines),
    you don't use the Java libraries. You only need the Selenium Server, the .jar file.
    It does everything needed to run the tests on the browsers.


     */
}
