package barista.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import barista.app.ingredients.Cocoa;
import barista.app.ingredients.Coffe;
import barista.app.ingredients.Cream;
import barista.app.ingredients.DecafCoffe;
import barista.app.ingredients.Espresso;
import barista.app.ingredients.FoamedMilk;
import barista.app.ingredients.SteamedMilk;
import barista.app.ingredients.Sugar;
import barista.app.ingredients.WhippedCream;

public class Inventory {

	List <Ingredient> inventory;
	
	public Inventory() {
		
		inventory = new ArrayList<Ingredient>();
		
		inventory.add(new WhippedCream(10));
		
		inventory.add(new Cocoa(10));
		inventory.add(new Coffe(10));
		inventory.add(new Cream(10));
		inventory.add(new DecafCoffe(10));
		inventory.add(new Espresso(10));
		inventory.add(new FoamedMilk(10));
		inventory.add(new SteamedMilk(10));
		inventory.add(new Sugar(10));
		
		
		Collections.sort(inventory);
		
		
	}
	
	public List<Ingredient> getInventory() {
		return inventory;
	}

	public void printInventory(){
		System.out.println("Inventory :\n");
		for(Ingredient i:inventory){
			System.out.println(i.inventoryDescription());
		}
		
		System.out.println("\n");
		
	}
	
	public boolean dispence(DrinkItem di){
		if(di.isAvailable(inventory)){
			// Dispensing:
			System.out.println("Dispensing : "+di.getName());
			for(Ingredient i:di.getIngredients()){
				Ingredient inv = inventory.get(inventory.indexOf(i));
				inv.setQuantity(inv.getQuantity()-i.getQuantity());
			}
			return true;
			
		}
		return false;
		
	}

}
