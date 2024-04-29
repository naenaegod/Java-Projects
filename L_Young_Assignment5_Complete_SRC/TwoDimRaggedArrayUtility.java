/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Handles primary calculations and get methods needed to calculate bonus and total them up.
 * Due: 04/19/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Logan Young
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {

    // Constructor
    public TwoDimRaggedArrayUtility() {
        // Empty constructor since it's a utility class
    }

    // Returns the total of all elements in the two-dimensional array
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double element : row) {
                total += element;
            }
        }
        return total;
    }

    // Returns the average of the elements in the two-dimensional array
    public static double getAverage(double[][] data) {
        int count = 0;
        double sum = 0;
        for (double[] row : data) {
            for (double element : row) {
                sum += element;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    // Returns the total of the selected row in the two-dimensional array
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        if (row < data.length) {
            for (double element : data[row]) {
                total += element;
            }
        }
        return total;
    }

    // Returns the total of the selected column in the two-dimensional array
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    // Returns the largest element of the selected row in the two-dimensional array
    public static double getHighestInRow(double[][] data, int row) {
        double max = Double.MIN_VALUE;
        if (row < data.length) {
            for (double element : data[row]) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    // Returns the index of the largest element of the selected row in the two-dimensional array
    public static int getHighestInRowIndex(double[][] data, int row) {
        double max = Double.MIN_VALUE;
        int index = -1;
        if (row < data.length) {
            for (int i = 0; i < data[row].length; i++) {
                if (data[row][i] > max) {
                    max = data[row][i];
                    index = i;
                }
            }
        }
        return index;
    }

    // Returns the smallest element of the selected row in the two-dimensional array
    public static double getLowestInRow(double[][] data, int row) {
        double min = Double.MAX_VALUE;
        if (row < data.length) {
            for (double element : data[row]) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    // Returns the index of the smallest element of the selected row in the two-dimensional array
    public static int getLowestInRowIndex(double[][] data, int row) {
        double min = Double.MAX_VALUE;
        int index = -1;
        if (row < data.length) {
            for (int i = 0; i < data[row].length; i++) {
                if (data[row][i] < min) {
                    min = data[row][i];
                    index = i;
                }
            }
        }
        return index;
    }

    // Returns the largest element of the selected column in the two-dimensional array
    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.MIN_VALUE;
        for (double[] row : data) {
            if (col < row.length && row[col] > max) {
                max = row[col];
            }
        }
        return max;
    }

    // Returns the index of the largest element of the selected column in the two-dimensional array
    public static int getHighestInColumnIndex(double[][] data, int col) {
        double max = Double.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > max) {
                max = data[i][col];
                index = i;
            }
        }
        return index;
    }

    // Returns the smallest element of the selected column in the two-dimensional array
    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.MAX_VALUE;
        for (double[] row : data) {
            if (col < row.length && row[col] < min) {
                min = row[col];
            }
        }
        return min;
    }

    // Returns the index of the smallest element of the selected column in the two-dimensional array
    public static int getLowestInColumnIndex(double[][] data, int col) {
        double min = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < min) {
                min = data[i][col];
                index = i;
            }
        }
        return index;
    }

    // Returns the largest element in the two-dimensional array
    public static double getHighestInArray(double[][] data) {
        double max = Double.MIN_VALUE;
        for (double[] row : data) {
            for (double element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    // Returns the smallest element in the two-dimensional array
    public static double getLowestInArray(double[][] data) {
        double min = Double.MAX_VALUE;
        for (double[] row : data) {
            for (double element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    // Reads from a file and returns a ragged array of doubles
    public static double[][] readFile(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("File not found.");
        }

        Scanner scanner = new Scanner(file);
        double[][] temp = new double[10][];
        int numRows = 0;

        while (scanner.hasNextLine() && numRows < 10) {
            String[] elements = scanner.nextLine().trim().split("\\s+");
            double[] row = new double[elements.length];
            for (int i = 0; i < elements.length; i++) {
                row[i] = Double.parseDouble(elements[i]);
            }
            temp[numRows++] = row;
        }

        double[][] data = new double[numRows][];
        System.arraycopy(temp, 0, data, 0, numRows);
        scanner.close();
        return data;
    }

    // Writes the ragged array of doubles into the file
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (double[] row : data) {
            for (int i = 0; i < row.length; i++) {
                writer.print(row[i] + (i < row.length - 1 ? " " : ""));
            }
            writer.println();
        }
        writer.close();
    }
}
