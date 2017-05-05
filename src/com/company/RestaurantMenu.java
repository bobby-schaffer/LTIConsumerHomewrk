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

        ArrayList<MainDish> mainDishes = new ArrayList<>();
        ArrayList<Dessert> desserts = new ArrayList<>();
        ArrayList<Drink> drinks = new ArrayList<>();

        FoodTextFileReader ffr = new FoodTextFileReader();
        MainDishFoodListParser mdflp = new MainDishFoodListParser();

        MainDishHandler mdh = new MainDishHandler(ffr, mdflp, "src/main_dish.txt");
        mainDishes = mdh.getMainDishList();

        DessertFoodListParser dflp = new DessertFoodListParser();
        DessertHandler dh = new DessertHandler(ffr, dflp, "src/dessert.txt");
        desserts = dh.getDessertlist();

        //DrinkFoodListParser drflp = new DrinkFoodListParser();
        //DrinkHandler drh = new DrinkHandler(ffr, drflp, "src/drinks.txt");

        DrinkHandler drh = new DrinkHandler("src/drinks.json");
        drinks = drh.getDrinkList();

        for(MainDish f : mainDishes) {
            System.out.println(f);
        }

        for(Dessert d : desserts) {
            System.out.println(d);
        }

        for(Drink f : drinks) {
            System.out.println(f);
        }

    }
}
