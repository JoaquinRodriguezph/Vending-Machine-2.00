import javax.swing.*;
import java.util.ArrayList;

public class FactoryModel {
    private ArrayList<VendingMachine> vendingMachines;

    private ArrayList<Money> moneyList;

    public ArrayList<Item> getMyInventory() {
        return myInventory;
    }

    private ArrayList<Item> myInventory;

    public FactoryModel() {
        this.vendingMachines = new ArrayList<VendingMachine>();
        this.myInventory = new ArrayList<Item>();
        vendingMachines.add(new VendingMachine("Vending Machine 1", 10, 10));
        myInventory.add(new Item("Sunny Side Up", 120));
        myInventory.add(new Item("Chippy", 170));
        myInventory.add(new Item("Tapas", 200));
        myInventory.add(new Item("Hotdog", 75));
        myInventory.add(new Item("Piattos", 180));
        myInventory.add(new Item("V-Cut", 180));
        myInventory.add(new Item("Corn", 88));
        myInventory.add(new Item("Fried Chicken", 246));
        myInventory.add(new Item("Bangus", 200));
        myInventory.add(new Item("Pork Chop", 231));
        myInventory.add(new Item("Tosino", 230));
        myInventory.add(new Item("Rice", 206));
        myInventory.add(new Item("Coca Cola", 140));
        myInventory.add(new Item("Royal", 140));
        myInventory.add(new Item("Bottled Water", 0));
    }


    public void replenishBills(int choice, int num, int quantity, JFrame frame) {
        Money money = null;
        switch(num){
            case 1 ->
            {
                money = new Money(1);
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice).addMoney(money);
                }
            }
            case 2 -> {
                money = new Money(5);
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice).addMoney(money);
                }
            }
            case 3 -> {
                money = new Money(10);
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice).addMoney(money);
                }
            }
            case 4 -> {
                money = new Money(20);
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice).addMoney(money);
                }
            }
            case 5 -> {
                money = new Money(50);
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice).addMoney(money);
                }
            }
            case 6 -> {
                money = new Money(100);
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice).addMoney(money);
                }
            }
            case 7 -> {
                money = new Money(200);
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice).addMoney(money);
                }
            }
            case 8 -> {
                money = new Money(500);
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice).addMoney(money);
                }
            }
            case 9 -> {
                money = new Money(1000);
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice).addMoney(money);
                }
            }
        }
    }
    public void createVendingMachine(String name, int maxSlots, int slotMaxItems, JFrame frame){
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Name cannot be empty",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (maxSlots < 8) {
            JOptionPane.showMessageDialog(frame, "Max slots should be >= 8",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (slotMaxItems < 10) {
            JOptionPane.showMessageDialog(frame, "Max items per slot should be >= 10",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        vendingMachines.add(new VendingMachine(name, maxSlots, slotMaxItems));
        JOptionPane.showMessageDialog(frame, "Success!",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void createItem(String name, int calories, JFrame frame) {
        ArrayList<Item> itemStocks = new ArrayList<Item>();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Name cannot be empty",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (calories < 0) {
            JOptionPane.showMessageDialog(frame, "Calories should be >= 0",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(frame, "Success!",
                "Error", JOptionPane.ERROR_MESSAGE);

        try{
            itemStocks.add(new Item(name, calories));  //itemStocks Arraylist adds the new itemStocks
            this.myInventory.addAll(itemStocks);
            return;
        }
        catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(frame, "Calories should be >= 0",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    public void selectItem(int choice, JFrame errorFrame){
        if (choice <= myInventory.size() && choice >= 0){
            JOptionPane.showMessageDialog(errorFrame, "Successfully selected item.",
                    "Success", JOptionPane.ERROR_MESSAGE);;
        }
        else {
            JOptionPane.showMessageDialog(errorFrame, "Please enter a valid number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void addItem(int choice, int num, JFrame frame) {
        if (choice < 0 || choice > myInventory.size()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(frame, "Success!",
                "Error", JOptionPane.ERROR_MESSAGE);
        myInventory.add(myInventory.get(choice));
    }


    /**
     * This method displays the items in the inventory.
     * @param ta, the text area of the view to be utilized
     */
    public void displayItems(JTextArea ta){
        ta.append("Item No || Name ||  Calories\n");
        int i = 0;
        for (Item item : myInventory) {
            ta.append(i + "\t" +  item.getName() + "\t" + item.getCalories() + "\n");
            i++;
        }
    }

    public void displayVendingMachines(JTextArea ta){
        ta.append("Vending Machine No || Name ||  Max Slots || Max Items\n");
        int i = 0;
        for (VendingMachine vm : vendingMachines) {
            ta.append(i + "\t" + vm.getName() + "    " + vm.getNumSlots() + "    " + vm.getMaxSlotItem() + "\n");
            i++;
        }
    }

    public void displayVendingMachineInfo(int vendingMachineNum, JTextArea ta, JFrame frame){
        try{
            if (vendingMachineNum >= 0 && vendingMachineNum <= vendingMachines.size()){
                ta.append("Slot No || Item Name ||  Calories\n");
                for (String string : vendingMachines.get(vendingMachineNum).getSlotInfo()) {
                    ta.append(string);
                }
            }
        }
        catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    public void displayVendingMachineMoney(int vendingMachineNum, JTextArea ta){
        ArrayList<String> money = vendingMachines.get(vendingMachineNum).showMoney();
        for (String string : money) {
            ta.append(string);
        }
    }

    public void invalidNumberError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Please enter a valid number.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    public int getVendingMachineSize(){
        return vendingMachines.size();
    }
    public int myInventoryNum(){
        return myInventory.size();
    }
}