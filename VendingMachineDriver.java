import java.util.*;


/**
 * This is the driver class or "factory" of the vending machines.
 * It is where the program is run from. It contains maintenance features,
 * buying features, and wallet features.
 */
public class VendingMachineDriver {
    /**
     * This method is a constructor which creates an instance from
     * @param name the name of the vending machine driver.
     */
    public VendingMachineDriver(String name) {
        itemStockList = new ArrayList<ItemStock>();

        vendingMachineList = new ArrayList<VendingMachine>();

        moneyList = new ArrayList<Money>();
        Money unliMoney = new Money();  //a default Money object for each VendingMachine for the user

        unliMoney.setOnePeso(99999);
        unliMoney.setFivePeso(99999);
        unliMoney.setTenPeso(99999);
        unliMoney.setTwentyPeso(99999);
        unliMoney.setFiftyPeso(99999);
        unliMoney.setOneHundredPeso(99999);
        unliMoney.setTwoHundredPeso(99999);
        unliMoney.setFiveHundredPeso(99999);
        unliMoney.setOneThousandPeso(99999);


        moneyList.add(unliMoney);
    }

    /**
     * This method displays the mainMenu.
     * @param wallet the wallet of the current User.
     * @return theItem that the user bought.
     */
    public Item mainMenu(VendingMachine vm, Money wallet) {
        Item theItem = null;

        if (vm.getStartingInventory() != null) {    //if the vendingMachine has never been done maintenance on
            boolean bCon = false;
            Scanner sc = new Scanner(System.in);
            int slotSelection;
            ItemSlot[] itemSlots = vm.getItemSlots();

            displayItemMenu(vm);
            do {
                System.out.println("(0) Exit");
                System.out.println("Pick an Item: ");
                slotSelection = sc.nextInt();

                if (slotSelection != 0) {
                    bCon = chooseItem(vm, slotSelection);
                    if (bCon) {   //if valid user input (bCon)

                        theItem = vmTransaction(vm, slotSelection, wallet); //vending machine transaction process

                        if (theItem != null) {  //updates the transaction log of that item if the transaction was successful
                            vm.successfulTransaction(slotSelection);
                        }
                    }
                }
                else
                    bCon = true;
            } while (!bCon);   //exit detection also exists within the chooseItem() method

            if (theItem != null) {
                System.out.println("Dispensing Item...");
                System.out.println("Thank You for Your Purchase!");
            }
            else
                System.out.println("Thank You Come Again!");


            sc = null;
        }
        else
            System.out.println("Error: This New Vending Machine Has Not Yet Been Setup");

        return theItem;
    }

    /**
     * This private method deals with the transaction when buying an item.
     * @param slotSelection the slot selected by the user
     * @param wallet money of the user.
     * @return an Item if transaction successful and null if not.
     */
    private Item vmTransaction(VendingMachine vm, int slotSelection, Money wallet) {
        Item theItem = null;

        int temp = -1;
        Money payment = new Money();
        Money tempWallet = new Money(wallet);
        Scanner sc = new Scanner(System.in);
        boolean b = false;
        int cost = vm.getItemSlots()[slotSelection - 1].getPrice();

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

        do {
            System.out.println("Insert: "); //this retrieves the denominations from the user
            temp = sc.nextInt();
            switch (temp) { //adding the denominations to the total payment in Money Object
                case 1:
                    payment.changeOnePeso(1);
                    break;
                case 2:
                    payment.changeFivePeso(1);
                    break;
                case 3:
                    payment.changeTenPeso(1);
                    break;
                case 4:
                    payment.changeTwentyPeso(1);
                    break;
                case 5:
                    payment.changeFiftyPeso(1);
                    break;
                case 6:
                    payment.changeOneHundredPeso(1);
                    break;
                case 7:
                    payment.changeTwoHundredPeso(1);
                    break;
                case 8:
                    payment.changeFiveHundredPeso(1);
                    break;
                case 9:
                    payment.changeOneThousandPeso(1);
                case 0:
                    break;
                default:
                    System.out.println("Error: Invalid Option");
            }

            if (temp <= 9 && temp >= 1) {   //checking of the valid denominations
                if (tempWallet.removeMoney(payment)) {  //if the wallet of the user contains enough of the payment with respect to their deonominations
                    System.out.println("Paid: " + payment.getMoney());
                    if (payment.getMoney() < cost)
                        tempWallet.replace(wallet);
                }
                else
                    System.out.println("Error: Invalid Money Availability");
            }
        } while (payment.getMoney() < cost && temp != 0);

        if (temp != 0)  //checking if user wants to exit or not
            do {
                System.out.println("Confirm Transaction: (1) Yes   (0) No");
                temp = sc.nextInt();
                if (temp != 1 && temp != 0)
                    System.out.println("Error: Invalid Option");
            } while (temp != 1 && temp != 0);

        if (temp == 0) {
            System.out.println("Cancelling Transaction...");
        }
        else if (payment.getMoney() >= cost) {  // if the total payment is more than the cost
            System.out.println("Calculating Change...");
            int change = vm.calcChange(payment, cost);
            //Display Details of the Transaction
            System.out.println("=========================");
            System.out.println("Amount Paid: " + payment.getMoney());
            System.out.println("Total Cost:  " + cost);
            System.out.println("Amount Paid - Total Cost");
            System.out.println("(Change):    " + change);
            System.out.println("=========================");

            theItem = vm.performTransaction(payment, wallet, tempWallet, slotSelection, change);

            if (theItem == null)
                System.out.println("The Machine Does Not Have Enough Change\nCancelling Transaction...");
        }

        if (theItem == null) //if transaction failed
            System.out.println("Transaction Failed");
        else
            System.out.println("Transaction Successful");

        return theItem;
    }


