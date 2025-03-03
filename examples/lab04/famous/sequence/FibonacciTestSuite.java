package famous.sequence;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    FibonacciStructureTest.class,
    FibonacciTest.class
})
public class FibonacciTestSuite {}
