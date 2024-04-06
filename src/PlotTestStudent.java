/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: tests plot class
 * Due: 04/05/2024
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Logan Young
*/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class PlotTestStudent {

    @Test
    void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX(), "Default X coordinate should be 0");
        assertEquals(0, plot.getY(), "Default Y coordinate should be 0");
        assertEquals(1, plot.getWidth(), "Default width should be 1");
        assertEquals(1, plot.getDepth(), "Default depth should be 1");
    }

    @Test
    void testParameterizedConstructor() {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals(2, plot.getX(), "X coordinate should be set to 2");
        assertEquals(3, plot.getY(), "Y coordinate should be set to 3");
        assertEquals(4, plot.getWidth(), "Width should be set to 4");
        assertEquals(5, plot.getDepth(), "Depth should be set to 5");
    }

    @Test
    void testCopyConstructor() {
        Plot original = new Plot(2, 3, 4, 5);
        Plot copy = new Plot(original);
        assertEquals(original.getX(), copy.getX(), "Copied X coordinate should match original");
        assertEquals(original.getY(), copy.getY(), "Copied Y coordinate should match original");
        assertEquals(original.getWidth(), copy.getWidth(), "Copied width should match original");
        assertEquals(original.getDepth(), copy.getDepth(), "Copied depth should match original");
    }

    @Test
    void testOverlaps() {
        Plot plot1 = new Plot(1, 1, 3, 3);
        Plot plot2 = new Plot(2, 2, 3, 3); // Overlaps with plot1
        Plot plot3 = new Plot(5, 5, 2, 2); // Does not overlap with plot1
        
        assertTrue(plot1.overlaps(plot2), "plot1 should overlap with plot2");
        assertFalse(plot1.overlaps(plot3), "plot1 should not overlap with plot3");
    }

    @Test
    void testEncompasses() {
        Plot bigPlot = new Plot(1, 1, 5, 5);
        Plot smallPlotInside = new Plot(2, 2, 2, 2); // Completely inside bigPlot
        Plot smallPlotOutside = new Plot(0, 0, 2, 2); // Outside bigPlot
        
        assertTrue(bigPlot.encompasses(smallPlotInside), "bigPlot should encompass smallPlotInside");
        assertFalse(bigPlot.encompasses(smallPlotOutside), "bigPlot should not encompass smallPlotOutside");
    }

    @Test
    void testSettersAndGetters() {
        Plot plot = new Plot();
        plot.setX(10);
        plot.setY(20);
        plot.setWidth(30);
        plot.setDepth(40);
        
        assertEquals(10, plot.getX(), "X should be set to 10");
        assertEquals(20, plot.getY(), "Y should be set to 20");
        assertEquals(30, plot.getWidth(), "Width should be set to 30");
        assertEquals(40, plot.getDepth(), "Depth should be set to 40");
    }

    @Test
    void testToString() {
        Plot plot = new Plot(1, 2, 3, 4);
        String expected = "1,2,3,4";
        assertEquals(expected, plot.toString(), "toString should return the correct format");
    }
}