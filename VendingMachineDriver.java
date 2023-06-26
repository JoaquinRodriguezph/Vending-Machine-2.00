import java.util.ArrayList;

public class VendingMachineDriver {
    private ArrayList<Item> ItemList = new ArrayList<Item>();

    //VendingMachineDriver(){this.ItemList = new ArrayList<>();}
    public static void main(String args[]) {
        VendingMachineDriver vm = new VendingMachineDriver();
        vm.ItemList.add(new Item("Fried Egg", 30, 150));
        vm.ItemList.add(new Item("Chippy", 75, 170));
        vm.ItemList.add(new Item("Tapas", 100, 200));
        vm.ItemList.add(new Item("Hotdog", 75, 290));
        vm.ItemList.add(new Item("Piattos", 75, 150));
        vm.ItemList.add(new Item("V-Cut", 75, 180));
        vm.ItemList.add(new Item("Corn", 20, 88));
        vm.ItemList.add(new Item("Fried Chicken", 100, 246));
        vm.ItemList.add(new Item("Bangus", 100, 200));
        vm.ItemList.add(new Item("Pork Chop", 100, 231));
        vm.ItemList.add(new Item("Tosino", 100, 230));
        vm.ItemList.add(new Item("Rice", 20, 206));
        vm.ItemList.add(new Item("Coca Cola", 50, 139));
        vm.ItemList.add(new Item("Royal", 50, 139));
        vm.ItemList.add(new Item("Bottled Water", 25, 0));
    }

}
