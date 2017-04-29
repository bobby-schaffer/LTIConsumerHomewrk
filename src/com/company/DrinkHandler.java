package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby on 4/29/17.
 */
public class DrinkHandler {
    //has list of drinks
    //reads text file into List<String>
    //parses List<String> into ArrayList<Drink>
    //getter for ArrayList<Drink>

    ArrayList<Drink> drinks = new ArrayList<>();

    public DrinkHandler(FoodFileReader ffr, DrinkFoodListParser listParser, String fileName){
        List<String> drinkStrings;

        drinkStrings = ffr.readFile(fileName);

        //parse list to return list of Drink items
        drinks = listParser.parser(drinkStrings);

    }

    public ArrayList<Drink> getDrinkList() { return drinks; }
}
