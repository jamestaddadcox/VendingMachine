package com.techelevator;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {

    private int balance;

    private int STARTING_ITEM_AMOUNT = 5;

    private String INVENTORY_FILE_NAME = "vendingmachine.csv";


    private Map<Item, Integer> inventoryMap = new LinkedHashMap<>();

    public Inventory() {
        balance = 0;
    }

    public void putItem(Item newItem) {
        inventoryMap.put(newItem, STARTING_ITEM_AMOUNT);
    }

    public Map getInventoryMap() {
        return new LinkedHashMap<>(inventoryMap);
    }

    public int addMoneyToBalance(int moneyToAdd) {
        balance += moneyToAdd;
        return balance;
    }

    public int makePurchase(Item purchasedItem) {           // return boolean instead?
        balance = purchasedItem.getPrice();
        inventoryMap.put(purchasedItem, inventoryMap.get(purchasedItem) - 1);
        return balance;
    }

    public int getBalance() {
        return balance;
    }

    public int returnChange() {
        int Change = balance;
        balance = 0;
        return Change;
    }


}
