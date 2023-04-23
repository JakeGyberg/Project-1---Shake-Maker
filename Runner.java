import java.util.*;

public class Runner
{


    public static void main(String[] args) {

        //List of ingredients shown to user
		ArrayList<Ingredient> ingredientOptions = new ArrayList<Ingredient>();

		//saadfsafas
		ingredientOptions.add(new Ingredient("chocolate", 0, 1.5, 0.5, 0, 0, 0.2, 0.2));
		ingredientOptions.add(new Ingredient("caramel", 0, 1, 0.6, 0, 0.2, 0, 0.2));
		ingredientOptions.add(new Ingredient("penut butter", 0, 1, 0.2, 0, 0.2, 0.1, 0.5));
		ingredientOptions.add(new Ingredient("honey", 0, 10, 0.9, 0, 0, 0, 0.1));
		ingredientOptions.add(new Ingredient("salt", 0, 10, 0, 0, 1, 0, 0.01));
		ingredientOptions.add(new Ingredient("grahm cracker", 0, 1, 0.4, 0, 0, 0, 0.4));
		ingredientOptions.add(new Ingredient("coffee", 0, 4, 0, .1, 0, .8, .1));

		//Fruit
		ingredientOptions.add(new Ingredient("strawberry", 0, 1, 0.6, 0.2, 0, 0.05, 0));
		ingredientOptions.add(new Ingredient("orange", 0, 1, 0.6, 0.3, 0, 0.05, 0));
		//ingredientOptions.add(new Ingredient("mint", 0, 1, .3, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("rasberry", 0, 1, .6, .2, 0, 0, 0));
		ingredientOptions.add(new Ingredient("lemon", 0, 1, .3, .8, 0, 0, 0));
		ingredientOptions.add(new Ingredient("peach", 0, 1, .7, 0, 0, 0, 0));
		ingredientOptions.add(new Ingredient("bannana", 0, 1, .5, 0, 0, 0, 0.2));
		ingredientOptions.add(new Ingredient("cherry", 0, 1, 0.6, 0.4, 0, 0, 0));
		
/* 
		//Creates the shake object
		Shake myShake = new Shake("Milkshake_v1");
		//Base shake stats
		myShake.printTasteStats();

		//Add ingredient
		
		// 1 tsp = 5 ml
		//1 tbsp = 15 ml
		//1 cup = 237 ml
		//1 pint = 437 ml
		//1 quart = 946 ml
		//1 gallon 3785 ml
		 
 		myShake.addIngredient(myShake.findIngredient("chocolate", ingredientOptions), 50);
		myShake.addIngredient(myShake.findIngredient("penut butter", ingredientOptions), 50);
		myShake.addIngredient(myShake.findIngredient("honey", ingredientOptions), 111);
		myShake.addIngredient(myShake.findIngredient("grahm cracker", ingredientOptions), 50);
 		myShake.addIngredient(myShake.findIngredient("coffe", ingredientOptions), 15);


		//Adjusted stats ith ne ingredient
		myShake.printTasteStats();

		myShake.rateShake();
 */


		//Game Play
		boolean invalid;
		String playerInput;
		double playerInputDouble = 0;
		boolean playing = true;

		Scanner input = new Scanner(System.in);

		System.out.println("Name your shake");
		playerInput = input.nextLine();
		Shake myShake = new Shake(playerInput);
		myShake.printTasteStats();



		System.out.println("Here are the ingredient options:");
		for (Ingredient i: ingredientOptions)
		{
			i.printTasteStats2();
		}
		while (playing)
		{
			//prompt player 
            System.out.println("Add an ingredient by typing 'add.' Show shake stats by typing 'stats.' Rate shake with 'rate.' ");

            //Get and validate input
            invalid = true;
            while (invalid)
            {
				
                playerInput = input.nextLine();

				//Checks for ingredient input
				if (playerInput.trim().equalsIgnoreCase("add"))
				{
					
					System.out.print("Type the name of the ingredient. ");
					boolean invalid2 = true;
					while (invalid2)
					{
						playerInput = input.nextLine();
						
						for (Ingredient i: ingredientOptions)
						{
							if (playerInput.trim().equalsIgnoreCase(i.getName()))
							{
								System.out.print("How many mls would you like to add? ");

								boolean invalid3 = true;
								while (invalid3)
								{
									playerInput = input.nextLine();
									try 
									{
										playerInputDouble = Double.parseDouble(playerInput);
										invalid3 = false;
									} 
									catch (NumberFormatException e)
									{
										System.out.println("Enter a number.");
									}
									
									
								}
								

								myShake.addIngredient(i, playerInputDouble);

								invalid2 = false;
							}
						}
						if (invalid2)
						{
							System.out.print("\nIngredient not found. Enter the name agian. ");
						}
					}
					invalid = false;
					//input.nextLine();
				} 
				else if (playerInput.trim().equalsIgnoreCase("stats"))
				{
					myShake.printTasteStats();
					invalid = false;
				} 
				else if (playerInput.trim().equalsIgnoreCase("rate"))
				{
					myShake.rateShake();
					invalid = false;
				} 
				else 
				{
					System.out.print("Input not recognised. Try again. ");
				}

			}


			//playing = false;
		}

    }
}
