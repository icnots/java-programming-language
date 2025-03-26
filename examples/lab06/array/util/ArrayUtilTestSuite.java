package array.util;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
	ArrayUtilStructureTest.class,
	ArrayUtilTest.class
})
public class ArrayUtilTestSuite {}

