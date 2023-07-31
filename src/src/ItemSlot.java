import java.util.ArrayList;
import java.util.IllegalFormatException;

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
    public ItemSlot(int max) throws IllegalFormatException {
        if (max < 10)
            throw new IllegalArgumentException("Number of Items in a Slot shall be 10 or more");
        this.items = new ArrayList<Item>();
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
        return items.size();
    }

    /**
     * This method gets the name of items that is contained the slot.
     *
     * @return the name of item within the slot.
     */
    public String getItemName() throws IndexOutOfBoundsException {
        return items.get(0).getName();
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
    public Item removeItem() throws IndexOutOfBoundsException {
        return items.remove(0);
    }


    /**
     * This method adds the item to the item slot. It is only added when
     * the slot is empty or the item is of the same.
     *
     * @param item the item to be added to the item slot
     * @return true if adding item is successful, false otherwise
     */
    public boolean addStock(Item item) {
        boolean b = false;

        if (items.isEmpty()) {
            items.add(item);
            b = true;
        }
        else {
            Item temp = items.get(0);
            if (temp.getName().equalsIgnoreCase(item.getName()) && temp.getCalories() == item.getCalories()) {
                items.add(item);
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
        return items.size() > 0;
    }


    /**
     * This method checks if there is no stock left of an item.
     *
     * @return true if stock is 0 and false if not
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * This method checks if there is no stock left of an item.
     *
     * @return true if stock is 0 and false if not
     */
    public boolean isFull() {
        return items.size() == MAX;
    }

    private ArrayList<Item> items;

    private final int MAX;

    private int price;
}
