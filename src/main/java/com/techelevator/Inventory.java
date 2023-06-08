package com.techelevator;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {

    private int balance;




    private Map<String, Item> inventoryMap = new LinkedHashMap<>();         // string is item location

    public Inventory() {
        balance = 0;
    }

    public void putItem(String location, Item newItem) {
        inventoryMap.put(location, newItem);
    }


    public Item getItem(String location) {
        return inventoryMap.get(location);
    }

    public Map<String, Item> getInventoryMap() {
         return new LinkedHashMap<>(inventoryMap);
    }

    public int addMoneyToBalance(int moneyToAdd) {
        balance += moneyToAdd;
        return balance;
    }

    public boolean makePurchase(String location) {
        if (balance < inventoryMap.get(location).getPrice()) {
            return false;
        }
        if (inventoryMap.get(location).getQuantity() < 1) {
            return false;
        }
            balance = balance - inventoryMap.get(location).getPrice();
            inventoryMap.get(location).setQuantity(inventoryMap.get(location).getQuantity() - 1);
            return true;

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
