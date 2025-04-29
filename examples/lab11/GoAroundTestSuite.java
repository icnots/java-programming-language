import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import loop.GoAroundTest;
import loop.GoAroundStructureTest;
import loop.iterator.GoAroundIteratorStructureTest;

@Suite
@SelectClasses({
	GoAroundStructureTest.class,
	GoAroundIteratorStructureTest.class,
	GoAroundTest.class,
})
public class GoAroundTestSuite {}
