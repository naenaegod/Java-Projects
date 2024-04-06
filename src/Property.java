/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Handles property creation and calls plots.
 * Due: 04/05/2024
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Logan Young
*/
public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Creates a new Property using empty strings and a default Plot.
    public Property() {
        this("", "", 0, "", 0, 0, 1, 1); // Assuming default Plot values
    }

    // Creates a new Property object using given values and a default Plot.
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1); // Assuming default Plot values
    }

    // Creates a new Property object using given values and creates a Plot using given plot values.
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // Creates a new copy of the given property object.
    public Property(Property otherProperty) {
        this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount, otherProperty.owner, 
             otherProperty.plot.getX(), otherProperty.plot.getY(), otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
    }

    // Gets the plot.
    public Plot getPlot() {
        return this.plot;
    }

    // Gets the property name.
    public String getPropertyName() {
        return this.propertyName;
    }

    // Gets the city where the property is located.
    public String getCity() {
        return this.city;
    }

    // Gets the rent amount.
    public double getRentAmount() {
        return this.rentAmount;
    }

    // Gets the owner's name.
    public String getOwner() {
        return this.owner;
    }

    // Represents a Property object in the specified format.
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}