/**
 * This class represents an item with a name and calories.
 */
public class Item {
    /**
     * This method is a constructor which creates an instance using:
     *
     * @param name the name of the item
     * @param calories the calories of the item.
     */
    public Item (String name, int calories) throws IllegalArgumentException {
        if (calories < 0)
            throw new IllegalArgumentException("Calories should be 0 or more");

        NAME = name;
        CALORIES = calories;
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
     * The name of the item.
     */
    private final String NAME;

    /**
     * The calories of the item.
     */
    private final int CALORIES;
}