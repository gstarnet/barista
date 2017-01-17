package barista.app;

public abstract class Ingredient implements Comparable<Ingredient>{

	private String name;
	private float unitCost;
	private int quantity;
	
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getName() {
		return name;
	}

	public float getUnitCost() {
		return unitCost;
	}

	public boolean checkIfAvailable(int requestedQuantity){
		if(quantity >= requestedQuantity){
			return true;
		}
		return false;
	}

	public Ingredient(String name, float unitCost, int quantity) {
		super();
		this.name = name;
		this.unitCost = unitCost;
		this.quantity = quantity;
	}
	
	
	public int compareTo(Ingredient o) {
		
		return this.getName().compareTo(o.getName());
	}

	public String inventoryDescription() {
		return name + "," + quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
