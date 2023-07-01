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
        this.stock = 0;
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

    /**
     * This method gets the stock of the item in the slot.
     * @return the stock.
     */
    public int getStock() {
        return stock;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSRP() {
        setPrice(itemStock.getSRP());
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * This method adds the amount specified in the parameter if it is not
     * below 0 and is not above the maximum capacity.
     * @param stock the amount of stock to be added
     * @return true or false depending on if the stocking is successful
     */
    public boolean addStock(int stock){
        if (stock > 0 && MAX >= this.stock + stock){    //the stock must be positive and must add to less than or equal to MAX
            if (itemStock.removeStock(stock)) {
                this.stock += stock;

                System.out.println("Slot " + this.SLOTNUMBER + ": " + this.itemStock.getName() + " Adding Stock Successful");
                return true;
            }
        }
        else
            System.out.println("Error: Invalid Amount/Stock");

        return false;
    }


    public void removeStock() {
        this.stock--;
    }

    /**
     * The method checks if there is stock left of an item.
     * @return true or false depending if there is at least one stock
     */
    public boolean isAvailable() {
        return stock > 0;
    }


    public boolean isEmpty() {
        return stock == 0;
    }

    private final int SLOTNUMBER;

    private ItemStock itemStock;

    private int stock;

    private final int MAX;

    private int price;
}
