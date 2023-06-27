import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineDriver {
    private ArrayList<ItemStock> itemStockList = new ArrayList<ItemStock>();

    private ArrayList<VendingMachine> vendingMachineList = new ArrayList<VendingMachine>();

    //VendingMachineDriver(){this.ItemList = new ArrayList<>();}

    private ItemStock selectItemStock(ArrayList<ItemStock> itemStocks) {

    }

    private void execVendingMachine(VendingMachine vendingMachine) {

    }

    private VendingMachine selectVendingMachine(ArrayList<VendingMachine> vendingMachines) {

    }

    private ArrayList<Item> startInteraction(Money buyerWallet, Money maintenanceWallet, ArrayList<VendingMachine> vendingMachines, ArrayList<ItemStock> itemStocks) {
        //main interaction loop
        do {
            System.out.println("=========================");
            System.out.println("Type of Interaction");
            System.out.println("=========================");
            System.out.println("(0) Exit");
            System.out.println("(1) Buyer");
            System.out.println("(2) Maintenance Person");
            System.out.println("=========================");



        } while ();
    }


    private void displayBuyerItems(ArrayList<Item> items) {

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        VendingMachineDriver vm = new VendingMachineDriver();
        vm.itemStockList.add(new ItemStock("Fried Egg", 30, 150));
        vm.itemStockList.add(new ItemStock("Chippy", 75, 170));
        vm.itemStockList.add(new ItemStock("Tapas", 100, 200));
        vm.itemStockList.add(new ItemStock("Hotdog", 75, 290));
        vm.itemStockList.add(new ItemStock("Piattos", 75, 150));
        vm.itemStockList.add(new ItemStock("V-Cut", 75, 180));
        vm.itemStockList.add(new ItemStock("Corn", 20, 88));
        vm.itemStockList.add(new ItemStock("Fried Chicken", 100, 246));
        vm.itemStockList.add(new ItemStock("Bangus", 100, 200));
        vm.itemStockList.add(new ItemStock("Pork Chop", 100, 231));
        vm.itemStockList.add(new ItemStock("Tosino", 100, 230));
        vm.itemStockList.add(new ItemStock("Rice", 20, 206));
        vm.itemStockList.add(new ItemStock("Coca Cola", 50, 139));
        vm.itemStockList.add(new ItemStock("Royal", 50, 139));
        vm.itemStockList.add(new ItemStock("Bottled Water", 25, 0));

        vm.vendingMachineList.add(new VendingMachine("PH", 12, 15));
        vm.vendingMachineList.add(new VendingMachine("FOODIES", 8, 10));

        ArrayList<Item> myInventory = new ArrayList<Item>();
        Money myMoney = new Money();

        Money maintenanceMoney = new Money();



        startInteraction(Money buyerWallet, Money maintenanceWallet, ArrayList<VendingMachine> vendingMachines, ArrayList<ItemStock> itemStocks);



    }

}
