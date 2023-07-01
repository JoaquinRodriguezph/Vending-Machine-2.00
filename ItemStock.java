/**
 * The Item Class contains the information and methods to change
 * the information of an item instance. There is a counter attribute
 * as well which contains the total amount of items.
 */
public class ItemStock {

    /**
     * This method is a constructor used to create an item instance
     * from the following parameters:
     * @param name This is the name of the item. IT IS FINAL.
     * @param srp This is the SRP of the item. IT IS FINAL
     * @param calories This is the amount of calories in the item. IT IS FINAL.
     */
    public ItemStock(String name, int srp, int calories){
        this(name, srp, calories, 0);   //stock set to zero by default
    }

    /**
     * This method is a constructor used to create an item instance
     * from the following parameters:
     * @param name This is the name of the item. IT IS FINAL.
     * @param srp This is the SRP of the item. IT IS FINAL
     * @param calories This is the amount of calories in the item. IT IS FINAL.
     * @param stock This is the amount of stock for the item.
     */
    public ItemStock(String name, int srp, int calories, int stock){
        this.NAME = name;
        this.SRP = srp;
        this.CALORIES = calories;
        setStock(stock);  //item stock is set to the parameter stock
        count++;    //incrementing the number of items created (products)
        this.ITEM = new Item(NAME, CALORIES);
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
     * This static method gets the count of all item instances.
     * @return the count of all items.
     */
    public static int getCount() {
        return count;
    }

    /**
     * This method gets the number of the item in stock.
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    public Item getItem() {
        return ITEM;
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
     * @return true if stock to be added is greater than 0, false otherwise.
     */
    public boolean addStock(int stock) {
        boolean b = false;
        if (stock > 0) {    //stocks should be positive
            this.stock += stock;
            System.out.println(stock + " Stocks Have Been added to " + NAME);
            System.out.println("Current Stock: " + this.stock);
            b = true;
        }

        return b;
    }

    public boolean removeStock(int stock) {
        boolean b = false;
        if (stock > 0) {    //stocks should be positive
            if (stock <= this.stock) {  //if the stocks in this instance is has <stock> amount
                this.stock -= stock;
                b = true;
            }
            else
                System.out.println("Error: Not Enough Stock");
        }
        else
            System.out.println("Error: Invalid Quantity");

        return b;
    }

    /**
     * This method deletes the item by making it null.
     * @param itemStock the item to be deleted.
     */
    public static void delete(ItemStock itemStock) {
        itemStock = null;    //deletes the item by making it null
        count--;    //decrementing the number of object (item)
    }

    private final String NAME;

    private final Item ITEM;

    private final int SRP;

    private final int CALORIES;

    private int stock;

    private static int count = 0;
}