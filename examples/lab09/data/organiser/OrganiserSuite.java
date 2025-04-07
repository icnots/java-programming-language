package data.organiser;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    OrganiserStructureTest.class
    , OrganiserTest.class
})
public class OrganiserSuite {}
