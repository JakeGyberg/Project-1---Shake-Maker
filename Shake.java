import java.util.*;

public class Shake extends Ingredient
{
    //List of ingredients in the shake
	private ArrayList<Ingredient> blender = new ArrayList<Ingredient>();

    //Constructor with default shake base
    public Shake(String name_) {
		super(name_, 250, 80, 0, 0, 0, 20);
	}

	//Finds an ingredient by name from a given ArrayList
	public Ingredient findIngredient (String name, ArrayList<Ingredient> list) 
	{
		for (Ingredient i: list)
        {
            if (i.getName().equalsIgnoreCase(name))
            {
                return i;
            }
        }
        return list.get(0);
	}
	
	public void addIngredient (Ingredient newIngredient, double volume) 
	{
        newIngredient.setVolume(volume);
		blender.add(newIngredient);
        setSweet(getSweet() + newIngredient.getSweet() * newIngredient.getVolume() / getVolume());
        setSour(getSour() + newIngredient.getSour() * newIngredient.getVolume() / getVolume());
        setSalt(getSalt() + newIngredient.getSalt() * newIngredient.getVolume() / getVolume());
        setBitter(getBitter() + newIngredient.getBitter() * newIngredient.getVolume() / getVolume());
        setUmami(getUmami() + newIngredient.getUmami() * newIngredient.getVolume() / getVolume());
	}


	//Rates this shake based off the interaction of its flavors
	public void blend()
	{
		double rating;
	}
}
