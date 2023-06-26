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
        this.item = null;
        this.stock = 0;
        this.MAX = max;
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
    public Item getItem() {
        return item;
    }

    /**
     * This method gets the stock of the item in the slot.
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    /**
     * This method sets the item that is in the item slot.
     * @param item the item to be set in the slot
     */
    public void setItem(Item item) {
        this.item = item;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSRP() {
        setPrice(item.getSRP());
    }

    /**
     * This method adds the amount specified in the parameter if it is not
     * below 0 and is not above the maximum capacity.
     * @param stock the amount of stock to be added
     * @return true or false depending on if the stocking is successful
     */
    public boolean addStock(int stock){
        if (this.item != null && stock > 0 && MAX >= this.stock + stock){
            this.stock += stock;
            System.out.println("Adding Stock Successful");
            return true;
        }

        System.out.println("Error: Invalid Amount/Stock");
        return false;
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

    private Item item;

    private int stock;

    private final int MAX;

    private int price;
}
