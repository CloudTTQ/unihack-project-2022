import java.util.ArrayList;
import java.util.Collections;

public class UniHackProj1
{
    public static void main(String[] args)
    {
        Restaurant r1 = new Restaurant("Name1,Address1,Cafe,10:00-22:00,4.5,true,false,false,true,4,item1,item2,item3,item4");
        Restaurant r2 = new Restaurant("Name2,Address2,Restaurant,08:00-23:00,4.8,true,true,3,item1,item2,item3,item3");
        Restaurant r3 = new Restaurant("Name3,Address3,Cafe,09:00-20:00,4.4,false,true,true,true,5,item1,item2,item3,item4,item5");

        r1.setName();
        r1.setAddress();
        r1.setType();
        r1.setWorkingHours();
        r1.setRating();
        r1.setIsFavorite();
        r1.setIsVegan();
        r1.setCoffeeHas();
        r1.setMenu();

        r2.setName();
        r2.setAddress();
        r2.setType();
        r2.setWorkingHours();
        r2.setRating();
        r2.setIsFavorite();
        r2.setIsVegan();
        r2.setCoffeeHas();
        r2.setMenu();

        r3.setName();
        r3.setAddress();
        r3.setType();
        r3.setWorkingHours();
        r3.setRating();
        r3.setIsFavorite();
        r3.setIsVegan();
        r3.setCoffeeHas();
        r3.setMenu();

        System.out.println("r1:\n" + r1 + "\n");
        System.out.println("r2:\n" + r2 + "\n");
        System.out.println("r3:\n" + r3 + "\n");

        ListRest l = new ListRest();

        System.out.println("Added r1: " + l.addRest(r1));
        System.out.println("Added r2: " + l.addRest(r2));
        System.out.println("Added r3: " + l.addRest(r3));

        System.out.println("list:\n" + l + "\n");

        l.setPriceLwr(20.00);
        l.setPriceUpr(35.75);
        l.setName("Name1");
        l.setType("Cafe") ;
        l.setRating(4);
        l.setIsFavorite(true);
        l.setIsVegan(false);
        l.setCoffeeHasSnacks(false);
        l.setCoffeeHasMilk(true);

        System.out.println("After introducing the parameters:\n");
        l.searchList();
    }
}

class Restaurant
{
    private String str;
    private String[] arrOfStr;
    private int contr = 0;

    private String name;
    private String address;
    private String type;
    private boolean coffeeHasSnacks, coffeeHasMilk;
    private String workingHours;
    private double rating;
    private boolean isFavorite;
    private boolean isVegan;

    private int nrItems;
    private String[] menu;

    public Restaurant(String str)
    {
        this.str = str;
    }

    public void setName()
    {
        arrOfStr = str.split(",");
        this.name = arrOfStr[contr];
        contr++;
    }

    public void setAddress()
    {
        arrOfStr = str.split(",");
        this.address = arrOfStr[contr];
        contr++;
    }

    public void setType()
    {
        arrOfStr = str.split(",");
        this.type = arrOfStr[contr];
        contr++;
    }

    public void setWorkingHours()
    {
        arrOfStr = str.split(",");
        this.workingHours = arrOfStr[contr];
        contr++;
    }

    public void setRating()
    {
        arrOfStr = str.split(",");
        this.rating = Float.valueOf(arrOfStr[contr]);
        contr++;
    }

    public void setIsFavorite()
    {
        arrOfStr = str.split(",");
        this.isFavorite = Boolean.valueOf(arrOfStr[contr]);
        contr++;
    }

    public void setIsVegan()
    {
        arrOfStr = str.split(",");
        this.isVegan = Boolean.valueOf(arrOfStr[contr]);
        contr++;
    }

    public void setMenu()
    {
        arrOfStr = str.split(",");
        this.nrItems = Integer.valueOf(arrOfStr[contr]);
        contr++;

        this.menu = new String[nrItems];

        for(int i = 0; i < this.nrItems; i++)
        {
            arrOfStr = str.split(",");
            this.menu[i] = arrOfStr[contr];
            contr++;
        }
    }

