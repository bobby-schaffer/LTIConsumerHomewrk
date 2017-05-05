
package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {


        RestaurantMenu rmenu = new RestaurantMenu();
        rmenu.run();
        rmenu = null;
//////////////
        JSONParser parser = new JSONParser();

        try {

            JSONArray a = (JSONArray) parser.parse(new FileReader("src/drinks.json"));
            for (Object o : a)
            {
                JSONObject drink = (JSONObject) o;

                String name = (String) drink.get("Name");
                String price = (String) drink.get("Price");

                System.out.println("Name: " + name + " Price: " + price);
            }

            Object obj = parser.parse(new FileReader("src/file1.txt"));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("Name");
            String author = (String) jsonObject.get("Author");
            JSONArray companyList = (JSONArray) jsonObject.get("Company List");

            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("\nCompany List:");
            Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


class DessertHandlerX{
 public DessertHandlerX() {;}

 //read file and convert to an ArrayList of Dessert objects

    List<String> dessertStrings;
    ArrayList<Dessert> desserts = new ArrayList<Dessert>() {
    };

    //desserts = readFile("main_dish.txt");
    MyReader readerX = new MyReader();
    //reader.readNamedFile(my)

    //String myPath  = new File(".").getAbsolutePath();
    String myTarget = "src/dessert.txt"; // "src/drinks.txt";

//    dessertStrings =  readerX.readNamedFile(myTarget);
//        System.out.println(desserts);

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
                "\n\t\tPrice:\t" + moneyString; //Double.toString(super.getPrice());
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

        //String s = Double.toString(super.getPrice());
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
                "\n\t\tPrice:\t" + moneyString; //Double.toString(super.getPrice());
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

