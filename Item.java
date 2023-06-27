public class Item {
    public Item(String name, int calories) {
        NAME = name;
        CALORIES = calories;
    }

    public String getName() {
        return NAME;
    }

    public int getCalories() {
        return CALORIES;
    }

    private final String NAME;

    private final int CALORIES;
}
