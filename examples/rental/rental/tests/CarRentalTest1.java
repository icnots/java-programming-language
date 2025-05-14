package rental.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import rental.CarRental;

public class CarRentalTest1 {
	@BeforeAll
	public static void set() {
		CarRentalTestSuite.setHuLocale();
		assertTrue(new File("cars.txt").isFile(), "Missing file: cars.txt");
	}

	@Test
    public void test01() {
        CarRental cr = new CarRental("nonexistent_filename.txt");
        assertEquals(0, cr.numberOfCars(), "CarRental konstruktora: hibas filenev eseten nem ures listaval inicilaizalta az autokolcsonzot.");
    }

    @Test
    public void test02() {
        CarRental cr = new CarRental("cars.txt");
        assertEquals(4, cr.numberOfCars(), "CarRental konstruktora: nem megfelelo mennyisegu adatot olvasott be.");
    }

    @Test
    public void test03() {
        CarRental cr = new CarRental("nonexistent_filename.txt");
        assertEquals("", cr + "", "CarRental: rosszul jeleniti meg az objektumot, ha nincsenek autok.");
    }

    @Test
    public void test04() {
        CarRental cr = new CarRental("cars.txt");
        String expected = """
			BMW (ABC 123)  50,0 EUR
			Alfa Romeo (DEF 234)   9,0 EUR
			Toyota (GHI 456) 500,0 EUR
			Volvo (JSD 856) 500,0 EUR
        	""";
        assertEquals(expected, cr + "",
                     "CarRental: vagy a konstruktor rogzit hibas adatokat, vagy a szoveges metodus jeleniti meg oket rosszul.");
    }
}
