import java.util.ArrayList;
public class Warehouse {
    public Warehouse(String name) {
        NAME = name;
        ArrayList<Item> products = new ArrayList<Item>();
    }

    public String getNAME() {
        return NAME;
    }

    public ArrayList<Item> getProducts() {
        return products;
    }

    private final String NAME;
    private ArrayList<Item> products;
}
