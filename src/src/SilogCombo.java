import java.util.ArrayList;
/**
 * This class represents a Silog Combo made from the special vending machine with a name, items, and calories.
 */
public class SilogCombo extends Item {
    /**
     * This method is a constructor which utilizes the following parameters:
     *
     * @param name the name of the Silog Combo.
     * @param items the list of items that comprise the combo.
     * @param calories the total calories of the combo meal.
     */
    public SilogCombo(String name, ArrayList<Item> items, int calories) {
        super(name, calories);
        ITEMS = items;
    }

    /**
     * Gets the list of items that comprise the combo
     * @return the list of items that comprise the combo
     */
    public ArrayList<Item> getItems() {
        return ITEMS;
    }

    /**
     * The list of items that comprise the combo
     */
    private final ArrayList<Item> ITEMS;
}
