package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby on 4/29/17.
 */
public interface FoodFileReader {

    List<String> readFile(String filename);

}
