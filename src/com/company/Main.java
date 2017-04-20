
package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> mainCourse = null;

        //mainCourse = readFile("main_dish.txt");
        MyReader reader = new MyReader();

        //String myPath  = new File(".").getAbsolutePath();
        String myTarget = "src/drinks.txt";

         mainCourse =  reader.readNamedFile(myTarget);
        String str1 = mainCourse.get(1);
        System.out.println(str1);

    }

}

/*        try {
                //Choose the file that you will use.
                String filenameTXT = "Root/src/recipes.txt";
                String filenameJSON = "Root/src/recipes.json";

                //Read your input and create the Objects Recipe


                } catch (IOException e) {
                e.printStackTrace();
                } finally {
                try {
                if (input != null){
                input.close();
                }
                } catch (IOException ex) {

                ex.printStackTrace();

                }
                }
*/
/*

      try {
            FileOutputStream output = new FileOutputStream("Root/src/favorite_recipe.txt");

            //Write to the file the favorite recipe Crock Pot Roast information to test
            //Use methods of the Object Recipe to generate the amount of ingredients
            //and the amount of steps.

            //Write the favorite recipe to the file


            //Expected action: Save the favorite recipe
            //Use tab instead of space to give format after each new line.


        } catch (IOException e) {
                e.printStackTrace();
                }
                }
                */


abstract class Food {
    private String name;
    private double price;
    public Food() {
        ;
    }

    public abstract String toString();
}

class MainDish extends Food {
    private String mainmeal, accompaniments;
    public MainDish() {
        ;
    }

    public String toString(){
        return "";
    };
}

class Drink extends Food {
    public Drink() {
        ;
    }

    public String toString(){
        return "";
    };
}

class Dessert extends Food {
    private String description;
    public Dessert() {
        ;
    }

    public String toString(){
        return "";
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