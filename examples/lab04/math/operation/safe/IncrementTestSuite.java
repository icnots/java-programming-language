package math.operation.safe;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
    IncrementStructureTest.class,
    IncrementTest.class
})
public class IncrementTestSuite {}

