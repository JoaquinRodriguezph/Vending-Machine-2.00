/**
 * The Item Class contains the information and methods to change
 * the information of an item instance. There is a counter attribute
 * as well which contains the total amount of items.
 */
public class Item {
    //peepee poo poo

    /**
     * This method is a constructor used to create an item instance
     * from the following parameters:
     * @param name This is the name of the item. IT IS FINAL.
     * @param cost This is the cost of the item.
     * @param calories This is the amount of calories in the item. IT IS FINAL.
     */
    public Item(String name, int cost, int calories){
        this.NAME = name;
        this.cost = cost;
        this.CALORIES = calories;
        stock = 0;
        count++;
    }

    /**
     * This method gets the name of the item.
     * @return the name of the item
     */
    public String getName() {
        return NAME;
    }

    /**
     * This method gets the amount of calories of the item.
     * @return the number of calories of the item
     */
    public int getCalories() {
        return CALORIES;
    }

    /**
     * This method gets the cost of the item.
     * @return the price of the item.
     */
    public int getCost() {
        return cost;
    }

    /**
     * This method gets the count of all items.
     * @return the count of all items.
     */
    public int getCount() {
        return count;
    }

    /**
     * This method gets the number of the item in stock.
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * This method sets the number of items in stock of the item.
     * @param stock the amount of item to add in stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * This method adds the amount of items in stock of the item.
     * @param stock the amount of item to add in stock.
     */
    public void addStock(int stock) {
        this.stock += stock;
    }

    public static void delete(Item item) {
        item = null;
        count--;
    }

    private final String NAME;

    private int cost;

    private final int CALORIES;

    private int stock;

    private static int count = 0;
}
