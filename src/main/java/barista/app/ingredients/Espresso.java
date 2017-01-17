package barista.app.ingredients;

import barista.app.Ingredient;

public class Espresso extends Ingredient {

	public Espresso(int quantity) {
		super("Espresso", (float) 1.10, quantity);
	}

}
