import java.util.ArrayList;
import java.util.HashMap;

/**
 * The VendingMachine class contains all the methods and
 * attributes for setting up (maintenance) and buying
 * from a vending machine.
 */
public class VendingMachine {
    /**
     * This method is a constructor which utilizes the following parameters:
     *
     * @param name the name of the vending machine.
     * @param maxSlots the max amount of Slots.
     * @param slotMaxItems the max amount of items in each Slot.
     */
    public VendingMachine(String name, int maxSlots, int slotMaxItems) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (maxSlots < 8)
            throw new IllegalArgumentException("Number of slots in the vending machine shall be 8 or more");
        this.NAME = name;
        this.itemSlots = new ItemSlot[maxSlots];    //initializing the number of slots in the vending machine
        for (int i = 0; i < maxSlots; i++) {    //loop to assign SLOTNUMBER and max items in each slot
            itemSlots[i] = new ItemSlot(slotMaxItems);
        }
        startingInventory = new ArrayList<String>();
        transactionLog = new ArrayList<String>();
        money = new ArrayList<Money>();
    }

    /**
     * This method gets the name of the vending machine.
     *
     * @return the name of the vending machine.
     */
    public String getName() {
        return NAME;
    }

    /**
     * This method gets the transaction log of the vending machine.
     *
     * @return the transaction log of the vending machine.
     */
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
     * This method gets the starting inventory of the vending machine.
     *
     * @return the starting inventory of the vending machine.
     */
    private ArrayList<String> getStartingInventory() {
        return startingInventory;
    }

    /**
     * This method gets the current inventory of the vending machine.
     *
     * @return the current inventory of the vending machine.
     */
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
    public ArrayList<String> getInventoryLog() {
        ArrayList<String> log = new ArrayList<String>();
        log.add("----- Starting Inventory " + NAME + " -----\n");
        log.addAll(startingInventory);
        log.add("----- Current Inventory " + NAME + " -----\n");
        log.addAll(getCurrentInventory());
        return log;
    }

    /**
     * This method gets the number of slots in the vending machine.
     *
     * @return the current inventory of the vending machine.
     */
    public int getNumSlots() {
        return itemSlots.length;
    }

    /**
     * This method gets the max capacity of the item slots.
     *
     * @return the max capacity of the item slots.
     */
    public int getMaxSlotItem() {
        return itemSlots[0].getMax();
    }

    /**
     * This method gets the ArrayList of Strings that shows the slot information.
     *
     * @return the ArrayList of Strings that shows the slot information.
     */
    public ArrayList<String> getSlotInfo() {
        ArrayList<String> slotInfo = new ArrayList<String>();

        slotInfo.add("-------- Vending Machine " + NAME + "--------\n");
        slotInfo.add("Slot - Item - Calories - Cost - Availability\n");
        for (int i = 0; i < itemSlots.length; i++) {
            String availability;
            if (itemSlots[i].isAvailable())
                availability = "(Available)";
            else
                availability = "(Not Available)";

            if (itemSlots[i].getStock() > 0)
                slotInfo.add("[" + (i + 1) + "] " + itemSlots[i].getItemName() + " - " + itemSlots[i].getItemCalories() + " Calories - "+ itemSlots[i].getPrice() + " PHP " + availability + "\n");
            else
                slotInfo.add("[" + (i + 1) + "] "  + availability + "\n");

        }

        return slotInfo;
    }

    /**
     * This method gets the price of the item on the slot.
     *
     * @param slot the slot number given
     * @return the price of the item on the slot.
     */
    public int getSlotPrice(int slot) {
        return itemSlots[slot - 1].getPrice();
    }


    /**
     * This method sets a new price given a slot number if it contains items.
     *
     * @param slot the slot number to update the price with.
     * @param newPrice the new price given to the slot.
     * @return true if changing the price is successful, false otherwise.
     */
    public boolean setSlotPrice(int slot, int newPrice) throws IndexOutOfBoundsException {
        boolean b = false;

        if (itemSlots[slot - 1].getStock() > 0) {
            b = true;
            itemSlots[slot - 1].setPrice(newPrice);
        }
        return b;
    }

    /**
     * This method gets the name of the item on the slot.
     *
     * @param slot the slot number given
     * @return the name of the item on the slot, null if item does not exist on the slot.
     */
    public String getSlotItemName(int slot) {
        String name = null;
        if (itemSlots[slot - 1].getStock() > 0)
            name = itemSlots[slot - 1].getItemName();

        return name;
    }

    /**
     * This method adds an item given a slot number.
     *
     * @param slot the slot number to update the price with.
     * @param vendItems the items to add to the slot.
     * @return true if the item was successfully added to the slot, otherwise false
     */
    public boolean addSlotStock(int slot, ArrayList<VendItem> vendItems) throws IndexOutOfBoundsException {
        boolean b = false;

        if (getMaxSlotItem() >= itemSlots[slot - 1].getStock() + vendItems.size()) {
            if (itemSlots[slot - 1].addStock(vendItems)){
                b = true;
                newStartingInventory();
            }
        }
        return b;
    }

    /**
     * This method clears the transaction log.
     */
    public void clearLog() {
        transactionLog.clear();
    }

    /**
     * This method updates the starting inventory.
     */
    public void newStartingInventory() {
        startingInventory = getCurrentInventory();
    }

    /**
     * This method retrieves and dispenses the item given an item slot,
     * while also adding that transaction to the vending machine.
     *
     * @param slot the item slot the item will be retrieved from
     * @return the item from the given item slot
     */
    public VendItem dispenseItem(int slot) throws IndexOutOfBoundsException {
        VendItem vendItem = itemSlots[slot - 1].removeItem();

        addTransaction(vendItem.getName(), itemSlots[slot - 1].getPrice());
        return vendItem;
    }

    /**
     * This method adds a transaction string to the transaction log.
     *
     * @param item the item of transaction
     * @param price the price of the item transaction
     */
    public void addTransaction(String item, int price) {
        String transaction = item + "-" + price;
        transactionLog.add(transaction);
    }

    /**
     * This method calculates and returns change if there is sufficient denominations in the vending machine.
     *
     * @param payment the payment in denominations
     * @param cost the price of the item transaction
     * @return an int of change
     */
    public int calcChange(ArrayList<Money> payment, int cost) {
        int total = 0;

        //getting the payment value in terms of int
        for (Money denomination : payment) {
            total += denomination.getValue();
        }

        return total - cost;
    }

    /**
     * This method calculates and returns change if there is sufficient denominations in the vending machine.
     *
     * @param payment the payment in denominations
     * @param cost the price of the item transaction
     * @return an ArrayList of Money in change, and return payment if a change cannot be given
     */
    public ArrayList<Money> getChange(ArrayList<Money> payment, int cost) {
        ArrayList<Money> change = new ArrayList<Money>();
        int nChange;
        boolean b = true;
        money.addAll(payment);

        nChange = calcChange(payment, cost);

        while (nChange >= 1000 && b) {
            b = false;
            for (Money denomination : money) {
                if (denomination.getValue() == 1000) {
                    b = true;
                    change.add(denomination);
                    nChange -= 1000;
                    money.remove(denomination);
                    break;
                }
            }
        }

        b = true;

        while (nChange >= 500 && b) {
            b = false;
            for (Money denomination : money) {
                if (denomination.getValue() == 500) {
                    b = true;
                    change.add(denomination);
                    nChange -= 500;
                    money.remove(denomination);
                    break;
                }
            }
        }

        b = true;

        while (nChange >= 200 && b) {
            b = false;
            for (Money denomination : money) {
                if (denomination.getValue() == 200) {
                    b = true;
                    change.add(denomination);
                    nChange -= 200;
                    money.remove(denomination);
                    break;
                }
            }
        }

        b = true;

        while (nChange >= 100 && b) {
            b = false;
            for (Money denomination : money) {
                if (denomination.getValue() == 100) {
                    b = true;
                    change.add(denomination);
                    nChange -= 100;
                    money.remove(denomination);
                    break;
                }
            }
        }

        b = true;

        while (nChange >= 50 && b) {
            b = false;
            for (Money denomination : money) {
                if (denomination.getValue() == 50) {
                    b = true;
                    change.add(denomination);
                    nChange -= 50;
                    money.remove(denomination);
                    break;
                }
            }
        }

        b = true;

        while (nChange >= 20 && b) {
            b = false;
            for (Money denomination : money) {
                if (denomination.getValue() == 20) {
                    b = true;
                    change.add(denomination);
                    nChange -= 20;
                    money.remove(denomination);
                    break;
                }
            }
        }

        b = true;

        while (nChange >= 10 && b) {
            b = false;
            for (Money denomination : money) {
                if (denomination.getValue() == 10) {
                    b = true;
                    change.add(denomination);
                    nChange -= 10;
                    money.remove(denomination);
                    break;
                }
            }
        }

        b = true;

        while (nChange >= 5 && b) {
            b = false;
            for (Money denomination : money) {
                if (denomination.getValue() == 5) {
                    b = true;
                    change.add(denomination);
                    nChange -= 5;
                    money.remove(denomination);
                    break;
                }
            }
        }

        b = true;

        while (nChange >= 1 && b) {
            b = false;
            for (Money denomination : money) {
                if (denomination.getValue() == 1) {
                    b = true;
                    change.add(denomination);
                    nChange -= 1;
                    money.remove(denomination);
                    break;
                }
            }
        }



        if (nChange == 0) {   //nChange = 0 meaning there is change
            return change;
        }

        money.addAll(change);
        money.removeAll(payment);
        return payment;
    }


    /**
     * This method collects the money in the vending machine.
     */
    public ArrayList<Money> collectMoney() {
        ArrayList<Money> temp = new ArrayList<Money>(money);
        money.clear();
        return temp;
    }

    /**
     * This method adds a given money denomination to the vending machine for change.
     *
     * @param money the given money denomination to be added to the vending machine.
     */
    public void addMoney(Money money) {
        this.money.add(money);
    }

    /**
     * This method returns an ArrayList of Strings to so show the money in the vending machine.
     *
     * @return ArrayList of String of denominations in the vending machine.
     */
    public ArrayList<String> showMoney() {
        ArrayList<String> show = new ArrayList<String>();
        HashMap<Integer, ArrayList<Money>> denominations = getDenominations(money);

        show.add("Money in " + NAME + "\n");
        show.add("------------------------" + "\n");
        show.add("1 PHP: " + denominations.get(1).size() + "\n");
        show.add("5 PHP: " + denominations.get(5).size() + "\n");
        show.add("10 PHP: " + denominations.get(10).size() + "\n");
        show.add("20 PHP: " + denominations.get(20).size() + "\n");
        show.add("50 PHP: " + denominations.get(50).size() + "\n");
        show.add("100 PHP: " + denominations.get(100).size() + "\n");
        show.add("200 PHP: " + denominations.get(200).size() + "\n");
        show.add("500 PHP: " + denominations.get(500).size() + "\n");
        show.add("1000 PHP: " + denominations.get(1000).size() + "\n");

        return show;
    }

    /**
     * This is a method that returns whether a slot of the vending machine have available item for purchase.
     *
     * @return true if there are available items, false otherwise.
     */
    public boolean isSlotAvailable(int slot) {
        return itemSlots[slot - 1].isAvailable();
    }


    /**
     * This is a helper method that returns a HashMap that contains the value of denominations as key and ArrayList of
     * Money as values.
     *
     * @return HashMap that contains the value of denominations as key and ArrayList of Money as values.
     */
    private HashMap<Integer, ArrayList<Money>> getDenominations(ArrayList<Money> given) {

        HashMap<Integer, ArrayList<Money>> denominations = new HashMap<Integer, ArrayList<Money>>();

        denominations.put(1, new ArrayList<Money>());
        denominations.put(5, new ArrayList<Money>());
        denominations.put(10, new ArrayList<Money>());
        denominations.put(20, new ArrayList<Money>());
        denominations.put(50, new ArrayList<Money>());
        denominations.put(100, new ArrayList<Money>());
        denominations.put(200, new ArrayList<Money>());
        denominations.put(500, new ArrayList<Money>());
        denominations.put(1000, new ArrayList<Money>());


        for (Money denom : given) {
            if (denominations.containsKey(denom.getValue())) {
                denominations.get(denom.getValue()).add(denom);
            }
        }

        return denominations;
    }



    /**
     * The name of the Vending Machine
     */
    protected final String NAME;

    /**
     * The item slots of the vending machine
     */
    protected ItemSlot[] itemSlots;

    /**
     * The ArrayList of Money of the vending machine
     */
    protected ArrayList<Money> money;

    /**
     * The ArrayList of String for the transaction log of the vending machine
     */
    protected ArrayList<String> transactionLog;

    /**
     * The ArrayList of String for the starting inventory of the vending machine
     */
    protected ArrayList<String> startingInventory;

}

