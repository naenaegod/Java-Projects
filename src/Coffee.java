
public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private static final double EXTRA_SHOT_PRICE = .50;
	private static final double EXTRA_SYRUP_PRICE = .50;
	
	public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
	super(name, Type.COFFEE, size);
	this.extraShot = extraShot;
	this.extraSyrup = extraSyrup;
	
	}
	
	@Override
	public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) {
            price += EXTRA_SHOT_PRICE;
        }
        if (extraSyrup) {
            price += EXTRA_SYRUP_PRICE;
        }
        return price;
    }
	
	 @Override
	 public String toString() {
	       return "Coffee{name='" + getName() + "', size=" + getSize() + 
	              ", extra shot=" + extraShot + ", extra syrup=" + extraSyrup + 
	              ", price=" + calcPrice() + "}";
	    }	
	 
	 @Override
	 public boolean equals(Object obj) {
	        if (!super.equals(obj)) return false;
	        if (!(obj instanceof Coffee)) return false;
	        Coffee other = (Coffee) obj;
	        return extraShot == other.extraShot && extraSyrup == other.extraSyrup;
	    }
	 
	 //getters and setters for coffee additives
	 public boolean isExtraShot() {
	        return extraShot;
	    }

	 public void setExtraShot(boolean extraShot) {
	        this.extraShot = extraShot;
	    }

	 public boolean isExtraSyrup() {
	        return extraSyrup;	
	    }

	 public void setExtraSyrup(boolean extraSyrup) {
	        this.extraSyrup = extraSyrup;
	    }	 


	
}
