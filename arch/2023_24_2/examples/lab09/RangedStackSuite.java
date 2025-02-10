import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import data.structure.RangedStackTest;

@Suite
@SelectClasses({
    RangedStackStructureTest.class
    , RangedStackTest.class
})
public class RangedStackSuite {}
