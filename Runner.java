import java.util.*;

public class Runner
{
    public static void main(String[] args) {

        //List of ingredients shown to user
		ArrayList<Ingredient> ingredientOptions = new ArrayList<Ingredient>();

		ingredientOptions.add(new Ingredient("chocolate", 0, 1.5, 0.5, 0, 0, 0.2, 0.2));
		ingredientOptions.add(new Ingredient("strawberry", 0, 1, 0.6, 0.3, 0, 0.05, 0));
		ingredientOptions.add(new Ingredient("caramel", 0, 1, 0.6, 0, 0.2, 0, 0.2));
		ingredientOptions.add(new Ingredient("orange", 0, 1, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("mint", 0, 1, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("rasberry", 0, 1, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("lemon", 0, 1, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("penut butter", 0, 1, 0.2, 0, 0.2, 0.1, 0.5));
		ingredientOptions.add(new Ingredient("peach", 0, 1, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("bannana", 0, 1, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("honey", 0, 10, 0.9, 0, 0, 0, 0.1));
		ingredientOptions.add(new Ingredient("cherry", 0, 1, 0, 0, 0, 0, 0));
		
		ingredientOptions.add(new Ingredient("salt", 0, 30, 0, 0, 1, 0, 0.01));
		//ingredientOptions.add(new Ingredient("grahm cracker", 0, 1, 0, 0, 0, 0, 0));
		
		//Creates the shake object
		Shake myShake = new Shake("Milkshake_v1");
		//Base shake stats
		System.out.println(myShake.getStringTaste());

		//Add ingredient
		myShake.addIngredient(myShake.findIngredient("strawberry", ingredientOptions), 50);
		myShake.addIngredient(myShake.findIngredient("penut butter", ingredientOptions), 50);
		myShake.addIngredient(myShake.findIngredient("honey", ingredientOptions), 1);
		myShake.addIngredient(myShake.findIngredient("grahm cracker", ingredientOptions), 50);
		myShake.addIngredient(myShake.findIngredient("salt", ingredientOptions), 3);


		//Adjusted stats ith ne ingredient
		System.out.println(myShake.getStringTaste());

		myShake.rateShake();

    }
}
