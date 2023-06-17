public class Item {
    //peepee poo poo
    public Item(String name, int cost, int calories){
        this.NAME = name;
        this.cost = cost;
        this.CALORIES = calories;
        stock = 0;
        count++;
    }

    public String getName() {
        return NAME;
    }

    public int getCalories() {
        return CALORIES;
    }

    public int getCost() {
        return cost;
    }

    public int getCount() {
        return count;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void addStock(int stock) {
        this.stock += stock;
    }
    private final String NAME;

    private int cost;

    private final int CALORIES;

    private int stock;

    private static int count = 0;
}
