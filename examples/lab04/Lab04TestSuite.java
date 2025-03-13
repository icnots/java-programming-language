import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import famous.sequence.FibonacciTestSuite;

@Suite
@SelectClasses({
	  famous.sequence.FibonacciTestSuite.class, // demo
	  Lab04TestSuite.Tasks.class,
	  Lab04TestSuite.Excercises.class,
})
public class Lab04TestSuite {
	@Suite
	@SelectClasses({
		  famous.sequence.TriangularNumbersTestSuite.class,
		  math.operation.safe.IncrementTestSuite.class,
		  MusicTestSuite.class,
		  math.operation.textual.AdderTestSuite.class,
	})
	public static class Tasks {}

	@Suite
	@SelectClasses({
	    // intentionally Fibonacci since this has to be non-empty
	    famous.sequence.FibonacciTestSuite.class,
		  //CaesarCipherTestSuite.class,
		  //IncantationStructureTest.class,
		  //SoliloquyTestSuite.class,
	})
	public static class Excercises {}
}
