import java.util.ArrayList;

public class AddOn {

    /**
     * This method is a constructor used to create a AddOn instance
     * from the following parameters:
     *
     * @param addOnStock This AddOnStock of the AddOn.
     * @param price This is the price of the AddOn.
     */
    public AddOn(AddOnStock addOnStock, int price) {
        this.addOnStock = addOnStock;
        this.price = price;
    }

    /**
     * This method is a constructor used to create a AddOn instance
     * from the following parameters:
     *
     * @param addOnStock This AddOnStock of the AddOn.
     */
    public AddOn(AddOnStock addOnStock) {
        this.addOnStock = addOnStock;
        setSRP();
    }

    /**
     * This method gets the AddOnStock instance of the AddOn.
     *
     * @return AddOnStock of AddOn.
     */
    public AddOnStock getAddOnStock() {
        return addOnStock;
    }

    /**
     * This method gets the number of stocks available of the AddOn.
     *
     * @return size of items.
     */
    public int getStock() {
        return items.size();
    }

    /**
     * This method gets List of items.
     *
     * @return ArrayList of items of the AddOn.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * This method gets the price of the AddOn.
     *
     * @return the price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * This method sets the price of the AddOn.
     *
     * @param price the price of AddOn.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This method sets the price of the AddOn to the suggested retail price.
     */
    public void setSRP() {
        setPrice(addOnStock.getSRP());
    }

    /**
     * This method sets the stock of the items to the given:
     *
     * @param stock the new stock of the item slot.
     */
    public void setStock(int stock) {
        items.clear();
        for (int i = 0; i < stock; i++)
            items.add(new Item(addOnStock.getItem()));
    }

    /**
     * This method adds the amount specified in the parameter if it is not
     * below 0
     *
     * @param stock the amount of stock to be added
     * @return true or false depending on if the stocking is successful
     */
    public boolean addStock(int stock) {
        if (stock > 0){    //the stock must be positive
            if (addOnStock.removeStock(stock)) {
                for (int i = 0; i < stock; i++)
                    items.add(new Item(addOnStock.getItem()));
                return true;
            }
        }

        return false;
    }

    /**
     * This method removes an item from the slot and returns the Item instance
     *
     * @return an Item instance within the slot
     */
    public Item removeStock() {
        if (isAvailable())
            return items.remove(0);
        return null;
    }

    /**
     * The method checks if there is stock left of an item.
     *
     * @return true or false depending if there is at least one stock.
     */
    public boolean isAvailable() {
        return items.size() > 0;
    }

    /**
     * This method checks if there is no stock left of an item.
     *
     * @return true if stock is 0 and false if not
     */
    public boolean isEmpty() {
        return items.size() == 0;
    }

    private AddOnStock addOnStock;
    private ArrayList<Item> items;
    private int price;
}
