import java.util.ArrayList;
/**
 * This class represents a Sisig Combo made from the special vending machine with a name, items, and calories.
 */
public class SisigCombo {
    /**
     * This method is a constructor which utilizes the following parameters:
     *
     * @param name the name of the Sisig Combo.
     * @param items the list of items that comprise the combo.
     * @param calories the total calories of the combo meal.
     */
    public SisigCombo(String name, ArrayList<Item> items, int calories) {
        NAME = name;
        ITEMS = items;
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
     * Gets the list of items that comprise the combo
     * @return the list of items that comprise the combo
     */
    public ArrayList<Item> getItems() {
        return ITEMS;
    }

    /**
     * Gets the total calories of the combo meal
     * @return the total calories of the combo meal
     */
    public int getCalories() {
        return CALORIES;
    }

    /**
     * The name of the Sisig Combo
     */
    private final String NAME;

    /**
     * The list of items that comprise the combo
     */
    private final ArrayList<Item> ITEMS;

    /**
     * The total calories of the combo meal
     */
    private final int CALORIES;
}
