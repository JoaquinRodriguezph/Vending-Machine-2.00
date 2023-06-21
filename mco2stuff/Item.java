/**
 * The Item Class contains the information and methods to change
 * the information of an item instance. There is a counter attribute
 * as well which contains the total amount of items.
 */
public class Item {

    /**
     * This method is a constructor used to create an item instance
     * from the following parameters:
     * @param name This is the name of the item. IT IS FINAL.
     * @param srp This is the SRP of the item. IT IS FINAL
     * @param calories This is the amount of calories in the item. IT IS FINAL.
     */
    public Item(String name, int srp, int calories){
        this(name, srp, calories, 0);   //stock set to zero by default
    }

    public Item(String name, int srp, int calories, int stock){
        this.NAME = name;
        this.SRP = srp;
        this.CALORIES = calories;
        setStock(stock);  //item stock is set to the parameter stock
        count++;    //incrementing the number of items created (products)
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
     * This method gets the SRP of the item.
     * @return the price of the item.
     */
    public int getSRP() {
        return SRP;
    }

    /**
     * This method gets the count of all item instances.
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
        item = null;    //deletes the item by making it null
        count--;    //decrementing the number of object (item)
    }

    private final String NAME;

    private final int SRP;

    private final int CALORIES;

    private int stock;

    private static int count = 0;
}
