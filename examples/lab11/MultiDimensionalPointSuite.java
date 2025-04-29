
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import action.UndoableStructureTest;
import action.ScalableStructureTest;
import action.user.MultiDimensionalPointStructureTest;

import action.user.MultiDimensionalPointTest;



@Suite
@SelectClasses({
	ScalableStructureTest.class,
	UndoableStructureTest.class,
	MultiDimensionalPointStructureTest.class,
	MultiDimensionalPointTest.class
})
public class MultiDimensionalPointSuite {}
