package github.boniGarcia.junit4.ch06.parallel;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public class ParallelJUnit4Suite {
    //We specify which test classes are executed in parallel.
    @Test
    public void runInParallel() {
        Class<?>[] classes = { Parallel1JUnit4Test.class,
                Parallel2JUnit4Test.class };
        JUnitCore.runClasses(new ParallelComputer(true, true), classes);
    }
}
/*
    JUnit provides a basic way to execute tests in parallel through the class ParallelComputer.
    This class accepts two boolean parameters in its constructor
    to enable parallel test execution of classes and methods,
    respectively.
 */
    /*
    The class ParallelJUnit4Suite and the method runInParallel inside it are designed to run JUnit tests in parallel.
    Let me explain the structure and the purpose of this method:

Class: ParallelJUnit4Suite
This is a regular Java class. It appears to be intended for use as a test suite,
where multiple test classes can be run together.

Method: runInParallel
This is a test method, annotated with @Test. This annotation signifies that this method is a test method for JUnit.

Inside the method, we see the following structure:

Class Array:

Class<?>[] classes = { Parallel1JUnit4Test.class, Parallel2JUnit4Test.class };

This array classes is created to hold references to other test classes.
In this case, Parallel1JUnit4Test.class and Parallel2JUnit4Test.class are the classes
that are meant to be run in parallel.
This means Parallel1JUnit4Test and Parallel2JUnit4Test are presumably JUnit test classes
containing their own @Test methods.

JUnitCore.runClasses:

JUnitCore.runClasses(new ParallelComputer(true, true), classes);

This line is where the parallel execution of tests occurs.

JUnitCore is a facade for running tests. It provides various methods to run JUnit tests programmatically.
runClasses is a method of JUnitCore which is used to run the given test classes.
new ParallelComputer(true, true) creates a ParallelComputer object,
which is a special kind of Computer used to run tests in parallel in JUnit. The two boolean parameters (true, true)
indicate that both classes and methods should be run in parallel.
The first true indicates that different classes should be run in parallel.
The second true indicates that methods within a single class should also be run in parallel.
This setup is useful when you want to run multiple test classes and their methods in parallel,
thereby reducing the total time taken for testing,
especially in cases where you have a large number of tests that are independent of each other.

In summary, the runInParallel method in the ParallelJUnit4Suite class is designed to run the test methods of Parallel1JUnit4Test and Parallel2JUnit4Test in parallel, both at the class level and the method level. This approach is particularly beneficial in large-scale testing environments
where parallel execution can significantly reduce the overall testing time.
     */
