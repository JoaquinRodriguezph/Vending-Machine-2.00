import javax.swing.*;
import java.util.ArrayList;

public class FactoryModel {
    public ArrayList<VendingMachine> getVendingMachines() {
        return vendingMachines;
    }

    private ArrayList<VendingMachine> vendingMachines;

    private ArrayList<Item> myInventory;

    public FactoryModel() {
        this.vendingMachines = new ArrayList<VendingMachine>();
        this.myInventory = new ArrayList<Item>();
        vendingMachines.add(new VendingMachine("Regular Vending Machine", 10, 10));
        vendingMachines.add(new SpecialVendingMachine("Special Vending Machine", 10, 10 ,10));
        SpecialVendingMachine svm = (SpecialVendingMachine) vendingMachines.get(1);

        myInventory.add(new VendItem("Sunny Side Up", 120));
        myInventory.add(new VendItem("Chippy", 170));
        myInventory.add(new VendItem("Tapas", 200));
        myInventory.add(new VendItem("Hotdog", 75));
        myInventory.add(new VendItem("Piattos", 180));
        myInventory.add(new VendItem("V-Cut", 180));
        myInventory.add(new VendItem("Corn", 88));
        myInventory.add(new VendItem("Fried Chicken", 246));
        myInventory.add(new VendItem("Bangus", 200));
        myInventory.add(new VendItem("Pork Chop", 231));
        myInventory.add(new VendItem("Tosino", 230));
        myInventory.add(new VendItem("Rice", 206));
        myInventory.add(new VendItem("Coca Cola", 140));
        myInventory.add(new VendItem("Royal", 140));
        myInventory.add(new VendItem("Bottled Water", 0));
        myInventory.add(new Item("Gravy", 79));
        myInventory.add(new Item("Toyo", 53));

        svm.addToInventory(myInventory.get(0), 30);
        svm.addToInventory(myInventory.get(1), 75);
        svm.addToInventory(myInventory.get(2), 100);
        svm.addToInventory(myInventory.get(3), 75);
        svm.addToInventory(myInventory.get(4), 75);
        svm.addToInventory(myInventory.get(5), 75);
        svm.addToInventory(myInventory.get(6), 20);
        svm.addToInventory(myInventory.get(7), 100);
        svm.addToInventory(myInventory.get(8), 100);
        svm.addToInventory(myInventory.get(9), 100);
        svm.addToInventory(myInventory.get(10), 100);
        svm.addToInventory(myInventory.get(11), 20);
        svm.addToInventory(myInventory.get(12), 50);
        svm.addToInventory(myInventory.get(13), 50);
        svm.addToInventory(myInventory.get(14), 25);

    }

