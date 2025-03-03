import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import cipher.CaesarCipherTest;

@SelectClasses({
    CaesarCipherTestSuite.StructuralTests.class
  , CaesarCipherTestSuite.FunctionalTests.class
})
@Suite public class CaesarCipherTestSuite {
  @SelectClasses({
      CaesarCipherStructureTest.class
  })
  @Suite public static class StructuralTests {}

  @SelectClasses({
      CaesarCipherTest.class
  })
  @Suite public static class FunctionalTests {}
}
