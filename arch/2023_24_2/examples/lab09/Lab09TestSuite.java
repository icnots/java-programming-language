
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	OrganiserSuite.class
	, MultiSetSuite.class
	, RangedStackSuite.class
})
public class Lab09TestSuite {}
