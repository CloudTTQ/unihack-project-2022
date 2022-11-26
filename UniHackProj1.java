import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class UniHackProj1
{
    public static void main(String[] args)
    {
        Restaurant r1 = new Restaurant("Name1,Address1,Cafe,10:00-22:00,4.5,true,false,10");

        r1.setName();
        r1.setAddress();
        r1.setType();
        r1.setWorkingHours();
        r1.setRating();
        r1.setPriceLwr(20.00);
        r1.setPriceUpr(35.75);
        r1.setIsFavorite();
        //r1.setIsVegan();
        //r1.setCoffeeHas();
        r1.setMenu();

        System.out.println(r1);
    }
}

class Restaurant
{
    private String str;
    private String[] arrOfStr;

    private String name;
    private String address;
    private String type;
    private String workingHours;
    private double rating;
    private double priceLwr, priceUpr;
    private boolean isFavorite;
    private boolean isVegan;
    private int nrItems;
    private String[] menu;
    private boolean coffeeHasSnacks, coffeeHasMilk;

    public Restaurant(String str)
    {
        this.str = str;
    }

    public void setName()
    {
        arrOfStr = str.split(",");
        this.name = arrOfStr[0];
    }

    public void setAddress()
    {
        arrOfStr = str.split(",");
        this.address = arrOfStr[1];
    }

    public void setType()
    {
        arrOfStr = str.split(",");
        this.type = arrOfStr[2];
    }

    public void setWorkingHours()
    {
        arrOfStr = str.split(",");
        this.workingHours = arrOfStr[3];
    }

    public void setRating()
    {
        arrOfStr = str.split(",");
        this.rating = Float.valueOf(arrOfStr[4]);
    }

    public void setPriceLwr(double priceLwr)
    {
        this.priceLwr = priceLwr;
    }

    public void setPriceUpr(double priceUpr)
    {
        this.priceUpr = priceUpr;
    }

    public void setIsFavorite()
    {
        arrOfStr = str.split(",");
        this.isFavorite = Boolean.valueOf(arrOfStr[5]);
    }

    public void setIsVegan()
    {
        arrOfStr = str.split(",");
        this.isVegan = Boolean.valueOf(arrOfStr[6]);
    }

    public void setMenu()
    {
        arrOfStr = str.split(",");
        this.nrItems = Integer.valueOf(arrOfStr[7]);
    }

    public void setCoffeeHas()
    {
        if("Cafe".equals(this.type) == true)
        {
            arrOfStr = str.split(",");
            this.coffeeHasSnacks= Boolean.valueOf(arrOfStr[7]);
            arrOfStr = str.split(",");
            this.coffeeHasMilk = Boolean.valueOf(arrOfStr[8]);
        }
    }

    public String toString()
    {
        if("Cafe".equals(this.type) == true)
        {
            String tmp = "Name: " + name + "\nAddress: " + address + "\nType: " + type + "\nSnacks: " + coffeeHasSnacks + " - Milk: " + coffeeHasMilk + "\nWorking Hours: " + workingHours + "\nRating: " + rating +
                    "\nLower Price: " + priceLwr + " - Upper Price: " + priceUpr + "\nFavorite: " + isFavorite + "\nVegan: " + isVegan;
            tmp = tmp + "\nNumber of Items on the Menu: " + nrItems;
            return tmp;
        }
        else
        {
            String tmp = "Name: " + name + "\nAddress: " + address + "\nType: " + type + "\nWorking Hours: " + workingHours + "\nRating: " + rating +
                    "\nLower Price: " + priceLwr + " - Upper Price: " + priceUpr + "\nFavorite: " + isFavorite + "\nVegan: " + isVegan;
            tmp = tmp + "\nNumber of Items on the Menu: " + nrItems;
            return tmp;
        }
    }


}