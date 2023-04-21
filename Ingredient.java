import java.util.*;

public class Ingredient 
{
    private String name;
    private double volume;
    private double tasteFactor;

    private ArrayList<Flavor> flavors = new ArrayList<Flavor>();

    //Constructor
    public Ingredient (String n, double v, double tasteFactorNum, double sweetness, double sourness, double saltiness, double bitterness, double savoriness)
    {
        name = n;
        volume = v;
        tasteFactor = tasteFactorNum;
        flavors.add(new Flavor(1, sweetness));
        flavors.add(new Flavor(2, sourness));
        flavors.add(new Flavor(3, saltiness));
        flavors.add(new Flavor(4, bitterness));
        flavors.add(new Flavor(5, savoriness));
    }

    private Flavor findFlavor (String type)
    {
        for (Flavor f: flavors)
        {
            if (f.getType().equals(type))
            {
                return f;
            }
        } 
        return new Flavor();
    }

    private String doubleToPercent (double num)
    {
        return (int) (num * 100) + "%";
    }
    public String getStringTaste() {
        return name + " is\nSweet: " + doubleToPercent(findFlavor("sweet").getIntensity())
            + "\nSalt: " + doubleToPercent(findFlavor("salt").getIntensity())
            + "\nSour: " + doubleToPercent(findFlavor("sour").getIntensity())
            + "\nBitter: " + doubleToPercent(findFlavor("bitter").getIntensity())
            + "\nSavory: " + doubleToPercent(findFlavor("umami").getIntensity()) + "\n";
	}








    //getters
    public ArrayList<Flavor> getFlavors () 
    {
        return flavors;
    }
    public String getName()
    {
        return name;
    }
    public double getVolume () 
    {
        return volume;
    }
    public double getTasteFactor () 
    {
        return tasteFactor;
    }
    public double getSweet () 
    {
        return findFlavor("sweet").getIntensity();
    }
    public double getSour () 
    {
        return findFlavor("sour").getIntensity();
    }
    public double getSalt () 
    {
        return findFlavor("salt").getIntensity();
    }
    public double getBitter () 
    {
        return findFlavor("bitter").getIntensity();
    }
    public double getUmami () 
    {
        return findFlavor("umami").getIntensity();
    }
    //setters
    public void setName (String a) 
    {
        name = a;
    }
    public void setVolume (double a) 
    {
        volume = a;
    }
    public void setTasteFactor (double a) 
    {
        tasteFactor = a;
    }
    
    public void setSweet (double a) 
    {
        flavors.get(0).setIntensity(a);
    }
    public void setSour (double a) 
    {
        findFlavor("sour").setIntensity(a);
    }
    public void setSalt (double a) 
    {
        findFlavor("salt").setIntensity(a);
    }
    public void setBitter (double a) 
    {
        findFlavor("bitter").setIntensity(a);
    }
    public void setUmami (double a) 
    {
        findFlavor("umami").setIntensity(a);
    }

}
