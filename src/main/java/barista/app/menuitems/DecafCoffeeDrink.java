package barista.app.menuitems;


import java.util.List;

import barista.app.DrinkItem;
import barista.app.Ingredient;

public class DecafCoffeeDrink extends DrinkItem {

	public DecafCoffeeDrink(List <Ingredient> ingredients) {
		super("Decaf Coffee", ingredients);
	}

}
