/**
 * This class represents an item with a name and calories.
 */
public class Item {
    /**
     * This method is a constructor which creates an instance using:
     * @param name the name of the item
     * @param calories the calories of the item.
     */
    public Item(String name, int calories) {
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

    private final String NAME;

    private final int CALORIES;
}
