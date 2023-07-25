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
}
