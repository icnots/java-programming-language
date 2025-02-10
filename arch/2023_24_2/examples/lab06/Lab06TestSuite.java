
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	SectorTimerTestSuite.class
	, ArrayUtilTestSuite.class
	, ElectionTestSuite.class
})
public class Lab06TestSuite {}
