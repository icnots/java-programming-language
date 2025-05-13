package rental.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import rental.Car;

public class CarTest {
	@BeforeAll
	public static void set() {
		CarRentalTestSuite.setHuLocale();
	}

	@ParameterizedTest
    @CsvSource(textBlock = """
		A,             DEF 234,  9.0,    Brand too short
		Alpha Romeo,   DEF 234,  -500.0, Negative price
		Alpha Romeo,   DEF 234,  0.0,    Price is zero
		Alpha Romeo,   DEF 234,  503.0,  Price too high
		'Alpha,Romeo', DEF 234,  503.0,  Wrong character in brand
		Alpha Romeo,   DEF 23,   503.0,  Plate too short
		Alpha Romeo,   DEF 2345, 503.0,  Plate too long
		Alpha Romeo,   DeF 234,  503.0,  Wrong character in plate
		Alpha Romeo,   DEF D34,  503.0,  Wrong number in plate
	""")
    public void testWrongData(String brand, String licensePlate, double price, String errMsg) {
    	Car c1 = Car.make(brand, licensePlate, price);
        assertNull(c1, "Car.make() should have failed: " + errMsg);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
		Alfa Romeo, DEF 234, 9.0
		BMW,        ABC 123, 50.0
		Toyota,     GHI 456, 500.0
		Volvo,      JSD 856, 500.0
	""")
    public void testCanCreate(String brand, String licensePlate, double price) {
        Car c1 = Car.make(brand, licensePlate, price);
        assertNotNull(c1, "Car.make(): helyes parameterekkel sem hozza letre az objektumot.");
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
		Alfa Romeo, DEF 234, 9.0
		BMW,        ABC 123, 50.0
		Toyota,     GHI 456, 500.0
		Volvo,      JSD 856, 500.0
	""")
    public void testInitPrice(String brand, String licensePlate, double price) {
        Car c1 = Car.make(brand, licensePlate, price);
        assertEquals(price, c1.getPrice(), "Car.getPrice(): a metodus nem a helyes arat adja vissza.");
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
		Alfa Romeo, DEF 234, 9.0,   9.0
		BMW,        ABC 123, 50.0,  40.0
		Toyota,     GHI 456, 500.0, 500.0
		Volvo,      JSD 856, 500.0, 500.0
	""")
    public void testDecreasedPrice(String brand, String licensePlate, double price, double expectedPrice) {
        Car c1 = Car.make(brand, licensePlate, price);
        c1.decreasePrice();
        assertEquals(expectedPrice, c1.getPrice(), "Car.decreasePrice(): a metodus nem jol csokkenti az arat.");
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
		Alfa Romeo, DEF 234, 30.0,  10.0
		BMW,        ABC 123, 50.0,  30.0
		Toyota,     GHI 456, 499.9, 479.9
	""")
    public void testDoublyDecreasedPrice(String brand, String licensePlate, double price, double expectedPrice) {
        Car c1 = Car.make(brand, licensePlate, price);
        c1.decreasePrice();
        c1.decreasePrice();

        Car c2 = Car.make(brand, licensePlate, price);
        c2.decreasePrice();

        assertEquals(expectedPrice, c1.getPrice(), "Car.decreasePrice(): a metodus nem jol csokkenti az arat.");
        assertTrue(c1.isCheaperThan(c2), "Car.cheaperThan(): a metodus nem a helyes adatot adja vissza.");
        assertTrue(!c2.isCheaperThan(c1), "Car.cheaperThan(): a metodus nem a helyes adatot adja vissza.");
    }

    @Test
    public void testCheaper() {
        Car c1 = Car.make("BMW", "ABC 123", 50.0);
        c1.decreasePrice();
        Car c2 = Car.make("Alfa Romeo", "DEF 234", 9.0);
        c2.decreasePrice();
        Car c3 = Car.make("Toyota", "GHI 456", 500.0);
        c3.decreasePrice();
        Car c4 = Car.make("Volvo", "JSD 856", 500.0);

        assertFalse(c3.isCheaperThan(c4), "Car.cheaperThan(): a metodus nem a helyes adatot adja vissza egyforma aru kocsik eseten.");
        assertFalse(c4.isCheaperThan(c3), "Car.cheaperThan(): a metodus nem a helyes adatot adja vissza egyforma aru kocsik eseten.");
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
		Alfa Romeo, DEF 234, 9.0,   'Alfa Romeo (DEF 234)   9,0 EUR'
		BMW,        ABC 123, 50.0,  'BMW (ABC 123)  50,0 EUR'
		Toyota,     GHI 456, 500.0, 'Toyota (GHI 456) 500,0 EUR'
		Volvo,      JSD 856, 500.0, 'Volvo (JSD 856) 500,0 EUR'
	""")
    public void testText(String brand, String licensePlate, double price, String expectedText) {
        Car c1 = Car.make(brand, licensePlate, price);
    	assertEquals(expectedText, c1 + "");
    }
}
