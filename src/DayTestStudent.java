import static org.junit.Assert.*;
import org.junit.Test;

public class DayTestStudent {

    @Test
    public void testEnumValues() {
        // Check the total number of defined enums which should be 7 for 7 days of the week
        assertEquals("There should be exactly 7 days defined", 7, Day.values().length);

        // Check each enum value
        assertEquals("First day should be MONDAY", Day.MONDAY, Day.valueOf("MONDAY"));
        assertEquals("Second day should be TUESDAY", Day.TUESDAY, Day.valueOf("TUESDAY"));
        assertEquals("Third day should be WEDNESDAY", Day.WEDNESDAY, Day.valueOf("WEDNESDAY"));
        assertEquals("Fourth day should be THURSDAY", Day.THURSDAY, Day.valueOf("THURSDAY"));
        assertEquals("Fifth day should be FRIDAY", Day.FRIDAY, Day.valueOf("FRIDAY"));
        assertEquals("Sixth day should be SATURDAY", Day.SATURDAY, Day.valueOf("SATURDAY"));
        assertEquals("Seventh day should be SUNDAY", Day.SUNDAY, Day.valueOf("SUNDAY"));
    }

    @Test
    public void testOrderOfValues() {
        // Check the order of the enum values
        assertTrue("MONDAY should come before TUESDAY", Day.MONDAY.ordinal() < Day.TUESDAY.ordinal());
        assertTrue("SUNDAY should come after SATURDAY", Day.SUNDAY.ordinal() > Day.SATURDAY.ordinal());
    }

    @Test
    public void testToString() {
        // Verify toString method which should return the name of the enum constant
        assertEquals("MONDAY should convert to 'MONDAY'", "MONDAY", Day.MONDAY.toString());
        assertEquals("SUNDAY should convert to 'SUNDAY'", "SUNDAY", Day.SUNDAY.toString());
    }
}
