package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby on 4/29/17.
 */
public class MainDishHandler {

    //has list of main dishes
    //reads text file into List<String>
    //parses List<String> into ArrayList<MainDish>
    //getter() for ArrayList<MainDish>

   // ArrayList<MainDish> mainDishList = new ArrayList<>();

    ArrayList<MainDish> mainDishes = new ArrayList<>();

    public MainDishHandler(FoodFileReader ffr, MainDishFoodListParser listParser, String fileName) {

        //SET UP MAIN DISH LIST
        List<String> mainCourse;

//        for(MainDish f : mainDishes) {
//            System.out.println(f);
//        }

        //FoodFileReader ffr = new FoodFileReader();

        //FoodTextFileReader ffr = new FoodTextFileReader();

        //mainCourse = ffr.readFile("src/main_dish.txt");

        //read file and convert to list of strings
        mainCourse = ffr.readFile(fileName);

        //parse the list to return a list of MainDish items
        //public List<MainDish> parser(List<String> mainCourse) {
        mainDishes = listParser.parser(mainCourse);

/*
        //mainDishes = parser(List<String> mainCourse)

        //FileToList ftl = FileToList.getInstance();

        //mainCourse = FileToList.getInstance().readFile("src/main_dish.txt");

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
*/



    }






    public ArrayList<MainDish> getMainDishList(){
        return mainDishes;
    }




}
