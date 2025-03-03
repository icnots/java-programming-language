

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import math.operation.safe.IncrementTest;

@Suite
@SelectClasses({
    IncrementStructureTest.class,
    IncrementTest.class
})
public class IncrementTestSuite {}

