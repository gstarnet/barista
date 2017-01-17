package barista.app;

import java.util.List;

public abstract class DrinkItem implements Comparable<DrinkItem>{

	private String name;
	private float unitCost;
	private List<Ingredient> ingredients;
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public String getName() {
		return name;
	}

	public String getUnitCost() {
		return String.format("$%.02f", unitCost);
	}

	public DrinkItem( String name , List<Ingredient> ingredients) {
		super();
		this.name = name;
		this.ingredients = ingredients;
		for(Ingredient i:ingredients){
			this.unitCost += (i.getUnitCost() * i.getQuantity() );
		}
		
	}
	
	public int compareTo(DrinkItem o) {
		
		return this.getName().compareTo(o.getName());
	}

	public String menuDescription() {
		return name + "," + getUnitCost();
	}
	
	public boolean isAvailable(List <Ingredient> inventory){
		
		if(inventory == null || inventory.isEmpty()){
			return false;
		}
		
		for(Ingredient i:ingredients){
			if(inventory.contains(i)){
				Ingredient inv = inventory.get(inventory.indexOf(i));
				if (inv.getQuantity() < i.getQuantity()){
					return false;
				}
						
			}else{
				return false;
			} 
		}
		return true;
	}
	
}
