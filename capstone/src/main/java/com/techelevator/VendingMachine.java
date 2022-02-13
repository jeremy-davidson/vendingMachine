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
import java.util.stream.Stream;

public class VendingMachine {

//    public static void main(String[] args) {
//
//        VendingMachine vendingMachine = new VendingMachine();
//    }

    //variables
    private double startingBalance = 0;
    public double currentMoneyProvided = 0;
    private Map<String, Products> inventory;
    private List<String> list = getList();


    public double getStartingBalance() {
        return startingBalance;
    }

    public double getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public void feedMoney(double moneyFed) {
        currentMoneyProvided = currentMoneyProvided + moneyFed;
    }


//    String path = "C:\\Users\\Student\\workspace\\capstone-1-team-0\\capstone\\vendingmachine.csv";
//    File inputFile = new File(path);

    //constructor
    public VendingMachine() {
        this.inventory = loadInventory();
    }

    public Map<String, Products> getInventory() {
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
        return inventory;

    }

    public void displayItems() {// CLI is using this method for displaying items...

        String[] productArray = new String[getInventory().size()];

        Set<Map.Entry<String, Products>> entrySet = getInventory().entrySet();
        int counter = 0;
        for (Map.Entry<String, Products> entry : entrySet) {
            String key = entry.getKey();
            Products value = entry.getValue();
            productArray[counter] = "Slot: " + key + " | " + "Item: " + value.getName() + " | " + "Price: " + "$" + value.getPrice() + " | " + "Quantity: " + value.getNumberInStock();
            counter++;
        }
        for (int i = 0; i < counter; i++) {
            System.out.println(productArray[i]);
        }
    }

    //*****this is SUPPOSED to write a new file log.txt when run... cant test functionality until we figure out vending classes
    public void logFile() throws IOException {
        File outputFile = new File("C:\\Users\\Student\\workspace\\capstone-1-team-0\\capstone\\log.txt");
        //List<String> list = getList();
        try (FileWriter logWriter = new FileWriter(outputFile, true)) {
            for (String str : list) {
                logWriter.write(str);
                logWriter.write("\n");
            }
        }
    }

    public List<String> log(String name, double startingBalance, double endAmount) {

        LocalDateTime time = LocalDateTime.now();
        DecimalFormat format = new DecimalFormat("#.00");
        String str = time + " " + name + " " + getStartingBalance() + " " + format.format(endAmount);
        //List<String> list = getList();
        list.add(str);
        return list;
    }

    public List<String> getList() {
        return this.list;
    }

    //working on this method to vend product... need to add slot key option in menu class?
    public String getSlotChoiceFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        String slotChoice = null;
        System.out.print(System.lineSeparator() + "Please input slot location for desired item >>> ");
        slotChoice = scanner.nextLine();
        if (slotChoice == null || slotChoice == " ") {
            System.out.println(System.lineSeparator() + "*** " + slotChoice + " is not a valid option ***" + System.lineSeparator());
        }
        return slotChoice;
    }
    //method only working if selection is entered twice?
    public void payForItem() {
        {
            currentMoneyProvided = currentMoneyProvided - inventory.get(getSlotChoiceFromUserInput()).getPrice();

        }
    }

}



