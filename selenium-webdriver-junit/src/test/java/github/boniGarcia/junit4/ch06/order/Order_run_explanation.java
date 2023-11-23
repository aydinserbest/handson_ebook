package github.boniGarcia.junit4.ch06.order;

public class Order_run_explanation {
    /*
    When you use @FixMethodOrder(MethodSorters.NAME_ASCENDING) in JUnit,
    it affects how tests are run when you execute the entire test class.
    However, you can still run individual test methods separately if you choose.
    This is often done during development or debugging when you want to focus on a specific test.

    But there's an important caveat in the context of your test class:

    Since your tests (testA, testB, testC) are designed to be executed in a specific order
    and they depend on the state left by the previous test, running them individually might not work as intended.
    For instance:
    Running testB or testC independently might fail because they rely on actions performed in testA or testB,
    respectively.
    Each test expects the browser to be in a certain state, which is set up by the previous tests.
    So while you technically can run each test method separately, doing so might not produce meaningful
    or valid results because of these dependencies. For accurate and reliable testing in this scenario,
    you should run the entire test class to ensure that the tests are executed in the intended order
    and with the correct setup.
     */
}
