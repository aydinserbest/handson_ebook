package github.boniGarcia.junit4.ch06.retry;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class RetryRule implements TestRule {
    static final Logger log = getLogger(lookup().lookupClass());

    int maxRetries;

    public RetryRule(int maxRetries) {
        this.maxRetries = maxRetries;
    }
    /*
    Inside apply, there is an anonymous inner class with an evaluate method.
    This method is where the retry logic happens. It tries to run the test (base.evaluate()),
    and if it fails, it retries up to the maximum number of retries specified.
    If all retries fail, it throws the last caught exception.
     */

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable throwable = null;
                for (int i = 0; i < maxRetries; i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable t) {
                        throwable = t;
                        log.debug("{}: run {} failed",
                                description.getDisplayName(), i + 1);
                    }
                }
                log.debug("{}: giving up after {} failures",
                        description.getDisplayName(), maxRetries);
                throw throwable;
            }
        };
    }
}
