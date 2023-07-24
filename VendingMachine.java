import java.util.ArrayList;
import java.util.Scanner;

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
     * This method checks if the amount of itemstock is valid.
     * @param itemStock itemStock to be validated.
     * @return true if itemstock is valid and false if not.
     */
    public boolean isValidItem(ItemStock itemStock) {
        boolean b = true;

        if (itemStock.getSRP() <= 0 || itemStock == null) //item is invalid if SRP <= 0 or is null
            b = false;

        if (!b)
            System.out.println("Error: Invalid Item");

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
        else {
            System.out.println("Error: Invalid Item Slot");
            return false;
        }
    }

    /**
     * This method makes sure to check if the slot is currently empty.
     * @param slot the slot to be checked.
     * @param quantity the quantity of the slot to be checked.
     * @param itemStock the itemStock of the slot to be checked.
     * @return true if successful and false if not.
     */
    public boolean newStock(int slot, int quantity, ItemStock itemStock) {
        return newStock(slot, quantity, itemStock, itemStock.getSRP());
    }

    /**
     * This method makes sure to check if the slot is currently empty.
     * @param slot the slot to be checked.
     * @param quantity the quantity of the slot to be checked.
     * @param itemStock the itemStock of the slot to be checked.
     * @param price the price to be checked.
     * @return true if successful and false if not
     */
    public boolean newStock(int slot, int quantity, ItemStock itemStock, int price) {
        boolean b = false, found = false;
        ItemStock tempItem;
        int oldPrice;


        tempItem = itemSlots[slot - 1].getItemStock();  //keeps track of old item
        oldPrice = itemSlots[slot - 1].getPrice();  //keeps track of old price of the slot
        if (isValidSlot(slot) && isValidItem(itemStock)) {
            for (int i = 0; i < itemSlots.length; i++) {
                if (itemStock == itemSlots[i].getItemStock())
                    found = true;
            }
            if (!found) {
                if (itemSlots[slot - 1].isEmpty()) {    //check if the itemSlot is empty
                    b = true;
                    System.out.println("Setting Up New Stock On Slot " + slot);

                    itemSlots[slot - 1].setItemStock(itemStock); //sets the slot to this new item for addStock to function

                    b = changePrice(slot, price);   //sets the price of the new item

                    if (quantity != 0 && b)  //quantity 0 bypasses new boolean value
                    {
                        b = itemSlots[slot - 1].addStock(quantity);
                    }

                    if (!b) {
                        System.out.println("Resetting Price...");
                        itemSlots[slot - 1].setPrice(oldPrice);
                        itemSlots[slot - 1].setItemStock(tempItem); //sets the slot to the old item
                    }

                    if (b) {
                        System.out.println("Slot " + slot + " Now Has " + itemSlots[slot - 1].getItemStock().getName() + " at " + itemSlots[slot - 1].getPrice() + " PHP");
                        //resets when stocking
                        newStartingInventory();
                        clearLog();
                    }
                } else
                    System.out.println("Error: Slot " + slot + " is Not Empty");
            }
            else
                System.out.println("Error: The Same Item Already Exists in Vending Machine " + NAME);
        }

        if (!b)
            System.out.println("Failed to Setup New Item");


        return b;
    }

    /**
     * This method restocks an item slot.
     * @param slot the item slot to be restocked.
     * @param quantity how many stocks would be put.
     * @return true if successful and false if not.
     */
    public boolean restock(int slot, int quantity) {
        boolean b = false;

        if (isValidSlot(slot))
            if (itemSlots[slot - 1].getItemStock() != null) {   //making sure the object is not null
                b = itemSlots[slot - 1].addStock(quantity); //retrieving the boolean if the adding of stock is successful
                if (b) {
                    //resets when stocking
                    newStartingInventory();
                    clearLog();
                }
            } else
                System.out.println("Slot " + slot + " is Not Assigned to Any Items");

        return b;
    }

    /**
     * This method changes the price of an item slot.
     * @param slot the item slot to be changed.
     * @param price the new price of the item slot.
     * @return true if successful and false if not.
     */
    public boolean changePrice(int slot, int price) {
        boolean b = false;

        if (itemSlots[slot - 1].getItemStock() != null){
            if (price > 0) {    //positive integer
                System.out.print("Slot " + slot);
                if (itemSlots[slot - 1].getPrice() != 0)    //if the item slot had contained any pre-existing assigned item
                    System.out.print(" Price Has Been Changed From " + itemSlots[slot - 1].getPrice() + " PHP to ");
                else
                    System.out.print(" Has Been Set to ");
                itemSlots[slot - 1].setPrice(price);
                System.out.println(itemSlots[slot - 1].getPrice() + " PHP (" + itemSlots[slot - 1].getItemStock().getName() + ")");
                b = true;
            } else {
                System.out.println("Error: Invalid Price");
            }
        }
        else
            System.out.println("Slot " + slot + " is Not Assigned to Any Items");

        if (!b)
            System.out.println("Failed to Change Price");

        return b;
    }

    /**
     * This method sets the SRP of an item slot.
     * @param slot the item slot to be set.
     * @return true if successful and false if not.
     */
    public boolean setSRP(int slot) {
        boolean b = false;

        if (isValidSlot(slot))
            if (itemSlots[slot - 1].getItemStock() != null) {   //making usre the object is not null
                itemSlots[slot - 1].setSRP();
                b = true;
            }
            else
                System.out.println("Slot " + slot + " is Not Assigned to Any Items");

        return b;
    }

    /**
     * This method sets all prices of existing items to its SRP.
     */
    public void setAllSRP() {
        for (int slot = 1; slot <= itemSlots.length; slot++) {
            if (itemSlots[slot - 1].getItemStock() != null) //assuring non-initialized slot will obtain a change in price
                itemSlots[slot - 1].setSRP();
        }

        System.out.println("All Existing Items Have Been Set to Its SRP");
    }

    /**
     * This method displays the amount of money in info's currency and the total.
     */
    public void showMoney() {
        money.showMoney(NAME);
    }

    /**
     * This method collects the money inside the vending machine and
     * transfers it into the following:
     * @param wallet the wallet to be transferred to.
     */
    public void collectMoney(Money wallet) {
        wallet.addMoney(money); //add all money in the vending machine to the user wallet
        System.out.println("Money Collected");
        money.showMoney();

        System.out.println("Money in Vending Machine " + NAME + " Has Been Emptied.\nReminder: Replenish Change");

        money.empty();  //empties the vending machine money
    }

    /**
     * This method puts money into the following:
     * @param wallet the wallet to be replenished.
     */
    public void replenishMoney(Money wallet) {
        int temp = -1;
        int quantity = 0;
        Money change = new Money();
        Money emptyWallet = new Money();
        Money tempWallet = new Money(wallet);
        Scanner sc = new Scanner(System.in);

        //similar with receive payment method but allows maintenance person to replenish
        while (temp != 0) {
            System.out.println("Replenish Change");
            System.out.println("=========================");
            System.out.println("(0) Finish");
            System.out.println("Replenish Bills/Coins: ");
            System.out.println("(1) 1 Peso");
            System.out.println("(2) 5 Pesos");
            System.out.println("(3) 10 Pesos");
            System.out.println("(4) 20 Pesos");
            System.out.println("(5) 50 Pesos");
            System.out.println("(6) 100 Pesos");
            System.out.println("(7) 200 Pesos");
            System.out.println("(8) 500 Pesos");
            System.out.println("(9) 1000 Pesos");
            System.out.println("(10) Everything");
            System.out.println("=========================");

            do {
                System.out.println("Bills/Coins: ");
                temp = sc.nextInt();
                if (temp < 0 || temp > 10)
                    System.out.println("Error: Invalid Option");
            } while (temp < 0 || temp > 10);

            if (temp != 0 && temp != 10)
                do {
                    System.out.println("Quantity: ");
                    quantity = sc.nextInt();
                    if (quantity <= 0)
                        System.out.println("Error: Invalid Quantity");
                } while (quantity <= 0);

            switch (temp) {
                case 1:
                    change.changeOnePeso(quantity);
                    break;
                case 2:
                    change.changeFivePeso(quantity);
                    break;
                case 3:
                    change.changeTenPeso(quantity);
                    break;
                case 4:
                    change.changeTwentyPeso(quantity);
                    break;
                case 5:
                    change.changeFiftyPeso(quantity);
                    break;
                case 6:
                    change.changeOneHundredPeso(quantity);
                    break;
                case 7:
                    change.changeTwoHundredPeso(quantity);
                    break;
                case 8:
                    change.changeFiveHundredPeso(quantity);
                    break;
                case 9:
                    change.changeOneThousandPeso(quantity);
                    break;
                case 10:
                    change.replace(wallet);
                case 0:
            }

            if (temp <= 9 && temp >= 1) {
                if (tempWallet.removeMoney(change)) {   //if the user wallet contains the approriate deonominations for the replenish change
                    change.showMoney(NAME + "Change");
                    tempWallet.replace(wallet); //replace the temp wallet with the actual wallet to continue the loop
                }
                else {
                    switch (temp) {
                        case 1:
                            change.changeOnePeso(-quantity);
                            break;
                        case 2:
                            change.changeFivePeso(-quantity);
                            break;
                        case 3:
                            change.changeTenPeso(-quantity);
                            break;
                        case 4:
                            change.changeTwentyPeso(-quantity);
                            break;
                        case 5:
                            change.changeFiftyPeso(-quantity);
                            break;
                        case 6:
                            change.changeOneHundredPeso(-quantity);
                            break;
                        case 7:
                            change.changeTwoHundredPeso(-quantity);
                            break;
                        case 8:
                            change.changeFiveHundredPeso(-quantity);
                            break;
                        case 9:
                            change.changeOneThousandPeso(-quantity);
                        case 0:
                    }
                    System.out.println("Error: Invalid Money Availability");
                }
            }
        }

        change.showMoney(NAME + " Change");

        do {
            System.out.println("Confirm Replenishing Change: (1) Yes   (0) No");
            temp = sc.nextInt();
            if (temp != 1 && temp != 0)
                System.out.println("Error: Invalid Option");
        } while (temp != 1 && temp != 0);


        if (temp == 1) {    //if user confirms to replenish the change
            tempWallet.removeMoney(change);
            wallet.replace(tempWallet);
            money.addMoney(change);
            newStartingInventory();
        }

        tempWallet = null;
        change = null;
        sc = null;
    }

    /**
     * This method lets the user select an item slot.
     * @return number inputted
     */
    public int selectSlot() {
        Scanner sc = new Scanner(System.in);
        int slot;

        do {
            System.out.println("(0) Back");
            System.out.print("Select Item Slot: ");
            slot = sc.nextInt();
            if (slot < 0 || slot > itemSlots.length)
                System.out.println("Error: Invalid Slot Selection");
        } while(slot < 0 || slot > itemSlots.length);

        if (slot == 0)
            System.out.println("No Slot Selected, Going Back...");

        return slot;
    }

    /**
     * This method displays all the transactions of the user.
     */
    public void displayTransactions() {
        int total = 0;

        System.out.println("=========================");
        for (ItemTransaction transactions : transactionLog) {
            if (transactions.getSlot().getItemStock() != null) {    //assuring the transaction of the specific
                System.out.println(transactions.toString());
                total += transactions.getTotal();   //adds the total earnings
            }
        }


        if (total == 0)
            System.out.println(NAME + ": No Transactions Were Made");
        System.out.println("Total Earnings: " + total + " PHP");


        System.out.println("=========================");

    }

    /**
     * This method displays the inventories of a user.
     */
    public ArrayList<String> displayInventories() {
        ArrayList<String> strInventories = new
        if (startingInventory != null) {
            VendingMachineInventory endingInventory = new VendingMachineInventory(this);    //creating the ending inventory using the current inventory

            displayInventory(startingInventory, "Starting Inventory");
            displayInventory(endingInventory, "Ending Inventory");

            endingInventory = null;
        }
        else
            System.out.println(NAME + " Vending Machine is Still New");

        return
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
        itemSlots[slotSelection - 1].removeStock();
        transactionLog[slotSelection - 1].addTransaction();
    }

    public Item performTransaction(Money payment, Money sourceWallet, Money wallet, int slotSelection) {
        int change;
        int cost = itemSlots[slotSelection - 1].getPrice();
        Item theItem = null;

        if (payment.getMoney() != cost)
            System.out.println("Calculating Change...");

        change = payment.getMoney() - cost;
        //Display Details of the Transaction
        System.out.println("=========================");
        System.out.println("Amount Paid: " + payment.getMoney());
        System.out.println("Total Cost:  " + cost);
        System.out.println("Amount Paid - Total Cost");
        System.out.println("(Change):    " + change);
        System.out.println("=========================");

        money.addMoney(payment);    //adding the payment to the vending machine money

        if (money.removeMoney(change)) {    //checking if the removing of change in the vending machine is successful
            sourceWallet.replace(wallet); //replace the actual wallet of the user with the resulting wallet considering the successful payment
            System.out.println("Transaction Successful");
            theItem = itemSlots[slotSelection - 1].getItemStock().getItem();
        }
        else {
            money.removeMoney(payment); //remove the payment from the vending machine money if the vending machine money don't have the appropriate denominations for the change (if there is)
            System.out.println("The Machine Does Not Have Enough Change\nCancelling Transaction...");
        }

        return theItem;
    }



    /**
     * This method displays the inventory of a vending machine.
     * @param inventory the inventory to be displayed.
     * @param info the info to be displayed.
     */
    private void displayInventory(VendingMachineInventory inventory, String info) {
        System.out.println("=========================");
        System.out.println("---" + info + "---");
        System.out.println("Slot Number || Item");
        System.out.println("=========================");
        for (int i = 0; i < inventory.getItemSlots().length; i++){  //displays the vending machine inventory of when the VendingMachineInventory is constructed
            if (inventory.getItemSlots()[i] != null){   //the item slots must be initialized for it to be considered as a valid inventory space
                System.out.print(inventory.getItemSlots()[i].getSlotNumber() + " || ");
                if (inventory.getItemSlots()[i].getItemStock() != null)
                    System.out.println(inventory.getItemSlots()[i].getItemStock().getName() + " - " + inventory.getItemSlots()[i].getStock());
                else
                    System.out.println("X");
            }
        }
        System.out.println("=========================");
        inventory.getMoney().showMoney(info);
    }

    private final String NAME;

    private ItemSlot[] itemSlots;
    private Money money;
    private ItemTransaction[] transactionLog;
    private VendingMachineInventory startingInventory;

}
