package barista.app.menuitems;


import java.util.List;

import barista.app.DrinkItem;
import barista.app.Ingredient;

public class CoffeeDrink extends DrinkItem {

	public CoffeeDrink(List <Ingredient> ingredients) {
		super("Coffee", ingredients);
	}

}
