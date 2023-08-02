import javax.swing.*;
import java.util.ArrayList;

public class FactoryModel {

    /**
     * This method is the constructor for the Factory Model Class.
     * It is used to initialize the components of the factory.
     */
    public FactoryModel() {
        this.vendingMachines = new ArrayList<VendingMachine>();
        this.myInventory = new ArrayList<Item>();
        vendingMachines.add(new VendingMachine("Regular Vending Machine", 10, 10));
        vendingMachines.add(new SpecialVendingMachine("Special Vending Machine", 10, 10 ,20));
        SpecialVendingMachine svm = (SpecialVendingMachine) vendingMachines.get(1);

        myInventory.add(new VendItem("Fried Egg", 120));
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

    /**
     * This method gets the vending machines.
     *
     * @return the ArrayList of vending machines
     */
    public ArrayList<VendingMachine> getVendingMachines() {
        return vendingMachines;
    }


    //Special Vending Machine Features
    /**
     * This method checks if the list of items compose of a valid silog combo meal.
     *
     * @param items the items in the potential silog combo meal
     * @param vendingMachine the vending machine choice
     * @return the true if it is valid combo meal, false otherwise
     */
    public boolean isSilog(ArrayList<Item> items, int vendingMachine){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachine - 1)));
        return svm.isSilog(items);
    }

    /**
     * This method removes and gets the Item from the special vending machine.
     *
     * @param vendingMachineChosed the selected vending machine
     * @param slot the choice
     * @return the true if it is valid combo meal, false otherwise
     */
    public Item getItem(int vendingMachineChosed, int slot){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        return svm.releaseItem(slot);
    }

    /**
     * This method gets the ArrayList of String used for the combo box of the special vending machine feature
     *
     * @param vendingMachine the selected vending machine
     * @return ArrayList of String used for the combo box of the special vending machine feature
     */
    public ArrayList<String> specialComboBox(int vendingMachine){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachine - 1)));
        ArrayList<String> choices = new ArrayList<String>();
        for (int i = 0; i < svm.getItemListSize(); i++) {
            choices.add("" + (i + 1));
        }
        return choices;
    }

    /**
     * This method sets the item price of the special vending machine.
     *
     * @param vendingMachineChosed the selected vending machine
     * @param slot the choice
     * @param price the price to be set
     */
    public void setItemPrice(int vendingMachineChosed, int slot, int price){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        svm.setItemPrice(slot, price);
    }

    /**
     * This method gets the size of the special vending machine item list.
     *
     * @param vendingMachineChosed the selected vending machine
     * @return the size of the special vending machine item list
     */
    public int getSVMItemListSize(int vendingMachineChosed){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        return svm.getItemListSize();
    }

    /**
     * This method adds the item to the special vending machine inventory.
     *
     * @param vendingMachineChosed the selected vending machine
     * @param item the item to be added
     */
    public void addToInventory(int vendingMachineChosed, Item item){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        svm.addToInventory(item);

    }

    /**
     * This method adds the item to the special vending machine inventory, and check if it is new or not.
     *
     * @param vendingMachineChosed the selected vending machine
     * @param slot the choice
     * @return true if it is not new, false if new.
     */
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

    /**
     * This method adds the item and sets the item to the special vending machine inventory,
     * and check if it is new or not, and also if it is full.
     *
     * @param vendingMachineChosed the selected vending machine
     * @param slot the choice
     * @param price the set price
     * @return true if it is new and not full, false if new or full.
     */
    public boolean addToInventoryFalse(int vendingMachineChosed, int slot, int price){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineChosed - 1)));
        Item item = myInventory.get(slot - 1);
        return svm.addToInventory(item, price);
    }

    /**
     * This method gets the ArrayList of String used for the combo box of the vending machine feature
     *
     * @param choice the selected vending machine
     * @return ArrayList of String used for the combo box of the vending machine feature
     */
    public ArrayList<String> comboboxChoices(int choice) {
        ArrayList<String> choices = new ArrayList<String>();
        for (int i = 0; i < vendingMachines.get(choice-1).getNumSlots(); i++) {
            choices.add("" + (i + 1));
        }
        return choices;
    }

    /**
     * This method gets the ArrayList of Money of the change of the transaction
     *
     * @param choice the selected vending machine
     * @param payment the payment
     * @param cost the cost of the item
     * @return ArrayList of Money as change
     */
    public ArrayList<Money> getChange(int choice, ArrayList<Money> payment, int cost){
        return vendingMachines.get(choice-1).getChange(payment, cost);
    }

    /**
     * This method dispenses the item from the vending machine
     *
     * @param choice the selected vending machine
     * @param slotChosed the selected slot
     * @return the dispensed item
     */
    public Item dispenseItem(int choice, int slotChosed){
        return vendingMachines.get(choice-1).dispenseItem(slotChosed);
    }

    /**
     * This method restocks the item to the item slot of the vending machine
     *
     * @param choice the selected vending machine
     * @param selected the selected slot
     * @param quantity the quantity to be added
     * @param frame the frame to notify events
     */
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

    /**
     * This method restocks the item to the item slot of the vending machine
     *
     * @param choice the selected vending machine
     * @param selected the selected slot
     * @param price the price to be set
     * @param frame the frame to notify events
     */
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

    /**
     * This method collects the Money from the vending machine
     *
     * @param choice the selected vending machine
     * @param frame the frame to notify events
     */
    public void collectMoney(int choice, JFrame frame){
        int choice2 = choice - 1;
        vendingMachines.get(choice2).collectMoney();
        JOptionPane.showMessageDialog(frame, "Success!",
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method adds the Money to the vending machine
     *
     * @param choice the selected vending machine
     * @param num the money value
     * @param quantity the quantity of money denomination
     * @param frame the frame to notify events
     */
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

    /**
     * This method creates special vending machine
     *
     * @param name the name of the vending machine
     * @param maxSlots the max slots of the vending machine
     * @param slotMaxItems the max items per slot
     * @param inventoryLimit the inventory limit of the special vending machine
     * @param frame the frame to notify events
     */
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

    /**
     * This method creates regular vending machine
     *
     * @param name the name of the vending machine
     * @param maxSlots the max slots of the vending machine
     * @param slotMaxItems the max items per slot
     * @param frame the frame to notify events
     */
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

    /**
     * This method creates an item
     *
     * @param name the name of the vending machine
     * @param calories the max slots of the vending machine
     * @param frame the frame to notify events
     */
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

    /**
     * This method creates a VendItem
     *
     * @param name the name of the vending machine
     * @param calories the max slots of the vending machine
     * @param frame the frame to notify events
     */
    public void createVendingItem(String name, int calories, JFrame frame) {
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
            itemStocks.add(new VendItem(name, calories));  //itemStocks Arraylist adds the new itemStocks
            this.myInventory.addAll(itemStocks);
            return;
        }
        catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(frame, "Calories should be >= 0",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    /**
     * This method shows whether an item choice is valid
     *
     * @param choice the choice of the item
     * @param errorFrame the frame to notify events
     */
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

    /**
     * This method validates the addition of an item to the slot
     *
     * @param choice the choice of the item
     * @param num
     * @param frame the frame to notify events
     */
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
     * This method displays the transaction log to the text area
     *
     * @param choice the choice of the vending machine
     * @param ta text area to be appendended to
     */
    public void displayTransactions(int choice, JTextArea ta){
        ArrayList<String> transactionLog = vendingMachines.get(choice - 1).getTransactionLog();
        for (String transaction : transactionLog) {
            ta.append(transaction);
        }
    }

    /**
     * This method displays the items in the inventory.
     *
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

    public void displayItems2(JTextArea ta){
        ta.append("Item No || Name ||  Calories\n");
        int i = 1;
        for (Item item : myInventory) {
            if(item instanceof VendItem){
                ta.append(i + "\t" +  item.getName() + "\t" + item.getCalories() + "\n");
                i++;
            }
        }
    }


    /**
     * This method displays the inventory.
     *
     * @param choice the selected vednding machine
     * @param ta, the text area of the view to be utilized
     */
    public void displayInventories(int choice, JTextArea ta){
        ArrayList<String> inventories = vendingMachines.get(choice - 1).getInventoryLog();
        for (String string : inventories){
            ta.append(string);
        }
    }

    /**
     * This method displays the vending machines.
     *
     * @param ta, the text area of the view to be utilized
     */
    public void displayVendingMachines(JTextArea ta){
        ta.append("Vending Machine No || Name ||  Max Slots || Max Items || Inventory Limit\n");
        int i = 1;
        for (VendingMachine vm : vendingMachines) {
            if (vm instanceof SpecialVendingMachine)
            {
                ta.append("SVM [");
                ta.append(i + "]\t" + vm.getName() + "    " + vm.getNumSlots() + "    " + vm.getMaxSlotItem() + "    " + ((SpecialVendingMachine) vm).getInventoryLimit() + "\n");
            }
            else {
                ta.append("RVM [");
                ta.append(i + "]\t" + vm.getName() + "    " + vm.getNumSlots() + "    " + vm.getMaxSlotItem() + "\n");
            }
            i++;
        }
    }

    /**
     * The method displays the all vending machine information
     * @param vendingMachineNum the selected vending machine
     * @param ta, the text area of the view to be utilized
     * @param frame the frame to notify
     */
    public void displayVendingMachineInfo(int vendingMachineNum, JTextArea ta, JFrame frame){
    int vendingMachineNum2 = vendingMachineNum - 1;
    ArrayList<String> slots = vendingMachines.get(vendingMachineNum2).getSlotInfo();
    for (String string : slots) {
            ta.append(string);
        }
    }

    /**
     * The method displays the all vending machine money
     * @param vendingMachineNum the selected vending machine
     * @param ta, the text area of the view to be utilized
     */
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

    /**
     * The method displays the special vending machine inventory
     *
     * @param vendingMachineNum the selected vending machine
     * @param ta, the text area of the view to be utilized
     */
    public void displaySpecialVendingMachineInventory(int vendingMachineNum ,JTextArea ta){
        SpecialVendingMachine svm = ((SpecialVendingMachine) (vendingMachines.get(vendingMachineNum - 1)));
        ArrayList<String> inventory = svm.getIndexInventoryInfo();
        for (String string : inventory){
            ta.append(string);
        }
    }

    /**
     * The helper method that does the invalid number error
     *
     * @param frame the frame to notify
     */
    public void invalidNumberError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Please enter a valid number.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * The method displays the success message
     *
     * @param frame the frame to notify
     */
    public void success(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Success!",
                "Notice", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * The method displays the error message
     *
     * @param frame the frame to notify
     */
    public void noItemSelectedError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Please select an item.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * The method displays the availability message
     *
     * @param frame the frame to notify
     */
    public void slotNotAvailableError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Slot not available.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * The method displays the special vending machine message
     *
     * @param frame the frame to notify
     */
    public void notSpecialVendingMachine(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Not a special vending machine.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void fullInventoryError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Inventory is full.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * The method displays the null message
     *
     * @param frame the frame to notify
     */
    public void nullError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Item Not Available. Please select another.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * The method displays the invalid silog message
     *
     * @param frame the frame to notify
     */
    public void invalidSilog(JFrame frame){
        JOptionPane.showMessageDialog(frame, "The items you chose cannot be made into a proper silog meal.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * The method gets the number of vending machines
     *
     * @return the number of vending machines
     */
    public int getVendingMachineSize(){
        return vendingMachines.size();
    }

    /**
     * The method gets the number of items in list of blueprints
     *
     * @return the number of items in list of blueprints
     */
    public int myInventoryNum(){
        return myInventory.size();
    }



    private ArrayList<VendingMachine> vendingMachines;

    private ArrayList<Item> myInventory;

}