
package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {


        RestaurantMenu rmenu = new RestaurantMenu();
        rmenu.run();
        rmenu = null;
    }

}


abstract class Food {
    private String name;
    private double price;
    public Food () {; }


    protected void setName(String name) {
        this.name = name;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    protected String getName() {
        return this.name;
    };

    protected double getPrice() {
        return this.price;
    }


    public abstract String toString();
}

class MainDish extends Food {
    private String mainmeal, accompaniments;
    public MainDish() {;}
    public MainDish(String mainmeal, String accompaniments, String name, double price) {
        super.setName(name);
        super.setPrice(price);
        this.mainmeal = mainmeal;
        this.accompaniments = accompaniments;
    }

    public String toString(){

        double money = super.getPrice();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(money);
        //System.out.println(moneyString);

        return "\tName:\t" + super.getName() +
                "\n\t\tMain Meal:\t" + this.mainmeal +
                "\n\t\tAccompaniments:\t" + this.accompaniments +
                "\n\t\tPrice:\t" + moneyString;
    };
}

class Drink extends Food {
    public Drink() {
        ;
    }

    public Drink(String name, double price) {
        super.setName(name);
        super.setPrice(price);
    }

    public String toString(){

        double money = super.getPrice();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(money);

        return "Name:\t" + super.getName() +
                "\n\tPrice:\t" + moneyString;
    };
}

class Dessert extends Food {
    private String description;
    public Dessert() {
        ;
    }

    public Dessert(String name, double price, String description) {
        super.setName(name);
        super.setPrice(price);
        this.description = description;
    }

    public String toString(){

        double money = super.getPrice();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(money);

        return "Name:\t" + super.getName() +
                "\n\t\tDescription:\t" + this.description +
                "\n\t\tPrice:\t" + moneyString;
    };
}

class MyReader {
    public MyReader() {;}

    public List<String> readNamedFile(String filename)
    {
        List<String> result = readFile(filename);
        return result;
    }

    public List<String> readFile(String filename)
    {
        List<String> records = new ArrayList<String>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null)
            {
                records.add(line);
            }
            reader.close();
            return records;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }

}

class Combo {
    //Combine Main Dish, Drink, Dessert
    private double ComboPrice;
    public Combo() {
        ;
    }

    private double calculateComboPrice(){
        return 0.00;
    }

    private double calculateComboDiscount(){
        return 0.00;
    }

    public String toString(){
        return "";
    };
}

