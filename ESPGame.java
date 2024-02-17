
import java.util.Scanner;
import java.util.Random;

/*
 * Class: CMSC203 
 * Instructor:
 * Description: This program tests the user's ESP by guessing colors.
 * Due: 02/16/24
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Logan Young
 */

public class ESPGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Constants for color names
        final String COLOR_RED = "Red";
        final String COLOR_GREEN = "Green";
        final String COLOR_BLUE = "Blue";
        final String COLOR_ORANGE = "Orange";
        final String COLOR_YELLOW = "Yellow";
        
        int score = 0;
        
        // User input for personal information
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.println("Describe yourself: ");
        String description = scanner.nextLine();
        
        System.out.println("Due Date: ");
        String dueDate = scanner.nextLine();
        
        System.out.println("CMSC203 Assignment1: Test your ESP skills!");
        
        // Main game loop
        for (int i = 1; i <= 11; i++) {
            System.out.println("Round " + i);
            System.out.println("I am thinking of a color.\nIs it Red, Green, Blue, Orange, or Yellow?\nEnter your guess: ");
            
            // Randomly select a color
            int colorIndex = random.nextInt(5);
            String selectedColor = "";
            switch (colorIndex) {
                case 0:
                    selectedColor = COLOR_RED;
                    break;
                case 1:
                    selectedColor = COLOR_GREEN;
                    break;
                case 2:
                    selectedColor = COLOR_BLUE;
                    break;
                case 3:
                    selectedColor = COLOR_ORANGE;
                    break;
                case 4:
                    selectedColor = COLOR_YELLOW;
                    break;
            }
            
            String userGuess = scanner.nextLine();
            userGuess = userGuess.trim().toLowerCase();
            
            // Check the user's guess against the selected color
            boolean validColor = true;
            switch (userGuess.toLowerCase()) {
                case "red":
                case "green":
                case "blue":
                case "orange":
                case "yellow":
                    if (userGuess.equalsIgnoreCase(selectedColor)) {
                        score++;
                        System.out.println("You guessed correctly!");
                    } else {
                        System.out.println("Incorrect. The correct color was " + selectedColor + ".");
                    }
                    break;
                default:
                    validColor = false;
                    System.out.println("You entered an incorrect color. Please guess again.");
                    i--; // Decrement the counter to repeat the round because of invalid input
            }
            
            if (validColor) {
                System.out.println("I was thinking of " + selectedColor + ".");
            }
        }
        
        // Results
        System.out.println("Game Over\n\nYou guessed " + score + " out of 11 colors correctly.");
        System.out.println("Student Name: " + name);
        System.out.println("User Description: " + description);
        System.out.println("Due Date: " + dueDate);
        
        scanner.close();
    }
}
