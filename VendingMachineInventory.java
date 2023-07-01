/**
 * The VendingMachineInventory class contains
 * the itemSlots and money of the vending machine.
 */
public class VendingMachineInventory {
    /**
     * This method is a constructor which creates an instance using:
     * @param vm the vending machine to be inventoried.
     */
    public VendingMachineInventory(VendingMachine vm) {
        money = new Money(vm.getMoney());
        ItemSlot[] tempSlots = vm.getItemSlots();
        itemSlots = new ItemSlot[tempSlots.length];
        for (int i = 0; i < tempSlots.length; i++) {
            itemSlots[i] = new ItemSlot(tempSlots[i].getSlotNumber(), tempSlots[i].getMax());
            itemSlots[i].setItemStock(tempSlots[i].getItemStock());
            itemSlots[i].setStock(tempSlots[i].getStock());
            itemSlots[i].setPrice(tempSlots[i].getPrice());
        }
    }

    /**
     * This method gets the item slot list.
     * @return the list of item slots.
     */
    public ItemSlot[] getItemSlots() {
        return itemSlots;
    }

    /**
     * This method gets the money of the vending machine inventory.
     * @return the money instance of the vending machine inventory.
     */
    public Money getMoney() {
        return money;
    }

    private ItemSlot[] itemSlots;
    private Money money;
}
