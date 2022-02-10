package com.techelevator;

import com.techelevator.view.Menu;

public class ChangeCalculator {

    //calculates the required change in least amount of coins possible

    public void change(double coins) {

        //vars

        int quarters = 0;
        int dimes = 0;
        int nickles = 0;
        int pennies = 0;

        while (coins >= 0.25) {
            quarters = quarters + 1;
            coins = coins - 0.25;
        }
        while (coins >= 0.10) {
            dimes = dimes + 1;
            coins = coins - 0.10;
        }
        while (coins >= 0.05) {
            nickles = nickles + 1;
            coins = coins - 0.05;
        }
        while (coins >= 0.01) {             //redundant for this project but added any
            pennies = pennies + 1;
            coins = coins - 0.01;
        }

        System.out.println("Your change is " + quarters + " quarters, " + dimes + " dimes and " + nickles + " nickles.");
    }


}

