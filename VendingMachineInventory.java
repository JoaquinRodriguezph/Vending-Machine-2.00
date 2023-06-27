public class VendingMachineInventory {
    public VendingMachineInventory(VendingMachine vm) {
        money = new Money(vm.getMoney());
        ItemSlot[] tempSlots = vm.getItemSlots();
        itemSlots = new ItemSlot[tempSlots.length];
        for (int i = 0; i < tempSlots.length; i++) {
            itemSlots[i] = new ItemSlot(tempSlots[i].getSlotNumber(), tempSlots[i].getMax());
            itemSlots[i].setItemStock(tempSlots[i].getItemStock());
            itemSlots[i].addStock(tempSlots[i].getStock());
            itemSlots[i].setPrice(tempSlots[i].getPrice());
        }
    }

    public ItemSlot[] getItemSlots() {
        return itemSlots;
    }

    public Money getMoney() {
        return money;
    }

    private ItemSlot[] itemSlots;
    private Money money;
}
