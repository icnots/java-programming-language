import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import famous.sequence.FibonacciTestSuite;

@Suite
@SelectClasses({
	  FibonacciTestSuite.class // demo
	, Lab04TestSuite.Tasks.class
	, Lab04TestSuite.Excercises.class
})
public class Lab04TestSuite {
	@Suite
	@SelectClasses({
		  TriangularNumbersTestSuite.class
		, IncrementTestSuite.class
		, MusicTestSuite.class
		, AdderTestSuite.class
	})
	public static class Tasks {}

	@Suite
	@SelectClasses({
		  CaesarCipherTestSuite.class
		, IncantationStructureTest.class
		, SoliloquyTestSuite.class
	})
	public static class Excercises {}
}
