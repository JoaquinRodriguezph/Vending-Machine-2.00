import java.util.ArrayList;

/**
 * The SpecialVendingMachine class is an extension of VendingMachine
 * class (Regular Vending Machine), which contains all the methods and
 * attributes and some additional features that would make Sisig Combo meals
 */
public class SpecialVendingMachine extends VendingMachine{

    /**
     * This method is a constructor which utilizes the following parameters:
     *
     * @param name         the name of the vending machine.
     * @param maxSlots     the max amount of Slots.
     * @param slotMaxItems the max amount of items in each Slot.
     */
    public SpecialVendingMachine(String name, int maxSlots, int slotMaxItems, int inventoryMax) {
        super(name, maxSlots, slotMaxItems);
        defaultSisigBase = new ArrayList<Item>();
        defaultSisigBase.add(new VendItem("Rice", 206));
        defaultSisigBase.add(new VendItem("Fried Egg", 120));
        defaultSisigSide = new ArrayList<Item>();
        defaultSisigSide.add(new VendItem("Fried Chicken", 246));
        defaultSisigSide.add(new VendItem("Bangus", 200));
        defaultSisigSide.add(new VendItem("Tapas", 200));
        defaultSisigSide.add(new VendItem("Tosino", 230));
        defaultSisigSide.add(new VendItem("Pork Chop", 231));
        itemInventory = new ArrayList<Item>();
        MAX_INV = inventoryMax;
    }

    /**
     * The list of items that comprise the combo
     */
    private ArrayList<Item> defaultSisigBase;

    private ArrayList<Item> defaultSisigSide;

    private ArrayList<Item> itemInventory;

    private final int MAX_INV;
}
