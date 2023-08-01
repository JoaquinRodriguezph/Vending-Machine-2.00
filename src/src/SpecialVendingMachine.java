import java.util.ArrayList;

/**
 * The SpecialVendingMachine class is an extension of VendingMachine
 * class (Regular Vending Machine), which contains all the methods and
 * attributes and some additional features that would make Silog Combo meals
 */
public class SpecialVendingMachine extends VendingMachine{

    /**
     * This method is a constructor which utilizes the following parameters:
     *
     * @param name         the name of the vending machine.
     * @param maxSlots     the max amount of Slots.
     * @param slotMaxItems the max amount of items in each Slot.
     */
    public SpecialVendingMachine(String name, int maxSlots, int slotMaxItems, int inventoryMax) {
        super(name, maxSlots, slotMaxItems);
        defaultSilogBase = new ArrayList<Item>();
        defaultSilogBase.add(new VendItem("Rice", 206));
        defaultSilogBase.add(new VendItem("Fried Egg", 120));
        defaultSilogSide = new ArrayList<Item>();
        defaultSilogSide.add(new VendItem("Fried Chicken", 246));
        defaultSilogSide.add(new VendItem("Bangus", 200));
        defaultSilogSide.add(new VendItem("Tapas", 200));
        defaultSilogSide.add(new VendItem("Tosino", 230));
        defaultSilogSide.add(new VendItem("Pork Chop", 231));
        itemInventory = new ArrayList<Item>();
        MAX_INV = inventoryMax;
    }

    /**
     * This method gets the transaction log of the vending machine.
     *
     * @return the transaction log of the vending machine.
     */
    @Override
    public ArrayList<String> getTransactionLog() {
        ArrayList<String> logs = new ArrayList<String>();
        String[] stringFind = new String[transactionLog.size()];
        int[] tCount = new int[transactionLog.size()];
        boolean b;


        for (String temp1 : transactionLog) {
            b = false;
            for (int i = 0; i < stringFind.length; i++) {
                if (temp1.equalsIgnoreCase(stringFind[i]) && stringFind[i] != null) {
                    tCount[i] += 1;
                    b = true;
                    break;
                }

            }
            if (!b) {
                for (int i = 0; i < stringFind.length; i++) {
                    if (stringFind[i] == null || stringFind[i].isEmpty()) {
                        stringFind[i] = temp1;
                        tCount[i] += 1;
                        break;
                    }
                }
            }
        }



        for (int i = 0; i < tCount.length; i++) {
            if (!(stringFind[i] == null || stringFind[i].isEmpty())) {
                int price = Integer.parseInt(stringFind[i].substring(stringFind[i].indexOf('-') + 1));
                int totalItem = tCount[i] * price;
                logs.add(stringFind[i].substring(0, stringFind[i].indexOf('-')) + ": " + tCount[i] + " * " + price + " = " + totalItem + " PHP\n");
            }
        }

        return logs;
    }

    /**
     * This method gets the current inventory of the vending machine.
     *
     * @return the current inventory of the vending machine.
     */
    @Override
    public ArrayList<String> getCurrentInventory() {
        ArrayList<String> inventory = new ArrayList<String>();
        for (ItemSlot slot : itemSlots) {
            if (slot.isAvailable())
                inventory.add(slot.getItemName() + ": " + slot.getStock() + "\n");
        }

        return inventory;
    }

    /**
     * This method gets the inventory log of the vending machine.
     *
     * @return the inventory log of the vending machine.
     */
    @Override
    public ArrayList<String> getInventoryLog() {
        ArrayList<String> log = new ArrayList<String>();
        log.add("----- Starting Inventory " + NAME + " -----\n");
        log.addAll(startingInventory);
        log.add("----- Current Inventory " + NAME + " -----\n");
        log.addAll(getCurrentInventory());
        return log;
    }

    /**
     * This method updates the starting inventory.
     */
    @Override
    public void newStartingInventory() {
        startingInventory = getCurrentInventory();
    }

//updates all the methods abovve

    /**
     * This method gets silog meal type String.
     *
     * @param items the potential silog combo meal
     * @return the silog String if it is a silog meal, else return null.
     */
    public String getSilog(ArrayList<Item> items) {
        String silog = null;
        boolean b = false;

        for (Item def : defaultSilogSide) {
            for (Item item : items) {
                if (def.getName().equalsIgnoreCase(item.getName()) && def.getCalories() == item.getCalories()) {
                    switch (def.getName()) {
                        case "Tapas" -> silog = "Tapsilog";
                        case "Bangus" -> silog = "Bangsilog";
                        case "Tosino" -> silog = "Tosilog";
                        case "Pork Chop" -> silog = "Porksilog";
                        case "Fried Chicken" -> silog = "Chicksilog";
                    }
                    b = true;
                    break;
                }
            }
            if (b)
                break;
        }
        return silog;
    }

    public ArrayList<String> silogProcess(ArrayList<Item> items, String silog) {
        ArrayList<String> process = new ArrayList<String>();



        process.add(getSilog(items) + " Done!\n");
        return process;
    }


    /**
     * The list of items that comprise the default silog combo base
     */
    private ArrayList<Item> defaultSilogBase;

    /**
     * The list of items that comprise the default silog combo sides
     */
    private ArrayList<Item> defaultSilogSide;

    /**
     * An item inventory that is used for silog combos
     */
    private ArrayList<Item> itemInventory;

    /**
     * The maximum items in item inventory
     */
    private final int MAX_INV;
}
