package github.boniGarcia.testng.ch06.cross_browser;

public class Explanation_dataProvider_static {
    /*
    In TestNG, a DataProvider method does not necessarily have to be static.
    It can be either static or non-static (instance method).
    However, there are some considerations to keep in mind when deciding whether to make a DataProvider
    static or non-static:

    Static DataProvider:

    A static DataProvider method can be called regardless of the instance state of the test class.
    This means it can be used across different instances of the test class and even across different test classes
    if it's made public.
    It's a good choice when the data provided does not depend on any instance variables of the test class.
    Non-Static (Instance) DataProvider:

    A non-static DataProvider method is tied to a specific instance of the test class.
    It can access instance variables and methods of the class.
    This is useful when the data being provided depends on the state of the test class instance
    or when you need to perform some instance-specific computations to generate the data.
    In the context of your CrossBrowserNGTest class, since the data() method does not rely on
    any instance variables and provides a generic set of data (browser names),
    it could be either static or non-static. Making it static is a common practice
    for such generic and state-independent data providers. However,
    if you needed the data provider to access or modify the state of the test class instance,
    you would make it non-static.

    In your specific case,
    having the data() method as static is appropriate and aligns with typical usage patterns in TestNG
    for data providers.
     */
}
