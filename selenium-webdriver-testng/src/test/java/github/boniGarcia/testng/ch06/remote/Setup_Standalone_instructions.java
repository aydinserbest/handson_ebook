package github.boniGarcia.testng.ch06.remote;

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

    java -jar webdrivermanager-5.6.2-fat.jar resolveDriverFor chrome
    java -jar webdrivermanager-5.6.2-fat.jar resolveDriverFor firefox

    These commands will download the necessary WebDriver binaries for Chrome and Firefox,
    WebDriverManager will automatically add them to your PATH

     or you can do it manually by placing them in the same directory.

    After resolving the drivers, you can start the Selenium Server in standalone mode:

    java -jar selenium-server-4.15.0.jar standalone

    This command will start the Selenium Grid server in standalone mode,
    making it ready to accept connections from your tests.

    Remember, every time you download a new version of the Selenium Server or WebDriverManager,
    you will need to update the version in your command to match the file name you have downloaded.

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
