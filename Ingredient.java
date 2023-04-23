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
    public void printTasteStats() 
    {
        System.out.println(name + " is:"
            + "\n" + volume + " ml"
            + "\nSweet: " + doubleToPercent(findFlavor("sweet").getIntensity())
            + "\nSalt: " + doubleToPercent(findFlavor("salt").getIntensity())
            + "\nSour: " + doubleToPercent(findFlavor("sour").getIntensity())
            + "\nBitter: " + doubleToPercent(findFlavor("bitter").getIntensity())
            + "\nSavory: " + doubleToPercent(findFlavor("umami").getIntensity()) + "\n");
	}

    public void printTasteStats2()
    {
        System.out.println
        (
            name + " is "
            + " Sweet: " + doubleToPercent(findFlavor("sweet").getIntensity())
            + " Salt: " + doubleToPercent(findFlavor("salt").getIntensity())
            + " Sour: " + doubleToPercent(findFlavor("sour").getIntensity())
            + " Bitter: " + doubleToPercent(findFlavor("bitter").getIntensity())
            + " Savory: " + doubleToPercent(findFlavor("umami").getIntensity()) + "\n"
        );
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
    //Calls the correct get meathod based off of parameter
    public double getTasteByString(String tasteString)
    {
        if (tasteString.equals("sweet"))
        {
            return getSweet();
        } 
        else if (tasteString.equals("sour"))
        {
            return getSour();
        }
        else if (tasteString.equals("salt"))
        {
            return getSalt();
        }
        else if (tasteString.equals("bitter"))
        {
            return getBitter();
        }
        else if (tasteString.equals("umami"))
        {
            return getUmami();
        }
        else 
        {
            System.out.println("getTasteByString parameter error");
            return -1;
        }
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
