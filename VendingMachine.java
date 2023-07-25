import java.util.ArrayList;

/**
 * The VendingMachine class contains all the methods and
 * attributes for setting up (maintenance) and buying
 * from a vending machine.
 */
public class VendingMachine {
    /**
     * This method is a constructor which utilizes the following parameters:
     * @param name the name of the vending machine.
     * @param maxSlots the max amount of Slots.
     * @param slotMaxItems the max amount of items in each Slot.
     */
    public VendingMachine(String name, int maxSlots, int slotMaxItems) {
        this.NAME = name;
        this.itemSlots = new ItemSlot[maxSlots];    //initializing the number of slots in the vending machine
        for (int i = 0; i < maxSlots; i++) {    //loop to assign SLOTNUMBER and max items in each slot
            itemSlots[i] = new ItemSlot(i + 1, slotMaxItems);
        }
        startingInventory = null;   //there is no startingInventory when the Vending Machine is first instantiated
        transactionLog = new ItemTransaction[maxSlots]; //initializing the number of possible items for the item transactions
        for (int i = 0; i < maxSlots; i++) {
            transactionLog[i] = new ItemTransaction(itemSlots[i]);
        }
        money = new Money();
    }

    /**
     * This method gets the total amount of money in the vending machine.
     * @return the total amount of money in the vending machine.
     */
    public Money getMoney() {
        return money;
    }

    /**
     * This method gets the list of Item Slots in the vending machine.
     * @return list of item slots in the vending machine.
     */
    public ItemSlot[] getItemSlots() {
        return itemSlots;
    }

    /**
     * This method gets the name of the vending machine.
     * @return the name of the vending machine.
     */
    public String getName() {
        return NAME;
    }

    public VendingMachineInventory getStartingInventory() {
        return startingInventory;
    }



    /**
     * This method checks if the amount of VendingStock is valid.
     * @param itemStock itemStock to be validated.
     * @return true if itemstock is valid and false if not.
     */
    public boolean isValidItem(ItemStock itemStock) {
        boolean b = true;

        if (itemStock.getSRP() <= 0 || itemStock == null) //item is invalid if SRP <= 0 or is null
            b = false;


        return b;
    }

    /**
     * This method checks if the itemSlot is valid.
     * @param slot itemSlot to be validated.
     * @return true if itemSlot is valid and false if not.
     */
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

    /**
     * This method sets the SRP of an item slot.
     * @param slot the item slot to be set.
     * @return true if successful and false if not.
     */
    public boolean setSRP(int slot) {
        boolean b = false;

        if (isValidSlot(slot))
            if (itemSlots[slot - 1].getVendingStock() != null) {   //making usre the object is not null
                itemSlots[slot - 1].setSRP();
                b = true;
            }

        return b;
    }

    /**
     * This method sets all prices of existing items to its SRP.
     */
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

    /**
     * This method puts money into the following:
     * @param change the Money to be replenishing the vending machine change.
     */
    public void replenishMoney(Money change) {
            money.addMoney(change);
            newStartingInventory();
    }

    /**
     * This determines validity of selected slot.
     * @return true if valid, false otherwise
     */
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

    /**
     * This method clears the transaction logs.
     */
    public void clearLog() {
        for (int i = 0; i < transactionLog.length; i++) {
            transactionLog[i].clearTransaction();
        }
    }

    /**
     * This method makes a new vending machine inventory.
     */
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

    private final String NAME;

    private ItemSlot[] itemSlots;
    private Money money;
    private ItemTransaction[] transactionLog;
    private VendingMachineInventory startingInventory;

}
