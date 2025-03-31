import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import data.structure.ListUtilTest;

@Suite
@SelectClasses({
    ListUtilStructureTest.class
    , ListUtilTest.class
})
public class ListUtilSuite {}
