/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Tests property class
 * Due: 04/05/2024
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Logan Young
*/
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent {

    private Property defaultProperty;
    private Property customProperty;
    private Plot customPlot;

    @BeforeEach
    void setUp() {
        // Create a default property using the no-arg constructor
        defaultProperty = new Property();

        // Create a custom property using the parameterized constructor
        customProperty = new Property("Barack Obama", "LLama", 1200.0, "John Doe", 5, 5, 10, 10);
        
        // Create a custom plot based off of the custom property, this suspends the need to create a constructor with given values and a default plot.
        customPlot = new Plot(customProperty.getPlot());
    }

    @Test
    void testDefaultPropertyValues() {
        assertEquals("", defaultProperty.getPropertyName(), "Default property name should be an empty string");
        assertEquals("", defaultProperty.getCity(), "Default city should be an empty string");
        assertEquals(0, defaultProperty.getRentAmount(), "Default rent amount should be 0");
        assertEquals("", defaultProperty.getOwner(), "Default owner should be an empty string");
        
    }

    @Test
    void testCustomPropertyValues() {
        assertEquals("Barack Obama", customProperty.getPropertyName(), "Property name should match constructor argument");
        assertEquals("LLama", customProperty.getCity(), "City should match constructor argument");
        assertEquals(1200.0, customProperty.getRentAmount(), "Rent amount should match constructor argument");
        assertEquals("John Doe", customProperty.getOwner(), "Owner should match constructor argument");
        assertEquals("5,5,10,10", customPlot.toString(), "Plot string should match plot argument");
    }

    @Test
    void testCopyConstructor() {
        Property copiedProperty = new Property(customProperty);
        assertEquals(customProperty.getPropertyName(), copiedProperty.getPropertyName(), "Copied property name should match original");
        assertEquals(customProperty.getCity(), copiedProperty.getCity(), "Copied city should match original");
        assertEquals(customProperty.getRentAmount(), copiedProperty.getRentAmount(), "Copied rent amount should match original");
        assertEquals(customProperty.getOwner(), copiedProperty.getOwner(), "Copied owner should match original");
        // Additionally, ensure the Plot is correctly copied
    }

    @Test
    void testToString() {
        String expected = "Barack Obama,LLama,John Doe,1200.0";
        assertEquals(expected, customProperty.toString(), "toString output should match expected format");
    }
}
