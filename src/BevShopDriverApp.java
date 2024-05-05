import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        BevShop bevShop = new BevShop();
        Scanner scanner = new Scanner(System.in);
        
        

        System.out.println("The current order in process can have at most " + BevShopInterface.MAX_ORDER_FOR_ALCOHOL + " alcoholic beverages.");
        System.out.println("The minimum age to order an alcohol drink is " + BevShopInterface.MIN_AGE_FOR_ALCOHOL);

        // Continue to handle orders
        while (true) {
            System.out.println("Start please a new order:");
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine().toUpperCase();
            System.out.print("Would you please enter your age: ");
            int age = Integer.parseInt(scanner.nextLine());

            if (bevShop.isValidAge(age)) {
                System.out.println("Your age is above 20 and you are eligible to order alcohol.");
            } else {
                System.out.println("Your Age is not appropriate for alcohol drink!!");
            }

            System.out.print("Enter the order time (8 to 23): ");
            int time = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the day (e.g., MONDAY, TUESDAY): ");
            Day day = Day.valueOf(scanner.nextLine().toUpperCase());

            bevShop.startNewOrder(time, day, name, age);

            boolean ordering = true;
            while (ordering) {
                System.out.print("Would you please add a drink: ");
                String input = scanner.nextLine().toUpperCase();

                if ((input.contains("ALCOHOL") || input.contains("DRINK")) && bevShop.isValidAge(age)) {
                    if (bevShop.isEligibleForMore()) {
                        bevShop.processAlcoholOrder("Generic Alcohol", Size.SMALL);
                        System.out.println("Added alcohol drink. Total drinks: " + bevShop.getNumOfAlcoholDrink());
                    } else {
                        System.out.println("You have a maximum alcohol drinks for this order.");
                        continue;
                    }
                } else if (input.contains("COFFEE")) {
                    bevShop.processCoffeeOrder("Generic Coffee", Size.SMALL, false, false);
                } else if (input.contains("SMOOTHIE")) {
                    bevShop.processSmoothieOrder("Generic Smoothie", Size.MEDIUM, 1, false);
                } else {
                    System.out.println("Invalid drink type.");
                    continue;
                }

                System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());
                System.out.print("Add another drink (yes/no)? ");
                if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                    ordering = false;
                }
            }

            System.out.print("Would you like to start a new order (yes/no)? ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
        scanner.close();
    }
}
