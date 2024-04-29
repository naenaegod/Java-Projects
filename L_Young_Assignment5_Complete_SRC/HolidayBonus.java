/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Uses the twodimutility to total up bonus and spit them out. 
 * Due: 04/19/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Logan Young
*/

public class HolidayBonus {

    // Constant values for bonus amounts
    private static final double HIGH_BONUS = 5000.0;
    private static final double LOW_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;
    private static final double SINGLE_STORE_BONUS = 5000.0;

    /**
     * Calculates the holiday bonuses for each store in the district based on sales data.
     * @param data the two-dimensional ragged array of store sales
     * @return an array of doubles representing the holiday bonuses for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        int maxColumns = getMaxColumns(data);

        // Iterate over each category (column in the sales data)
        for (int col = 0; col < maxColumns; col++) {
            int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
            boolean singleStore = highestIndex == lowestIndex; // Determines if single store by checking how many are in the array

            // Iterate over each store (row)
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length && data[row][col] > 0) {  // Store must have positive sales to qualify for a bonus
                    if (singleStore) {
                        bonuses[row] += SINGLE_STORE_BONUS;
                    } else {
                        if (row == highestIndex) {
                            bonuses[row] += HIGH_BONUS;
                        } else if (row == lowestIndex) {
                            bonuses[row] += LOW_BONUS;
                        } else {
                            bonuses[row] += OTHER_BONUS;
                        }
                    }
                }
            }
        }

        return bonuses;
    }

    /**
     * Calculates the total of all holiday bonuses for the district.
     * @param data the two-dimensional ragged array of store sales
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double total = 0;
        double[] bonuses = calculateHolidayBonus(data);
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }

    /**
     * Finds the maximum number of columns in any row of the provided two-dimensional array.
     * @param data the two-dimensional array of store sales
     * @return the maximum number of columns across all rows
     */
    private static int getMaxColumns(double[][] data) {
        int max = 0;
        for (double[] row : data) {
            if (row.length > max) {
                max = row.length;
            }
        }
        return max;
    }

 
}
