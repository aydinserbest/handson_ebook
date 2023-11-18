package github.boniGarcia.testng.ch06.parametrized;

public class Explanations_dataProvider {
    /*
    The @DataProvider annotation in the TestNG framework
    is used to specify a method that provides data to a test method.
    The data method must return an Object[][]
    where each Object[] array within the larger two-dimensional array (Object[][]) represents
    a set of parameters for a single test run.

     @DataProvider(name = "LoginData")
    public static Object[] data(){
        return new Object[][]{{"user","user","Login successful"},
                {"bad-user", "bad-user", "Invalid credentials"}};
    }
     */
    /*
    Even though you have specified the return type as Object[], you're actually returning an Object[][].
    In this case, Java performs an implicit cast
    to match the actual return type (Object[][]) with the declared return type (Object[]).
    This is allowed because an Object[][] is also an Object[] — specifically,
    it's an Object[] where each element is itself an Object[].

    Here's a breakdown of why both declarations don't result in an error:

    Object[] as return type: While it may seem incorrect, Java allows it
    because an array of arrays (Object[][]) is also an instance of an array of objects (Object[]).
    Each element of the outer array is an Object[], so it's valid for the method
    to claim it's returning an array of objects.

    Object[][] as return type: This is the correct and expected return type for a DataProvider in TestNG.
    Each inner array represents a set of parameters for one instance of the test.

    However, the best practice and most accurate declaration for a DataProvider method
    that provides multiple sets of data is Object[][] because it clearly communicates
    that you're returning a two-dimensional array, where each inner array is
    treated as a distinct set of parameters for a test method. Here is how you should properly declare your DataProvider:

    @DataProvider(name = "LoginData")
    public static Object[][] data() {
        return new Object[][]{
            {"user", "user", "Login successful"},
            {"bad-user", "bad-user", "Invalid credentials"}
        };
    }
    In conclusion, while using Object[] does not cause an error due to how arrays are treated in Java,
    using Object[][] is the correct way to declare the return type for a DataProvider
    that provides multiple sets of parameters
     */


/*
    if we write like this:
     public static Collection<Object[][]>data(){
     compiler gives error
 */
/*
    In Java, when you define a method that is supposed to return a collection of arrays,
    the type of the collection should match the type of the arrays you are returning.
    In the method signature:

    public static Collection<Object[]> data() { ... }

    Collection<Object[]> indicates that the method will return a collection,
    and each item in this collection will be an Object array.
    The Object[] represents a single-dimensional array of Objects.

    If you change the method signature to:

    public static Collection<Object[][]> data() { ... }

    This now indicates that the method will return a collection of two-dimensional arrays (Object[][]).
    In this case, each item in the collection should itself be an array of Object arrays.

    However, the data you are returning:

    return Arrays.asList(new Object[][] {{"chrome"}, {"firefox"}});

    is a single-dimensional array of Object arrays, where each Object array contains a single String.
    Therefore, the method signature Collection<Object[][]> is incorrect
    because it expects each item in the collection to be a two-dimensional array.

    To fix this, you should use Collection<Object[]> as the return type
    since you are returning a list of one-dimensional Object arrays.
    Here's the correct way to write your method:


    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"chrome"},
            {"firefox"}
        });
    }


    Method Explanation and Example
    In the data method, we define a collection of arrays with the return type Collection<Object[]>.
    This indicates that the method returns a collection
    where each element is a one-dimensional array of objects (Object[]).

    When we specify new Object[][] {{"chrome"}, {"firefox"}}, we're creating a one-dimensional array of Object arrays.
    Each inner array contains one element. In this context, {"chrome"} and {"firefox"} are one-dimensional arrays.

    Here's the correct method definition:

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"chrome"},
            {"firefox"}
        });
    }
    In this example, we use Arrays.asList to create a collection from our array of Object arrays.
    Each inner array is treated as a separate element in the collection.

    If we were to change the method signature to Collection<Object[][]>,
    Java would expect each element of the collection to be a two-dimensional array,
    which is not what we are returning. Hence, we use Collection<Object[]>
    to match the type of the data we are providing.

    This explanation provides a clear understanding of how the types correspond
    to the data structure being returned by the method.

     */
    /*
    The discrepancy you're experiencing is due to how Java's type system works with generics compared to arrays.
    Let me clarify the difference.

    In your first example with Collection<Object[]>, you are using generics.
    Java's generics are strictly typed;
    thus, a Collection<Object[]> expects a collection of one-dimensional arrays of Object.
    If you try to change it to Collection<Object[][]>,
    it expects a collection of two-dimensional arrays of Object,
    which is a different type and will not be implicitly cast.

    Here is the correct use of generics:

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{"chrome"}, {"firefox"}});
    }
    Now, in your second example with the @DataProvider, you are dealing with arrays, not collections with generics:

    @DataProvider(name = "LoginData")
    public static Object[][] data() {
        return new Object[][]{
            {"user", "user", "Login successful"},
            {"bad-user", "bad-user", "Invalid credentials"}
        };
    }
    With arrays, Java allows a certain level of flexibility due to array covariance.
    An Object[][] is still an Object[] because an array of arrays is also an array of objects.
    However, this is not good practice because it can lead to ArrayStoreExceptions at runtime if the types are mismatched.

    The fact that TestNG did not throw an error when you used Object[] in the @DataProvider annotation
    is likely because TestNG internally checks the type of the object returned by the data() method
    and handles it accordingly. It might be doing an instanceof check and casting it for you
    to the correct type expected by the framework.

    Despite this leniency, you should still declare the method with the return type
    that accurately reflects what is being returned for clarity and maintainability.
    Therefore, for a DataProvider that provides data in the form of two-dimensional arrays,
    the correct return type is Object[][]. This ensures that anyone reading the code understands that
    the method returns a two-dimensional array where each sub-array represents a different set of test parameters.
     */
}
