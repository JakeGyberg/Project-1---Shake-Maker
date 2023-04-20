import java.util.*;

public class Runner
{
    public static void main(String[] args) {

        //List of ingredients shown to user
		ArrayList<Ingredient> ingredientOptions = new ArrayList<Ingredient>();

		ingredientOptions.add(new Ingredient("chocolate", 0, 50, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("strawberry", 0, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("caramel", 0, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("orange", 0, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("mint", 0, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("rasberry", 0, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("lemon", 0, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("penut butter", 0, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("peach", 0, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("bannana", 0, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("honey", 0, 0, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("cherry", 0, 0, 0, 0, 0, 0));
		//ingredientOptions.add(new Ingredient("honey"));
		//ingredientOptions.add(new Ingredient("honey"));
		//ingredientOptions.add(new Ingredient("honey"));

		//Creates the shake object
		Shake myShake = new Shake("Chocolate");

		myShake.getStringTaste();

		myShake.addIngredient(myShake.findIngredient("chocolate", ingredientOptions), 50);
        System.out.println(ingredientOptions.get(0).getStringTaste());
		myShake.getStringTaste();
    }
}