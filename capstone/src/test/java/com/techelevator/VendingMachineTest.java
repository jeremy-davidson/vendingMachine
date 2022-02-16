package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

    VendingMachine vendingMachine;

    @Before
    public void SetUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void feeding_money_feeds_balance_1_dollar() {
        vendingMachine.feedMoney(1);
        double actual = vendingMachine.getCurrentBalance();
        Assert.assertEquals(1, actual, 0.001);
    }

    @Test
    public void feeding_money_feeds_balance_5_dollar() {
        vendingMachine.feedMoney(5);
        double actual = vendingMachine.getCurrentBalance();
        Assert.assertEquals(5, actual, 0.001);
    }

    @Test
    public void feeding_money_feeds_balance_10_dollar() {
        vendingMachine.feedMoney(10);
        double actual = vendingMachine.getCurrentBalance();
        Assert.assertEquals(10, actual, 0.001);
    }



}