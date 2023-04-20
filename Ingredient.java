import java.util.*;

public class Ingredient 
{
    private String name;
    private double volume;
    private double sweet;
    private double sour;
    private double salt;
    private double bitter;
    private double umami;

    //Constructor
    public Ingredient (String name_, double millileters, double sweet_, double sour_, double salt_, double bitter_, double umami_)
    {
        name = name_;
        volume = millileters;
        sweet = sweet_;
        sour = sour_;
        salt = salt_;
        bitter = bitter_;
        umami = umami_;
    }

    public String getStringTaste() {
        return "sweet: " + sweet + " salt: " + salt + " sour: " + sour + " bitter: " + bitter + " umami: " + umami;
	}








    //getters
    public String getName()
    {
        return name;
    }
    public double getVolume () 
    {
        return volume;
    }
    public double getSweet () 
    {
        return sweet;
    }
    public double getSour () 
    {
        return sour;
    }
    public double getSalt () 
    {
        return salt;
    }
    public double getBitter () 
    {
        return bitter;
    }
    public double getUmami () 
    {
        return umami;
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
    public void setSweet (double a) 
    {
        sweet = a;
    }
    public void setSour (double a) 
    {
        sour = a;
    }
    public void setSalt (double a) 
    {
        salt = a;
    }
    public void setBitter (double a) 
    {
        bitter = a;
    }
    public void setUmami (double a) 
    {
        umami = a;
    }

}
