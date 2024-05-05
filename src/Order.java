import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;


public class Order extends Object implements OrderInterface, Comparable<Order> {
    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private List<Beverage> beverages;

    // Parameterized constructor
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNumber = generateOrder();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Ensures use of copy constructor
        this.beverages = new ArrayList<>();
    }



	// Generate a random number for the order
    private int generateOrder() {
        Random rand = new Random();
        return 10000 + rand.nextInt(80001); // From 10000 to 90000
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo); // Shallow copy, actual reference
        }
        return null;
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage bev : beverages) {
            total += bev.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage bev : beverages) {
            if (bev.getType() == type) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Order{orderNumber=" + orderNumber + ", orderTime='" + orderTime + "', orderDay=" + orderDay +
               ", customer=" + customer + ", beverages=" + beverages + "}";
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNumber, other.orderNumber);
    }

    // Getters and Setters
    public int getOrderNo() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }
    
    public Day getDay() {
    	LocalDate now = LocalDate.now();
    	Day day = Day.valueOf(now.getDayOfWeek().toString().toUpperCase());
    	return day;
    }

    public void setOrderDay(Day orderDay) {
        this.orderDay = orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // Deep copy
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer); // Uses copy constructor for deep copy
    }

    public List<Beverage> getBeverages() {
        return new ArrayList<>(beverages); // Return a shallow copy of the list
    }

    public void setBeverages(List<Beverage> beverages) {
        this.beverages = new ArrayList<>(beverages);
    }
    public int getTotalItems() {
        return beverages.size();
    }
}
