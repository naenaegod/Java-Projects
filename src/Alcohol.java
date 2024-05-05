
public class Alcohol extends Beverage {
    private boolean weekendOffer;
    private static final double WEEKEND_COST = 0.60;

    public Alcohol(String name, Size size, boolean weekendOffer) {
        super(name, Type.ALCOHOL, size);
        this.weekendOffer = weekendOffer;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (weekendOffer) {
            price += WEEKEND_COST;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Alcohol name='" + getName() + "', size=" + getSize() + 
               ", weekend offer=" + weekendOffer + ", price=" + calcPrice() + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Alcohol)) return false;
        Alcohol other = (Alcohol) obj;
        return weekendOffer == other.weekendOffer; //returns if it is also a weekend offer, after checking everything else is equivalent.
    }

    // Getters and Setters
    public boolean isWeekendOffer() {
        return weekendOffer;
    }

    public void setWeekendOffer(boolean weekendOffer) {
        this.weekendOffer = weekendOffer;
    }
}
