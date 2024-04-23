import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import data.structure.peculiar.StuffyListTest;

@Suite
@SelectClasses({
    StuffyListTest.class,
    StuffyListStructureTest.class
})
public class StuffyListSuite {}