    /**
     * This is a private method that chooses item based on:
     * @param slot the slot to be chosen.
     * @return true if successful and false if not.
     */
    private boolean chooseItem(VendingMachine vm, int slot){
        boolean b = false;
        ItemSlot[] itemSlots = vm.getItemSlots();
        ItemSlot selectedSlot = null;
        ItemStock selectedItemStock = null;

        if (slot == 0)  //slot selection at 0 for exit per user input
            return true;

        for (ItemSlot itemSlot: itemSlots){ //looks for the corresponding slot number in the itemSlots array
            if (slot == itemSlot.getSlotNumber() && itemSlot.isAvailable()) {   //only accept item slots that are valid and have available stock/s
                b = true;
                selectedSlot = itemSlot;
                selectedItemStock = selectedSlot.getItemStock();
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

    /**
     * This method displays the item menu.
     * It shows each slot number with its corresponding item.
     */
    public void displayItemMenu(VendingMachine vm){
        ItemSlot[] itemSlots = vm.getItemSlots();

        System.out.println("=========================");
        System.out.println("Slot Number || Item");
        System.out.println("=========================");

        for (int i = 0; i < itemSlots.length; i++){ //loop for displaying all the items and their details and if it is available or not
            if (itemSlots[i] != null){
                System.out.print(itemSlots[i].getSlotNumber() + " || ");
                if (itemSlots[i].getItemStock() != null) {
                    System.out.print(itemSlots[i].getItemStock().getName() + " " + itemSlots[i].getPrice() + " PHP");
                }
                else
                    System.out.print("X");
                System.out.print(" - ");
                if (!itemSlots[i].isAvailable())
                    System.out.print("Not ");
                System.out.println("Available");
            }
        }
        System.out.println("=========================");
    }

    /**
     * This method is the main where the program runs from.
     * @param args The string arguments the user inputs.
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        VendingMachineDriver factory = new VendingMachineDriver("REGULAR VENDING MACHINE");

        //default ItemStocks for the factory
        {
            factory.itemStockList.add(new ItemStock("Fried Egg", 30, 150, 10));
            factory.itemStockList.add(new ItemStock("Chippy", 75, 170, 2));
            factory.itemStockList.add(new ItemStock("Tapas", 100, 200, 20));
            factory.itemStockList.add(new ItemStock("Hotdog", 75, 290, 5));
            factory.itemStockList.add(new ItemStock("Piattos", 75, 150));
            factory.itemStockList.add(new ItemStock("V-Cut", 75, 180));
            factory.itemStockList.add(new ItemStock("Corn", 20, 88));
            factory.itemStockList.add(new ItemStock("Fried Chicken", 100, 246));
            factory.itemStockList.add(new ItemStock("Bangus", 100, 200));
            factory.itemStockList.add(new ItemStock("Pork Chop", 100, 231));
            factory.itemStockList.add(new ItemStock("Tosino", 100, 230));
            factory.itemStockList.add(new ItemStock("Rice", 20, 206));
            factory.itemStockList.add(new ItemStock("Coca Cola", 50, 139));
            factory.itemStockList.add(new ItemStock("Royal", 50, 139));
            factory.itemStockList.add(new ItemStock("Bottled Water", 25, 0));
        }

        //default VendingMachines for the factory
        factory.vendingMachineList.add(new VendingMachine("PH", 12, 15));
        factory.vendingMachineList.add(new VendingMachine("FOODIES", 8, 10));

        //default Moneys for the factory
        Money myMoney = new Money();
        Money maintenanceMoney = new Money(); {
            maintenanceMoney.setOnePeso(9999999);
            maintenanceMoney.setFivePeso(9999999);
            maintenanceMoney.setTwentyPeso(9999999);
        }

        factory.moneyList.add(myMoney);
        factory.moneyList.add(maintenanceMoney);

        programMenu(factory);

    }

    /**
     * This method displays an item stock from a list of item stocks.
     * @param itemStocks the list of item stocks.
     */
    private void displayItemStock(ArrayList<ItemStock> itemStocks) {
        Iterator<ItemStock> it = itemStocks.iterator();

        System.out.println("=========================");
        System.out.println("Item Stocks: " + itemStocks.size());
        System.out.println("=========================");

        for (int i = 1; it.hasNext(); i++) {    //utilizing iterators in a forloop to display all the ItemStocks given the parameter
            ItemStock itemStock;
            itemStock = it.next();

            System.out.println("(" + i + ") " + itemStock.getName() + "; Stock: " + itemStock.getStock() + "; SRP: " + itemStock.getSRP() + "; Calories: " + itemStock.getCalories());
        }
        System.out.println("=========================");
    }

    /**
     * This method lets the user select an Item Stock from a list of item stocks.
     * @param itemStocks the list of item stocks.
     * @return the ItemStock selected.
     */
    private ItemStock selectItemStock(ArrayList<ItemStock> itemStocks) {
        Scanner sc = new Scanner(System.in);
        ItemStock item = null;
        int option;


        System.out.println("=========================");
        System.out.println("Item Stock/s");
        System.out.println("=========================");
        System.out.println("(0) Back");

        displayItemStock(itemStocks);

        do {
            System.out.print("Option: ");
            option = sc.nextInt();
            if (option > itemStocks.size() || option < 0)
                System.out.println("Error: Invalid Option");
        } while (option > itemStocks.size() || option < 0);

        if (option != 0) {
            item = itemStocks.get(option - 1);  //gets the item of what the user chooses
            System.out.println("Selected Item: " + item.getName());
        }
        else
            System.out.println("Going Back...");

        return item;
    }

    /**
     * This private method is used to run the main menu of the vending machine class
     * @param vendingMachine the vending machine instance to be used.
     * @param wallet the wallet instance to be used.
     * @return the bought item.
     */
    private Item execBuyer(VendingMachine vendingMachine, Money wallet) {
        return mainMenu(vendingMachine, wallet); //runs the mainMenu method in VendingMachine class for the user to buy items in the vendingMachine
    }

    /**
     * This private method adds a new stock to a vending machine.
     *
     * @param itemStock the item stock to be added.
     * @param vendingMachine the vending machine to be used.
     * @return true if successful and false if not.
     */
    private boolean addNewStock(ItemStock itemStock, VendingMachine vendingMachine) {
        boolean b = false;
        Scanner sc = new Scanner(System.in);
        int quantity, temp, slot, price = 0;

        do {    //a feature of letting users choose if they would like to set the price to its SRP by default
            System.out.println("Set to SRP: (1) Yes   (0) No");
            temp = sc.nextInt();
            if (temp != 1 && temp != 0)
                System.out.println("Error: Invalid Option");
        } while (temp != 1 && temp != 0);

        if (temp == 0) {    //if user did not choose to set to SRP and let them input a specific price
            System.out.print("Set Price (PHP): ");
            price = sc.nextInt();
        }

        displayItemMenu(vendingMachine);
        slot = selectVMSlot(vendingMachine);

        if (slot != 0) {    //if the user does not prompt to exit during the slot selection
            //shows the max stocks and current stocks in the itemslots to assist the user
            System.out.println("Max Stocks: " + vendingMachine.getItemSlots()[slot - 1].getMax());
            System.out.println("Current Stocks: " + vendingMachine.getItemSlots()[slot - 1].getStock());
            System.out.print("Quantity: "); //receives quantity of stocks to add from the user
            quantity = sc.nextInt();

            if (temp == 1)  //if temp == 1 then set to SRP
                b = newVMStock(vendingMachine, slot, quantity, itemStock);
            else
                b = newVMStock(vendingMachine, slot, quantity, itemStock, price);
        }

        return b;
    }


    /**
     * This method makes sure to check if the slot in the vending machine is currently empty.
     *
     * @param vendingMachine the vending in question
     * @param slot the slot to be checked.
     * @param quantity the quantity of the slot to be checked.
     * @param itemStock the itemStock of the slot to be checked.
     * @return true if successful and false if not.
     */
    public boolean newVMStock(VendingMachine vendingMachine, int slot, int quantity, ItemStock itemStock) {
        return newVMStock(vendingMachine, slot, quantity, itemStock, itemStock.getSRP());
    }

    /**
     * This method makes sure to check if the slot is currently empty.
     *
     * @param slot the slot to be checked.
     * @param quantity the quantity of the slot to be checked.
     * @param itemStock the itemStock of the slot to be checked.
     * @param price the price to be checked.
     * @return true if successful and false if not
     */
    public boolean newVMStock(VendingMachine vendingMachine, int slot, int quantity, ItemStock itemStock, int price) {
        boolean b = false, found = false;
        ItemStock tempItem;
        int oldPrice;
        ItemSlot[] itemSlots = vendingMachine.getItemSlots();


        tempItem = itemSlots[slot - 1].getItemStock();  //keeps track of old item
        oldPrice = itemSlots[slot - 1].getPrice();  //keeps track of old price of the slot
        if (vendingMachine.isValidSlot(slot) && vendingMachine.isValidItem(itemStock)) {
            for (int i = 0; i < itemSlots.length; i++) {
                if (itemStock == itemSlots[i].getItemStock())
                    found = true;
            }
            if (!found) {
                if (itemSlots[slot - 1].isEmpty()) {    //check if the itemSlot is empty
                    b = true;
                    System.out.println("Setting Up New Stock On Slot " + slot);

                    vendingMachine.setSlotItem(slot, itemStock); //sets the slot to this new item for addStock to function

                    b = changePrice(vendingMachine, slot, price);   //sets the price of the new item

                    if (quantity != 0 && b)  //quantity 0 bypasses new boolean value
                    {
                        b = itemSlots[slot - 1].addStock(quantity);
                        if (b)
                            System.out.println("Slot " + slot + ": " + itemSlots[slot - 1].getItemStock().getName() + " - Adding Stock Successful");
                        else
                            System.out.println("Error: Invalid Amount/Stock");
                    }

                    if (!b) {
                        System.out.println("Resetting Price...");
                        vendingMachine.setSlotPrice(slot, oldPrice);
                        vendingMachine.setSlotItem(slot, tempItem); //sets the slot to the old item
                    }

                    if (b) {
                        System.out.println("Slot " + slot + " Now Has " + itemSlots[slot - 1].getItemStock().getName() + " at " + itemSlots[slot - 1].getPrice() + " PHP");
                        //resets when stocking
                        vendingMachine.resetLogs();
                    }
                } else
                    System.out.println("Error: Slot " + slot + " is Not Empty");
            }
            else
                System.out.println("Error: The Same Item Already Exists in Vending Machine " + vendingMachine.getName());
        }
        else if (!vendingMachine.isValidItem(itemStock))
            System.out.println("Error: Invalid Item");
        else if (!vendingMachine.isValidSlot(slot))
            System.out.println("Error: Invalid Item Slot");

        if (!b)
            System.out.println("Failed to Setup New Item");


        return b;
    }


    /**
     * This method restocks an item slot in a given vending machine.
     * @param vendingMachine the vending machine in question
     * @param slot the item slot to be restocked.
     * @param quantity how many stocks would be put.
     * @return true if successful and false if not.
     */
    public boolean restock(VendingMachine vendingMachine, int slot, int quantity) {
        boolean b = false;
        ItemSlot[] itemSlots = vendingMachine.getItemSlots();

        if (vendingMachine.isValidSlot(slot))
            if (itemSlots[slot - 1].getItemStock() != null) {   //making sure the object is not null
                b = itemSlots[slot - 1].addStock(quantity); //retrieving the boolean if the adding of stock is successful

                if (b) {
                    System.out.println("Slot " + slot + ": " + itemSlots[slot - 1].getItemStock().getName() + " - Adding Stock Successful");
                    //resets when stocking
                    vendingMachine.resetLogs();
                }
                else
                    System.out.println("Error: Invalid Amount/Stock");
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
    public boolean changePrice(VendingMachine vendingMachine, int slot, int price) {
        boolean b = false;
        ItemSlot[] itemSlots = vendingMachine.getItemSlots();

        if (itemSlots[slot - 1].getItemStock() != null){
            if (price > 0) {    //positive integer
                System.out.print("Slot " + slot);
                if (itemSlots[slot - 1].getPrice() != 0)    //if the item slot had contained any pre-existing assigned item
                    System.out.print(" Price Has Been Changed From " + itemSlots[slot - 1].getPrice() + " PHP to ");
                else
                    System.out.print(" Has Been Set to ");

                vendingMachine.setSlotPrice(slot, price);
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
     * This private method facilitates the stocking procedures in the vending machine.
     * @param vendingMachine the vending machine to be stocked.
     */
    private void execStocking(VendingMachine vendingMachine) {
        Scanner sc = new Scanner(System.in);
        int option, slot;
        ItemStock itemStock;
        boolean exit = false;

        do {
            System.out.println("=========================");
            System.out.println("       Stocking");
            System.out.println("=========================");
            System.out.println("(0) Back");
            System.out.println("(1) Restock");
            System.out.println("(2) Add New Stock");
            System.out.println("=========================");

            do {
                System.out.println("Stocking Option: ");
                option = sc.nextInt();
                if (option > 2 || option < 0)
                    System.out.println("Error: Invalid Option");
            } while (option > 2 || option < 0);

            if (option == 0)
                exit = true;

            switch (option) {
                case 2 -> {
                    itemStock = selectItemStock(itemStockList);
                    if (itemStock != null)  //if the user did select an itemstock
                        addNewStock(itemStock, vendingMachine);
                }
                case 1 -> {
                    displayItemMenu(vendingMachine);
                    slot = selectVMSlot(vendingMachine);
                    if (slot != 0) {    //if the user selects a slot
                        //displays max and current stocks to assist how much stock the users should add
                        System.out.println("Max Stocks: " + vendingMachine.getItemSlots()[slot - 1].getMax());
                        System.out.println("Current Stocks: " + vendingMachine.getItemSlots()[slot - 1].getStock());
                        System.out.print("Quantity: "); //quantity of how much stock would the user wants to add
                        option = sc.nextInt();
                        if (restock(vendingMachine, slot, option))
                            System.out.println("Restocking Successful");
                        else
                            System.out.println("Restocking Failed");
                    }
                }
            }

        } while (!exit);

        System.out.println("Going Back...");
    }

    /**
     * This method changes the suggested retail price of an item.
     * @param vendingMachine the vending machine to be changed.
     */
    private void execChangePrice(VendingMachine vendingMachine) {
        Scanner sc = new Scanner(System.in);
        int option;
        int slot = 0;
        boolean exit = false;


        displayInventories(vendingMachine);
        do {
            System.out.println("=========================");
            System.out.println("     Price Change");
            System.out.println("=========================");
            System.out.println("(0) Back");
            System.out.println("(1) Edit Price");
            System.out.println("(2) Set to SRP");
            System.out.println("(3) Set All to SRP");
            System.out.println("(4) Display Slots");
            System.out.println("=========================");

            do {
                System.out.println("Price Change Option: ");
                option = sc.nextInt();
                if (option > 4 || option < 0)
                    System.out.println("Error: Invalid Option");
            } while (option > 4 || option < 0);

            if (option == 0)
                exit = true;

            if (option < 3 && option > 0)   //options 1 and 2 prompts the user to select a slot
                slot = selectVMSlot(vendingMachine);

            if (slot != 0 || (option == 4 || option == 3))  //if user did not choose to go back during the slot selection process, or when the user option is 3 or 4
                switch (option) {
                    case 1 -> {
                        System.out.print("Set Price (PHP): ");
                        changePrice(vendingMachine, slot, sc.nextInt());
                    }
                    case 2 -> {
                        if (!vendingMachine.setSRP(slot))
                            System.out.println("Slot " + slot + " is Not Assigned to Any Items");
                    }
                    case 3 -> {
                        vendingMachine.setAllSRP();
                        System.out.println("All Existing Items Have Been Set to Its SRP");
                    }
                    case 4 -> displayItemMenu(vendingMachine);
                }

        } while (!exit);

        System.out.println("Going Back...");
    }

    public int selectVMSlot(VendingMachine vendingMachine) {
        Scanner sc = new Scanner(System.in);
        int slot;

        do {
            System.out.println("(0) Back");
            System.out.print("Select Item Slot: ");
            slot = sc.nextInt();
            if (!vendingMachine.selectSlot(slot) && slot != 0)
                System.out.println("Error: Invalid Slot Selection");
        } while(!vendingMachine.selectSlot(slot) && slot != 0);

        if (slot == 0)
            System.out.println("No Slot Selected, Going Back...");

        return slot;
    }


    /**
     * This private method facilitates the maintenance of the vending machines.
     * @param vendingMachine the vending machine to be maintained.
     * @param wallet the wallet to be maintained.
     */
    private void execMaintenance(VendingMachine vendingMachine, Money wallet) {
        Scanner sc = new Scanner(System.in);
        int option;


        displayInventories(vendingMachine);
        displayTransactions(vendingMachine);

        //a normal functioning menu for maintenance

        do {
            System.out.println("=========================");
            System.out.println("       Maintenance");
            System.out.println("=========================");
            System.out.println("(0) Back");
            System.out.println("(1) Stocking");
            System.out.println("(2) Change Price");
            System.out.println("(3) Collect Money");
            System.out.println("(4) Replenish Change");
            System.out.println("(5) Show Item Slots");
            System.out.println("(6) Show All ItemStocks");
            System.out.println("(7) Display Inventories");
            System.out.println("(8) Display Transactions");
            System.out.println("(9) Show Money");
            System.out.println("=========================");

            do {
                System.out.println("Maintenance Option: ");
                option = sc.nextInt();
                if (option > 9 || option < 0)
                    System.out.println("Error: Invalid Option");
            } while (option > 9 || option < 0);

            switch (option) {
                case 1:
                    execStocking(vendingMachine);
                    break;
                case 2:
                    execChangePrice(vendingMachine);
                    break;
                case 3:
                    collectVMMoney(vendingMachine, wallet);
                    break;
                case 4:
                    replenishVMMoney(vendingMachine, wallet);
                    break;
                case 5:
                    displayItemMenu(vendingMachine);
                    break;
                case 6:
                    displayItemStock(itemStockList);
                    break;
                case 7:
                    displayInventories(vendingMachine);
                    break;
                case 8:
                    displayTransactions(vendingMachine);
                    break;
                case 9:
                    showMoney(vendingMachine.getMoney());
            }

        } while (option != 0);

        System.out.println("Going Back...");
    }

    public void collectVMMoney(VendingMachine vm, Money wallet) {
        wallet.addMoney(vm.collectMoney()); //add all money in the vending machine to the user wallet
        System.out.println("Money Collected");
        showMoney(vm.getMoney());

        System.out.println("Money in Vending Machine " + vm.getName() + " Has Been Emptied.\nReminder: Replenish Change");
    }

    public void replenishVMMoney(VendingMachine vm, Money wallet) {
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
                    showMoney(change, vm.getName() + "Change");
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

        showMoney(change, vm.getName() + " Change");

        do {
            System.out.println("Confirm Replenishing Change: (1) Yes   (0) No");
            temp = sc.nextInt();
            if (temp != 1 && temp != 0)
                System.out.println("Error: Invalid Option");
        } while (temp != 1 && temp != 0);


        if (temp == 1) {    //if user confirms to replenish the change
            tempWallet.removeMoney(change);
            wallet.replace(tempWallet);
            vm.replenishMoney(change);
        }

        tempWallet = null;
        change = null;
        sc = null;
    }

    public void displayInventories(VendingMachine vm) {
        for (String str : vm.stringInventories()) {
            System.out.println(str);
        }
    }

    public void displayTransactions(VendingMachine vm) {
        for (String str : vm.stringTransactions()) {
            System.out.println(str);
        }
    }

    /**
     * This private method displays the vending machines.
     * @param vendingMachines the list of vending machines.
     */
    private void displayVendingMachine(ArrayList<VendingMachine> vendingMachines) {
        Iterator<VendingMachine> it = vendingMachines.iterator();

        System.out.println("=========================");
        System.out.println("Vending Machine/s");
        System.out.println("=========================");
        System.out.println("(0) Back");

        //displays the vending machines using an iterator and forloop
        for (int i = 1; it.hasNext(); i++) {
            VendingMachine machine;
            machine = it.next();

            System.out.println("(" + i + ") " + machine.getName());
        }
        System.out.println("=========================");
    }

    /**
     * This private method lets the user select a vending machine.
     * @param vendingMachines the list of vending machines to be selected from.
     * @return the vending machine selected.
     */
    private VendingMachine selectVendingMachine(ArrayList<VendingMachine> vendingMachines) {
        Scanner sc = new Scanner(System.in);
        VendingMachine vm = null;
        int option;

        displayVendingMachine(vendingMachines);

        do {    //let user selects one of the vending machines
            option = sc.nextInt();
            if (option > vendingMachines.size() || option < 0)
                System.out.println("Error: Invalid Option");
        } while (option > vendingMachines.size() || option < 0);

        if (option != 0)
            vm = vendingMachines.get(option - 1);
        else
            System.out.println("Going Back...");

        return vm;
    }

    /**
     * This private method displays the list of money instances.
     * @param moneyList the list of money instances.
     */
    private void displayMoneyList(ArrayList<Money> moneyList) {
        Iterator<Money> it = moneyList.iterator();

        System.out.println("=========================");

        //display all the money option exists within the factory interface
        for (int i = 1; it.hasNext(); i++) {
            Money money;
            money = it.next();

            System.out.println("-----[ " + i + " ]-----");
            showMoney(money);
        }
        System.out.println("=========================");
    }

    /**
     * This private method lets the user select a money instance from a list
     * of money instances.
     * @param wallets the list of money instances.
     * @param currentWallet the current money instance.
     * @return
     */
    private Money selectWallet(ArrayList<Money> wallets, Money currentWallet) {
        Scanner sc = new Scanner(System.in);

        int option;
        Money selectedWallet = currentWallet;

        displayMoneyList(wallets);

        System.out.println("(0) Back");

        do {    //lets users select a specific Money object for themselves to use
            System.out.print("Select Wallet: ");
            option = sc.nextInt();
            if (option > wallets.size() || option < 0)
                System.out.println("Error: Invalid Option");
        } while (option > wallets.size() || option < 0);
        if (option != 0)
            selectedWallet = wallets.get(option - 1);

        System.out.println("Going Back...");

        return selectedWallet;
    }

    /**
     * This private method lets the user interact with the vending machine.
     * @param wallet the Money instance to be used.
     * @return an array list of items.
     */
    private ArrayList<Item> startInteraction(Money wallet) {
        boolean exit = false;
        ArrayList<Item> allItems = new ArrayList<Item>();
        int option;
        Scanner sc = new Scanner(System.in);
        VendingMachine vm;

        //main interaction loop
        do {
            System.out.println("=========================");
            System.out.println("Select Interaction");
            System.out.println("=========================");
            System.out.println("(0) Exit");
            System.out.println("(1) Buy From Vending Machine");
            System.out.println("(2) Do Maintenance");
            System.out.println("(3) Select Wallet");
            System.out.println("(4) Show Current Wallet");
            System.out.println("=========================");

            do {
                option = sc.nextInt();
                if (option > 4 || option < 0)
                    System.out.println("Error: Invalid Option");
            } while (option > 4 || option < 0);

            switch (option) {
                case 0:
                    exit = true;
                    break;
                case 3:
                    wallet = selectWallet(moneyList, wallet);   //sets the current wallet to the wallet the method returns
                    break;
                case 4:
                    showMoney(wallet, "Current Wallet"); //shows the current wallet information
                    break;
                case 1:
                case 2:
                    vm = selectVendingMachine(vendingMachineList);  //let user select vending machine
                    if (vm == null) //if the user decides to exit within the vending machine selection
                        option = 0;
                    switch (option) {
                        case 1:
                            do {
                                Item anItem = execBuyer(vm, wallet);    //executes the buyer method and it either returns an item that the user purchased or null if no transactions were done
                                if (anItem != null)
                                    allItems.add(anItem);
                                anItem = null; //make anItem null

                                do {    //prompts the user whether they would like to continue buying within this vending machine
                                    System.out.println("Continue Buying: (1) Yes   (0) No");
                                    option = sc.nextInt();
                                    if (option != 1 && option != 0)
                                        System.out.println("Error: Invalid Option");
                                } while (option != 1 && option != 0);

                            } while (option != 0);
                            break;
                        case 2:
                            execMaintenance(vm, wallet);
                            break;

                    }
            }
        } while (!exit);

        System.out.println("Exiting...");

        return allItems;
}

    /**
     *  This private method displays the item inventory.
     * @param items the list of items to be displayed.
     */
    private void displayItemInventory(ArrayList<Item> items) {
        ArrayList<Item> itemSets = new ArrayList<Item>();
        ArrayList<Integer> itemQuantity = new ArrayList<Integer>();

        //display the inventory of what the user have bought

        for (Item item : items) {   //utilizing two arrayList by counting the number of repeated instances
            if (!itemSets.contains(item)) {
                itemSets.add(item);
                itemQuantity.add(1);
            }
            else {
                itemQuantity.set(itemSets.indexOf(item), itemQuantity.get(itemSets.indexOf(item)) + 1) ;
            }
        }

        Iterator<Item> item = itemSets.iterator();
        Iterator<Integer> quantity = itemQuantity.iterator();

        System.out.println("Total Items Bought: " + myInventory.size());


        if (!(itemSets.size() == 0 || itemQuantity.size() == 0)) {  //checking if the user have bought anything
            while (item.hasNext() && quantity.hasNext()) {  //displaying the item and quantity using an iterator
                Item it = item.next();
                Integer in = quantity.next();
                if (it != null && in != null)
                    System.out.println(it.getName() + ": " + in);
            }
        }
        else
            System.out.println("No Items Has Been Bought");
    }

    /**
         * This private method displays the vending machine's item menu,
     * inventories, and transactions.
     * @param vendingMachine the vending machine to be displayed.
     */
    private void showVendingMachine(VendingMachine vendingMachine) {
        displayItemMenu(vendingMachine);
        displayInventories(vendingMachine);
        displayTransactions(vendingMachine);
    }

    /**
     * This private method lets the user create a new vending machine.
     * @return an array list of vending machines.
     */
    private ArrayList<VendingMachine> createVendingMachine() {
        ArrayList<VendingMachine> vm = new ArrayList<VendingMachine>();
        Scanner sc = new Scanner(System.in);
        int option;
        String name;
        int slotSize = -1;
        int numSlots = -1;
        boolean create = false;

        do {
            System.out.println("=========================");
            System.out.println("(0) Cancel");
            System.out.print("Vending Machine Name: ");
            name = sc.next();
            if (!name.equalsIgnoreCase("0")) {  //checking if the provided string is 0
                do {    //prompts users for the number of item slots they would like the vending machine to have (should be more than or equal to 8)
                    System.out.println("=========================");
                    System.out.println("(0) Cancel");
                    System.out.print("Number of Item Slots: ");
                    numSlots = sc.nextInt();
                    if (numSlots < 8 && numSlots != 0)
                        System.out.println("Error: Invalid Number of Slots");
                } while (numSlots < 8 && numSlots != 0);

                if (numSlots != 0) {    //if the user did not decide to cancel the creation of vending machine

                    do {    //prompts users for the max number of items an item slot can contain (should be more than or equal to 10)
                        System.out.println("=========================");
                        System.out.println("(0) Cancel");
                        System.out.print("Max Items Per Slot: ");
                        slotSize = sc.nextInt();
                        if (slotSize < 10 && slotSize != 0)
                            System.out.println("Error: Invalid Max Items");
                    } while (slotSize < 10 && slotSize != 0);

                    if (slotSize != 0)
                        create = true;
                }
            }

            if (create) {   //if the user provides the necessary valid information for creating a vending machine
                vm.add(new VendingMachine(name, numSlots, slotSize));
                System.out.println("New Vending Machine Created");
            }
            else
                System.out.println("Vending Machine Creation Cancelled");

            create = false; //reset this boolean

            do {
                System.out.println("=========================");
                System.out.println("(0) Finish");
                System.out.println("(1) Create Another");
                System.out.println("(2) Show Created Vending Machine/s");
                System.out.println("=========================");

                do {
                    System.out.print("Option: ");
                    option = sc.nextInt();
                    if (option > 2 || option < 0)
                        System.out.println("Error: Invalid Option");
                } while (option > 2 || option < 0);

                if (option == 2)
                    if (vm.size() != 0) //no vending machine is created if the size of the arraylist is zero
                        displayVendingMachine(vm);
                    else
                        System.out.println("No New Vending Machines Have Been Created");

            } while (option != 0 && option != 1);
        } while(option != 0);

        System.out.println("Going Back...");

        return vm;
    }

    /**
     * This private method lets the user customize vending machines.
     */
    private void customizeVendingMachine() {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("=========================");
            System.out.println("Customize Vending Machine");
            System.out.println("=========================");
            System.out.println("(0) Back");
            System.out.println("(1) Create Vending Machine");
            System.out.println("(2) Show Details");
            System.out.println("(3) Show Vending Machines");
            System.out.println("=========================");

            do {
                System.out.print("Option: ");
                option = sc.nextInt();
                if (option > 3 || option < 0)
                    System.out.println("Error: Invalid Option");
            } while (option > 3 || option < 0);

            switch(option) {
                case 1 -> vendingMachineList.addAll(createVendingMachine());    //arraylist of vending machine of the factory adds the arraylist returned by the method of creating a vending machine
                case 2 -> {
                    VendingMachine vm = selectVendingMachine(vendingMachineList);
                    if (vm != null) //if the user did choose a vending machine
                        showVendingMachine(vm);
                }
                case 3 -> displayVendingMachine(vendingMachineList);    //displays all the vending machine within the factory
            }


        } while (option != 0);

        System.out.println("Going Back...");
    }

    /**
     * This private method lets the user create a new money instance.
     * @return an array list of money instances.
     */
    private ArrayList<Money> createMoney() {
        ArrayList<Money> money = new ArrayList<Money>();
        Scanner sc = new Scanner(System.in);
        int option, quantity = 0;
        boolean create = false;
        Money newMoney = new Money();

        do {

            System.out.println("=========================");
            System.out.println("Adding Denominations");
            System.out.println("=========================");
            System.out.println("(0) Finish");
            System.out.println("(1) 1 Peso");
            System.out.println("(2) 5 Pesos");
            System.out.println("(3) 10 Pesos");
            System.out.println("(4) 20 Pesos");
            System.out.println("(5) 50 Pesos");
            System.out.println("(6) 100 Pesos");
            System.out.println("(7) 200 Pesos");
            System.out.println("(8) 500 Pesos");
            System.out.println("(9) 1000 Pesos");

            do {

                do {
                    System.out.println("=========================");
                    System.out.print("Choose Bills/Coins: ");   //lets user choose the type of denomination they would like to customize
                    option = sc.nextInt();
                    if (option < 0 || option > 9)
                        System.out.println("Error: Invalid Option");
                } while (option < 0 || option > 9);

                if (option != 0)
                    do {
                        System.out.print("Quantity: "); //lets the users choose the quantity of denominations they would like to add to the newly created money class
                        quantity = sc.nextInt();
                        if (quantity < 0)
                            System.out.println("Error: Invalid Quantity");
                    } while (quantity < 0);

                if (quantity == 0)  //quantity == 0 meaning user intends to finish the creation
                    option = 0;


                switch (option) {   //adds denominations to the newly created money
                    case 1 -> newMoney.changeOnePeso(quantity);
                    case 2 -> newMoney.changeFivePeso(quantity);
                    case 3 -> newMoney.changeTenPeso(quantity);
                    case 4 -> newMoney.changeTwentyPeso(quantity);
                    case 5 -> newMoney.changeFiftyPeso(quantity);
                    case 6 -> newMoney.changeOneHundredPeso(quantity);
                    case 7 -> newMoney.changeTwoHundredPeso(quantity);
                    case 8 -> newMoney.changeFiveHundredPeso(quantity);
                    case 9 -> newMoney.changeOneThousandPeso(quantity);
                }

                    System.out.println("Total: " + newMoney.getMoney() + " PHP");
            } while(option != 0);



            do {    //prompts user whether they would like to confirm the creation
                System.out.println("Confirm Creation: (1) Yes   (0) No");
                option = sc.nextInt();
                if (option != 1 && option != 0)
                    System.out.println("Error: Invalid Option");
            } while (option != 1 && option != 0);

            if (option == 1)
                create = true;


            if (create) {   //the create boolean is true, new money will be created
                money.add(newMoney);
                System.out.println("New Money Created");
            }
            else
                System.out.println("Money Creation Cancelled");

            create = false; //reset this boolean

            do {
                System.out.println("=========================");
                System.out.println("(0) Finish");
                System.out.println("(1) Create Another");   //option 1 utilizes the outside loop itself
                System.out.println("(2) Show Created Money");
                System.out.println("=========================");

                do {
                    System.out.print("Option: ");
                    option = sc.nextInt();
                    if (option > 2 || option < 0)
                        System.out.println("Error: Invalid Option");
                } while (option > 2 || option < 0);

                if (option == 2)
                    if (money.size() != 0)  //if there are money object newly created
                        displayMoneyList(money);
                    else
                        System.out.println("No New Vending Machines Have Been Created");
                else if (option == 1) {
                    newMoney = new Money();
                }

            } while (option != 0 && option != 1);
        } while(option != 0);

        System.out.println("Going Back...");

        return money;
    }

    /**
     * This private method lets the user customize money.
     */
    private void customizeMoney() {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("=========================");
            System.out.println("    Customize Money");
            System.out.println("=========================");
            System.out.println("(0) Back");
            System.out.println("(1) Create New Money");
            System.out.println("(2) Show All Money");
            System.out.println("=========================");

            do {
                System.out.print("Option: ");
                option = sc.nextInt();
                if (option > 2 || option < 0)
                    System.out.println("Error: Invalid Option");
            } while (option > 2 || option < 0);

            switch(option) {
                case 1 -> moneyList.addAll(createMoney());  //moneyList arraylist of the factory adds the money created from createMoney method
                case 2 -> displayMoneyList(moneyList);  //displays all the money exists within the factory
            }


        } while (option != 0);

        System.out.println("Going Back...");
    }

    /**
     * This private method lets the user create a new item stock.
     * @return
     */
    private ArrayList<ItemStock> createItemStock() {
        ArrayList<ItemStock> itemStocks = new ArrayList<ItemStock>();
        Scanner sc = new Scanner(System.in);
        int option;
        String name;
        int srp = -1;
        int calories = -1;
        boolean create = false;
        int stock = -1;

        do {
            System.out.println("=========================");
            System.out.println("(0) Cancel");
            System.out.print("Item Name: ");
            name = sc.next();
            if (!name.equalsIgnoreCase("0")) {  //check if the user inputted string is 0, prompting a cancellation of creation of the Item Stock
                do {    //prompts user the input valid calories
                    System.out.print("Calories: ");
                    calories = sc.nextInt();
                    if (calories < 0)
                        System.out.println("Error: Invalid Calories");
                } while (calories < 0);


                do {    //prompts user the input valid stocks
                    System.out.print("Stocks: ");
                    stock = sc.nextInt();
                    if (stock < 0)
                        System.out.println("Error: Invalid Stock/s");
                } while (stock < 0);


                System.out.println("=========================");
                System.out.println("(0) Cancel");
                do {    //prompts the user to input the srp for the item
                    System.out.print("SRP (PHP): ");
                    srp = sc.nextInt();
                    if (srp < 0)
                        System.out.println("Error: Invalid SRP");
                } while (srp < 0);

                if (srp != 0)   //if srp is not zero, then user had provided valid information for the creation of the item stock
                    create = true;
            }

            if (create) {   //if creation boolean is true
                itemStocks.add(new ItemStock(name, srp, calories, stock));  //itemStocks Arraylist adds the new itemStocks
                System.out.println("New Item Stock Created");
            }
            else
                System.out.println("Item Stock Creation Cancelled");

            create = false; //this boolean resets to false

            do {
                System.out.println("=========================");
                System.out.println("(0) Finish");
                System.out.println("(1) Create Another");   //option 1 utilizes the outside loop itself
                System.out.println("(2) Show Created Item Stock/s");
                System.out.println("=========================");

                do {
                    System.out.print("Option: ");
                    option = sc.nextInt();
                    if (option > 2 || option < 0)
                        System.out.println("Error: Invalid Option");
                } while (option > 2 || option < 0);

                if (option == 2)
                    if (itemStocks.size() != 0) //if there are item stock object newly created
                        displayItemStock(itemStocks);
                    else
                        System.out.println("No New Item Stocks Have Been Created");

            } while (option != 0 && option != 1);
        } while(option != 0);

        System.out.println("Going Back...");

        return itemStocks;
    }

    /**
     * This private method lets the user add an item stock.
     * @param itemStock the item stock to be added.
     */
    private void addItemStock(ItemStock itemStock) {
        Scanner sc = new Scanner(System.in);
        int stock;
        boolean b = true;

        System.out.println("=========================");
        System.out.println("Adding Stock to " + itemStock.getName());
        System.out.println("Current Stock: "+ itemStock.getStock());
        System.out.println("=========================");
        System.out.println("(0) Back");

        do {    //prompts the user to input the amount of stock that they would like to an item stock
            System.out.println("=========================");
            System.out.print("Add Stock: ");
            stock = sc.nextInt();
            if (stock > 0) {
                b = itemStock.addStock(stock);

                if (b) {
                    System.out.println(stock + " Stocks Have Been added to " + itemStock.getName());
                    System.out.println("Current Stock: " + itemStock.getStock());
                }
            }
            else if (stock < 0)
                System.out.println("Amount Should Be Positive");

        } while (stock != 0);
    }

    /**
     * This private method lets the user customize the item stock.
     */
    private void customizeItemStock() {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("=========================");
            System.out.println("Customize Item Stock");
            System.out.println("=========================");
            System.out.println("(0) Back");
            System.out.println("(1) Create Item Stock");
            System.out.println("(2) Add Stocks");
            System.out.println("(3) Show Item Stocks");
            System.out.println("=========================");

            do {
                System.out.print("Option: ");
                option = sc.nextInt();
                if (option > 3 || option < 0)
                    System.out.println("Error: Invalid Option");
            } while (option > 3 || option < 0);

            switch(option) {
                case 1 -> itemStockList.addAll(createItemStock());  //itemStockList arraylist of the factory adds the ItemStocks created from createItemStock method
                case 2 -> {
                    ItemStock item = selectItemStock(itemStockList);
                    if (item != null) { //if the user has selected an ItemStock
                        addItemStock(item);
                    }
                }
                case 3 -> displayItemStock(itemStockList);  //displays all the itemStocks within the factory
            }

        } while (option != 0);

        System.out.println("Going Back...");
    }


    /**
     * This private method displays the main menu of the vending machine driver.
     * @param factory the factory instance to be performed on.
     */
    private static void programMenu(VendingMachineDriver factory) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("=========================");
            System.out.println("        Main Menu");
            System.out.println("=========================");
            System.out.println("(0) Exit");
            System.out.println("(1) Start Main Program");
            System.out.println("(2) Customize Vending Machines");
            System.out.println("(3) Customize Money");
            System.out.println("(4) Customize Item Stocks");
            System.out.println("(5) Show Inventory");
            System.out.println("=========================");

            do {
                System.out.print("Option: ");
                option = sc.nextInt();
                if (option > 5 || option < 0)
                    System.out.println("Error: Invalid Option");
            } while (option > 5 || option < 0);

            switch(option) {
                case 2 -> factory.customizeVendingMachine();
                case 3 -> factory.customizeMoney();
                case 4 -> factory.customizeItemStock();
                case 5 -> factory.displayItemInventory(factory.myInventory);
                case 1 -> {
                    do {
                        factory.myInventory.addAll(factory.startInteraction(factory.moneyList.get(0))); //myInventory arraylist adds Item arraylist returned from the startInteraction method given an instance by providing the parameter of the default Money object (unliMoney)
                        System.out.println("-----Resulting myInventory------");
                        factory.displayItemInventory(factory.myInventory);

                        do {    //prompts the user whether they would like to exit
                            System.out.println("Exit: (1) Yes   (0) No");
                            option = sc.nextInt();
                            if (option != 1 && option != 0)
                                System.out.println("Error: Invalid Option");
                        } while (option != 1 && option != 0);

                    } while (option != 1);
                }
            }


        } while (option != 0);
    }

    public void showMoney(Money money, String info) {
        ArrayList<String> str = money.moneyString(info);
        for (String string : str) {
            System.out.println(string);
        }
    }

    public void showMoney(Money money) {
        ArrayList<String> str = money.moneyString();
        for (String string : str) {
            System.out.println(string);
        }
    }


    private ArrayList<ItemStock> itemStockList;

    private ArrayList<VendingMachine> vendingMachineList;

    private ArrayList<Money> moneyList;

    private ArrayList<Item> myInventory = new ArrayList<Item>();

}