/*

 */
/**
 * This method gets the total amount of money in the vending machine.
 * @return the total amount of money in the vending machine.
 *//*

    public Money getMoney() {
        return money;
    }

    */
/**
 * This method gets the list of Item Slots in the vending machine.
 * @return list of item slots in the vending machine.
 *//*

    public ItemSlot[] getItemSlots() {
        return itemSlots;
    }

    */
/**
 * This method gets the name of the vending machine.
 * @return the name of the vending machine.
 *//*

    public String getName() {
        return NAME;
    }

    public VendingMachineInventory getStartingInventory() {
        return startingInventory;
    }



    */
/**
 * This method checks if the amount of VendingStock is valid.
 * @param itemStock itemStock to be validated.
 * @return true if itemstock is valid and false if not.
 *//*

    public boolean isValidItem(ItemStock itemStock) {
        boolean b = true;

        if (itemStock.getSRP() <= 0 || itemStock == null) //item is invalid if SRP <= 0 or is null
            b = false;


        return b;
    }

    */
/**
 * This method checks if the itemSlot is valid.
 * @param slot itemSlot to be validated.
 * @return true if itemSlot is valid and false if not.
 *//*

    public boolean isValidSlot(int slot) {
        if (slot > 0 && slot <= itemSlots.length)
            return true;
        else
            return false;
    }



    public void setSlotPrice(int slot, int newPrice) {
        itemSlots[slot - 1].setPrice(newPrice);
    }

    public void setSlotItem(int slot, VendingStock newItem) {
        itemSlots[slot - 1].setVendingStock(newItem);
    }

    */
