package github.boniGarcia.testng.ch06.parametrized;

public class Explanations_Two_Diemensional {
    /*
    The two sets of curly braces {{ }} indicate a two-dimensional array in Java.
    The outermost set of braces defines the array itself,
    and each pair of inner braces defines a sub-array within the outer array.
    This is what makes it "two-dimensional":

    The first dimension is the array of arrays, represented by the outer set of braces {}.
    The second dimension is the individual arrays contained within the outer array,
    each represented by their own set of inner braces {}.
    Here’s an expanded explanation of the two dimensions:

    First Dimension - Array of Arrays:
    The outermost set of braces encapsulates the entire structure,
    indicating that this is an array containing other arrays.

    Second Dimension - Elements of Each Array:
    Each set of inner braces defines one of these inner arrays.
    The elements within these inner arrays are the second dimension.

    In your @DataProvider example:

    return new Object[][]{{"chrome"}, {"firefox"}};

    The Object[][] before the return statement declares a two-dimensional array.

    The {{"chrome"}, {"firefox"}} initializes the two-dimensional array with two one-dimensional arrays as its elements.
    Each of the one-dimensional arrays {"chrome"} and {"firefox"} is
    an element of the outer array, hence the two levels of braces.
    Even if the inner arrays contain only one item, this structure is
    still a two-dimensional array because it is an array (the first dimension) of arrays (the second dimension).
     */
    /*
    Here's the breakdown of the structure:

    Object[][] indicates a two-dimensional array, which is an array of arrays.
    {{"chrome"}, {"firefox"}} is the initialization of the two-dimensional array.
    It contains two single-element arrays.
    Each inner array is one-dimensional and holds a single String object.
    {"chrome"} and {"firefox"} are the inner one-dimensional arrays that contain the actual data.
    In this case, each array has only one item.
    So when you provide this data to a TestNG test method, each inner one-dimensional array
    will be passed as a set of parameters to the test method. If your test method is expecting a single parameter,
    such as public void testBrowser(String browser), then:

    For the first test run, browser will be "chrome".
    For the second test run, browser will be "firefox".
    Each inner array could be considered a single test case's set of parameters.
    Even though in this case each inner array only contains one parameter,
    the structure is still considered two-dimensional.
     */
}
