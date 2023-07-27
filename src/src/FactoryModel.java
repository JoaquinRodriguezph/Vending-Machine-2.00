import java.util.ArrayList;

public class FactoryModel {
    private ArrayList<VendingMachine> vendingMachines;

    private ArrayList<Money> moneyList;

    public ArrayList<Item> getMyInventory() {
        return myInventory;
    }

    private ArrayList<Item> myInventory;
    private ArrayList<ItemStock> itemStockList;

    public FactoryModel(){
        this.vendingMachines = new ArrayList<VendingMachine>();
        this.myInventory =  new ArrayList<Item>();
    }

}
