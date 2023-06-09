package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"); // create date and time pattern

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

    public boolean addMoneyToBalance(int moneyToAdd) {
        if (moneyToAdd <= 0) {
            return false;
        }
        String previousBalance = NumberFormat.getCurrencyInstance().format(balance);
        balance += moneyToAdd;
        String newBalance = NumberFormat.getCurrencyInstance().format(balance);
        addLogEntry("FEED MONEY: " + previousBalance + " " + newBalance);
        return true;
    }

    public boolean makePurchase(String location) {
        if (balance < inventoryMap.get(location).getPrice()) {
            addLogEntry("Transaction Cancelled: Insufficient Balance");
            return false;
        }
        if (inventoryMap.get(location).getQuantity() < 1) {
            addLogEntry("Transaction Cancelled: Item Sold Out");
            return false;
        }
            String price = NumberFormat.getCurrencyInstance().format(inventoryMap.get(location).getPrice());
            balance = balance - inventoryMap.get(location).getPrice();
            String newBalance = NumberFormat.getCurrencyInstance().format(balance);
            inventoryMap.get(location).setQuantity(inventoryMap.get(location).getQuantity() - 1);
            addLogEntry(inventoryMap.get(location).getName() + " " + location + " " + price + " " + newBalance);
            return true;

    }

    public int getBalance() {
        return balance;
    }

    public int returnChange() {
        int Change = balance;
        balance = 0;
        String changeAmount = NumberFormat.getCurrencyInstance().format(Change);
        String newBalance = NumberFormat.getCurrencyInstance().format(balance);
        addLogEntry("GIVE CHANGE: " + changeAmount + " " + newBalance);
        return Change;

        //more code in here
    }
    private void addLogEntry(String logEntry) {
        try (
                FileWriter fileWriter = new FileWriter("Log.txt", true);
                PrintWriter fileAppender = new PrintWriter(fileWriter);
                ) {
            String formattedTime = LocalDateTime.now().format(formatter); // create a string for the current date and time using the pattern
            fileAppender.println(formattedTime + " " + logEntry);
        } catch (IOException e) {
            // call something from UI
        }
    }


}
