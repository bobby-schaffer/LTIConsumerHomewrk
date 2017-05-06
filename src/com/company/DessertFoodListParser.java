package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby on 4/29/17.
 */
public class DessertFoodListParser {

    public ArrayList<Dessert> parser(List<String> dessertStrings) {

        ArrayList<Dessert> desserts = new ArrayList<>();

        String dessertDescription = "";
        String dessertName= "";
        double dessertPrice;


        for (int i = 0; i < dessertStrings.size(); i++) {
            //each record is three lines followed by \n
//            Jelly
//                    Strawberry
//            $2
//
            int modi = i % 4;
            String lineItem = dessertStrings.get(i);
            if (lineItem.length() > 0){
                switch(modi){
                    case 0: dessertName = lineItem; break;
                    case 1: dessertDescription = lineItem; break;
                    case 2: String newStr = lineItem.replaceAll("[^\\d.]+", "");
                        dessertPrice = Double.parseDouble(newStr);
                        Dessert myDessert = new Dessert(dessertName, dessertPrice, dessertDescription);
                        desserts.add(myDessert);
                        dessertDescription = "";
                        break;
                    case 3:
                        break;
                    default: break;
                }
            }

        }

        return desserts;
    }


}
