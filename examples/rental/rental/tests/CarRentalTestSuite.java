package rental.tests;

import java.util.Locale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	CarRentalTestSuite.StructuralTests.class,
	CarRentalTestSuite.FunctionalTests.class
})
public class CarRentalTestSuite {
	@Suite
	@SelectClasses({
	      CarStructureTest.class
	    , CarRentalStructureTest.class
	})
	public static class StructuralTests {}

	@Suite
	@SelectClasses({
		  CarTest.class
		, CarRentalTest1.class
		, CarRentalTest2.class
		, CarRentalTest3.class
	})
	public static class FunctionalTests {}

	// All functional tests call this method using @BeforeEach.
	// This part ensures that numbers are formatted as
	//     123,456 EUR
	// and not as
	//     123.456 EUR
	// for testing purposes.
	@BeforeAll
	public static void setHuLocale() {
		// older Java
//		Locale.setDefault(new Locale("hu", "HU"));
		// Java 21+
		Locale.setDefault(Locale.of("hu", "HU"));
	}
}
