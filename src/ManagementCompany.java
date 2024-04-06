/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Handles property and plot classes together for one company to manage.
 * Due: 04/05/2024
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Logan Young
*/

public class ManagementCompany {
    public static final int MAX_PROPERTY = 5; 
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    private String name;
    private String taxID;
    private double mgmFee;
    private Plot plot;
    private Property[] properties;
    private int propertiesCount = 0;

    // Default constructor
    public ManagementCompany() {
        this("", "", 0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    // Constructor with name, taxID, and mgmFee
    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    // Constructor with all attributes
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    // Copy constructor
    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee, otherCompany.plot.getX(), otherCompany.plot.getY(), otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
        this.properties = new Property[MAX_PROPERTY];
        // Deep copy
        for (int i = 0; i < otherCompany.getPropertiesCount(); i++) {
            if (otherCompany.properties[i] != null) {
                this.addProperty(new Property(otherCompany.properties[i]));
            }
        }
    }

    // Adds a new property to the properties array
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    // Adds a new property with location to the properties array
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    // Creates a property object and adds it to the properties array
    public int addProperty(Property property) {
        if (isPropertiesFull()) {
            return -1;
        }
        if (property == null) {
            return -2;
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        for (Property p : properties) {
            if (p != null && p.getPlot().overlaps(property.getPlot()) && p.getPlot().getWidth() != 1) {
                return -4;
            }
        }
        
        properties[propertiesCount] = property;
        
        return propertiesCount++;
    }

    // Removes the LAST property in the properties array
    public void removeLastProperty() {
        if (propertiesCount > 0) {
            properties[propertiesCount - 1] = null;
            propertiesCount--;
        }
    }

    // Check if properties array is full
    public boolean isPropertiesFull() {
        return propertiesCount == MAX_PROPERTY;
    }

    // Gets the number of existing properties
    public int getPropertiesCount() {
        return propertiesCount;
    }

    // Calculates total rent
    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < propertiesCount; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    // Finds the property with the highest rent amount
    public Property getHighestRentProperty() {
        Property maxRentProperty = null;
        double maxRent = 0;
        for (int i = 0; i < propertiesCount; i++) {
            if (properties[i].getRentAmount() > maxRent) {
                maxRent = properties[i].getRentAmount();
                maxRentProperty = properties[i];
            }
        }
        return maxRentProperty;
    }

    // Checks if the management fee is valid
    public boolean isManagementFeeValid() {
        return mgmFee >= 0 && mgmFee <= 100;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public Property[] getProperties() {
        return properties;
    }

    public double getMgmFeePer() {
        return mgmFee;
    }

    public Plot getPlot() {
        return plot;
    }

    // Returns information of all the properties
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("List of the properties for " + name + ", taxID: " + taxID + "\n");
        
        sb.append("______________________________________________________\n");
        for (int i = 0; i < propertiesCount; i++) {
        	
            sb.append(properties[i].toString()).append("\n");
            sb.append("______________________________________________________\n");
            sb.append("\n");
            
        }
        sb.append(" total management Fee: " + (getTotalRent() * (mgmFee)/100));
        return sb.toString();
    }
}