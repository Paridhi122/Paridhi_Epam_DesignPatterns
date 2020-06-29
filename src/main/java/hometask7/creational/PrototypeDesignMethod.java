package hometask7.creational;

import java.util.HashMap;
import java.util.Map;

abstract class Color implements Cloneable
{
    protected String colorName;
    abstract void addColor();
    public Object clone()
    {
        Object clone = null;
        try
        {
            clone = super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return clone;
    }
}

class GreenColor extends Color
{
    public GreenColor()
    {
        this.colorName = "green";
    }

    @Override
    void addColor()
    {
        System.out.println("Green color added");
    }
}

class yellowColor extends Color{

    public yellowColor()
    {
        this.colorName = "yellow";
    }

    @Override
    void addColor()
    {
        System.out.println("Yellow color added");
    }
}

class ColorStore {

    private static Map<String, Color> colorMap = new HashMap<String, Color>();
    static
    {
        colorMap.put("green", new GreenColor());
        colorMap.put("yellow", new yellowColor());
    }
    public static Color getColor(String colorName)
    {
        return (Color) colorMap.get(colorName).clone();
    }
}

class PrototypeDesignMethod
{
    public static void main (String[] args)
    {
        ColorStore.getColor("yellow").addColor();
        ColorStore.getColor("green").addColor();
        ColorStore.getColor("yellow").addColor();
        ColorStore.getColor("green").addColor();
    }
}
