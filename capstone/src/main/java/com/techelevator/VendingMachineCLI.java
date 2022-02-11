package com.techelevator;

import com.techelevator.view.Menu;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VendingMachineCLI {

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String FEED_MONEY = "Feed Money";
    private static final String SELECT_PRODUCT = "Select Product";
    private static final String FINISH_TRANSACTION = "Finish";
    private static final String[] PURCHASE_MENU_OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};
    private static final String FEED_ONE_DOLLAR = "Feed One Dollar";
    private static final String FEED_FIVE_DOLLARS = "Feed Five Dollars";
    private static final String FEED_TEN_DOLLARS = "Feed Ten Dollars";
    private static final String[] FEED_MONEY_OPTIONS = {FEED_ONE_DOLLAR, FEED_FIVE_DOLLARS, FEED_TEN_DOLLARS};
    private static final String RETURN_TO_MAIN_MENU = "Return to Main Menu";
    private Menu inventory;
    private VendingMachine vendingMachine;
    //List<Products> purchasedProducts = new ArrayList<>();

    public VendingMachineCLI(Menu menu) {
        this.inventory = menu;
        this.vendingMachine = new VendingMachine();
    }

    public void run() {
        while (true) {
            String choice = (String) this.inventory.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                 //display vending machine items
                while (true) {
                    String[] productArray = new String[vendingMachine.getInventory().size()];
                    int counter = 0;
                    Set<Map.Entry<String, Products>> entrySet = vendingMachine.getInventory().entrySet();
                    for (Map.Entry<String, Products> entry : entrySet) {
                        String key = entry.getKey();
                        Products value = entry.getValue();
                        productArray[counter] = "Slot: " + key + " | " + "Item: " + value.getName() + " | " + "Price: " + "$" + value.getPrice() + " | " + "Quantity: " + value.getNumberInStock();
                        counter++;
                    }
                    this.inventory.displayMenuOptionsForItems(productArray);
                    break;
                }
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {//do purchase
                System.out.println("Current Money Provided: $" + vendingMachine.getCurrentMoneyProvided());
                choice = (String) this.inventory.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

                if (choice.equals(FEED_MONEY)) {
                    choice = (String) this.inventory.getChoiceFromOptions(FEED_MONEY_OPTIONS);
                    if (choice.equals(FEED_ONE_DOLLAR)) {
                        vendingMachine.feedMoney(1.00);
                    }
                    if (choice.equals(FEED_FIVE_DOLLARS)) {
                        vendingMachine.feedMoney(5.00);
                    }
                    if (choice.equals(FEED_TEN_DOLLARS)) {
                        vendingMachine.feedMoney(10.00);
                    }
                }
                if (choice.equals(SELECT_PRODUCT)) {

                }
            }

//        } else {
//            System.out.println("***Thank you for using Vendo-Matic 800!***");
//            System.exit(1);
//        }
        }
    }
}
