/**
 * The ItemTransaction class counts the number of times
 * the specific item has been sold since the last restock.
 */
public class ItemTransaction {
    /**
     * This method is a constructor that creates an ItemTransaction
     * instance using the following parameter:
     * @param itemSlot item to be counted
     */
    public ItemTransaction(ItemSlot itemSlot){
        this.itemSlot = itemSlot;
    }


    /**
     * This method gets the item
     * @return the item of the ItemTransaction instance
     */
    public ItemSlot getItem() {
        return itemSlot;
    }

    /**
     * This method gets the quantity of the item
     * @return the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method gets the total cost of the items
     * @return the total cost of the items
     */
    public int getTotal() {
        return itemSlot.getPrice() * quantity;
    }

    public void addTransaction() {
        quantity++;
    }

    public void clearTransaction() {
        quantity = 0;
    }

    @Override
    public String toString() {
        return itemSlot.getItem().getName() + itemSlot.getPrice() + quantity + getTotal();
    }

    private ItemSlot itemSlot;
    private int quantity;
}
