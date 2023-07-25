public class Meal extends Item {
    public Meal(String name, VendingStock[] itemList, int price) {
        super(name, setCalories(itemList));
        this.itemList = itemList;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public VendingStock[] getItemList() {
        return itemList;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This private static method is used by the constructor to calculate the total calories in the meal.
     * @param itemList List of items that comprises the meal.
     */
    private static int setCalories(VendingStock[] itemList) {
        int calories = 0;
        for (VendingStock item : itemList) {
            calories += item.getCalories();
        }

        return calories;
    }

    private final VendingStock[] itemList;
    private int price;

}
