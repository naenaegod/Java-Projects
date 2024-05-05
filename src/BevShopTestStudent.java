import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {

    private BevShop bevShop;

    @Before
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testValidTime() {
        assertTrue("10 AM should be a valid time", bevShop.isValidTime(10));
        assertFalse("7 AM should not be a valid time", bevShop.isValidTime(7));
        assertTrue("11 PM should  be a valid time", bevShop.isValidTime(23));
    }

    @Test
    public void testValidAge() {
        assertTrue("Age 21 should be valid for alcohol", bevShop.isValidAge(21));
        assertFalse("Age 20 should not be valid for alcohol", bevShop.isValidAge(20));
    }

    @Test
    public void testStartNewOrder() {
        bevShop.startNewOrder(9, Day.MONDAY, "John Doe", 25);
        assertNotNull("Current order should be initialized", bevShop.getCurrentOrder());
        assertEquals("Total number of monthly orders should be 1", 1, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testProcessOrders() {
        bevShop.startNewOrder(9, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);
        bevShop.processAlcoholOrder("Whisky", Size.LARGE);
        bevShop.processSmoothieOrder("Berry", Size.MEDIUM, 3, true);
        assertEquals(2.5+3+5.50, bevShop.getCurrentOrder().calcOrderTotal(), 0.01);
    }

    @Test
    public void testEligibilityForMoreAlcohol() {
        bevShop.startNewOrder(9, Day.MONDAY, "John Doe", 25);
        bevShop.processAlcoholOrder("Whisky", Size.LARGE);
        bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
        bevShop.processAlcoholOrder("Gin", Size.SMALL);
        assertFalse("Should not be eligible for more alcohol", bevShop.isEligibleForMore());
    }

    @Test
    public void testFindOrder() {
        bevShop.startNewOrder(9, Day.MONDAY, "John Doe", 25);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        bevShop.startNewOrder(10, Day.TUESDAY, "Jane Doe", 22);
        assertEquals("Should find the first order", 0, bevShop.findOrder(orderNo));
    }

    @Test
    public void testTotalMonthlySales() {
        bevShop.startNewOrder(9, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);
        bevShop.processAlcoholOrder("Whisky", Size.LARGE);
        bevShop.startNewOrder(10, Day.TUESDAY, "Jane Doe", 22);
        bevShop.processSmoothieOrder("Berry", Size.MEDIUM, 3, true);
        double expectedSales = bevShop.getCurrentOrder().calcOrderTotal() + bevShop.getOrderAtIndex(0).calcOrderTotal();
        assertEquals(expectedSales, bevShop.totalMonthlySale(), 0.01);
    }
}
