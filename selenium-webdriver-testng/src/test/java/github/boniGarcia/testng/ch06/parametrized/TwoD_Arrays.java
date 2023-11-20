package github.boniGarcia.testng.ch06.parametrized;

import org.testng.annotations.DataProvider;

public class TwoD_Arrays {
    @DataProvider(name = "browsers2")
    public static Object[][] data2() {
        return new Object[][] {
                {"user1", "password1"},
                {"user2", "password2"}
        };
    }
    /*
    Each inner array provides two parameters ("user1", "password1" and "user2", "password2").
    If your test method is designed to accept two parameters (such as a username and a password),
    then using a two-dimensional (2D) array is necessary.

    A one-dimensional (1D) array cannot be used in this scenario without altering the structure of the test method.
    A 1D array would pass each element as a single parameter,
    which means the test method would need to be restructured to only accept one parameter.
    However, in cases where the test method requires a grouping of parameters (like a username and password pair),
    a 1D array is not suitable.

    Thus, for a test method that requires multiple parameters per invocation, a 2D array is the appropriate choice.
     */
    // DataProvider with a 1D Array
    @DataProvider(name = "browsers")
    public static Object[] data() {
        return new Object[] {"chrome", "firefox"};
    }
    /*
    Structure: It's a 1D array (Object[]), a simple list of objects.
    Data: Each element in the array ("chrome", "firefox") is a single parameter for one invocation of the test method.
    Usage: This is used when each test run requires only a single parameter.

    If your test method requires a single parameter,
    you can use either approach.
    The choice might depend on whether you anticipate adding more parameters in the future.
    If your test method might need multiple parameters in the future,
    it's better to start with a 2D array.
     */
    /*
    in the specific example where you're only passing a single parameter (like "chrome" or "firefox")
    to your test method, it doesn't make a significant difference
    whether you use a 1D or 2D array in your DataProvider.
    Both will effectively provide the necessary data for your test runs,
    although there are slight differences in how they are structured.

    Each element in the array is a single parameter ("chrome" or "firefox").
    The test method will be called once for each element in the array.
     */
    //2D Array
    @DataProvider(name = "browsers")
    public static Object[][] data2D() {
        return new Object[][] {{"chrome"}, {"firefox"}};
    }
    /*
    Each inner array contains one element (either "chrome" or "firefox").
    The test method will be called once for each inner array.

    For a single parameter, both 1D and 2D arrays work equally well.
    The choice between them can be based on personal preference or readability.
    If you plan to add more parameters in the future, a 2D array might be more adaptable.
     */
    /*
    Key Differences
    Array Dimensions: The 2D array (Object[][]) is an "array of arrays",
    while the 1D array (Object[]) is a simple array of objects.
    Flexibility: The 2D array allows for more flexibility.
    Each inner array can contain multiple elements, which means the test method can have multiple parameters.
    With a 1D array, each test run is limited to a single parameter.
     */



}
