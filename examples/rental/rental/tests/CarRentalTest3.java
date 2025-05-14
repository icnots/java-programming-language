package rental.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import rental.Car;
import rental.CarRental;

public class CarRentalTest3 {
	@BeforeAll
	public static void set() {
		CarRentalTestSuite.setHuLocale();
		assertTrue(new File("cars.txt").isFile(), "Missing file: cars.txt");
	}

	@Test
    public void test01() throws Exception {
        CarRental cr1 = new CarRental("nonexistent_filename.txt");
        CarRental cr2 = new CarRental("cars.txt");

        Car c1 = cr1.rentCheapest();
        assertNull(c1, "CarRental.rentCheapest(): a metodus nem a jo eredmenyt ad vissza, ha nincsenek autok.");
	}

    @Test
    public void test02() throws Exception {
    	CarRental cr2 = new CarRental("cars.txt");

        Car c2 = cr2.rentCheapest();
        assertEquals(3, cr2.numberOfCars(), "CarRental.rentCheapest(): a metodus nem csokkenti a lista meretet, ha vannak autok a listaban");
        assertEquals("Alfa Romeo (DEF 234)   9,0 EUR", c2 + "", "CarRental.rentCheapest(): a metodus nem a megfelelo autot adja vissza");
        String expected2 = """
			BMW (ABC 123)  50,0 EUR
			Toyota (GHI 456) 500,0 EUR
			Volvo (JSD 856) 500,0 EUR
			""";
        assertEquals(expected2, cr2 + "", "CarRental.rentCheapest(): a metodus nem a megfelelo auto(ka)t hagyja benne a listaban");

        Car c3 = cr2.rentCheapest();
        assertEquals(2, cr2.numberOfCars(), "CarRental.rentCheapest(): a metodus nem csokkenti a lista meretet, ha vannak autok a listaban");
        assertEquals("BMW (ABC 123)  50,0 EUR", c3 + "", "CarRental.rentCheapest(): a metodus nem a megfelelo autot adja vissza");
        String expected3 = """
			Toyota (GHI 456) 500,0 EUR
			Volvo (JSD 856) 500,0 EUR
    		""";
        assertEquals(expected3, cr2 + "", "CarRental.rentCheapest(): a metodus nem a megfelelo auto(ka)t hagyja benne a listaban");

        Car c4 = cr2.rentCheapest();
        assertEquals(1, cr2.numberOfCars(), "CarRental.rentCheapest(): a metodus nem csokkenti a lista meretet, ha vannak autok a listaban");
        assertEquals("Toyota (GHI 456) 500,0 EUR", c4 + "", "CarRental.rentCheapest(): a metodus nem a megfelelo autot adja vissza, ha a legolcsobbal azonos aru is van");
        String expected4 = """
      		Volvo (JSD 856) 500,0 EUR
        	""";
        assertEquals(expected4, cr2 + "", "CarRental.rentCheapest(): a metodus nem a megfelelo auto(ka)t hagyja benne a listaban, ha a legolcsobbal azonos aru is van");

        Car c5 = cr2.rentCheapest();
        assertEquals(0, cr2.numberOfCars(), "CarRental.rentCheapest(): a metodus nem csokkenti a lista meretet, ha mar csak egy auto van a listaban");
        assertEquals("Volvo (JSD 856) 500,0 EUR", c5 + "", "CarRental.rentCheapest(): a metodus nem a megfelelo autot adja vissza, ha mar csak egy auto van a listaban");
        assertEquals("", cr2 + "", "CarRental.rentCheapest(): a metodus nem uriti ki a listat, ha mar csak egy auto van a listaban");

        Car c6 = cr2.rentCheapest();
        assertNull(c6, "CarRental.rentCheapest(): a metodus nem a jo eredmenyt ad vissza, ha nincsenek autok.");
	}

	@Test
    public void test03() throws Exception {
        CarRental cr3 = new CarRental("cars.txt");
        ArrayList<Car> carList = new ArrayList<>();
        carList = cr3.sale();
        assertTrue(carList.get(0).getPrice() == 40.0 || carList.get(0).getPrice() == 50, "CarRental.sale(): a metodus nem jol csokkenti az autok arat.");
        assertEquals(9.0, carList.get(1).getPrice(), "CarRental.sale(): a metodus nem jol csokkenti az autok arat.");
        assertEquals(500.0, carList.get(2).getPrice(), "CarRental.sale(): a metodus nem jol csokkenti az autok arat.");
        assertEquals(500.0, carList.get(3).getPrice(), "CarRental.sale(): a metodus nem jol csokkenti az autok arat.");
    }
}
