/**
 * This class represents an vending machine slot item with a name and calories.
 */
public class VendItem extends Item {
    /**
     * This method is a constructor which creates an instance using:
     *
     * @param name the name of the item
     * @param calories the calories of the item.
     */
    public VendItem(String name, int calories) throws IllegalArgumentException {
        super(name, calories);
    }
}