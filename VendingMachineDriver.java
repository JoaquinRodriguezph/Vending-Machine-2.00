import java.util.*;

public class VendingMachineDriver {
    private static ArrayList<ItemStock> itemStockList = new ArrayList<ItemStock>();

    private static ArrayList<VendingMachine> vendingMachineList = new ArrayList<VendingMachine>();

    //VendingMachineDriver(){this.ItemList = new ArrayList<>();}

    private ItemStock selectItemStock(ArrayList<ItemStock> itemStocks) {

    }

    private static Item execBuyer(VendingMachine vendingMachine, Money wallet) {
        return vendingMachine.mainMenu(wallet);
    }

    private static void execMaintenance(VendingMachine vendingMachine, Money wallet) {

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
            System.out.println("=========================");

            do {
                option = sc.nextInt();
                if (option > 2 || option < 0)
                    System.out.println("Error: Invalid Option");
            } while (option > 2 || option < 0);

            switch (option) {
                case 0:
                    exit = true;
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

        if (allItems.size() == 0)
            allItems = null;

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
            System.out.println(item.next().getName() + ": " + quantity.next());
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        //    VendingMachineDriver vm = new VendingMachineDriver();
        itemStockList.add(new ItemStock("Fried Egg", 30, 150));
        itemStockList.add(new ItemStock("Chippy", 75, 170));
        itemStockList.add(new ItemStock("Tapas", 100, 200));
        itemStockList.add(new ItemStock("Hotdog", 75, 290));
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

        vendingMachineList.add(new VendingMachine("PH", 12, 15));
        vendingMachineList.add(new VendingMachine("FOODIES", 8, 10));

        ArrayList<Item> myInventory = new ArrayList<Item>();
        Money myMoney = new Money();

        Money maintenanceMoney = new Money();



        myInventory.addAll(startInteraction(myMoney));
        System.out.println("Resulting myInventory");
        displayItemInventory(myInventory);


    }

}