    public void setCoffeeHas()
    {
        if("Cafe".equals(this.type) == true)
        {
            arrOfStr = str.split(",");
            this.coffeeHasSnacks= Boolean.valueOf(arrOfStr[contr]);
            contr++;

            arrOfStr = str.split(",");
            this.coffeeHasMilk = Boolean.valueOf(arrOfStr[contr]);
            contr++;
        }
    }

    public String toString() {
        String tmp;

        if ("Cafe".equals(this.type) == true) {
            tmp = "Name: " + name + "\nAddress: " + address + "\nType: " + type + "\nSnacks: " + coffeeHasSnacks + " - Milk: " + coffeeHasMilk + "\nWorking Hours: " + workingHours + "\nRating: " + rating +
                    "\nFavorite: " + isFavorite + "\nVegan: " + isVegan;

        } else {
            tmp = "Name: " + name + "\nAddress: " + address + "\nType: " + type + "\nWorking Hours: " + workingHours + "\nRating: " + rating +
                    "\nFavorite: " + isFavorite + "\nVegan: " + isVegan;
        }

        tmp = tmp + "\nNumber of Items on the Menu: " + nrItems;

        if (this.nrItems != 0) {
            tmp = tmp + "\nItems:\n";
            for (int i = 0; i < this.nrItems; i++) {
                tmp = tmp + this.menu[i];
                if (i < (this.nrItems - 1)) {
                    tmp = tmp + "\n";
                }
            }
        }

        return tmp;
    }

    public boolean equals(Object o)
    {
        return ((o instanceof Restaurant) && (((Restaurant)o).name.equals(this.name)) && (((Restaurant)o).address==this.address));
    }

    public String getName()
    {
        return this.name;
    }

    public String getType()
    {
        return this.type;
    }

    public double getRating()
    {
        return this.rating;
    }

    public boolean getIsFavorite()
    {
        return this.isFavorite;
    }

    public boolean getIsVegan()
    {
        return this.isVegan;
    }

    public boolean getCoffeeHasSnacks()
    {
        return this.coffeeHasSnacks;
    }

    public boolean getCoffeeHasMilk()
    {
        return this.coffeeHasMilk;
    }
}

class ListRest
{
    private ArrayList<Restaurant> restaurant = new ArrayList<Restaurant>();

    private double priceLwr, priceUpr;
    private String name;
    private String type;
    private boolean coffeeHasSnacks, coffeeHasMilk;
    private double rating;
    private boolean isFavorite;
    private boolean isVegan;

    public void setPriceLwr(double priceLwr)
    {
        this.priceLwr = priceLwr;
    }

    public void setPriceUpr(double priceUpr)
    {
        this.priceUpr = priceUpr;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }

    public void setIsFavorite(boolean isFavorite)
    {
        this.isFavorite = isFavorite;
    }

    public void setIsVegan(boolean isVegan)
    {
        this.isVegan = isVegan;
    }

    public void setCoffeeHasSnacks(boolean coffeeHasSnacks)
    {
        this.coffeeHasSnacks = coffeeHasSnacks;
    }

    public void setCoffeeHasMilk(boolean coffeeHasMilk)
    {
        this.coffeeHasMilk = coffeeHasMilk;
    }

    public boolean addRest(Object o)
    {
        for(Restaurant r: restaurant)
        {
            if(r.equals(o) == true)
            {
                System.out.println("Already stored!");
                return false;
            }
        }
        restaurant.add((Restaurant)o);
        return true;
    }

    public void searchList()
    {
        for(Restaurant r: restaurant)
        {
            if((this.name.equals(r.getName())) && (this.type.equals(r.getType())) && (this.rating <= r.getRating()) && (this.isFavorite == r.getIsFavorite()) && (this.isVegan == r.getIsVegan()) && (this.coffeeHasSnacks == r.getCoffeeHasSnacks()) && (this.coffeeHasMilk == r.getCoffeeHasMilk()))
            {
                System.out.println(r);
            }
        }
    }

    public String toString()
    {
        return restaurant.toString();
    }
}