package race.car;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
	WrongSectorTimer1StructureTest.class,
	WrongSectorTimer1Test.class,

	WrongSectorTimer2StructureTest.class,
	WrongSectorTimer2Test.class,

	SectorTimerStructureTest.class,
	SectorTimerTest.class
})
public class SectorTimerTestSuite {}
