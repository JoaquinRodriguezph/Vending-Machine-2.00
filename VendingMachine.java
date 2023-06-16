public class VendingMachine {
    private ItemSlot[] itemSlots;
    private Money money;
    private ItemTransaction[] transactionLog;
    private VendingMachine startingInventory;

    public VendingMachine(int maxSlots) {
        this.itemSlots = new ItemSlot[maxSlots];
    }

    public void buyerMenu(){

    }

    public void displayItemMenu(){

    }

    public boolean chooseItem(int slot){
        boolean b = false;
        ItemSlot selectedItem = null;
        for (ItemSlot item: itemSlots){
            if (slot == item.getSlotNumber()) {
                b = true;
                selectedItem = item;
            }
        }
        if (b == false)
            System.out.println("Error: Invalid Item Selection");
        else
            System.out.println("(" + slot + ")Selected Item: " + selectedItem.getItem().getName());
        return b;
    }

    public boolean receivePayment(int cost) {
        

    }

}
