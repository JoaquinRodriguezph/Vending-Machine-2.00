/**
 * The ItemTransaction class counts the number of times
 * the specific item has been sold since the last restock.
 */
public class ItemTransaction {
    /**
     * This method is a constructor that creates an ItemTransaction
     * instance using the following parameter:
     * @param item item to be counted
     */
    public ItemTransaction(Item item){
        this.item = item;
    }


    /**
     * This method gets the item
     * @return the item of the ItemTransaction instance
     */
    public Item getItem() {
        return item;
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
        return item.getCost() * quantity;
    }

    private Item item;
    private int quantity;
}
