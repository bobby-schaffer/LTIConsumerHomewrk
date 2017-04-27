package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby on 4/25/17.
 */
public class FileToList {
    private static FileToList ourInstance = new FileToList();

    public static FileToList getInstance() {
        return ourInstance;
    }

    private FileToList() {
        System.out.println("FileToList ctor");
    }

    public void readTheFile(){
        System.out.println("readTheFile()");


    }




 //   public static List<String> ReadThisFile(String filename) {
 //       List<String> myList = new ArrayList<String>();
 //       return myList;
 //   }



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
