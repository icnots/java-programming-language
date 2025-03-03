
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import math.operation.textual.AdderTest;

@SelectClasses({
      AdderTestSuite.StructuralTests.class
    , AdderTestSuite.FunctionalTests.class
})
@Suite public class AdderTestSuite {
    @SelectClasses({
        AdderStructureTest.class
    })
    @Suite public static class StructuralTests {}

    @SelectClasses({
        AdderTest.class
    })
    @Suite public static class FunctionalTests {}
}
