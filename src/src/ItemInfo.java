/**
 * This class represents an item info stored in the special vending machine with  name, price and calories.
 */
public class ItemInfo {
    /**
     * This method is a constructor which creates an instance using:
     *
     * @param name the name of the item
     * @param calories the calories of the item.
     */
    public ItemInfo (String name, int calories, int price) throws IllegalArgumentException {
        if (price < 1)
            throw new IllegalArgumentException("Price should be 1 or more");

        NAME = name;
        CALORIES = calories;
        this.price = price;
    }

    /**
     * Gets the name of the item.
     * @return the name of the item.
     */
    public String getName() {
        return NAME;
    }

    /**
     * Gets the calories of the item.
     * @return the calories of the item.
     */
    public int getCalories() {
        return CALORIES;
    }

    /**
     * Gets the price of the item.
     * @return the price of the item.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * The name of the item.
     */
    private final String NAME;

    /**
     * The calories of the item.
     */
    private final int CALORIES;

    /**
     * The price of the item.
     */
    private int price;
}