package github.boniGarcia.testng.ch06.grid;

public class Node_explanation {
    /*
    We start the hub.
    By default, this server listens to W3C WebDriver HTTP requests in port 4444 and TCP ports 4442 and 4443
    for registering nodes.
        java -jar selenium-server-4.0.0.jar hub

    In a second console, we register the node(s). In this example,
    this command is executed in the same host as the hub.
        java -jar selenium-server-4.0.0.jar node

    Moreover, it supposes that the required drivers (e.g., chromedriver and geckodriver) are
    already resolved (as in Example 6-5).
    To start nodes from another host,
    we would need to invoke the following command:
        java -jar selenium-server-4.0.0.jar node --hub http://<hub-ip addresse>:4444
        //example: java -jar selenium-server-4.0.0.jar node --hub http://192.168.1.2:4444
     */
    /*
    Note In the same way as the standalone mode,
    you can start a hub-nodes grid using Java code.
    For that, you need to change the parameters to invoke the Selenium Grid main class
    following the same syntax of the CLI commands for hub and nodes.

     */
}
