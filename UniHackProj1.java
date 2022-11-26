import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class UniHackProj1
{
    public static void main(String[] args)
    {
        Restaurant r1 = new Restaurant("Name1");
    }
}

class Restaurant
{
    private String str;

    private String name;
    private String address;                 //coordinates, address of restaurant
    private String type;                    //restaurant, cafe, etc.
    private String[] menu;
    private String WorkingHours;
    private boolean CoffeeHasSnacks, CoffeeHasMilk;
    private float rating;
    private float priceLwr, priceUpr;
    private boolean isFavorite;
    private boolean isVegan;

    public Restaurant(String str)
    {
        this.str = str;
    }

    public void SplitString()
    {
        String[] arrOfStr = str.split(" ");
        this.name = arrOfStr[0];

        //arrOfStr = str.split(" ");
        //this.s2 = arrOfStr[1];

        //arrOfStr = str.split(" ");
        //this.s3 = arrOfStr[2];
    }

    public String toString()
    {
        return "Name: " + name;
    }


}