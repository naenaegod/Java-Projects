/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Tests the results from the calculated bonuses class.
 * Due: 04/19/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Logan Young
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class HolidayBonusTestStudent {

    @Test
    public void testSingleStoreSingleCategory() {
        double[][] sales = {{3000.0}};
        double[] expectedBonuses = {5000.0};
        assertArrayEquals(expectedBonuses, HolidayBonus.calculateHolidayBonus(sales), 0.01);
    }

    @Test
    public void testMultipleStoresSingleCategory() {
        double[][] sales = {{1000.0}, {2000.0}, {3000.0}};
        double[] expectedBonuses = {1000.0, 2000.0, 5000.0};
        assertArrayEquals(expectedBonuses, HolidayBonus.calculateHolidayBonus(sales), 0.01);
    }

    @Test
    public void testMultipleStoresMultipleCategories() {
        double[][] sales = {{1500.0, 0, 2500.0}, //store 1
        					{0, 3000.0, 0},//store 2
        					{500.0, 2000.0, 1000.0}}; //store 3
        double[] expectedBonuses = {5000.0 + 5000.0, 5000.0, 2000.0 + 2000.0 + 2000.0};
        assertArrayEquals(expectedBonuses, HolidayBonus.calculateHolidayBonus(sales), 0.01);
    }

    @Test
    public void testNoSales() {
        double[][] sales = {{0.0}, {0.0}, {0.0}};
        double[] expectedBonuses = {0.0, 0.0, 0.0};
        assertArrayEquals(expectedBonuses, HolidayBonus.calculateHolidayBonus(sales), 0.01);
    }

    @Test
    public void testNegativeSales() {
        double[][] sales = {{-100.0}, {3000.0}, {-50.0}};
        double[] expectedBonuses = {0.0, 5000.0, 0.0};
        assertArrayEquals(expectedBonuses, HolidayBonus.calculateHolidayBonus(sales), 0.01);
    }

    @Test
    public void testMixedSales() {
        double[][] sales = {{-100.0, 1000.0}, //store 1
        					{0.0, 500.0},//store 2
        					{3000.0, 0.0}}; //store 3
        double[] expectedBonuses = {5000.0, 2000.0, 5000.0};
        assertArrayEquals(expectedBonuses, HolidayBonus.calculateHolidayBonus(sales), 0.01);
    }

    @Test
    public void testTotalBonuses() {
        double[][] sales = {{1000.0, 2000.0}, //store 1
        					{2000.0, 1000.0}}; //store 2
        double expectedTotal = 5000.0 + 5000.0 +1000.0 + 1000.0;
        assertEquals(expectedTotal, HolidayBonus.calculateTotalHolidayBonus(sales), 0.01);
    }
}
