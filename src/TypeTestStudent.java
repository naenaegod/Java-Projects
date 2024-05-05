import static org.junit.Assert.*;
import org.junit.Test;

public class TypeTestStudent {

    @Test
    public void testEnumValues() {
        // Ensure all expected values are present
        assertEquals("There should be exactly 3 types defined", 3, Type.values().length);
        assertNotNull("COFFEE should be defined", Type.valueOf("COFFEE"));
        assertNotNull("SMOOTHIE should be defined", Type.valueOf("SMOOTHIE"));
        assertNotNull("ALCOHOL should be defined", Type.valueOf("ALCOHOL"));
    }


    @Test
    public void testToString() {
        // Check that the toString method returns the enum constants correctly
        assertEquals("COFFEE should convert to 'COFFEE'", "COFFEE", Type.COFFEE.toString());
        assertEquals("SMOOTHIE should convert to 'SMOOTHIE'", "SMOOTHIE", Type.SMOOTHIE.toString());
        assertEquals("ALCOHOL should convert to 'ALCOHOL'", "ALCOHOL", Type.ALCOHOL.toString());
    }
}
