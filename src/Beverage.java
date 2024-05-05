
public abstract class Beverage {
	private String name;
	private Type type;
	private Size size;
	private static final double BASE_PRICE = 2.0;
	private static final double SIZE_PRICE = .5;
	
	public Beverage(String name, Type type, Size size) {
		this.name = name;
		this.type = type;
		this.size = size;
		
	}
	
	public double addSizePrice() {
		switch (size) {
		case SMALL: 
			return BASE_PRICE;
		case MEDIUM:
			return BASE_PRICE + SIZE_PRICE;
		case LARGE:
			return BASE_PRICE + (2* SIZE_PRICE);
		default: 
			return BASE_PRICE;
		
		}
	}
	
	public abstract double calcPrice();

    @Override
    public String toString() {
        return "Beverage " + name + " Size: " + size + "type " + type;
    }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Beverage beverage = (Beverage) obj;
		return name.equals(beverage.name) && type == beverage.type && size == beverage.size;
		}
	
	 // Getters
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}

