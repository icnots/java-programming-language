package rental.tests;

import static check.CheckThat.*;
import static check.CheckThat.Lang.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import rental.CarRental;

public class CarRentalTest2 {
	@BeforeAll
	public static void set() {
		CarRentalTestSuite.setHuLocale();
		assertTrue(new File("cars.txt").isFile(), "Missing file: cars.txt");
	}

	@Test
    public void test01() throws Exception {
        CarRental cr = new CarRental("nonexistent_filename.txt");
        cr.insertionSort();
        assertEquals(0, cr.numberOfCars(), msg01);
    }

    @Test
    public void test02() throws Exception {
        CarRental cr = new CarRental("nonexistent_filename.txt");
        cr.insertionSort();
        assertEquals("", cr + "", msg01);
    }

    @Test
    public void test03() throws Exception {
        CarRental cr = new CarRental("nonexistent_filename.txt");
        cr.insertionSort();
        assertEquals(-1.0, cr.weightedAverage(), "CarRental.weightedAverage(): nem -1.0-et ad vissza, ha nincsenek autok.");
    }

    @Test
    public void test04() throws Exception {
        CarRental cr = new CarRental("cars.txt");
        cr.insertionSort();
        assertEquals(4, cr.numberOfCars(), "CarRental.insertionSort(): nem jol vegzi a rendezest, ha vannak autok a listaban");
    }

    @Test
    public void test05() throws Exception {
        CarRental cr = new CarRental("cars.txt");
        cr.insertionSort();
        String expected = """
			Alfa Romeo (DEF 234)   9,0 EUR
			BMW (ABC 123)  50,0 EUR
			Toyota (GHI 456) 500,0 EUR
			Volvo (JSD 856) 500,0 EUR
        	""";
        assertEquals(expected, cr + "",
                     "CarRental.insertionSort(): nem jol vegzi a rendezest, ha vannak autok a listaban");
    }

    @Test
    public void test06() throws Exception {
        CarRental cr = new CarRental("nonexistent_filename.txt");
        assertEquals(-1.0, cr.weightedAverage(), "CarRental.weightedAverage(): nem jol szamolja ki a sulyozott atlagot.");
    }

    @Test
    public void test07() throws Exception {
        CarRental cr = new CarRental("cars.txt");
        cr.insertionSort();
        assertEquals(360.9, cr.weightedAverage(), "CarRental.weightedAverage(): nem jol szamolja ki a sulyozott atlagot.");
    }


	boolean isHU = usedLang == HU;
	String msg01 = isHU ?
		"CarRental.insertionSort(): nem jol vegzi a rendezest, ha nincsenek autok" :
		"";

}
