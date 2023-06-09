package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class InventoryCreator {

    public Inventory createInventory(String filename, int maxNumberOfItem) {

        Inventory inventory = new Inventory();

        File inventoryFile = new File(filename);

        try (Scanner inventoryFileReader = new Scanner(inventoryFile)) {
            while (inventoryFileReader.hasNextLine()) {
                String line = inventoryFileReader.nextLine();
                Item newItem = parseLine(line);
                inventory.putItem(newItem.getLocation(), newItem);
            }
        } catch (FileNotFoundException e) {
            // call something from UI
        }

        return inventory;

    }

    private Item parseLine(String line) {
        String[] itemComponents = line.split("\\|");
        String location = itemComponents[0];
        String name = itemComponents[1];
        String priceStr = itemComponents[2].replace(".", "");
        String type = itemComponents[3];
        int price = Integer.parseInt(priceStr);
        return new Item(name, location, price, type);
    }

}
