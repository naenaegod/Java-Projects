
public class Smoothie extends Beverage {
    private int numberOfFruits;
    private boolean proteinPowder;
    private static final double PROTEIN_POWDER_COST = 1.50;
    private static final double EXTRA_FRUIT_COST = 0.50;

    public Smoothie(String name, Size size, int numberOfFruits, boolean proteinPowder) {
        super(name, Type.SMOOTHIE, size);
        this.numberOfFruits = numberOfFruits;
        this.proteinPowder = proteinPowder;
    }


	@Override
    public double calcPrice() {
        double price = addSizePrice() + (numberOfFruits * EXTRA_FRUIT_COST);
        if (proteinPowder) {
            price += PROTEIN_POWDER_COST;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Smoothie{name='" + getName() + "', size=" + getSize() + 
               ", protein powder=" + proteinPowder + ", number of fruits=" + numberOfFruits +
               ", price=" + calcPrice() + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Smoothie)) return false;
        Smoothie other = (Smoothie) obj;
        return numberOfFruits == other.numberOfFruits && proteinPowder == other.proteinPowder;
    }

    // Getters and Setters
    public int getNumberOfFruits() {
        return numberOfFruits;
    }

    public void setNumberOfFruits(int numberOfFruits) {
        this.numberOfFruits = numberOfFruits;
    }

    public boolean isProteinPowder() {
        return proteinPowder;
    }

    public void setProteinPowder(boolean proteinPowder) {
        this.proteinPowder = proteinPowder;
    }
}
