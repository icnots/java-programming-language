
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import loop.GoAroundTest;

@Suite
@SelectClasses({
	MultiDimensionalPointSuite.class,
	
	GoAroundStructureTest.class,
	GoAroundIteratorStructureTest.class,
	GoAroundTest.class
})
public class Lab11TestSuite {}
