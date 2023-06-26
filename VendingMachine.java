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
        money = new Money();
        maintenanceCode = passcode;
    }

    public void mainMenu(Money wallet) {
        boolean bCon = false;
        boolean bTransaction = false;
        Scanner sc = new Scanner(System.in);
        int slotSelection;
        Item itemSelection;

        displayItemMenu();
        do {
            System.out.println("(0) Exit");
            System.out.println("Pick an Item: ");
            slotSelection = sc.nextInt();

            if (slotSelection != maintenanceCode) { //if the user is a maintenance person that would or would not like to conduct maintenance
                bCon = chooseItem(slotSelection);
                if (bCon && slotSelection != 0) {   //if the user selects a valid item
                    itemSelection = itemSlots[slotSelection - 1].getItem();
                    bTransaction = receivePayment(itemSelection.getCost(), wallet); //receives the payment from the user

                    if (bTransaction)   //updates the transaction log of that item if the transaction was successful
                        transactionLog[slotSelection - 1].addTransaction();

                    mainMenu(wallet);
                }
            }
            else {
                maintenance(wallet);
                mainMenu(wallet);
            }
        } while (!bCon);   //exit detection also exists within the chooseItem() method

        if (bTransaction)
            System.out.println("Thank You for Your Purchase!");
        else
            System.out.println("Thank You Come Again!");
    }

    private void displayItemMenu(){
        System.out.println("=========================");
        System.out.println("Slot Number|| Item");
        System.out.println("==========Food===========");
        for (int i = 0; i < itemSlots.length; i++){
            if (itemSlots[i] != null){
                System.out.println(itemSlots[i].getSlotNumber() + " || " + itemSlots[i].getItem().getName());
            }
        }
    }

    private boolean chooseItem(int slot){
        boolean b = false;
        ItemSlot selectedSlot = null;
        Item selectedItem = null;
        int temp;
        Scanner sc = new Scanner(System.in);

        if (slot == 0)  //slot selection at 0 for exit per user input
            return true;

        for (ItemSlot itemSlot: itemSlots){ //looks for the corresponding slot number in the itemSlots array
            if (slot == itemSlot.getSlotNumber() && itemSlot.isAvailable()) {   //only accept item slots that are valid and have available stock/s
                b = true;
                selectedSlot = itemSlot;
                selectedItem = selectedSlot.getItem();
            }
        }

        if (!b) //identifying whether the item selection is valid
            System.out.println("Error: Invalid Item Selection");
        else {  //details of the selected item
            System.out.println("=========================");
            System.out.println("(" + slot + ")Selected Item: " + selectedItem.getName());
            System.out.println("Price:           " + selectedItem.getCost() + "PHP");
            System.out.println("Calorie/s:       " + selectedItem.getCalories());
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
                        tempWallet = wallet;
                }
            }
        }

        do {
            System.out.println("Confirm Transaction: (1) Yes   (0) No");
            temp = sc.nextInt();
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
                wallet = tempWallet;
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

    public boolean isValidItem(Item item) {
        boolean b = true;

        if (item.getSRP() <= 0 || item == null) //item is invalid if SRP <= 0 or is null
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
    public boolean newStock(int slot, int quantity, Item item) {
        return newStock(slot, quantity, item, item.getSRP());
    }

    public boolean newStock(int slot, Item item) {
        return newStock(slot, 0, item, item.getSRP());
    }

    public boolean newStock(int slot, Item item, int price) {
        return newStock(slot, 0, item, price);
    }

    public boolean newStock(int slot, int quantity, Item item, int price) {
        boolean b = false;

        if (isValidSlot(slot))
            if (isValidItem(item)) {
                if (itemSlots[slot - 1].isEmpty()) {    //check if the itemSlot is empty
                    b = true;
                    System.out.println("Setting Up New Stock On Slot " + slot);

                    b = changePrice(slot, price);   //sets the price of the new item

                    if (quantity != 0)  //quantity 0 bypasses new boolean value
                        b = itemSlots[slot - 1].addStock(quantity);

                    if (b) {
                        itemSlots[slot - 1].setItem(item);  //sets the slot to this new item
                        System.out.println("Slot " + slot + " Now Has " + itemSlots[slot - 1].getItem().getName() + " at " + itemSlots[slot - 1].getPrice() + " PHP");
                    }
                }
                System.out.println("Error: Slot " + slot + " is Not Empty");
            }

        return b;
    }

    public boolean restock(int slot, int quantity) {

    }


    public boolean changePrice(int slot, int price) {
        boolean b = true;

        if (price > 0)
            itemSlots[slot - 1].setPrice(price);
        else {
            b = false;
            System.out.println("Error: Invalid Price");
        }

        return b;
    }

    private boolean addStock(int slot, int quantity) {
        boolean b = false;

        if (itemSlots[])

    }


    private final String NAME;

    private ItemSlot[] itemSlots;
    private Money money;
    private ItemTransaction[] transactionLog;
    private VendingMachine startingInventory;
    private int maintenanceCode;

}
