package github.boniGarcia.testng.ch06.remote;

public class Explanation {
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

    Resource Limitation: Since everything runs on a single machine,
    the resources (like CPU, memory, and network bandwidth) are shared between the Selenium Server and all the browsers.
    If you run multiple or resource-intensive tests simultaneously, you might experience performance bottlenecks.
    This is because your machine's resources are being divided among multiple processes.

    Scalability Issue: The scalability problem arises when you need to run a large number of tests or tests
    that are resource-intensive. The single machine running both the Selenium Server and browsers
    might not cope with the increased load, leading to slower test executions, timeouts,
    or failures due to resource constraints.

    Hub-Nodes Architecture
    To address the scalability issue in standalone mode, Selenium Grid offers a hub-nodes architecture.
    Here's how this setup works:

    Separation of Responsibilities: In this architecture, you have two types of components:
    the hub and the nodes. The hub acts as a central point that manages the test sessions,
    while the nodes are separate machines or processes that run the browsers.

    Distributed Testing: Each node connects to the hub. You can have multiple nodes, potentially on different machines,
    each running different browsers or browser versions. The hub distributes the tests across these nodes.

    Enhanced Scalability: This separation allows for better scalability. As the load increases,
    you can add more nodes to handle more tests in parallel. Unlike the standalone mode, where everything
    is confined to one machine's resources, the hub-nodes architecture distributes the load across multiple machines
    or environments.

    Practical Example: Imagine you have a hub set up on one machine and three nodes on three different machines.
    When you run tests, the hub receives the test commands and intelligently delegates these commands to the nodes.
    One node might be running tests on Chrome, another on Firefox, and a third one on Safari, all simultaneously
    and without overloading a single machine's resources.

    In summary, while standalone mode is simple and straightforward for smaller testing needs,
    the hub-nodes architecture in Selenium Grid provides a more scalable solution for larger
    and more complex test suites by distributing the load across multiple machines or environments.
     */
}
