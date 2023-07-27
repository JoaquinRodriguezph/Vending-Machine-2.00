import java.util.ArrayList;

public class Meal extends Item {

    /**
     * This method is a constructor used to create a Meal instance
     * from the following parameters:
     *
     * @param name This is the name of the Meal. IT IS FINAL.
     * @param itemList This is the list of items to comprise the Meal.
     * @param price This is the price of the Meal.
     */
    public Meal(String name, ArrayList<ItemStock> itemList, int price) {
        super(name, setCalories(itemList));
        this.itemList = itemList;
        this.price = price;
    }

    /**
     * This method gets the price of the Meal.
     *
     * @return the price of the Meal
     */
    public int getPrice() {
        return price;
    }

    /**
     * This method gets the itemList of the Meal.
     *
     * @param addOnStock the add-on item to be added to the meal
     * @param price the price of the addOnStock
     */
    public void addAddOnStock(AddOnStock addOnStock, int price) {
        itemList.add(addOnStock);
        this.price += price;
    }

    /**
     * This method gets the itemList of the Meal.
     *
     * @return the ArrayList itemList attribute of the Meal
     */
    public ArrayList<ItemStock> getItemList() {
        return itemList;
    }

    /**
     * This method sets the price of the Meal.
     *
     * @param price the price value to be set.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This method is compares this meal to the meal given in the parameter by comparing
     * all the ItemStock objects in their respective ArrayList of ItemStock
     *
     * @param meal the Meal object to be compared with this Meal
     * @returns true if equal, false otherwise
     */
    public boolean equals(Meal meal) {
        boolean b = true;

        //initializing temp arraylists
        ArrayList<ItemStock> compMeal = new ArrayList<ItemStock>(meal.getItemList());
        ArrayList<ItemStock> thisMeal = new ArrayList<ItemStock>(itemList);

        //comparing each itemstock within each meal, and no duplicates
        while (thisMeal.size() > 0 && compMeal.size() > 0) {
            if (!(compMeal.remove(thisMeal.remove(0)))) {
                b = false;
                break;
            }
        }

        //if there are elements still within the list, return false
        if (thisMeal.size() > 0 || compMeal.size() > 0)
            b = false;

        return b;
    }

    /**
     * This private static method is used by the constructor to calculate the total calories in the meal.
     * @param itemList List of items that comprises the meal.
     * @return the calories calculated
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
