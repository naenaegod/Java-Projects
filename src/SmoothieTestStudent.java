import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SmoothieTestStudent {

    private Smoothie basicSmoothie;
    private Smoothie fruitySmoothie;
    private Smoothie proteinSmoothie;
    private Smoothie fullyLoadedSmoothie;

    @Before
    public void setUp() {
        //SMALL = $2.0, MEDIUM = $2.5, LARGE = $3.0
        basicSmoothie = new Smoothie("Basic", Size.SMALL, 0, false);
        fruitySmoothie = new Smoothie("Fruity", Size.MEDIUM, 3, false);
        proteinSmoothie = new Smoothie("Protein", Size.SMALL, 0, true);
        fullyLoadedSmoothie = new Smoothie("Fully Loaded", Size.LARGE, 5, true);
    }

    @Test
    public void testCalcPrice() {
        assertEquals("Price should match base price for basic small smoothie.", 2.0, basicSmoothie.calcPrice(), 0.01);
        assertEquals("Price for smoothie with 3 fruits.", 4.0, fruitySmoothie.calcPrice(), 0.01);
        assertEquals("Price for smoothie with protein.", 3.5, proteinSmoothie.calcPrice(), 0.01);
        assertEquals("Price for fully loaded smoothie.", 7.0, fullyLoadedSmoothie.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        String expected = "Smoothie{name='Fully Loaded', size=LARGE, protein powder=true, number of fruits=5, price=7.0}";
        assertEquals("toString should return the correct format.", expected, fullyLoadedSmoothie.toString());
    }

    @Test
    public void testEquals() {
        Smoothie anotherFullyLoaded = new Smoothie("Fully Loaded", Size.LARGE, 5, true);
        assertTrue("Smoothies with the same properties should be equal.", fullyLoadedSmoothie.equals(anotherFullyLoaded));

        Smoothie differentSmoothie = new Smoothie("Fully Loaded", Size.LARGE, 4, true);
        assertFalse("Smoothies with different number of fruits should not be equal.", fullyLoadedSmoothie.equals(differentSmoothie));
    }

    @Test
    public void testGettersAndSetters() {
        fruitySmoothie.setNumberOfFruits(5);
        assertEquals("Getter for number of fruits should match set value.", 5, fruitySmoothie.getNumberOfFruits());

        proteinSmoothie.setProteinPowder(false);
        assertFalse("Getter for protein powder should match set value.", proteinSmoothie.isProteinPowder());
    }
}
