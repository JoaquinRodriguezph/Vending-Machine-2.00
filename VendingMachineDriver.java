import java.util.*;

import static java.lang.String.valueOf;

public class VendingMachineDriver {
    private static ArrayList<ItemStock> itemStockList = new ArrayList<ItemStock>();

    private static ArrayList<VendingMachine> vendingMachineList = new ArrayList<VendingMachine>();

    private static ArrayList<Money> moneyList = new ArrayList<Money>();

    //VendingMachineDriver(){this.ItemList = new ArrayList<>();}

    private static void displayItemStock(ArrayList<ItemStock> itemStocks) {
        Iterator<ItemStock> it = itemStocks.iterator();

        System.out.println("=========================");

        for (int i = 1; it.hasNext(); i++) {
            ItemStock itemStock;
            itemStock = it.next();

            System.out.println("(" + i + ") " + itemStock.getName() + "; Stock: " + itemStock.getStock() + "; SRP: " + itemStock.getSRP() + "; Calories: " + itemStock.getCalories());
        }
        System.out.println("=========================");
    }

    private static ItemStock selectItemStock(ArrayList<ItemStock> itemStocks) {
        Scanner sc = new Scanner(System.in);
        ItemStock item = null;
        int option;


        System.out.println("=========================");
        System.out.println("Item Stock/s");
        System.out.println("=========================");
        System.out.println("(0) Back");

        displayItemStock(itemStocks);

        do {
            option = sc.nextInt();
            if (option > itemStocks.size() || option < 0)
                System.out.println("Error: Invalid Option");
        } while (option > itemStocks.size() || option < 0);

        if (option != 0) {
            item = itemStocks.get(option - 1);
            System.out.println("Selected Item: " + item.getName());
        }
        else
            System.out.println("Going Back...");

        return item;
    }

    private static Item execBuyer(VendingMachine vendingMachine, Money wallet) {
        return vendingMachine.mainMenu(wallet);
    }

    private static boolean addNewStock(ItemStock itemStock, VendingMachine vendingMachine) {
        boolean b = false;
        Scanner sc = new Scanner(System.in);
        int quantity, temp, slot, price = 0;

        do {
            System.out.println("Set to SRP: (1) Yes   (0) No");
            temp = sc.nextInt();
            if (temp != 1 && temp != 0)
                System.out.println("Error: Invalid Option");
        } while (temp != 1 && temp != 0);

        if (temp == 0) {
            System.out.print("Set Price (PHP): ");
            price = sc.nextInt();
        }

        vendingMachine.displayItemMenu();
        slot = vendingMachine.selectSlot();

        if (slot != 0) {
            System.out.print("Quantity: ");
            quantity = sc.nextInt();

            if (temp == 1)
                b = vendingMachine.newStock(slot, quantity, itemStock);
            else
                b = vendingMachine.newStock(slot, quantity, itemStock, price);
        }

        return b;
    }

