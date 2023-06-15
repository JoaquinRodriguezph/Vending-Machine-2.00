public class Item {
    //peepee poo poo
    public Item(String name, int cost, float calories){
        this.NAME = name;
        this.cost = cost;
        this.CALORIES = calories;
    }

    public String getName() {
        return NAME;
    }

    public float getCalories() {
        return CALORIES;
    }

    public int getCost() {
        return cost;
    }

    private final String NAME;

    private int cost;

    private final float CALORIES;
}
