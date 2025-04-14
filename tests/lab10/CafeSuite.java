

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import cafe.AdultStructureTest;
import cafe.BartenderStructureTest;
import cafe.GuestStructureTest;
import cafe.MinorStructureTest;

@Suite
@SelectClasses({
    BartenderStructureTest.class,
    GuestStructureTest.class,
    AdultStructureTest.class,
    MinorStructureTest.class
})
public class CafeSuite {}
