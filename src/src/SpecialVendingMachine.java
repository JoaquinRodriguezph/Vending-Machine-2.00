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
    public SpecialVendingMachine(String name, int maxSlots, int slotMaxItems, int inventoryMax) throws IllegalArgumentException, IndexOutOfBoundsException {
        super(name, maxSlots, slotMaxItems);
        if (inventoryMax < 10)
            throw new IllegalArgumentException("Inventory Limit Shall be 10 or more");
        defaultSilogBase = new ArrayList<Item>();
        defaultSilogBase.add(new VendItem("Rice", 206));
        defaultSilogBase.add(new VendItem("Fried Egg", 120));
        defaultSilogSide = new ArrayList<Item>();
        defaultSilogSide.add(new VendItem("Fried Chicken", 246));
        defaultSilogSide.add(new VendItem("Bangus", 200));
        defaultSilogSide.add(new VendItem("Tapas", 200));
        defaultSilogSide.add(new VendItem("Tosino", 230));
        defaultSilogSide.add(new VendItem("Pork Chop", 231));
        defaultToppings = new ArrayList<Item>();
        defaultToppings.add(new Item("Gravy", 79));
        defaultToppings.add(new Item("Toyo", 53));
        itemInventory = new ArrayList<Item>();
        MAX_INV = inventoryMax;
        itemList = new ArrayList<ItemInfo>();
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
            if (slot.getStock() > 0)
                inventory.add(slot.getItemName() + ": " + slot.getStock() + "\n");
        }
        inventory.addAll(getItemInventory());

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
     * This method gets the inventory limit of the vending machine.
     *
     * @return the inventory limit of the vending machine.
     */
    public int getInventoryLimit() {
        return MAX_INV;
    }


    /**
     * This method adds a silog meal transaction.
     */
    public void addTransaction(SilogCombo silogCombo) {
        ArrayList<Item> items = silogCombo.getItems();

        for (Item item : items) {
            transactionLog.add(item.getName() + "-" + priceItem(item));
        }
    }


    /**
     * This method updates the starting inventory.
     */
    @Override
    public void newStartingInventory() {
        startingInventory = getCurrentInventory();
    }

    /**
     * This method check if the item exists within the list of items in the inventory.
     *
     * @param item the item to be checked.
     * @return true if the item exists, false otherwise.
     */
    public boolean contains(Item item) {
        boolean b = false;

        for (ItemInfo itemInfo : itemList) {    //looking if item exists already in the list
            if (itemInfo.getName().equalsIgnoreCase(item.getName()) && itemInfo.getCalories() == item.getCalories()) {
                b = true;
                break;
            }
        }

        return b;
    }

    /**
     * This method check if the item exists within the inventory.
     *
     * @param item the item to be checked.
     * @return true if the item exists, false otherwise.
     */
    public boolean inventoryContains(Item item) {
        boolean b = false;

        for (Item itemInfo : itemInventory) {    //looking if item exists already in the list
            if (itemInfo.getName().equalsIgnoreCase(item.getName()) && itemInfo.getCalories() == item.getCalories()) {
                b = true;
                break;
            }
        }

        return b;
    }

    /**
     * This method check if the item in the item list exists within the inventory.
     *
     * @param itemInfo the item to be checked.
     * @return true if the item exists, false otherwise.
     */
    public boolean inventoryContains(ItemInfo itemInfo) {
        boolean b = false;

        for (Item item : itemInventory) {    //looking if item exists already in the list
            if (itemInfo.getName().equalsIgnoreCase(item.getName()) && itemInfo.getCalories() == item.getCalories()) {
                b = true;
                break;
            }
        }

        return b;
    }

    /**
     * This method adds a given item to the inventory.
     *
     * @param item the item to be added to the inventory.
     * @param price the price of the item
     * @return true if the item was successfully added, false otherwise.
     */
    public boolean addToInventory(Item item, int price) {
        boolean b = false;

        if (itemInventory.size() < MAX_INV) {
            if (!contains(item)) {
                itemList.add(new ItemInfo(item.getName(), item.getCalories(), price));
                itemInventory.add(item);
                newStartingInventory();
                clearLog();
                b = true;
            }
        }

        return b;
    }

    /**
     * This method adds a given item to the inventory.
     *
     * @param item the item to be added to the inventory.
     * @return true if the item was successfully added, false otherwise.
     */
    public boolean addToInventory(Item item) {
        boolean b = false;

        if (itemInventory.size() < MAX_INV) {
            if (contains(item)){
                itemInventory.add(item);
                newStartingInventory();
                clearLog();
                b = true;
            }
        }

        return b;
    }

    /**
     * This method gets the price of the item if it exists in the item list, return null otherwise.
     *
     * @param item the item to be checked.
     * @return the price of the item, null if not found.
     */
    public Integer priceItem(Item item) {
        Integer price = null;

        for (ItemInfo itemInfo : itemList) {    //looking for the item in the list
            if (itemInfo.getName().equalsIgnoreCase(item.getName()) && itemInfo.getCalories() == item.getCalories()) {
                price = itemInfo.getPrice();
                break;
            }
        }

        return price;
    }

    /**
     * This method sets the price of the item in the item list.
     *
     * @param choice the item choice index + 1.
     * @param price the price to be set.
     */
    public void setItemPrice(int choice, int price) throws IndexOutOfBoundsException {
        itemList.get(choice - 1).setPrice(price);
    }

    /**
     * This method shows the Inventory in index.
     *
     * @return the showing of the Inventory in index.
     */
    public ArrayList<String> getIndexInventoryInfo() {
        ArrayList<String> info = new ArrayList<String>();
        String availability = "";

        info.add("----- Item List of " + NAME + " -----\n");

        for (int i = 0; i < itemList.size(); i++) {
            ItemInfo itemInfo = itemList.get(i);
            if (inventoryContains(itemInfo))
                availability = "Available";
            else
                availability = "Not Available";

            info.add("[" + (i + 1) + "] " + itemInfo.getName() + " - " + itemInfo.getCalories() + " Calories - " + itemInfo.getPrice() + " PHP (" + availability + ")\n");
        }

        return info;
    }

    /**
     * This method gets the size of the item info list.
     *
     * @return the size of the item info list.
     */
    public int getItemListSize() {
        return itemList.size();
    }

    /**
     * This method returns instance of the item to be released, null if not found.
     *
     * @param choice the item index + 1
     * @return instance of the item to be released, null if not found.
     */
    public Item releaseItem(int choice) {
        Item item = null;
        ItemInfo itemInfo = itemList.get(choice - 1);

        for (int i = 0; i < itemInventory.size(); i++) {    //looks for the item in the inventory
            Item find = itemInventory.get(i);
            if (itemInfo.getName().equalsIgnoreCase(find.getName()) && itemInfo.getCalories() == find.getCalories()) {
                item = itemInventory.remove(i);
                break;
            }
        }

        return item;
    }



    /**
     * This method gets silog meal type String.
     *
     * @param items the potential silog combo meal
     * @return the silog String if it is a silog meal, else return null.
     */
    public String getSilog(ArrayList<Item> items) {
        String silog = null;
        boolean b = false;
        ArrayList<Item> counterList = new ArrayList<Item>();

        for (Item def : defaultSilogSide) { //counting for the different chosen side, there can only be one
            for (Item item : items) {
                if (def.getName().equalsIgnoreCase(item.getName()) && def.getCalories() == item.getCalories()) {
                    if (!counterList.contains(def))
                        counterList.add(def);
                    break;
                }
            }
            if (counterList.size() > 1)
                break;
        }

        if (counterList.size() == 1) {
            Item item = counterList.remove(0);
            switch (item.getName()) {
                case "Tapas" -> silog = "Tapsilog";
                case "Bangus" -> silog = "Bangsilog";
                case "Tosino" -> silog = "Tosilog";
                case "Pork Chop" -> silog = "Porksilog";
                case "Fried Chicken" -> silog = "Chicksilog";
            }
        }
        return silog;
    }

    /**
     * This method returns the process of making the silog meal
     *
     * @param silogCombo the silog combo meal
     * @return the ArrayList of Strings of the process of making the combo meal.
     */
    public ArrayList<String> silogProcess(SilogCombo silogCombo) {
        ArrayList<Item> items = silogCombo.getItems();
        ArrayList<String> process = new ArrayList<String>();
        String side = "";
        ArrayList<String> topping = new ArrayList<String>();
        boolean b = false;

        for (Item def : defaultSilogSide) { //looking for the item that defines the type of silog meal
            for (Item item : items) {
                if (def.getName().equalsIgnoreCase(item.getName()) && def.getCalories() == item.getCalories()) {
                    side = def.getName();
                    b = true;
                    break;
                }
            }
            if (b)
                break;
        }

        for (Item def : defaultToppings) {  //looks for all the toppings in the item list
            for (Item item : items) {
                if (def.getName().equalsIgnoreCase(item.getName()) && def.getCalories() == item.getCalories()) {
                    topping.add(def.getName());
                }
            }
        }

        process.add("Cooking Rice...\n");
        process.add("Cooking " + side + "...\n");
        process.add("Putting Rice and " + side + " in a Bowl...\n");
        for (String str : topping) {
            process.add("Topping with " + str + "...\n");
        }
        process.add(getSilog(items) + " Done!\n");
        process.add("Putting everything in bag...\n");
        process.add("Done!\n");
        return process;
    }

    /**
     * This method checks if the list of items compose of a valid silog combo meal.
     *
     * @param items the items in the potential silog combo meal
     * @return the true if it is valid combo meal, false otherwise
     */
    public boolean isSilog(ArrayList<Item> items) {
        boolean b = false;

        ArrayList<Item> counterList = new ArrayList<Item>();

        for (Item def : defaultSilogBase) { //counting for the base items that defines a silog meal
            for (Item item : items) {
                if (def.getName().equalsIgnoreCase(item.getName()) && def.getCalories() == item.getCalories()) {
                    if (!counterList.contains(def))
                        counterList.add(def);
                    break;
                }
            }
            if (counterList.size() == defaultSilogBase.size()) {
                b = true;
                break;
            }
        }

        if (b) {
            String silog = getSilog(items);
            if (silog == null)
                b = false;
        }

        return b;
    }

    /**
     * This method generates the silog combo meal.
     *
     * @param items the items in the potential silog combo meal
     * @return the silog combo meal, return null if not a silog combo meal
     */
    public SilogCombo produceSilogCombo(ArrayList<Item> items) {
        SilogCombo silogCombo = null;
        int calories = 0;
        boolean b = false;

        if (isSilog(items)) {
            for (Item item : items) {   //calculating total calories
                calories += item.getCalories();
            }
            silogCombo = new SilogCombo(getSilog(items), items, calories);
            addTransaction(silogCombo);
        }

        return silogCombo;
    }


    /**
     * This method gets the current count of items in the inventory of this special vending machine.
     *
     * @return the current count of items in the inventory of this special vending machine.
     */
    public ArrayList<String> getItemInventory() {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> nameCount = new ArrayList<String>();
        ArrayList<String> inventory = new ArrayList<String>();
        int[] nCount = new int[itemInventory.size()];
        boolean b = false;

        for (Item item : itemInventory) {   //getting all the names of the item instances in itemInventory
            names.add(item.getName());
        }

        for (String str : names) {  //counting the number of repeated names of the item instances in an array
            b = false;
            for (int i = 0; i < nameCount.size(); i++) {
                if (str.equalsIgnoreCase(nameCount.get(i))) {
                    nCount[i] += 1;
                    b = true;
                    break;
                }
            }
            if (!b) {
                nCount[nameCount.size()] += 1;
                nameCount.add(str);
            }
        }

        inventory.add("- - - Special Inventory " + NAME + " - - -\n");
        for (int i = 0; i < nameCount.size(); i++) {
            inventory.add(nameCount.get(i) + ": " + nCount[i] + "\n");
        }

        return inventory;
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
     * The list of items that comprise the default silog meal toppings
     */
    private ArrayList<Item> defaultToppings;

    /**
     * An item inventory that is used for silog combos
     */
    private ArrayList<Item> itemInventory;

    /**
     * The prices of items in the inventory with respect to index
     */
    private ArrayList<ItemInfo> itemList;

    /**
     * The maximum items in item inventory
     */
    private final int MAX_INV;
}
