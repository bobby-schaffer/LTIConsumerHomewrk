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
    //reads text file into List<String>
    //parses List<String> into ArrayList<Drink>
    //getter for ArrayList<Drink>

    ArrayList<Drink> drinks = new ArrayList<>();

    public DrinkHandler() {}

    public DrinkHandler(FoodFileReader ffr, DrinkFoodListParser listParser, String fileName){
        List<String> drinkStrings;

        drinkStrings = ffr.readFile(fileName);

        //parse list to return list of Drink items
        drinks = listParser.parser(drinkStrings);

    }

    public DrinkHandler( String fileName){
        //json handling
        //ArrayList<Drink> drinks = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {

            JSONArray a = (JSONArray) parser.parse(new FileReader("src/drinks.json"));
            for (Object o : a)
            {
                JSONObject drink = (JSONObject) o;

                String name = (String) drink.get("Name");
                String price = (String) drink.get("Price");

                System.out.println("Name: " + name + " Price: " + price);

                String newStr = price.replaceAll("[^\\d.]+", "");
                double drinkPrice = Double.parseDouble(newStr);
                Drink myDrink = new Drink(name, drinkPrice);
                drinks.add(myDrink);

//                case 0: drinkName = lineItem; break;
//                case 1: String newStr = lineItem.replaceAll("[^\\d.]+", "");
//                    drinkPrice = Double.parseDouble(newStr);
//                    Drink myDrink = new Drink(drinkName, drinkPrice);
//                    drinks.add(myDrink);

            }

//            Object obj = parser.parse(new FileReader("src/file1.txt"));
//
//            JSONObject jsonObject = (JSONObject) obj;
//
//            String name = (String) jsonObject.get("Name");
//            String author = (String) jsonObject.get("Author");
//            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
//
//            System.out.println("Name: " + name);
//            System.out.println("Author: " + author);
//            System.out.println("\nCompany List:");
//            Iterator<String> iterator = companyList.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public ArrayList<Drink> getDrinkList() { return drinks; }
}
