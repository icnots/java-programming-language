import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import magic.SoliloquyTest;

@SelectClasses({
    SoliloquyTestSuite.StructuralTests.class
  , SoliloquyTestSuite.FunctionalTests.class
})
@Suite public class SoliloquyTestSuite {
  @SelectClasses({
      SoliloquyStructureTest.class
  })
  @Suite public static class StructuralTests {}

  @SelectClasses({
      SoliloquyTest.class
  })
  @Suite public static class FunctionalTests {}
}
