import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {

    private Order orderWeekday;
    private Order orderWeekend;
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Alice", 30);
        orderWeekday = new Order(10, Day.MONDAY, customer);
        orderWeekend = new Order(15, Day.SATURDAY, customer);
    }

    @Test
    public void testAddNewBeverage() {
        orderWeekday.addNewBeverage("Latte", Size.MEDIUM, false, true);
        assertEquals("Order should have 1 beverage", 1, orderWeekday.getTotalItems());

        Beverage beverage = orderWeekday.getBeverage(0);
        assertTrue("Beverage should be a coffee", beverage instanceof Coffee);
        assertEquals("Beverage name should be Latte", "Latte", beverage.getName());

        orderWeekend.addNewBeverage("Whiskey", Size.SMALL);
        beverage = orderWeekend.getBeverage(0);
        assertTrue("Beverage should be alcohol", beverage instanceof Alcohol);
        assertEquals("Alcohol on weekends should consider weekend pricing", true, ((Alcohol) beverage).isWeekendOffer());
    }

    @Test
    public void testCalcOrderTotal() {
        orderWeekday.addNewBeverage("Latte", Size.MEDIUM, true, false);
        orderWeekday.addNewBeverage("Cappuccino", Size.SMALL, false, false);
        double expected = 3 + 2.0;  // Assuming prices including extras
        assertEquals("Total should be sum of beverages", expected, orderWeekday.calcOrderTotal(), 0.01);
    }

    @Test
    public void testWeekendCheck() {
        assertFalse("Should return false for a weekday", orderWeekday.isWeekend());
        assertTrue("Should return true for a weekend", orderWeekend.isWeekend());
    }

    @Test
    public void testFindNumOfBeveType() {
        orderWeekday.addNewBeverage("Mocha", Size.LARGE, true, true);
        orderWeekday.addNewBeverage("IPA", Size.MEDIUM);
        orderWeekday.addNewBeverage("Stout", Size.SMALL);

        assertEquals("Should find 1 coffee", 1, orderWeekday.findNumOfBeveType(Type.COFFEE));
        assertEquals("Should find 2 alcohol drinks", 2, orderWeekday.findNumOfBeveType(Type.ALCOHOL));
    }

    @Test
    public void testToString() {
        String expected = "Order{orderNumber=" + orderWeekday.getOrderNo() + ", orderTime='10', orderDay=MONDAY, customer=" + customer + ", beverages=[]}";
        assertEquals("toString should correctly format the order details", expected, orderWeekday.toString());
    }

    @Test
    public void testGettersAndSetters() {
        orderWeekday.setOrderTime(14);
        assertEquals("Order time should be updated to 14", 14, orderWeekday.getOrderTime());

        Day newDay = Day.WEDNESDAY;
        orderWeekday.setOrderDay(newDay);
        assertEquals("Order day should be updated to WEDNESDAY", newDay, orderWeekday.getOrderDay());

        Customer newCustomer = new Customer("Bob", 40);
        orderWeekday.setCustomer(newCustomer);
        assertEquals("Customer should be updated to Bob", "Bob", orderWeekday.getCustomer().getName());
    }
}
