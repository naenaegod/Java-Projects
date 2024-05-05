import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CustomerTestStudent {

    private Customer customer;
    private Customer copyCustomer;

    @Before
    public void setUp() {
        customer = new Customer("John Doe", 30);
        copyCustomer = new Customer(customer);  // Testing the copy constructor
    }

    @Test
    public void testCopyConstructor() {
        assertEquals("Copy constructor should copy the name", customer.getName(), copyCustomer.getName());
        assertEquals("Copy constructor should copy the age", customer.getAge(), copyCustomer.getAge());
    }

    @Test
    public void testToString() {
        String expectedOutput = "Customer{name='John Doe', age=30}";
        assertEquals(expectedOutput, customer.toString());
    }

    @Test
    public void testGetters() {
        assertEquals("getName should return the correct name", "John Doe", customer.getName());
        assertEquals("getAge should return the correct age", 30, customer.getAge());
    }

    @Test
    public void testSetters() {
        customer.setName("Jane Doe");
        assertEquals("setName should set the correct name", "Jane Doe", customer.getName());

        customer.setAge(25);
        assertEquals("setAge should set the correct age", 25, customer.getAge());
    }
}
