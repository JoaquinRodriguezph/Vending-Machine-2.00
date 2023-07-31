import java.util.ArrayList;

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
    public VendingMachine(String name, int maxSlots, int slotMaxItems) {
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
                if (temp1.equalsIgnoreCase(stringFind[i])) {
                    tCount[i] += 1;
                    b = true;
                    break;
                }

            }
            if (!b) {
                for (int i = 0; i < stringFind.length; i++) {
                    if (stringFind[i].isEmpty()) {
                        stringFind[i] = temp1;
                        tCount[i] += 1;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < tCount.length; i++) {
            if (stringFind[i].isEmpty())
                break;
            else {
                int price = Integer.parseInt(stringFind[i].substring(stringFind[i].indexOf('-') + 1));
                int totalItem = tCount[i] * price;
                logs.add(stringFind[i].substring(0, stringFind[i].indexOf('-')) + ": " + tCount[i] + " * " + price + " = " + totalItem + " PHP");
            }
        }

        return logs;
    }

    /**
     * This method gets the starting inventory of the vending machine.
     *
     * @return the starting inventory of the vending machine.
     */
    public ArrayList<String> getStartingInventory() {
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
                inventory.add(slot.getItemName() + ": " + slot.getStock());
        }

        return inventory;
    }



    /**
     * This method sets a new price given a slot number.
     *
     * @param slot the slot number to update the price with.
     * @param newPrice the new price given to the slot.
     */
    public void setSlotPrice(int slot, int newPrice) throws IndexOutOfBoundsException {
        itemSlots[slot - 1].setPrice(newPrice);
    }

    /**
     * This method adds an item given a slot number.
     *
     * @param slot the slot number to update the price with.
     * @param item the item to add to the slot.
     */
    public boolean addSlotStock(int slot, Item item) throws IndexOutOfBoundsException {
        if (itemSlots[slot - 1].addStock(item)) {
            newStartingInventory();
            return true;
        }
        return false;
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
     * This method retrieves and dispenses the item given an item slot.
     *
     * @param slot the item slot the item will be retrieved from
     * @return the item from the given item slot
     */
    public Item dispenseItem(int slot) throws IndexOutOfBoundsException {
        Item item = itemSlots[slot - 1].removeItem();

        addTransaction(item.getName(), itemSlots[slot - 1].getPrice());
        return item;
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
     * @return an ArrayList of Money in change, and null if a change cannot be given
     */
    public ArrayList<Money> getChange(ArrayList<Money> payment, int cost) {
        ArrayList<Money> change = new ArrayList<Money>();
        ArrayList<Money> tempMoney = new ArrayList<Money>(money);
        tempMoney.addAll(payment);
        int[] denominations = new int[9];
        int total = 0;

        //getting the payment value in terms of int
        for (Money denom : payment) {
            total += denom.getValue();
        }

        //putting the denominations in a simple array for better code readability
        for (Money denom : tempMoney) {
            switch (denom.getValue()) {
                case 1 -> denominations[0]++;
                case 5 -> denominations[1]++;
                case 10 -> denominations[2]++;
                case 20 -> denominations[3]++;
                case 50 -> denominations[4]++;
                case 100 -> denominations[5]++;
                case 200 -> denominations[6]++;
                case 500 -> denominations[7]++;
                case 1000 -> denominations[8]++;
            }
        }

        while (denominations[8] > 0 && total >= 1000) {
            denominations[8]--;
            total -= 1000;
        }

        while (denominations[7] > 0 && total >= 500) {
            denominations[7]--;
            total -= 500;
        }

        while (denominations[6] > 0 && total >= 200) {
            denominations[6]--;
            total -= 200;
        }

        while (denominations[5] > 0 && total >= 100) {
            denominations[5]--;
            total -= 100;
        }

        while (denominations[4] > 0 && total >= 50) {
            denominations[4]--;
            total -= 50;
        }

        while (denominations[3] > 0 && total >= 20) {
            denominations[3]--;
            total -= 20;
        }

        while (denominations[2] > 0 && total >= 10) {
            denominations[2]--;
            total -= 10;
        }

        while (denominations[1] > 0 && total >= 5) {
            denominations[1]--;
            total -= 5;
        }

        while (denominations[0] > 0 && total >= 1) {
            denominations[0]--;
            total -= 1;
        }

        if (total == 0) {   //total = 0 meaning there is change
            money = tempMoney;
            return change;
        }
        return null;
    }


    /**
     * This method updates the starting inventory.
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
    public void replenishMoney(Money money) {
        this.money.add(money);
    }


    /**
     * The name of the Vending Machine
     */
    private final String NAME;

    /**
     * The item slots of the vending machine
     */
    private ItemSlot[] itemSlots;

    /**
     * The ArrayList of Money of the vending machine
     */
    private ArrayList<Money> money;

    /**
     * The ArrayList of String for the transaction log of the vending machine
     */
    private ArrayList<String> transactionLog;

    /**
     * The ArrayList of String for the starting inventory of the vending machine
     */
    private ArrayList<String> startingInventory;

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
