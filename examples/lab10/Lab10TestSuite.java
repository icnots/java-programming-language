
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	BookSuite.class,
	StuffyListSuite.class
})
public class Lab10TestSuite {}
