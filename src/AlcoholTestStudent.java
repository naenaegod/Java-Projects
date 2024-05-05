import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AlcoholTestStudent {

    private Alcohol alcoholWeekday;
    private Alcohol alcoholWeekend;

    @Before
    public void setUp() {
        // Assuming Size.SMALL and other relevant enum types are defined correctly
        alcoholWeekday = new Alcohol("Vodka", Size.SMALL, false);
        alcoholWeekend = new Alcohol("Vodka", Size.SMALL, true);
    }

    @Test
    public void testCalcPrice() {
        // Assume the base price for SMALL is 2.0 (defined in the super class)
        assertEquals("Price should be base price on a weekday.", 2.0, alcoholWeekday.calcPrice(), 0.0);
        assertEquals("Price should include weekend cost on a weekend.", 2.60, alcoholWeekend.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue("toString should contain the correct attributes.",
                   alcoholWeekend.toString().contains("Vodka") &&
                   alcoholWeekend.toString().contains("SMALL") &&
                   alcoholWeekend.toString().contains("true") &&
                   alcoholWeekend.toString().contains("2.6"));
    }

    @Test
    public void testEquals() {
        Alcohol anotherAlcohol = new Alcohol("Vodka", Size.SMALL, true);
        Alcohol differentAlcohol = new Alcohol("Vodka", Size.SMALL, false);

        assertTrue("Alcohol objects with the same state should be equal.", alcoholWeekend.equals(anotherAlcohol));
        assertFalse("Alcohol objects with different weekendOffer should not be equal.", alcoholWeekend.equals(differentAlcohol));
    }
    
    @Test
    public void testGettersAndSetters() {
        assertFalse("Initially set to false", alcoholWeekday.isWeekendOffer());
        alcoholWeekday.setWeekendOffer(true);
        assertTrue("Should be true after setting to true", alcoholWeekday.isWeekendOffer());
    }
}
