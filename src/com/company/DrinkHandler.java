package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bobby on 4/29/17.
 */
public class DrinkHandler {
    //has list of drinks

    ArrayList<Drink> drinks = new ArrayList<>();

    public DrinkHandler() {}

    //reads text file into List<String>
    //parses List<String> into ArrayList<Drink>
    //getter for ArrayList<Drink>
    public DrinkHandler(FoodFileReader ffr, DrinkFoodListParser listParser, String fileName){
        List<String> drinkStrings;

        drinkStrings = ffr.readFile(fileName);

        //parse list to return list of Drink items
        drinks = listParser.parser(drinkStrings);

    }

    public DrinkHandler( String JSONfileName){
        //json handling
         JSONParser parser = new JSONParser();

        try {

            JSONArray a = (JSONArray) parser.parse(new FileReader(JSONfileName));
            for (Object o : a)
            {
                JSONObject drink = (JSONObject) o;

                String name = (String) drink.get("Name");
                String price = (String) drink.get("Price");

                String newStr = price.replaceAll("[^\\d.]+", "");
                double drinkPrice = Double.parseDouble(newStr);
                Drink myDrink = new Drink(name, drinkPrice);
                drinks.add(myDrink);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public ArrayList<Drink> getDrinkList() { return drinks; }
}