/**
 * This method sets the SRP of an item slot.
 * @param slot the item slot to be set.
 * @return true if successful and false if not.
 *//*

    public boolean setSRP(int slot) {
        boolean b = false;

        if (isValidSlot(slot))
            if (itemSlots[slot - 1].getVendingStock() != null) {   //making usre the object is not null
                itemSlots[slot - 1].setSRP();
                b = true;
            }

        return b;
    }

    */
/**
 * This method sets all prices of existing items to its SRP.
 *//*

    public void setAllSRP() {
        for (int slot = 1; slot <= itemSlots.length; slot++) {
            if (itemSlots[slot - 1].getVendingStock() != null) //assuring non-initialized slot will obtain a change in price
                itemSlots[slot - 1].setSRP();
        }
    }

    public void resetLogs() {
        newStartingInventory();
        clearLog();
    }


    public Money collectMoney() {
        Money tempMoney = new Money(money);

        money.empty();  //empties the vending machine money

        return tempMoney;
    }

    */
/**
 * This method puts money into the following:
 * @param change the Money to be replenishing the vending machine change.
 *//*

    public void replenishMoney(Money change) {
        money.addMoney(change);
        newStartingInventory();
    }

    */
/**
 * This determines validity of selected slot.
 * @return true if valid, false otherwise
 *//*

    public boolean selectSlot(int slot) {
        if (slot < 1 || slot > itemSlots.length)
            return false;
        return true;
    }


    public ArrayList<String> stringTransactions() {
        ArrayList<String> str = new ArrayList<String>();
        int total = 0;

        str.add("=========================");
        for (ItemTransaction transactions : transactionLog) {
            if (transactions.getSlot().getVendingStock() != null) {    //assuring the transaction of the specific
                str.add(transactions.toString());
                total += transactions.getTotal();   //adds the total earnings
            }
        }


        if (total == 0)
            str.add(NAME + ": No Transactions Were Made");
        str.add("Total Earnings: " + total + " PHP");


        str.add("=========================");
        return str;
    }


    public ArrayList<String> stringInventories() {
        ArrayList<String> strInventories = new ArrayList<String>();
        if (startingInventory != null) {
            VendingMachineInventory endingInventory = new VendingMachineInventory(this);    //creating the ending inventory using the current inventory

            strInventories.addAll(stringInventory(startingInventory, "Starting Inventory"));
            strInventories.addAll(stringInventory(endingInventory, "Ending Inventory"));

            endingInventory = null;
        }
        else
            strInventories.add(NAME + " Vending Machine is Still New");

        return strInventories;
    }

    */
