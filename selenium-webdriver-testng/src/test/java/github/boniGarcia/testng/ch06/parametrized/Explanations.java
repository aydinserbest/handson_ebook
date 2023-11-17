package github.boniGarcia.testng.ch06.parametrized;

import org.openqa.selenium.WebDriver;

public class Explanations {
    /*
    A widespread feature commonly supported by unit testing frameworks is creating parameterized tests.
    This feature enables the execution of tests multiple times using different parameters.
     */
    /*
    The approaches to parameterized testing in TestNG and JUnit are as follows:

    TestNG:

    Method parameters are directly supplied to the test methods.
    Parameters can be provided through methods annotated with @DataProvider or through XML configuration files.
    JUnit 4:

    Employs two different methods:
    Constructor Method: A method annotated with @Parameters supplies parameters to the class constructor
    via a collection.
    Field Injection Method: Class variables are annotated with @Parameter, each with an assigned index.
    The JUnit test runner directly assigns values to these variables, which are typically declared public.
    In JUnit 5, the @ParameterizedTest annotation, along with various source annotations
    (@ValueSource, @CsvSource, @MethodSource, etc.), is used for parameterized tests.
    This approach differs from JUnit 4's field injection and constructor methods,
    offering more flexible mechanisms for supplying parameters.
     */
}
