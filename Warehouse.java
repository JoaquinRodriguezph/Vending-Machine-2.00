import java.util.ArrayList;
public class Warehouse {
    public Warehouse(String name) {
        NAME = name;
        ArrayList<ItemStock> products = new ArrayList<ItemStock>();
    }

    public String getNAME() {
        return NAME;
    }

    public ArrayList<ItemStock> getProducts() {
        return products;
    }

    private final String NAME;
    private ArrayList<ItemStock> products;
}
