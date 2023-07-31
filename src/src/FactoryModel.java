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
    private ArrayList<ItemStock> itemStockList;

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

    private ArrayList<VendingStock> createItemStock() {
        ArrayList<VendingStock> vendingStocks = new ArrayList<VendingStock>();
        Scanner sc = new Scanner(System.in);
        int option;
        String name;
        int srp = -1;
        int calories = -1;
        boolean create = false;
        int stock = -1;

        do {
            System.out.println("=========================");
            System.out.println("(0) Cancel");
            System.out.print("Item Name: ");
            name = sc.next();
            if (!name.equalsIgnoreCase("0")) {  //check if the user inputted string is 0, prompting a cancellation of creation of the Item Stock
                do {    //prompts user the input valid calories
                    System.out.print("Calories: ");
                    calories = sc.nextInt();
                    if (calories < 0)
                        System.out.println("Error: Invalid Calories");
                } while (calories < 0);


                do {    //prompts user the input valid stocks
                    System.out.print("Stocks: ");
                    stock = sc.nextInt();
                    if (stock < 0)
                        System.out.println("Error: Invalid Stock/s");
                } while (stock < 0);


                System.out.println("=========================");
                System.out.println("(0) Cancel");
                do {    //prompts the user to input the srp for the item
                    System.out.print("SRP (PHP): ");
                    srp = sc.nextInt();
                    if (srp < 0)
                        System.out.println("Error: Invalid SRP");
                } while (srp < 0);

                if (srp != 0)   //if srp is not zero, then user had provided valid information for the creation of the item stock
                    create = true;
            }

            if (create) {   //if creation boolean is true
                vendingStocks.add(new VendingStock(name, srp, calories, stock));  //itemStocks Arraylist adds the new itemStocks
                System.out.println("New Item Stock Created");
            }
            else
                System.out.println("Item Stock Creation Cancelled");

            create = false; //this boolean resets to false

            do {
                System.out.println("=========================");
                System.out.println("(0) Finish");
                System.out.println("(1) Create Another");   //option 1 utilizes the outside loop itself
                System.out.println("(2) Show Created Item Stock/s");
                System.out.println("=========================");

                do {
                    System.out.print("Option: ");
                    option = sc.nextInt();
                    if (option > 2 || option < 0)
                        System.out.println("Error: Invalid Option");
                } while (option > 2 || option < 0);

                if (option == 2)
                    if (vendingStocks.size() != 0) //if there are item stock object newly created
                        displayItemStock(vendingStocks);
                    else
                        System.out.println("No New Item Stocks Have Been Created");

            } while (option != 0 && option != 1);
        } while(option != 0);

        System.out.println("Going Back...");

        return vendingStocks;
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
