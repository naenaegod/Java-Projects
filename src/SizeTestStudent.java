import static org.junit.Assert.*;
import org.junit.Test;

public class SizeTestStudent {

    @Test
    public void testEnumValues() {
        // Ensure all expected values are present
        assertEquals("There should be exactly 3 sizes defined", 3, Size.values().length);
        assertNotNull("SMALL should be defined", Size.valueOf("SMALL"));
        assertNotNull("MEDIUM should be defined", Size.valueOf("MEDIUM"));
        assertNotNull("LARGE should be defined", Size.valueOf("LARGE"));
    }

    @Test
    public void testOrderOfValues() {
        // Verify the ordering of the enum constants
        assertTrue("SMALL should come before MEDIUM", Size.SMALL.ordinal() < Size.MEDIUM.ordinal());
        assertTrue("MEDIUM should come before LARGE", Size.MEDIUM.ordinal() < Size.LARGE.ordinal());
    }

    @Test
    public void testToString() {
        // Check that the toString method returns the enum constants correctly
        assertEquals("SMALL should convert to 'SMALL'", "SMALL", Size.SMALL.toString());
        assertEquals("MEDIUM should convert to 'MEDIUM'", "MEDIUM", Size.MEDIUM.toString());
        assertEquals("LARGE should convert to 'LARGE'", "LARGE", Size.LARGE.toString());
    }
}
