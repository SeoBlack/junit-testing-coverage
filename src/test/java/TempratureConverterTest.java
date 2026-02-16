import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TempratureConverterTest {

    private TempratureConverter tempratureConverter;

    @BeforeEach
    void setUp() {
        tempratureConverter = new TempratureConverter();
    }

    @Test
    void fahrenheitToCelsiusTest() {
        double result1  = tempratureConverter.fahrenheitToCelsius(70.5);
        assertEquals(21.38,result1,2);
        double result2 =  tempratureConverter.fahrenheitToCelsius(-5);
        assertEquals(-20,result2,1);
        double result3 =  tempratureConverter.fahrenheitToCelsius(0);
        assertEquals(-17.777,result3,3);
    }
    @Test
    void celsiusToFahrenheitTest() {
        double result1 = tempratureConverter.celsiusToFahrenheit(20);
        assertEquals(68,result1,0);
        double result2 = tempratureConverter.celsiusToFahrenheit(-20);
        assertEquals(-4,result2,0);
        double result3 = tempratureConverter.celsiusToFahrenheit(19.5);
        assertEquals(67.1,result3,1);
    }
    @Test
    void isExtremeTempratureTest() {
        assertFalse(tempratureConverter.isExtremeTemprature(20));
        assertFalse(tempratureConverter.isExtremeTemprature(-20));
        assertFalse(tempratureConverter.isExtremeTemprature(0));
        // Boundary: exactly 50 and -40 are not extreme (condition is > 50 and < -40)
        assertFalse(tempratureConverter.isExtremeTemprature(50));
        assertFalse(tempratureConverter.isExtremeTemprature(-40));
        assertTrue(tempratureConverter.isExtremeTemprature(199.5));
        assertTrue(tempratureConverter.isExtremeTemprature(-180));
        assertTrue(tempratureConverter.isExtremeTemprature(123.999928));
        assertTrue(tempratureConverter.isExtremeTemprature(50.001));
        assertTrue(tempratureConverter.isExtremeTemprature(-40.001));
    }
    @Test
    void celsiusToKalvinTest() {
        double result1 = tempratureConverter.celsiusToKalvin(20);
        assertEquals(273.15 + 20,result1,0);
        double result2 = tempratureConverter.celsiusToKalvin(-20);
        assertEquals(273.15 - 20,result2,0);

    }
    @Test
    void kalvinToCelsiusTest() {
        double result3 = tempratureConverter.kalvinToCelsius(273.15);
        assertEquals(0,result3,0);
        double result4 = tempratureConverter.kalvinToCelsius(0);
        assertEquals(-273.15,result4,0);
    }
}