/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Tests all the methods to make sure calculations are accurate and consistent.
 * Due: 04/19/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Logan Young
*/

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtilityTestStudent {

    @Test
    public void testGetTotal() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0, 5.0}};
        assertEquals(15.0, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
    }

    @Test
    public void testGetAverage() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0, 5.0}};
        assertEquals(3.0, TwoDimRaggedArrayUtility.getAverage(data), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        double[][] data = {{1.0, 2.0},
        		{3.0, 4.0, 5.0}};
        assertEquals(12.0, TwoDimRaggedArrayUtility.getRowTotal(data, 1), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0, 5.0}, {6.0}};
        assertEquals(10.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 0), 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0, 5.0}};
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(data, 1), 0.001);
    }

    @Test
    public void testGetLowestInRow() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0, 5.0}};
        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInRow(data, 1), 0.001);
    }

    @Test
    public void testGetHighestInArray() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0, 5.0}};
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInArray(data), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0, 5.0}};
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(data), 0.001);
    }

    @Test
    public void testReadFile() throws FileNotFoundException, IOException {
        // Set up a temporary file with predefined content
        File tempFile = File.createTempFile("test", ".txt");
        PrintWriter writer = new PrintWriter(tempFile);
        writer.println("1.0 2.0");
        writer.println("3.0 4.0 5.0");
        writer.close();

        double[][] expected = {{1.0, 2.0}, {3.0, 4.0, 5.0}};
        double[][] result = TwoDimRaggedArrayUtility.readFile(tempFile);
        assertArrayEquals(expected, result);
        
        // Clean up the file
        tempFile.delete();
    }

    @Test
    public void testWriteToFile() throws FileNotFoundException, IOException {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0, 5.0}};
        File tempFile = File.createTempFile("testOutput", ".txt");
        
        TwoDimRaggedArrayUtility.writeToFile(data, tempFile);
        Scanner scanner = new Scanner(tempFile);
        assertTrue(scanner.hasNextLine());
        assertEquals("1.0 2.0", scanner.nextLine());
        assertEquals("3.0 4.0 5.0", scanner.nextLine());
        scanner.close();

        // Clean up the file
        tempFile.delete();
    }
}
