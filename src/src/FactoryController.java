import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class FactoryController {

    public FactoryController(FactoryView factoryView, FactoryModel factoryModel) {
        this.factoryModel = factoryModel;
        this.factoryView = factoryView;
        this.inventory = new ArrayList<Item>();

        this.factoryView.setStartProgramBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Main Program");
            }
        });

        this.factoryView.setCustomizeStocksBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Customize Stocks");
            }
        });

        this.factoryView.setShowInventoryBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Inventory");
                displayItemInventory(factoryModel.getMyInventory(), factoryView.getShowInventoryText());
            }
        });

    }
    private void displayItemInventory(ArrayList<Item> items, JTextArea textArea) {
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

        textArea.append("Total Items Bought: " + inventory.size());


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

    private ArrayList<Item> inventory;
    private FactoryView factoryView;
    private FactoryModel factoryModel;
}
