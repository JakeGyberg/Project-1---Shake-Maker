public class Flavor {
    private String type;
    private double intensity;

    public Flavor ()
    {
        type = null;
        intensity = -1000000;
    }

    public Flavor (int typeNum, double i)
    {
        if (typeNum == 1) {
            type = "sweet";
        } else if (typeNum == 2)
        {
            type = "sour";
        } else if (typeNum == 3)
        {
            type = "salt";
        } else if (typeNum == 4)
        {
            type = "bitter";
        } else if (typeNum == 5)
        {
            type = "umami";
        }
        intensity = i;
    }

    public String getType () 
    {
        return type;
    }

    public void settType (int typeNum)
    {
        if (typeNum == 1) {
            type = "sweet";
        } else if (typeNum == 2)
        {
            type = "sour";
        } else if (typeNum == 3)
        {
            type = "salt";
        } else if (typeNum == 4)
        {
            type = "bitter";
        } else if (typeNum == 5)
        {
            type = "umami";
        }
    }

    public double getIntensity ()
    {
        return intensity;
    }

    public void setIntensity (double i) 
    {
        intensity = i;
    }

}
