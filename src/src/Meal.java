import java.util.ArrayList;

public class Meal extends Item {
    public Meal(String name, ArrayList<ItemStock> itemList, int price) {
        super(name, setCalories(itemList));
        this.itemList = itemList;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void addAddOnStock(AddOnStock addOnStock, int price) {
        itemList.add(addOnStock);
        this.price += price;
    }

    public ArrayList<ItemStock> getItemList() {
        return itemList;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This private static method is used by the constructor to calculate the total calories in the meal.
     * @param itemList List of items that comprises the meal.
     */
    private static int setCalories(ArrayList<ItemStock> itemList) {
        int calories = 0;
        for (ItemStock item : itemList) {
            calories += item.getCalories();
        }

        return calories;
    }

    private final ArrayList<ItemStock> itemList;
    private int price;

}
