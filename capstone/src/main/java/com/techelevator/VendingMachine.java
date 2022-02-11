package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

public class VendingMachine {

//    public static void main(String[] args) {
//
//        VendingMachine vendingMachine = new VendingMachine();
//    }

    //variables
    private double startingBalance = 0;
    private Map<String, Products> inventory;

    public double getStartingBalance() {
        return startingBalance;
    }

//    String path = "C:\\Users\\Student\\workspace\\capstone-1-team-0\\capstone\\vendingmachine.csv";
//    File inputFile = new File(path);

    //constructor
    public VendingMachine() {
        this.inventory = loadInventory();
    }

    public Map <String, Products> getInventory() {
        return inventory;
    }


    private Map<String, Products> loadInventory() {
        String path = "C:\\Users\\Student\\workspace\\capstone-1-team-0\\capstone\\vendingmachine.csv";
        File inputFile = new File(path);
        Map<String, Products> inventory = new HashMap<>();
        try (Scanner fileScanner = new Scanner(inputFile)) {


            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] value_split = line.split(Pattern.quote("|"));
                if (value_split[3].equals("Chip")) {
                    Products product = new Chips(value_split[1], Double.parseDouble(value_split[2]));
                    inventory.put(value_split[0], product);

                } else if (value_split[3].equals("Candy")) {
                    Products product = new Candy(value_split[1], Double.parseDouble(value_split[2]));
                    inventory.put(value_split[0], product);

                } else if (value_split[3].equals("Drink")) {
                    Products product = new Bev(value_split[1], Double.parseDouble(value_split[2]));
                    inventory.put(value_split[0], product);

                } else if (value_split[3].equals("Gum")) {
                    Products product = new Gum(value_split[1], Double.parseDouble(value_split[2]));
                    inventory.put(value_split[0], product);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error loading...");
        }
        System.out.println(inventory.keySet());
        return inventory;

    }


}

