import java.util.Scanner;
public class VendingMachine {

    public VendingMachine(String name, int maxSlots, int slotMaxItems, int passcode) {
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

    public Money getMoney() {
        return money;
    }

    public ItemSlot[] getItemSlots() {
        return itemSlots;
    }

    public void mainMenu(Money wallet) {

        if (startingInventory != null) {
            boolean bCon = false;
            boolean bTransaction = false;
            Scanner sc = new Scanner(System.in);
            int slotSelection;

            displayItemMenu();
            do {
                System.out.println("(0) Exit");
                System.out.println("Pick an Item: ");
                slotSelection = sc.nextInt();

                bCon = chooseItem(slotSelection);
                if (bCon && slotSelection != 0) {   //if the user selects a valid item
                    bTransaction = receivePayment(itemSlots[slotSelection - 1].getPrice(), wallet); //receives the payment from the user

                    if (bTransaction) {  //updates the transaction log of that item if the transaction was successful
                        transactionLog[slotSelection - 1].addTransaction();

                    }

                    mainMenu(wallet);
                }
            } while (!bCon);   //exit detection also exists within the chooseItem() method

            if (bTransaction)
                System.out.println("Thank You for Your Purchase!");
            else
                System.out.println("Thank You Come Again!");


            sc = null;
        }
        else
            System.out.println("Error: This New Vending Machine Has Not Yet Been Setup");
    }

    private void displayItemMenu(){
        System.out.println("=========================");
        System.out.println("Slot Number || Item");
        System.out.println("=========================");
        for (int i = 0; i < itemSlots.length; i++){
            if (itemSlots[i] != null){
                System.out.println(itemSlots[i].getSlotNumber() + " || " + itemSlots[i].getItem().getName());
            }
        }
        System.out.println("=========================");
    }

    private boolean chooseItem(int slot){
        boolean b = false;
        ItemSlot selectedSlot = null;
        ItemStock selectedItemStock = null;

        if (slot == 0)  //slot selection at 0 for exit per user input
            return true;

        for (ItemSlot itemSlot: itemSlots){ //looks for the corresponding slot number in the itemSlots array
            if (slot == itemSlot.getSlotNumber() && itemSlot.isAvailable()) {   //only accept item slots that are valid and have available stock/s
                b = true;
                selectedSlot = itemSlot;
                selectedItemStock = selectedSlot.getItem();
            }
        }

        if (!b) //identifying whether the item selection is valid
            System.out.println("Error: Invalid Item Selection");
        else {  //details of the selected item
            System.out.println("=========================");
            System.out.println("(" + slot + ")Selected Item: " + selectedItemStock.getName());
            System.out.println("Price:           " + itemSlots[slot - 1].getPrice() + "PHP");
            System.out.println("Calorie/s:       " + selectedItemStock.getCalories());
            System.out.println("=========================");
        }


        return b;
    }

    private boolean receivePayment(int cost, Money wallet) {
        int change;
        int temp = -1;
        Money payment = new Money();
        Money tempWallet = new Money(wallet);
        Scanner sc = new Scanner(System.in);
        boolean b = false;

        System.out.println("Amount to Pay: " + cost + " PHP");
        System.out.println("=========================");
        System.out.println("(0) Cancel Payment");
        System.out.println("Insert Bills/Coins: ");
        System.out.println("(1) 1 Peso");
        System.out.println("(2) 5 Pesos");
        System.out.println("(3) 10 Pesos");
        System.out.println("(4) 20 Pesos");
        System.out.println("(5) 50 Pesos");
        System.out.println("(6) 100 Pesos");
        System.out.println("(7) 200 Pesos");
        System.out.println("(8) 500 Pesos");
        System.out.println("(9) 1000 Pesos");
        System.out.println("=========================");

        while (payment.getMoney() < cost && temp != 0) {
            System.out.println("Insert: ");
            temp = sc.nextInt();
            switch (temp) {
                case 1:
                    payment.addOnePeso(1);
                    break;
                case 2:
                    payment.addFivePeso(1);
                    break;
                case 3:
                    payment.addTenPeso(1);
                    break;
                case 4:
                    payment.addTwentyPeso(1);
                    break;
                case 5:
                    payment.addFiftyPeso(1);
                    break;
                case 6:
                    payment.addOneHundredPeso(1);
                    break;
                case 7:
                    payment.addTwoHundredPeso(1);
                    break;
                case 8:
                    payment.addFiveHundredPeso(1);
                    break;
                case 9:
                    payment.addOneThousandPeso(1);
                case 0:
                    break;
                default:
                    System.out.println("Error: Invalid Option");
            }

            if (temp <= 9 && temp >= 1) {
                if (tempWallet.removeMoney(payment)) {
                    System.out.println("Paid: " + payment.getMoney());
                    if (payment.getMoney() < cost)
                        tempWallet.replace(wallet);
                }
                else
                    System.out.println("Error: Invalid Money Availability");
            }
        }

        do {
            System.out.println("Confirm Transaction: (1) Yes   (0) No");
            temp = sc.nextInt();
            if (temp != 1 && temp != 0)
                System.out.println("Error: Invalid Option");
        } while (temp != 1 && temp != 0);

        if (temp == 0) {
            System.out.println("Cancelling Transaction...");
        }
        else if (payment.getMoney() >= cost) {
            if (payment.getMoney() != cost)
                System.out.println("Calculating Change");

            change = payment.getMoney() - cost;
            //Display Details of the Transaction
            System.out.println("=========================");
            System.out.println("Amount Paid: " + payment.getMoney());
            System.out.println("Total Cost:  " + cost);
            System.out.println("Amount Paid - Total Cost");
            System.out.println("(Change):    " + change);
            System.out.println("=========================");

            money.addMoney(payment);

            if (money.removeMoney(change)) {
                wallet.replace(tempWallet);
                System.out.println("Transaction Successful");
                b = true;
            }
            else {
                money.removeMoney(payment);
                System.out.println("The Machine Does Not Have Enough Change\nCancelling Transaction...");
            }
        }

        payment = null;
        tempWallet = null;
        sc = null;

        if (!b)
            System.out.println("Transaction Failed");
        return b;   //true transaction is successful, false otherwise (cancelling of payment or no change)
    }
/*
    private void maintenance(Money wallet) {
//reminder to make ItemSlot reflect directly onto transactionLog
        boolean bMaintenance = true;
        Scanner sc = new Scanner(System.in);
        int nOption;

        displayMaintenanceMenu();   //displays the maintenance menu
        do {
            nOption = sc.nextInt();

            switch (nOption) {
                case 0:
                    bMaintenance = false;
                    break;
                case 1:
                    displayItemMenu();
                    break;
                case 2:
                    break;
                case 3:

            }

            maintenance(wallet);    //recurrence after the user finish performing their action
        } while (bMaintenance);

    }

    private void displayMaintenanceMenu() {
//this includes Exit (0), ....
        System.out.println("============Maintenance=============");
        System.out.println("(0) Exit");
        System.out.println("(1) Display Slot Information");
        System.out.println("(2) Stock/Restock");
        System.out.println("(3) Modify");

    }

    */

    public boolean isValidItem(ItemStock itemStock) {
        boolean b = true;

        if (itemStock.getSRP() <= 0 || itemStock == null) //item is invalid if SRP <= 0 or is null
            b = false;

        if (!b)
            System.out.println("Error: Invalid Item");

        return b;
    }

    public boolean isValidSlot(int slot) {
        if (slot > 0 && slot <= itemSlots.length)
            return true;
        else {
            System.out.println("Error: Invalid Item Slot");
            return false;
        }
    }

    //newStock method: make sure to check if the slot is currently empty
    public boolean newStock(int slot, int quantity, ItemStock itemStock) {
        return newStock(slot, quantity, itemStock, itemStock.getSRP());
    }

    public boolean newStock(int slot, ItemStock itemStock) {
        return newStock(slot, 0, itemStock, itemStock.getSRP());
    }

    public boolean newStock(int slot, ItemStock itemStock, int price) {
        return newStock(slot, 0, itemStock, price);
    }

    public boolean newStock(int slot, int quantity, ItemStock itemStock, int price) {
        boolean b = false, found = false;



        if (isValidSlot(slot) && isValidItem(itemStock)) {
            for (int i = 0; i < itemSlots.length; i++) {
                if (itemStock == itemSlots[i].getItem())
                    found = true;
            }
            if (!found) {
                if (itemSlots[slot - 1].isEmpty()) {    //check if the itemSlot is empty
                    b = true;
                    System.out.println("Setting Up New Stock On Slot " + slot);

                    if (price > 0)
                        b = changePrice(slot, price);   //sets the price of the new item

                    if (quantity != 0 && b)  //quantity 0 bypasses new boolean value
                        b = itemSlots[slot - 1].addStock(quantity);

                    if (b) {
                        itemSlots[slot - 1].setItem(itemStock);  //sets the slot to this new item
                        System.out.println("Slot " + slot + " Now Has " + itemSlots[slot - 1].getItem().getName() + " at " + itemSlots[slot - 1].getPrice() + " PHP");
                    }
                } else
                    System.out.println("Error: Slot " + slot + " is Not Empty");
            }
            else
                System.out.println("Error: The Same Item Already Exists in Vending Machine " + NAME);
        }


        return b;
    }

    public boolean restock(int slot, int quantity) {
        boolean b = false;

        if (isValidSlot(slot))
            if (itemSlots[slot - 1].getItem() != null)
                b = itemSlots[slot - 1].addStock(quantity);
            else
                System.out.println("Slot " + slot + " is Not Assigned to Any Items");

        return b;
    }


    public boolean changePrice(int slot, int price) {
        boolean b = true;

        if (price > 0) {    //positive integer
            System.out.print("Slot " + slot);
            if (itemSlots[slot - 1].getPrice() != 0)    //if the item slot had contained any pre-existing assigned item
                System.out.print(" Price Has Been Changed From " + itemSlots[slot - 1].getPrice() + " PHP to ");
            else
                System.out.print(" Has Been Set to ");
            itemSlots[slot - 1].setPrice(price);
            System.out.println(itemSlots[slot - 1].getPrice() + " PHP (" + itemSlots[slot - 1].getItem().getName() + ")");
        }
        else {
            b = false;
            System.out.println("Error: Invalid Price");
        }

        return b;
    }

    public boolean setSRP(int slot) {
        boolean b = false;

        if (isValidSlot(slot))
            if (itemSlots[slot - 1].getItem() != null)
                b = changePrice(slot, itemSlots[slot - 1].getItem().getSRP());
            else
                System.out.println("Slot " + slot + " is Not Assigned to Any Items");

        return b;
    }

    public void setAllSRP() {
        for (int slot = 1; slot <= itemSlots.length; slot++) {
            if (itemSlots[slot - 1].getItem() != null)
                changePrice(slot, itemSlots[slot - 1].getItem().getSRP());
        }
    }

    public void collectMoney(Money wallet) {
        Scanner sc = new Scanner(System.in);
        int temp;

        Money tempMoney = new Money(money);
        wallet.addMoney(money);
        System.out.println("Money Collected");
        money.showMoney();

        System.out.println("Money in Vending Machine " + NAME + " Has Been Emptied.");

        do {
            System.out.println("Proceed to Replenish Change?: (1) Yes   (0) No");
            temp = sc.nextInt();
            if (temp != 1 && temp != 0)
                System.out.println("Error: Invalid Option");
        } while (temp != 1 && temp != 0);

        if (temp == 1)
            replenishMoney(wallet);

        sc = null;
    }

    public void replenishMoney(Money wallet) {
        int temp = -1;
        int quantity = 0;
        Money change = new Money();
        Money tempWallet = new Money(wallet);
        Scanner sc = new Scanner(System.in);

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
            System.out.println("=========================");

            do {
                System.out.println("Bills/Coins: ");
                temp = sc.nextInt();
                if (temp < 0 || temp > 9)
                    System.out.println("Error: Invalid Option");
            } while (temp < 0 || temp > 9);

            if (temp != 0)
                do {
                    System.out.println("Quantity: ");
                    quantity = sc.nextInt();
                    if (quantity <= 0)
                        System.out.println("Error: Invalid Quantity");
                } while (quantity <= 0);

            switch (temp) {
                case 1:
                    change.addOnePeso(quantity);
                    break;
                case 2:
                    change.addFivePeso(quantity);
                    break;
                case 3:
                    change.addTenPeso(quantity);
                    break;
                case 4:
                    change.addTwentyPeso(quantity);
                    break;
                case 5:
                    change.addFiftyPeso(quantity);
                    break;
                case 6:
                    change.addOneHundredPeso(quantity);
                    break;
                case 7:
                    change.addTwoHundredPeso(quantity);
                    break;
                case 8:
                    change.addFiveHundredPeso(quantity);
                    break;
                case 9:
                    change.addOneThousandPeso(quantity);
                case 0:
            }

            if (temp <= 9 && temp >= 1) {
                if (tempWallet.removeMoney(change)) {
                    change.showMoney(NAME + "Change");
                    tempWallet.replace(wallet);
                }
                else
                    System.out.println("Error: Invalid Money Availability");
            }
            else {
                change.showMoney(NAME + "Change");
            }
        }

        do {
            System.out.println("Confirm Replenishing Change: (1) Yes   (0) No");
            temp = sc.nextInt();
            if (temp != 1 && temp != 0)
                System.out.println("Error: Invalid Option");
        } while (temp != 1 && temp != 0);

        if (temp == 1) {
            wallet.replace(tempWallet);
            money.addMoney(change);
        }

        tempWallet = null;
        change = null;
        sc = null;
    }

