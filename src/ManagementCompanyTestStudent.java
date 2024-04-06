/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: tests management company
 * Due: 04/05/2024
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Logan Young
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManagementCompanyTestStudent {
    private ManagementCompany company;

    @BeforeEach
    void setUp() {
        company = new ManagementCompany("ABC Management", "123456789", 6);
    }

    @Test
    void testAddProperty() {
        assertEquals(0, company.addProperty("Sunset Villa", "Oceanview", 1000, "John Doe"),
                "First property should be added at index 0");
        assertEquals(1, company.addProperty("Lakeside Cottage", "Lakeland", 1500, "Jane Smith", 1, 1, 2, 2),
                "Second property should be added at index 1");
        System.out.println(company.addProperty(new Property("City Apartment", "Downtown", 2000, "Alice Johnson")));
        
        
        
    }

    @Test
    void testAddPropertyWhenFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            company.addProperty(new Property("Property " + i, "City", 1000 + i * 100, "Owner " + i));
        }
        System.out.println(company.addProperty(new Property("Extra Property", "City", 2000, "Extra Owner")));
    }

    @Test
    void testRemoveLastProperty() {
        company.addProperty("Property One", "City", 1000, "Owner");
        company.removeLastProperty();
        assertEquals(0, company.getPropertiesCount(), "Property count should be 0 after removing the last property");
    }

    @Test
    void testIsPropertiesFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY+ 1; i++) {
            company.addProperty(new Property("Property " + i, "City", 1000 + i * 100, "Owner " + i));
        }
        assertTrue(company.isPropertiesFull(), "Properties array should be full");
        
    }

    @Test
    void testGetTotalRent() {
        company.addProperty(new Property("Sunset Villa", "Oceanview", 1000, "John Doe"));
        company.addProperty(new Property("Lakeside Cottage", "Lakeland", 1500, "Jane Smith"));
        assertEquals(2500, company.getTotalRent(), "Total rent should be 2500");
    }

    @Test
    void testGetHighestRentProperty() {
        company.addProperty(new Property("Sunset Villa", "Oceanview", 1000, "John Doe"));
        Property highestRentProperty = new Property("Lakeside Cottage", "Lakeland", 1500, "Jane Smith");
        company.addProperty(highestRentProperty);
        assertEquals(highestRentProperty, company.getHighestRentProperty(), 
                "Lakeside Cottage should be the property with the highest rent");
    }

    @Test
    void testManagementFeeCalculation() {
        company.addProperty(new Property("Sunset Villa", "Oceanview", 1000, "John Doe"));
        double expectedFee = 1000 * (6.0 / 100); // Management fee is 6%
        double actualFee = company.getTotalRent() * (company.getMgmFeePer() / 100);
        assertEquals(expectedFee, actualFee, "Management fee should be calculated correctly");
    }
}