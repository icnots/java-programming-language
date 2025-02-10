// old archive file

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import race.car.SectorTimerTest;
import race.car.WrongSectorTimer1Test;
import race.car.WrongSectorTimer2Test;

@Suite
@SelectClasses({
	WrongSectorTimer1StructureTest.class,
	WrongSectorTimer1Test.class,

	WrongSectorTimer2StructureTest.class,
	WrongSectorTimer2Test.class,

	LapTimerStructureTest.class,
	SectorTimerTest.class
})
public class LapTimerTestSuite {}
