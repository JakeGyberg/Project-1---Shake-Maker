import java.util.*;

public class Shake extends Ingredient
{
    //List of ingredients in the shake
	private ArrayList<Ingredient> blender = new ArrayList<Ingredient>();

    //Constructor with default shake base
    public Shake(String name_) {
		super(name_, 250, 1, 0.8, 0, 0, 0, 0.2);
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
	
    //Adjusts the shake's flavors 
    public double runningAverage(double sweet, double volume, double newSweet, double newVolume, double tasteFactor)
    {//add tast facotr param
        double flavorVolume = volume * sweet;
        double newFlavorVolume = newVolume * newSweet * tasteFactor;
        double totalVolume = volume + newVolume;
        //System.out.println(tasteFactor);
        return (flavorVolume + newFlavorVolume) / totalVolume;
    }

    //Adds ingredient which catolougs the ingredients in the shake and adjusts the shakes favors based off of the new ingredient's flavors and how much of the new ingredient is being added
	public void addIngredient (Ingredient newIngredient, double volume)
	{
		blender.add(new Ingredient(newIngredient.getName(), newIngredient.getVolume(), newIngredient.getTasteFactor(), newIngredient.getSweet(), newIngredient.getSour(), newIngredient.getSalt(), newIngredient.getBitter(), newIngredient.getUmami()));
        setVolume(getVolume() + volume);
        //System.out.println("hyeyey" + runningAverage(getSweet(), getVolume(), newIngredient.getSweet(), volume));
        setSweet(runningAverage(getSweet(), getVolume(), newIngredient.getSweet(), volume, newIngredient.getTasteFactor()));
        setSour(runningAverage(getSour(), getVolume(), newIngredient.getSour(), volume, newIngredient.getTasteFactor()));
        setSalt(runningAverage(getSalt(), getVolume(), newIngredient.getSalt(), volume, newIngredient.getTasteFactor()));
        setBitter(runningAverage(getBitter(), getVolume(), newIngredient.getBitter(), volume, newIngredient.getTasteFactor()));
        setUmami(runningAverage(getUmami(), getVolume(), newIngredient.getUmami(), volume, newIngredient.getTasteFactor()));
    }

    //Print the taste of the shake
    public void rateShake () 
    {
        int numOfExcessive = 0;

        for (Flavor f: getFlavors()) 
        {
            if (f.getIntensity() > 0.8 || (f.getType().equals("bitter") && f.getIntensity() > 0.1)) {
                numOfExcessive++;
                Ingredient maxTaste = blender.get(0);
                for (Ingredient i: blender)
                {
                    double iInfluence = i.getVolume() * i.getTasteByString(f.getType()) * i.getTasteFactor();
                    double maxInfluence = maxTaste.getVolume() * maxTaste.getTasteByString(f.getType()) * maxTaste.getTasteFactor();
                    if (iInfluence > maxInfluence)
                    {
                        maxTaste = i;
                    }
                }
                System.out.println("Too much " + f.getType() + ". Less " + maxTaste.getName());
            }
        }
        if (numOfExcessive == 0) 
        {
            System.out.println("This milkshake might taste good");
        }
    }

}
