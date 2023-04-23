import java.util.*;

public class Shake extends Ingredient
{
    //List of ingredients in the shake
	private ArrayList<Ingredient> blender = new ArrayList<Ingredient>();
    private double effectiveVolume;

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
    public double calculateTaste(double flavorPercent, double effectiveVolume, double newFlavorPercent, double newEffectiveVolume)
    {
        double flavorVolume = effectiveVolume * flavorPercent;
        double newFlavorVolume = newEffectiveVolume * newFlavorPercent;
        double totalVolume = effectiveVolume + newEffectiveVolume;
        return (flavorVolume + newFlavorVolume) / totalVolume;
    }

    //Adds ingredient which catologs the ingredients in the shake and adjusts the shakes favors based off of the new ingredient's flavors and how much of the new ingredient is being added
	public void addIngredient (Ingredient newIngredient, double volume)
	{
		blender.add(new Ingredient(newIngredient.getName(), volume, newIngredient.getTasteFactor(), newIngredient.getSweet(), newIngredient.getSour(), newIngredient.getSalt(), newIngredient.getBitter(), newIngredient.getUmami()));
        
        effectiveVolume += volume * newIngredient.getTasteFactor();
        double newEffectiveVolume = volume * newIngredient.getTasteFactor();

        setVolume(getVolume() + volume);

        setSweet(calculateTaste(getSweet(), effectiveVolume, newIngredient.getSweet(), newEffectiveVolume));
        setSour(calculateTaste(getSour(), effectiveVolume, newIngredient.getSour(), newEffectiveVolume));
        setSalt(calculateTaste(getSalt(), effectiveVolume, newIngredient.getSalt(), newEffectiveVolume));
        setBitter(calculateTaste(getBitter(), effectiveVolume, newIngredient.getBitter(), newEffectiveVolume));
        setUmami(calculateTaste(getUmami(), effectiveVolume, newIngredient.getUmami(), newEffectiveVolume));
    }

    //Print the taste of the shake
    public void rateShake () 
    {
        int numOfExcessive = 0;

        for (Flavor f: getFlavors())
        {
            if (f.getIntensity() > 0.8 || (f.getType().equals("bitter") && f.getIntensity() > 0.1) || (f.getType().equals("salt") && f.getIntensity() > 0.2)) {
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
