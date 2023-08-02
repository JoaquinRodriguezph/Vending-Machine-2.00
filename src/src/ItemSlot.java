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
     *
     * @param max the max amount of items in the slot.
     */
    public ItemSlot(int max) throws IllegalArgumentException {
        if (max < 10)
            throw new IllegalArgumentException("Number of Items in a Slot shall be 10 or more");
        this.vendItems = new ArrayList<VendItem>();
        this.MAX = max;
    }


    /**
     * This method gets the price of item in the slot.
     *
     * @return the price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * This method gets the max amount of items in the slot.
     *
     * @return the max amount of items in the slot.
     */
    public int getMax() {
        return MAX;
    }

    /**
     * This method gets the amount of items in the slot.
     *
     * @return the amount of items in the slot.
     */
    public int getStock() {
        return vendItems.size();
    }

    /**
     * This method gets the name of items that is contained the slot.
     *
     * @return the name of item within the slot.
     */
    public String getItemName() throws IndexOutOfBoundsException {
        return vendItems.get(0).getName();
    }

    /**
     * This method gets the name of items that is contained the slot.
     *
     * @return the name of item within the slot.
     */
    public int getItemCalories() throws IndexOutOfBoundsException {
        return vendItems.get(0).getCalories();
    }

    /**
     * This method sets the price of the item slot.
     *
     * @param price the price of item slot.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This method removes a single item from the item slot
     *
     * @return the item removed from the item slot.
     */
    public VendItem removeItem() throws IndexOutOfBoundsException {
        return vendItems.remove(0);
    }


    /**
     * This method adds the item to the item slot. It is only added when
     * the slot is empty or the item is of the same.
     *
     * @param vendItem the item to be added to the item slot
     * @return true if adding item is successful, false otherwise
     */
    public boolean addStock(VendItem vendItem) {
        boolean b = false;

        if (vendItems.isEmpty()) {
            vendItems.add(vendItem);
            b = true;
        }
        else {
            VendItem temp = vendItems.get(0);
            if (temp.getName().equalsIgnoreCase(vendItem.getName()) && temp.getCalories() == vendItem.getCalories()) {
                vendItems.add(vendItem);
                b = true;
            }
        }

        return b;
    }

    /**
     * The method checks if there is stock left of an item.
     *
     * @return true or false depending if there is at least one stock.
     */
    public boolean isAvailable() {
        return vendItems.size() > 0;
    }


    /**
     * This method checks if there is no stock left of an item.
     *
     * @return true if stock is 0 and false if not
     */
    public boolean isEmpty() {
        return vendItems.isEmpty();
    }

    /**
     * This method checks if there is no stock left of an item.
     *
     * @return true if stock is 0 and false if not
     */
    public boolean isFull() {
        return vendItems.size() == MAX;
    }

    private ArrayList<VendItem> vendItems;

    private final int MAX;

    private int price;
}
