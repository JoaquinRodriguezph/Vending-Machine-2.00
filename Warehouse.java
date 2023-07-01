import java.util.ArrayList;

/**
 * The Warehouse class contains the list of item stocks unused by the vending machine.
 */
public class Warehouse {
    /**
     * This method is a constructor that creates an instance using:
     * @param name the name of the warehouse.
     */
    public Warehouse(String name) {
        NAME = name;
        ArrayList<ItemStock> products = new ArrayList<ItemStock>();
    }

    /**
     * This method gets the name of the warehouse.
     * @return the name of the warehouse.
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * This method gets the products of the warehouse.
     * @return the products of the warehouse.
     */
    public ArrayList<ItemStock> getProducts() {
        return products;
    }

    private final String NAME;
    private ArrayList<ItemStock> products;
}