/**
 * This method clears the transaction logs.
 *//*

    public void clearLog() {
        for (int i = 0; i < transactionLog.length; i++) {
            transactionLog[i].clearTransaction();
        }
    }

    */
/**
 * This method makes a new vending machine inventory.
 *//*

    public void newStartingInventory() {
        startingInventory = null;
        startingInventory = new VendingMachineInventory(this);
    }

    public void successfulTransaction(int slotSelection) {
        transactionLog[slotSelection - 1].addTransaction();
    }


    public Item performTransaction(Money payment, Money sourceWallet, Money wallet, int slotSelection,
                                   int change) {
        Item theItem = null;


        money.addMoney(payment);    //adding the payment to the vending machine money

        if (money.removeMoney(change)) {    //checking if the removing of change in the vending machine is successful
            sourceWallet.replace(wallet); //replace the actual wallet of the user with the resulting wallet considering the successful payment
            theItem = itemSlots[slotSelection - 1].removeStock();
        }
        else {
            money.removeMoney(payment); //remove the payment from the vending machine money if the vending machine money don't have the appropriate denominations for the change (if there is)
        }

        return theItem;
    }

    public int calcChange(Money payment, int cost) {
        return payment.getMoney() - cost;
    }


    private ArrayList<String> stringInventory(VendingMachineInventory inventory, String info) {
        ArrayList<String> strInventory = new ArrayList<String>();
        strInventory.add("=========================");
        strInventory.add("---" + info + "---");
        strInventory.add("Slot Number || Item");
        strInventory.add("=========================");

        for (int i = 0; i < inventory.getItemSlots().length; i++){  //displays the vending machine inventory of when the VendingMachineInventory is constructed
            String temp = "";
            if (inventory.getItemSlots()[i] != null){   //the item slots must be initialized for it to be considered as a valid inventory space
                temp = temp.concat(inventory.getItemSlots()[i].getSlotNumber() + " || ");
                if (inventory.getItemSlots()[i].getVendingStock() != null)
                    temp = temp.concat(inventory.getItemSlots()[i].getVendingStock().getName() + " - " + inventory.getItemSlots()[i].getStock());
                else
                    temp = temp.concat("X");

                strInventory.add(temp);
            }
        }
        strInventory.add("=========================");
        strInventory.addAll(inventory.getMoney().moneyString(info));
        return strInventory;
    }
*/
