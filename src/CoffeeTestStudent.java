import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTestStudent {

    private Coffee coffeeNoAdditives;
    private Coffee coffeeWithShot;
    private Coffee coffeeWithSyrup;
    private Coffee coffeeWithBoth;

    @Before
    public void setUp() {
        coffeeNoAdditives = new Coffee("Basic Coffee", Size.SMALL, false, false);
        coffeeWithShot = new Coffee("Coffee with Shot", Size.MEDIUM, true, false);
        coffeeWithSyrup = new Coffee("Coffee with Syrup", Size.LARGE, false, true);
        coffeeWithBoth = new Coffee("Coffee with Both", Size.LARGE, true, true);
    }

    @Test
    public void testCalcPrice() {
        //  SMALL: $2, MEDIUM: $2.5, LARGE: $3
        assertEquals("Price should match for basic small coffee", 2.0, coffeeNoAdditives.calcPrice(), 0.0);
        assertEquals("Price should include extra shot cost for medium coffee", 3.0, coffeeWithShot.calcPrice(), 0.0);
        assertEquals("Price should include extra syrup cost for large coffee", 3.5, coffeeWithSyrup.calcPrice(), 0.0);
        assertEquals("Price should include both additives for large coffee", 4.0, coffeeWithBoth.calcPrice(), 0.0);
    }

    @Test
    public void testToString() {
        assertTrue("toString should contain the correct attributes and price.",
                   coffeeWithBoth.toString().contains("Coffee with Both") &&
                   coffeeWithBoth.toString().contains("LARGE") &&
                   coffeeWithBoth.toString().contains("true") &&  // extra shot
                   coffeeWithBoth.toString().contains("true") &&  // extra syrup
                   coffeeWithBoth.toString().contains("4.0"));  // total price
    }

    @Test
    public void testEquals() {
        Coffee anotherCoffee = new Coffee("Coffee with Both", Size.LARGE, true, true);
        Coffee differentCoffee = new Coffee("Coffee with Both", Size.LARGE, true, false);

        assertTrue("Coffees with the same additives should be equal", coffeeWithBoth.equals(anotherCoffee));
        assertFalse("Coffees with different additives should not be equal", coffeeWithBoth.equals(differentCoffee));
    }

    @Test
    public void testGettersAndSetters() {
        assertFalse("Initially no extra shot", coffeeNoAdditives.isExtraShot());
        coffeeNoAdditives.setExtraShot(true);
        assertTrue("Should have extra shot after setting", coffeeNoAdditives.isExtraShot());

        assertFalse("Initially no extra syrup", coffeeNoAdditives.isExtraSyrup());
        coffeeNoAdditives.setExtraSyrup(true);
        assertTrue("Should have extra syrup after setting", coffeeNoAdditives.isExtraSyrup());
    }
}
