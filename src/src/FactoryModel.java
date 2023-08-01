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
    }

    public void createItem(String name, int calories, JFrame frame) {
        ArrayList<Item> itemStocks = new ArrayList<Item>();
        if (name == null) {
            JOptionPane.showMessageDialog(frame, "Name cannot be empty",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (calories < 0 || calories == 0) {
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

    public void displayItems(JTextArea ta){
        ta.append("Name ||  Calories\n");
        for (Item item : myInventory) {
            ta.append(item.getName() + " " + item.getCalories() + "\n");
        }
    }
}