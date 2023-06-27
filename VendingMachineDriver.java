import java.util.ArrayList;

public class VendingMachineDriver {
    private ArrayList<ItemStock> itemStockList = new ArrayList<ItemStock>();

    //VendingMachineDriver(){this.ItemList = new ArrayList<>();}

    private void

    public static void main(String args[]) {
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

        ArrayList<Item> myItems = new ArrayList<Item>();
        Money myMoney = new Money();

        Money maintenanceMoney = new Money();


    }

}