    public void displayTransactions() {
        for (ItemTransaction transactions : transactionLog) {
            System.out.println(transactions.toString());
        }
    }

    public void displayInventories() {
        VendingMachineInventory endingInventory = new VendingMachineInventory(this);

        displayInventory(startingInventory, "Starting Inventory");
        displayInventory(endingInventory, "Ending Inventory");

        endingInventory = null;
    }

    private void displayInventory(VendingMachineInventory inventory, String info) {
        System.out.println("=========================");
        System.out.println("Slot Number || Item");
        System.out.println("=========================");
        for (int i = 0; i < inventory.getItemSlots().length; i++){
            if (inventory.getItemSlots()[i] != null){
                System.out.println(inventory.getItemSlots()[i].getSlotNumber() + " || " + inventory.getItemSlots()[i].getItem().getName());
            }
        }
        System.out.println("=========================");
        inventory.getMoney().showMoney(info);
    }

    public void clearLog() {
        for (int i = 0; i < transactionLog.length; i++) {
            transactionLog[i].clearTransaction();
        }
    }

    public void newStartingInventory() {
        startingInventory = null;
        startingInventory = new VendingMachineInventory(this);
    }

    private final String NAME;

    private ItemSlot[] itemSlots;
    private Money money;
    private ItemTransaction[] transactionLog;
    private VendingMachineInventory startingInventory;

}
