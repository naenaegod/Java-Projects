/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Handles plots and getting and setting as well testing overlaps.
 * Due: 04/05/2024
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Logan Young
*/
public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    // Creates a default Plot with width and depth of 1.
    public Plot() {
        this(0, 0, 1, 1);
    }

    // Creates a Plot using the given values.
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Creates a new plot given another plot. This constructor must call an appropriate existing constructor.
    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    // Determines if the given plot instance is overlapped by the current plot.
    public boolean overlaps(Plot plot) {
        return this.x < plot.x + plot.width && this.x + this.width > plot.x &&
               this.y < plot.y + plot.depth && this.y + this.depth > plot.y;
    }

    // Determines if the given plot is encompassed by (is contained by) this plot.
    public boolean encompasses(Plot plot) {
        return this.x <= plot.x && this.x + this.width >= plot.x + plot.width &&
               this.y <= plot.y && this.y + this.depth >= plot.y + plot.depth;
    }

    // Sets the x.
    public void setX(int x) {
        this.x = x;
    }

    // Sets the y.
    public void setY(int y) {
        this.y = y;
    }

    // Sets the width.
    public void setWidth(int width) {
        this.width = width;
    }

    // Sets the depth.
    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Gets the x.
    public int getX() {
        return x;
    }

    // Gets the y.
    public int getY() {
        return y;
    }

    // Gets the width.
    public int getWidth() {
        return width;
    }

    // Gets the depth.
    public int getDepth() {
        return depth;
    }

    // Represents a Plot object in the following String format. x,y,width,depth
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}