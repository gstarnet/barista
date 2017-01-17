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
import barista.app.menuitems.CaffeAmericanoDrink;
import barista.app.menuitems.CaffeLatteDrink;
import barista.app.menuitems.CaffeMochaDrink;
import barista.app.menuitems.CappuccinoDrink;
import barista.app.menuitems.CoffeeDrink;
import barista.app.menuitems.DecafCoffeeDrink;

public class Menu {

	List <DrinkItem> drinkItems;
	
	public Menu() {
		
		
		drinkItems = new ArrayList<DrinkItem>();
		
		//Caffe Americano 3 units of espresso
		List <Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(new Espresso(3));
		drinkItems.add(new CaffeAmericanoDrink(ingredients));
		
		//Coffee 3 units of coffee, 1 unit of sugar, 1 unit of cream
		ingredients = new ArrayList<Ingredient>();
		ingredients.add(new Coffe(3));
		ingredients.add(new Sugar(1));
		ingredients.add(new Cream(1));
		drinkItems.add(new CoffeeDrink(ingredients));
		
		//Caffe Latte 2 units of espresso, 1 unit of steamed milk
		ingredients = new ArrayList<Ingredient>();
		ingredients.add(new Espresso(2));
		ingredients.add(new SteamedMilk(1));	
		drinkItems.add(new CaffeLatteDrink(ingredients));
		
		//Caffe Mocha 1 units of Espresso, 1 unit of cocoa, 1 unit of steamed milk, 
		// 1 unit of whipped cream
		ingredients = new ArrayList<Ingredient>();
		ingredients.add(new Espresso(1));
		ingredients.add(new Cocoa(1));
		ingredients.add(new SteamedMilk(1));
		ingredients.add(new WhippedCream(1));
		drinkItems.add(new CaffeMochaDrink(ingredients));
		
		//Cappuccino 2 units of Espresso, 1 unit of steamed milk, 1 unit of foamed milk
		ingredients = new ArrayList<Ingredient>();
		ingredients.add(new Espresso(2));
		ingredients.add(new SteamedMilk(1));
		ingredients.add(new FoamedMilk(1));
		drinkItems.add(new CappuccinoDrink(ingredients));
				
	
		//Decaf Coffee 3 units of Decaf Coffee, 1 unit of sugar, 1 unit of cream
		ingredients = new ArrayList<Ingredient>();	
		ingredients.add(new DecafCoffe(3));
		ingredients.add(new Sugar(1));
		ingredients.add(new Cream(1));
		drinkItems.add(new DecafCoffeeDrink(ingredients));
		
		Collections.sort(drinkItems);
		
	}
	
	public void printMenu(Inventory inventory){
		
		System.out.println("Menu :\n");
		for(DrinkItem i:drinkItems){
			
			System.out.println((drinkItems.indexOf(i)+1) +" , "+i.menuDescription()+","+i.isAvailable(inventory.getInventory()));
		}
		
		System.out.println("\n");
		
	}

	public boolean dispense(int m , Inventory inventory) {
		
		if((m) > drinkItems.size() || m < 1 ){ 
			return false;
		}
		
		DrinkItem di = drinkItems.get(m-1);
		return inventory.dispence(di);
	}

}
