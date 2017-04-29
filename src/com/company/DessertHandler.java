package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby on 4/29/17.
 */
public class DessertHandler {

    //has list of desserts
    //reads text file into List<String>
    //parses List<String> into ArrayList<Dessert>
    //getter() for ArrayList<Dessert>

    ArrayList<Dessert> desserts = new ArrayList<>();

    public DessertHandler(FoodFileReader ffr, DessertFoodListParser listParser, String fileName ) {
        List <String> dessertStrings;

        dessertStrings = ffr.readFile(fileName);

        //parse list to return list of Dessert items
        desserts = listParser.parser(dessertStrings);

    }

    public ArrayList<Dessert> getDessertlist() {return desserts; }
}
