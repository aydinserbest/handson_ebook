package github.boniGarcia.testng.ch06.grid;

public class Core_Explanation {

      /*
    A potential problem of the standalone mode is the scalability
    (since the Selenium Server and the browsers are executed in the same home).
    Thus, the hub-nodes architecture defines two types of components to solve this issue.
     */
    /*
    In the standalone mode of Selenium Grid, both the Selenium Server (which acts as the hub)
    and the browsers (which act as nodes) run on the same machine. Here's how this setup works
    and where scalability becomes an issue:

    Selenium Server and Browsers on Same Machine: When you run Selenium Grid in standalone mode,
    you are starting both the server that manages the tests and the browsers that execute the tests
    on the same physical or virtual machine.

     */

    /*
    Standalone Mode
    In standalone mode, Selenium Server acts as both the hub and the node. This means that:

    The server that manages the test sessions and the browsers that execute the tests are running on the same machine.
    If you run tests in this mode, the browser instances are opened on the same machine where the server is running.
    Local Browser Execution: So, if Selenium Grid is started in standalone mode on your local machine,
    tests will indeed use the browsers installed on your local machine. This is where the scalability concern arises
    because all tests are limited to the resources of a single machine – your local machine.
     */
    /*
    Distributed/Grid Mode with Remote Execution
    In a distributed/Grid mode, which involves remote execution, you have:

    A central hub that manages the test sessions, which can be on one machine.
    Multiple nodes connected to the hub, which can be on different machines across the network or cloud.
    Remote Browser Execution:
    In this scenario, when your code communicates with a Selenium Grid server
    and initiates a test, it can start a browser instance on a remote machine where a node is running.
    This remote browser instance is not on your local machine
    but on whichever remote machine (node) the hub has delegated the test session to.
     */
    /*
    If the Selenium Grid is set up in standalone mode on your local machine,
    The tests will run in a browser on your local machine.
    However, if the Grid is set up in a distributed mode (not standalone),
    then the tests will run on a remote browser that's not on your local machine,
    but on whichever node the hub has directed the test to.

    In summary, whether the browser is local or remote depends on how the Selenium Grid is set up:

    Standalone Mode: Browser instances are local.
    Distributed/Grid Mode: Browser instances can be on remote nodes
     */
}
