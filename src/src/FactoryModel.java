import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FactoryModel {
    private ArrayList<VendingMachine> vendingMachines;

    private ArrayList<Money> moneyList;

    public ArrayList<Item> getMyInventory() {
        return myInventory;
    }

    private ArrayList<Item> myInventory;
    private ArrayList<VendingStock> vendingStockList;
    public FactoryModel(){
        this.vendingMachines = new ArrayList<VendingMachine>();
        this.myInventory =  new ArrayList<Item>();
    }


    public void displayItemInventory(ArrayList<Item> items, JTextArea textArea) {
        ArrayList<Item> itemSets = new ArrayList<Item>();
        ArrayList<Integer> itemQuantity = new ArrayList<Integer>();

        //display the inventory of what the user have bought

        for (Item item : items) {   //utilizing two arrayList by counting the number of repeated instances
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

        textArea.append("Total Items Bought: " + myInventory.size() + "\n");


        if (!(itemSets.size() == 0 || itemQuantity.size() == 0)) {  //checking if the user have bought anything
            while (item.hasNext() && quantity.hasNext()) {  //displaying the item and quantity using an iterator
                Item it = item.next();
                Integer in = quantity.next();
                if (it != null && in != null)
                    textArea.append(it.getName() + ": " + in);
            }
        }
        else
            textArea.append("No Items Has Been Bought");
    }

    public void createItemStock(String name, int srp, int calories, int stock, JFrame frame) {
        ArrayList<VendingStock> vendingStocks = new ArrayList<VendingStock>();
            if (name == null){
                JOptionPane.showMessageDialog(frame, "Name cannot be empty",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (calories < 0 || calories == 0){
                JOptionPane.showMessageDialog(frame, "Calories should be >= 0",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (stock < 0 || stock == 0){
                JOptionPane.showMessageDialog(frame, "Stock should be >= 0",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (srp <= 0 || srp == 0){
                JOptionPane.showMessageDialog(frame, "SRP should be > 0",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


        JOptionPane.showMessageDialog(frame, "Success!",
                "Error", JOptionPane.ERROR_MESSAGE);
        vendingStocks.add(new VendingStock(name, srp, calories, stock));  //itemStocks Arraylist adds the new itemStocks
        this.vendingStockList.addAll(vendingStocks);
    }

    private void displayItemStock(ArrayList<VendingStock> vendingStocks) {
        Iterator<VendingStock> it = vendingStocks.iterator();

        System.out.println("=========================");
        System.out.println("Item Stocks: " + vendingStocks.size());
        System.out.println("=========================");

        for (int i = 1; it.hasNext(); i++) {    //utilizing iterators in a forloop to display all the ItemStocks given the parameter
            VendingStock vendingStock;
            vendingStock = it.next();

            System.out.println("(" + i + ") " + vendingStock.getName() + "; Stock: " + vendingStock.getStock() + "; SRP: " + vendingStock.getSRP() + "; Calories: " + vendingStock.getCalories());
        }
        System.out.println("=========================");
    }
}
