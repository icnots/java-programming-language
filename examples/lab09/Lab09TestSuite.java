
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import data.structure.MultiSetSuite;
import data.organiser.OrganiserSuite;

@Suite
@SelectClasses({
	OrganiserSuite.class,
	MultiSetSuite.class,
	// RangedStackSuite.class,
})
public class Lab09TestSuite {}
