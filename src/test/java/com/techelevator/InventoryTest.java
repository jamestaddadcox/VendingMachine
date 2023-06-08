package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

    private String INVENTORY_FILE_NAME = "vendingmachine.csv";
    private int MAX_ITEM_AMOUNT = 5;

    Inventory sut = null;

    @Before
    public void setup() {
        InventoryCreator inventoryCreator = new InventoryCreator();
        sut = inventoryCreator.createInventory(INVENTORY_FILE_NAME, MAX_ITEM_AMOUNT);
    }

    @Test
    public void negative_money_added_to_balance_returns_false_no_change_in_balance() {
        // arrange
        int expectedBalance = 0;
        // act
        boolean wasAdded = sut.addMoneyToBalance(-1);
        // assert
        Assert.assertFalse(wasAdded);
        Assert.assertEquals(expectedBalance, sut.getBalance());
    }

    @Test
    public void money_added_to_balance_returns_true_adds_money() {
        // arrange
        int expectedBalance = 1;
        // act
        boolean wasAdded = sut.addMoneyToBalance(1);
        // assert
        Assert.assertTrue(wasAdded);
        Assert.assertEquals(expectedBalance, sut.getBalance());
    }

    @Test
    public void zero_money_added_to_balance_returns_false_no_change_in_balance() {
        // arrange
        int expectedBalance = 0;
        // act
        boolean wasAdded = sut.addMoneyToBalance(0);
        // assert
        Assert.assertFalse(wasAdded);
        Assert.assertEquals(expectedBalance, sut.getBalance());
    }

    @Test
    public void makePurchase_adds_log_

}
