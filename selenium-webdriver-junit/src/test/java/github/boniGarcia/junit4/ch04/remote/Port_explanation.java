package github.boniGarcia.junit4.ch04.remote;

public class Port_explanation {
    /*
    Every time you run your test, a new port number is
    dynamically assigned by the PortProber.findFreePort() function.
    This means your tests will run on a different port each time,
    and this port number should match what you see in the logs.

    This behavior is useful to prevent port collisions if you are running multiple tests simultaneously
    or if previous sessions have not been closed properly. However, it also means that
    the RemoteWebDriver instance must be created with the correct URL since this URL will change with each test run.

    In your test's setupAll method, you create the seleniumServerUrl with the dynamic port:

    seleniumServerUrl = new URL(String.format("http://localhost:%d/", port));

    With this snippet, you are starting the Selenium Server before each test with the listening port,
    and this port number is stored in seleniumServerUrl for use by the RemoteWebDriver.

    If you want your tests to run on the same port every time, you can specify a fixed port number
    instead of using PortProber.findFreePort(). However, before using this fixed port, you must ensure that
    it is not being used by another application on your system. Also, if you plan to run multiple tests
    or Selenium Server instances at the same time, it could lead to port conflicts.

    It is normal for the port to change with each test run as it is a result of the dynamic management of ports.
    To ensure your tests can handle these dynamic ports correctly, you need to make sure that
    seleniumServerUrl is set correctly before each test and that RemoteWebDriver is using this URL.
     */
}