    //Special Vending Machine Features
    //public ArrayList<String> selledItems(){}
    public Item getItem(int vendingMachineChosed, int slot){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        return svm.releaseItem(slot);
    }
    public ArrayList<String> specialComboBox(int vendingMachine){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachine - 1)));
        ArrayList<String> choices = new ArrayList<String>();
        for (int i = 0; i < svm.getItemListSize(); i++) {
            choices.add("" + (i + 1));
        }
        return choices;
    }
    public void setItemPrice(int vendingMachineChosed, int slot, int price){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        svm.setItemPrice(slot, price);
    }

    public int getSVMItemListSize(int vendingMachineChosed){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        return svm.getItemListSize();
    }
    public boolean addToInventoryTest(int vendingMachineChosed, int slot){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        Item item = myInventory.get(slot - 1);
        if (svm.addToInventory(item)){
            return true;
        }
        else{
            return false;
        }
    }

    public void addToInventoryTrue(int vendingMachineChosed, int slot){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        Item item = myInventory.get(slot - 1);
        svm.addToInventory(item);
    }

    public void addToInventoryFalse(int vendingMachineChosed, int slot, int price){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        Item item = myInventory.get(slot - 1);
        svm.addToInventory(item, price);
    }
    //
    public ArrayList<String> comboboxChoices(int choice) {
        ArrayList<String> choices = new ArrayList<String>();
        for (int i = 0; i < vendingMachines.get(choice-1).getNumSlots(); i++) {
            choices.add("" + (i + 1));
        }
        return choices;
    }

    public ArrayList<Money> getChange(int choice, ArrayList<Money> payment, int cost){
        return vendingMachines.get(choice-1).getChange(payment, cost);
    }
    public void dispenseItem(int choice, int slotChosed){
        vendingMachines.get(choice-1).dispenseItem(slotChosed);
    }
    public void setStock(int choice, int selected, int item, int quantity, JFrame frame){
        int choice2 = choice - 1;
        int item2 = item - 1;

        if(myInventory.get(item2) instanceof VendItem){
            VendItem selected2 = (VendItem) myInventory.get(item2);
            ArrayList<VendItem> vendItems = new ArrayList<VendItem>();
            for (int i = 0; i < quantity; i++) {
                vendItems.add(new VendItem(selected2.getName(), selected2.getCalories()));
            }
            if(vendingMachines.get(choice2).addSlotStock(selected, vendItems)) {
                ;
                JOptionPane.showMessageDialog(frame, "Success!",
                        "Notice", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(frame, "Can only place VendItem!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    public void changeItemSlotPrice(int choice, int selected, int price, JFrame frame) {
        int choice2 = choice - 1;
        if (vendingMachines.get(choice2).setSlotPrice(selected, price))
        {
            vendingMachines.get(choice2).setSlotPrice(selected, price);
            JOptionPane.showMessageDialog(frame, "Success!",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(frame, "Slot is not available!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void collectMoney(int choice, JFrame frame){
        int choice2 = choice - 1;
        vendingMachines.get(choice2).collectMoney();
        JOptionPane.showMessageDialog(frame, "Success!",
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    public void replenishBills(int choice, int num, int quantity, JFrame frame) {
        Money money = null;
        switch(num){
            case 1 ->
            {
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice - 1).addMoney(new Money(1));
                }
            }
            case 2 -> {
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice - 1).addMoney(new Money(5));
                }
            }
            case 3 -> {
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice - 1).addMoney(new Money(10));
                }
            }
            case 4 -> {
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice - 1).addMoney(new Money(20));
                }
            }
            case 5 -> {
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice - 1).addMoney(new Money(50));
                }
            }
            case 6 -> {
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice - 1).addMoney(new Money(100));
                }
            }
            case 7 -> {
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice - 1).addMoney(new Money(200));
                }
            }
            case 8 -> {
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice - 1).addMoney(new Money(500));
                }
            }
            case 9 -> {
                for (int i = 0; i < quantity; i++) {
                    vendingMachines.get(choice - 1).addMoney(new Money(1000));
                }
            }
        }
    }
    public void createSpecialVendingMachine(String name, int maxSlots, int slotMaxItems, int inventoryLimit, JFrame frame){
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
        if (inventoryLimit < 10) {
            JOptionPane.showMessageDialog(frame, "Inventory limit should be >= 10",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        vendingMachines.add(new SpecialVendingMachine(name, maxSlots, slotMaxItems, inventoryLimit));
        JOptionPane.showMessageDialog(frame, "Success!",
                "Error", JOptionPane.INFORMATION_MESSAGE);
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
                "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    public void createItem(String name, int calories, JFrame frame) {
        ArrayList<Item> itemStocks = new ArrayList<Item>();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Name cannot be empty",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (calories < 0) {
            JOptionPane.showMessageDialog(frame, "Calories should be > 0",
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


    public void displayTransactions(int choice, JTextArea ta){
        ArrayList<String> transactionLog = vendingMachines.get(choice - 1).getTransactionLog();
        for (String transaction : transactionLog) {
            ta.append(transaction);
        }
    }

    /**
     * This method displays the items in the inventory.
     * @param ta, the text area of the view to be utilized
     */
    public void displayItems(JTextArea ta){
        ta.append("Item No || Name ||  Calories\n");
        int i = 1;
        for (Item item : myInventory) {
            ta.append(i + "\t" +  item.getName() + "\t" + item.getCalories() + "\n");
            i++;
        }
    }

    public void displayInventories(int choice, JTextArea ta){
        ArrayList<String> inventories = vendingMachines.get(choice - 1).getInventoryLog();
        for (String string : inventories){
            ta.append(string);
        }
    }
    public void displayVendingMachines(JTextArea ta){
        ta.append("Vending Machine No || Name ||  Max Slots || Max Items || Inventory Limit\n");
        int i = 1;
        for (VendingMachine vm : vendingMachines) {
            if (vm instanceof SpecialVendingMachine)
            {
                ta.append("SVM");
                ta.append(i + "\t" + vm.getName() + "    " + vm.getNumSlots() + "    " + vm.getMaxSlotItem() + "    " + ((SpecialVendingMachine) vm).getInventoryLimit() + "\n");
            }
            else {
                ta.append("RVM");
                ta.append(i + "\t" + vm.getName() + "    " + vm.getNumSlots() + "    " + vm.getMaxSlotItem() + "\n");
            }
            i++;
        }
    }

    public void displayVendingMachineInfo(int vendingMachineNum, JTextArea ta, JFrame frame){
    int vendingMachineNum2 = vendingMachineNum - 1;
    ArrayList<String> slots = vendingMachines.get(vendingMachineNum2).getSlotInfo();
    for (String string : slots) {
            ta.append(string);
        }
    }

    public void displayVendingMachineMoney(int vendingMachineNum, JTextArea ta){
        int vendingMachineNum2 = vendingMachineNum - 1;
        ArrayList<String> money = vendingMachines.get(vendingMachineNum2).showMoney();
        int count = -2;
        for (String string : money) {
            count++;
            if (count > 0)
                ta.append("[" + count + "] ");
            ta.append(string);
        }
    }

    public void displaySelectedItems(int vendingMachineNum, JTextArea ta){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineNum - 1)));
    }
    public void displaySpecialVendingMachineInventory(int vendingMachineNum ,JTextArea ta){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineNum - 1)));
        ArrayList<String> inventory = svm.getIndexInventoryInfo();
        for (String string : inventory){
            ta.append(string);
        }
    }
    public void invalidNumberError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Please enter a valid number.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void success(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Success!",
                "Notice", JOptionPane.INFORMATION_MESSAGE);
    }

    public void noItemSelectedError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Please select an item.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void slotNotAvailableError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Slot not available.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void notSpecialVendingMachine(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Not a special vending machine.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    public int getVendingMachineSize(){
        return vendingMachines.size();
    }
    public int myInventoryNum(){
        return myInventory.size();
    }

}