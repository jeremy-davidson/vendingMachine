package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VendingMachine {

    //variables
    double startingBalance = 0;
    String path = "C:\\Users\\Student\\workspace\\capstone-1-team-0\\capstone\\vendingmachine.csv";
    File inputFile = new File(path);

    public Map<String, Products> printInventory = new HashMap<>();

    public double getStartingBalance() {
        return startingBalance;
    }

    public Map<String, Products> getInventory(File inputFile) throws FileNotFoundException {
        Map<String, Products> inventoryMap = new HashMap<>();
        try(Scanner fileScanner = new Scanner(inputFile)){

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] value_split = line.split(Pattern.quote("|"));
                if(value_split[3].equals("Chips")) {
                    Products product = new Chips(value_split[1], Double.parseDouble(value_split[2]));
                    inventoryMap.put(value_split[0], product);

                } else if(value_split[3].equals("Candy")) {
                    Products product = new Candy(value_split[1], Double.parseDouble(value_split[2]));
                    inventoryMap.put(value_split[0], product);

                } else if(value_split[3].equals("Bev")) {
                    Products product = new Bev(value_split[1], Double.parseDouble(value_split[2]));
                    inventoryMap.put(value_split[0], product);

                } else if(value_split[3].equals("Gum")) {
                    Products product = new Gum(value_split[1], Double.parseDouble(value_split[2]));
                    inventoryMap.put(value_split[0], product);
                }
            }
        }
        return inventoryMap;
    }




}
