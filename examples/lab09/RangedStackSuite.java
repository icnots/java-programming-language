import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import data.organiser.OrganiserTest;

@Suite
@SelectClasses({
    RangedStackrStructureTest.class
    , RangedStackTest.class
})
public class RangedStackSuite {}
