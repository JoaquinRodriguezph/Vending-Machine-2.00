import java.util.ArrayList;

/**
 * The ItemSlot Class contains the slot number
 * that contains a specific item type. The slot number
 * and the max amount of items in a specific slot is final.
 */
public class ItemSlot {
    /**
     * This method is a constructor which creates an ItemSlot instance
     * using the following parameters:
     * @param slot the slot number to be inputted
     * @param max the max amount of items in the slot.
     */
    public ItemSlot(int slot, int max){
        this.SLOTNUMBER = slot;
        this.itemStock = null;
        this.items = new ArrayList<Item>();
        this.MAX = max;
        this.price = 0;
    }

    /**
     * This method gets the slot Number.
     * @return the slot number
     */
    public int getSlotNumber() {
        return SLOTNUMBER;
    }

    /**
     * This method gets the item in the slot.
     * @return the item in the Slot
     */
    public ItemStock getItemStock() {
        return itemStock;
    }

    public int getStock() {
        return items.size();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * This method gets the price of item in the slot.
     * @return the price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * This method gets the max amount of items in the slot.
     * @return the max amount of items in the slot.
     */
    public int getMax() {
        return MAX;
    }

    /**
     * This method sets the item that is in the item slot.
     * @param itemStock the item to be set in the slot
     */
    public void setItemStock(ItemStock itemStock) {
        this.itemStock = itemStock;
    }

    /**
     * This method sets the price of the item slot.
     * @param price the price of item slot.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This method sets the price of the item slot to the suggested retail price.
     */
    public void setSRP() {
        setPrice(itemStock.getSRP());
    }

    /**
     * This method sets the stock of the items to the given:
     * @param stock the new stock of the item slot.
     */
    public void setStock(int stock) {
        items.clear();
        for (int i = 0; i < stock; i++)
            items.add(new Item(itemStock.getItem()));
    }

    /**
     * This method adds the amount specified in the parameter if it is not
     * below 0 and is not above the maximum capacity.
     * @param stock the amount of stock to be added
     * @return true or false depending on if the stocking is successful
     */
    public boolean addStock(int stock){
        if (stock > 0 && MAX >= items.size() + stock){    //the stock must be positive and must add to less than or equal to MAX
            if (itemStock.removeStock(stock)) {
                for (int i = 0; i < stock; i++)
                    items.add(new Item(itemStock.getItem()));
                return true;
            }
        }

        return false;
    }

    /**
     * This method removes an item from the slot and returns the Item instance
     * @return an Item instance within the slot
     */
    public Item removeStock() {
        if (isAvailable())
            return items.remove(0);
        return null;
    }

    /**
     * The method checks if there is stock left of an item.
     * @return true or false depending if there is at least one stock.
     */
    public boolean isAvailable() {
        return items.size() > 0;
    }


    /**
     * This method checks if there is no stock left of an item.
     * @return true if stock is 0 and false if not
     */
    public boolean isEmpty() {
        return items.size() == 0;
    }

    private final int SLOTNUMBER;

    private ItemStock itemStock;

    private ArrayList<Item> items;

    private final int MAX;

    private int price;
}
