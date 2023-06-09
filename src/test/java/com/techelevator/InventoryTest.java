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
    public void makePurchase_decreases_balance_returns_true_on_successful_purchase() {
        // arrange
        sut.addMoneyToBalance(1000);
        String location = "A1";     // don't love this. feels sloppy. give this some thought.
        int expectedResultingBalance = 695;

        // act
        boolean wasPurchased = sut.makePurchase(location);

        // assert
        Assert.assertEquals(expectedResultingBalance, sut.getBalance());
        Assert.assertTrue(wasPurchased);
    }

    @Test
    public void makePurchase_with_insufficient_balance_returns_false_no_change_in_balance() {
        // arrange
        sut.addMoneyToBalance(300);
        String location = "A1";     // don't love this. feels sloppy. give this some thought.
        int expectedResultingBalance = 300;

        // act
        boolean wasPurchased = sut.makePurchase(location);

        // assert
        Assert.assertEquals(expectedResultingBalance, sut.getBalance());
        Assert.assertFalse(wasPurchased);
    }

    @Test
    public void makePurchase_with_insufficient_quantity_returns_false_no_change_in_balance() {
        // arrange
        sut.addMoneyToBalance(1000);
        sut.getItem("A1").setQuantity(0);
        String location = "A1";     // don't love this. feels sloppy. give this some thought.
        int expectedResultingBalance = 1000;

        // act
        boolean wasPurchased = sut.makePurchase(location);

        // assert
        Assert.assertEquals(expectedResultingBalance, sut.getBalance());
        Assert.assertFalse(wasPurchased);
    }

    @Test
    public void makePurchase_writes_to_log_on_success() {
        // arrange


        // act
        sut.makePurchase(location);

        // assert
    }


}
