
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import array.util.ArrayUtilTestSuite;
import race.car.SectorTimerTestSuite;
import election.ElectionTestSuite;

@Suite
@SelectClasses({
	SectorTimerTestSuite.class,
	ArrayUtilTestSuite.class,
	ElectionTestSuite.class,
})
public class Lab06TestSuite {}
