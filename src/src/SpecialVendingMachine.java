import java.util.ArrayList;
public class SpecialVendingMachine extends VendingMachine{

    /**
     * This method is a constructor which utilizes the following parameters:
     *
     * @param name         the name of the vending machine.
     * @param maxSlots     the max amount of Slots.
     * @param slotMaxItems the max amount of items in each Slot.
     */
    public SpecialVendingMachine(String name, int maxSlots, int slotMaxItems) {
        super(name, maxSlots, slotMaxItems);
    }

    public void setMealPrice(int index, int price) throws IndexOutOfBoundsException{
        Meal meal = mealList.get(index);
        meal.setPrice(price);
    }

    //public void successfulMealTransaction()



    private ArrayList<Meal> mealList;
    private ArrayList<Integer> mealTransactionCount;
}
