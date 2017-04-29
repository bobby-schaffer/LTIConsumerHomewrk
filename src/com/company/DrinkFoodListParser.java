package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby on 4/29/17.
 */
public class DrinkFoodListParser {

    public ArrayList<Drink> parser(List<String> drinkStrings) {
        ArrayList<Drink> drinks = new ArrayList<>();

        String drinkName = "";
        double drinkPrice;

        //load into a series of MainDish items
        for (int i = 0; i < drinkStrings.size(); i++) {
//            System.out.println(i);
            //each record is three lines followed by \n
//            Lemonade
//                    $3
//
            int modi = i % 3;
            String lineItem = drinkStrings.get(i);
            if (lineItem.length() > 0){
                switch(modi){
                    case 0: drinkName = lineItem; break;
                    case 1: String newStr = lineItem.replaceAll("[^\\d.]+", "");
                        drinkPrice = Double.parseDouble(newStr);
                        Drink myDrink = new Drink(drinkName, drinkPrice);
                        drinks.add(myDrink);
                        break;
                    case 2:
                        break;
                    default: break;
                }
            }

        }

//        for(Drink f : drinks) {
//            System.out.println(f);
//        }


        return drinks;
    }
}
