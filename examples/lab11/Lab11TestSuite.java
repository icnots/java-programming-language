
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	MultiDimensionalPointSuite.class,
	GoAroundTestSuite.class,
})
public class Lab11TestSuite {}