    private static void execStocking(VendingMachine vendingMachine) {
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
                    if (itemStock != null)
                        addNewStock(itemStock, vendingMachine);
                }
                case 1 -> {
                    vendingMachine.displayItemMenu();
                    slot = vendingMachine.selectSlot();
                    if (slot != 0) {
                        if (vendingMachine.isValidSlot(slot)) {
                            System.out.print("Quantity: ");
                            option = sc.nextInt();
                        }
                        vendingMachine.restock(slot, option);
                    }
                }
            }

        } while (!exit);

        System.out.println("Going Back...");
    }

    private static void execChangePrice(VendingMachine vendingMachine) {
        Scanner sc = new Scanner(System.in);
        int option;
        int slot = 0;
        boolean exit = false;


        vendingMachine.displayInventories();
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

            if (option < 3 && option > 0)
                slot = vendingMachine.selectSlot();

            if (slot != 0 || (option == 4 || option == 3))
                switch (option) {
                    case 1 -> {
                        System.out.print("Set Price (PHP): ");
                        vendingMachine.changePrice(slot, sc.nextInt());
                    }
                    case 2 -> vendingMachine.setSRP(slot);
                    case 3 -> vendingMachine.setAllSRP();
                    case 4 -> vendingMachine.displayItemMenu();
                }

        } while (!exit);

        System.out.println("Going Back...");
    }

    private static void execMoney(VendingMachine vendingMachine, boolean collect, Money wallet) {
        if (collect)
            vendingMachine.collectMoney(wallet);
        else
            vendingMachine.replenishMoney(wallet);

        System.out.println("Going Back...");
    }

    private static void execMaintenance(VendingMachine vendingMachine, Money wallet) {
        Scanner sc = new Scanner(System.in);
        int option;


        vendingMachine.displayInventories();
        vendingMachine.displayTransactions();
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
                    execMoney(vendingMachine, true, wallet);
                    break;
                case 4:
                    execMoney(vendingMachine, false, wallet);
                    break;
                case 5:
                    vendingMachine.displayItemMenu();
                    break;
                case 6:
                    displayItemStock(itemStockList);
                    break;
                case 7:
                    vendingMachine.displayInventories();
                    break;
                case 8:
                    vendingMachine.displayTransactions();
                    break;
                case 9:
                    vendingMachine.showMoney();
            }

        } while (option != 0);

        System.out.println("Going Back...");
    }

    private static VendingMachine selectVendingMachine(ArrayList<VendingMachine> vendingMachines) {
        Scanner sc = new Scanner(System.in);
        VendingMachine vm = null;
        int option;

        Iterator<VendingMachine> it = vendingMachines.iterator();


        System.out.println("=========================");
        System.out.println("Vending Machine/s");
        System.out.println("=========================");
        System.out.println("(0) Back");

        for (int i = 1; it.hasNext(); i++) {
            VendingMachine machine;
            machine = it.next();

            System.out.println("(" + i + ") " + machine.getName());
        }
        System.out.println("=========================");

        do {
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

    private static Money selectWallet(ArrayList<Money> wallets, Money currentWallet) {
        Scanner sc = new Scanner(System.in);
        Iterator<Money> it = wallets.iterator();
        int option;
        Money selectedWallet = currentWallet;

        System.out.println("=========================");

        for (int i = 1; it.hasNext(); i++) {
            Money wallet;
            wallet = it.next();

            System.out.println("-----[ " + i + " ]-----");
            wallet.showMoney();
        }
        System.out.println("=========================");
        System.out.println("(0) Back");

        do {
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

    private static ArrayList<Item> startInteraction(Money wallet) {
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
                    wallet = selectWallet(moneyList, wallet);
                    break;
                case 4:
                    wallet.showMoney("Current Wallet");
                    break;
                case 1:
                case 2:
                    vm = selectVendingMachine(vendingMachineList);  //let user select vending machine
                    if (vm == null)
                        option = 0;
                    switch (option) {
                        case 1:
                            do {
                                Item anItem = execBuyer(vm, wallet);
                                if (anItem != null)
                                    allItems.add(anItem);
                                anItem = null; //make anItem null

                                do {
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


    private static void displayItemInventory(ArrayList<Item> items) {
        ArrayList<Item> itemSets = new ArrayList<Item>();
        ArrayList<Integer> itemQuantity = new ArrayList<Integer>();

        for (Item item : items) {
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

        while (item.hasNext() && quantity.hasNext()) {
            Item it = item.next();
            Integer in = quantity.next();
            if (it != null && in != null)
                System.out.println(it.getName() + ": " + in);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        //    VendingMachineDriver vm = new VendingMachineDriver();

        {
            itemStockList.add(new ItemStock("Fried Egg", 30, 150, 10));
            itemStockList.add(new ItemStock("Chippy", 75, 170, 2));
            itemStockList.add(new ItemStock("Tapas", 100, 200, 20));
            itemStockList.add(new ItemStock("Hotdog", 75, 290, 5));
            itemStockList.add(new ItemStock("Piattos", 75, 150));
            itemStockList.add(new ItemStock("V-Cut", 75, 180));
            itemStockList.add(new ItemStock("Corn", 20, 88));
            itemStockList.add(new ItemStock("Fried Chicken", 100, 246));
            itemStockList.add(new ItemStock("Bangus", 100, 200));
            itemStockList.add(new ItemStock("Pork Chop", 100, 231));
            itemStockList.add(new ItemStock("Tosino", 100, 230));
            itemStockList.add(new ItemStock("Rice", 20, 206));
            itemStockList.add(new ItemStock("Coca Cola", 50, 139));
            itemStockList.add(new ItemStock("Royal", 50, 139));
            itemStockList.add(new ItemStock("Bottled Water", 25, 0));
        }

        vendingMachineList.add(new VendingMachine("PH", 12, 15));
        vendingMachineList.add(new VendingMachine("FOODIES", 8, 10));

        Money unliMoney = new Money(); {
            unliMoney.setOnePeso(99999);
            unliMoney.setFivePeso(99999);
            unliMoney.setTenPeso(99999);
            unliMoney.setTwentyPeso(99999);
            unliMoney.setFiftyPeso(99999);
            unliMoney.setOneHundredPeso(99999);
            unliMoney.setTwoHundredPeso(99999);
            unliMoney.setFiveHundredPeso(99999);
            unliMoney.setOneThousandPeso(99999);
        }


        ArrayList<Item> myInventory = new ArrayList<Item>();
        Money myMoney = new Money();
        Money maintenanceMoney = new Money(); {
            maintenanceMoney.setOnePeso(9999999);
            maintenanceMoney.setFivePeso(9999999);
            maintenanceMoney.setTwentyPeso(9999999);
        }

        {
            moneyList.add(unliMoney);
            moneyList.add(myMoney);
            moneyList.add(maintenanceMoney);
        }

        int option;


        do {
            myInventory.addAll(startInteraction(myMoney));
            System.out.println("Resulting myInventory");
            displayItemInventory(myInventory);

            do {
                System.out.println("Exit: (1) Yes   (0) No");
                option = sc.nextInt();
                if (option != 1 && option != 0)
                    System.out.println("Error: Invalid Option");
            } while (option != 1 && option != 0);
        } while (option != 1);

/*
        //=================================TESTING CODE=================================================
        VendingMachine vm = vendingMachineList.get(0);
        System.out.println("+++++++++++++");
        vm.displayItemMenu();
        vm.newStock(1, 2, itemStockList.get(1), 22);
   //     vm.displayItemMenu();
//        vm.newStock(2, 0, itemStockList.get(1));
//        System.out.println("+++++++++++++");
//        vm.restock(1, 1);
//        System.out.println("+++++++++++++");
//        vm.restock(2, 1);
//        System.out.println("+++++++++++++");
//        vm.changePrice(1, 30);
        vm.displayItemMenu();
    //    vm.mainMenu(unliMoney);
        System.out.println("+++++++++++++");
        vm.replenishMoney(maintenanceMoney);
        System.out.println("+++++++++++++");

        myInventory.add(vm.mainMenu(unliMoney));
        myInventory.add(vm.mainMenu(unliMoney));
        myInventory.add(vm.mainMenu(unliMoney));
        System.out.println("Resulting myInventory");
        displayItemInventory(myInventory);

        */
    }

}
