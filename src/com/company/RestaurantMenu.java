package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby on 4/26/17.
 */
public class RestaurantMenu {


    public RestaurantMenu(){
        //initialize here
    }

    public void run(){
        //do everything from here
        System.out.println("RestaurantMenu.run...");

        //SET UP MAIN DISH LIST
        List<String> mainCourse;
        ArrayList<MainDish> mainDishes = new ArrayList<MainDish>();

        //FileToList ftl = FileToList.getInstance();

        mainCourse = FileToList.getInstance().readFile("src/main_dish.txt");

        String mainmeal = "";
        String accomp= "";
        String name= "";
        double price;

        //load into a series of MainDish items
        for (int i = 0; i < mainCourse.size(); i++) {
            //each record is four lines followed by \n
            //1st line is name
            int modi = i % 5;
            String lineItem = mainCourse.get(i);
            if (lineItem.length() > 0){
                switch(modi % 5){
                    case 0: name = lineItem; break; //mainmeal = lineItem; break;
                    case 1: mainmeal = lineItem;// accomp = lineItem; break;
                    case 2: accomp = lineItem; break;// mainmeal = lineItem; break;
                    case 3: String newStr = lineItem.replaceAll("[^\\d.]+", "");
                        price = Double.parseDouble(newStr);
                        MainDish myMain = new MainDish((mainmeal), accomp, name, price);
                        mainDishes.add(myMain);
                        mainmeal = "";
                        accomp= "";
                        name= "";
                        //price= 0.0;
                        break;
                    case 4:
                        break;
                    default: break;
                }
            }

        }

        for(MainDish f : mainDishes) {
            System.out.println(f);
        }

        //END SET UP MAIN DISH LIST

        //SET UP DESSERTS
        List<String> dessertStrings;
        ArrayList<Dessert> desserts = new ArrayList<>();

        //FileToList ftl = FileToList.getInstance();

        dessertStrings = FileToList.getInstance().readFile("src/dessert.txt");
        //String name, double price, String description
        String dessertDescription = "";
        String dessertName= "";
        double dessertPrice;

        //load into a series of MainDish items
        for (int i = 0; i < dessertStrings.size(); i++) {
//            System.out.println(i);
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

        for(Dessert f : desserts) {
            System.out.println(f);
        }

        //END SET UP DESSERTS

        //SET UP DRINKS
        List<String> drinkStrings;
        ArrayList<Drink> drinks = new ArrayList<>();

        //FileToList ftl = FileToList.getInstance();

        drinkStrings = FileToList.getInstance().readFile("src/drinks.txt");
        //String name, double price, String description
        String drinkDescription = "";
        String drinkName= "";
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

        for(Drink f : drinks) {
            System.out.println(f);
        }
    //END SETUP DRINKS

    }
}
