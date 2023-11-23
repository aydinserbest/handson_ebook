package github.boniGarcia.junit4.ch06.parametrized;


public class ExampleOfSuccess {
    public static void main(String[] args) {
        boolean success = checkOperation();

        if (success) {
            System.out.println("Operation was successful.");
        } else {
            System.out.println("Operation failed.");
        }
    }

    public static boolean checkOperation() {
        // Simulate an operation that can succeed or fail
        return Math.random() > 0.5;
    }
}
/*
class BooleanAssertionTest{
    @Test
    public void testOperation() {
        boolean success = performOperation();
        Assert.assertTrue("The operation should have been successful.", success);
    }

    public boolean performOperation() {
        // Simulate an operation that should return true for success
        return true; // This should be the actual logic of the operation
    }
}

 */
/*
    In these examples, the boolean success is used to determine the outcome of a simulated operation.
    In the first example, it controls which message is printed to the console.
    In the second example, it is used in a JUnit test assertion to confirm that the operation was successful.
 */
