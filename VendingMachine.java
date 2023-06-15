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
        boolean result = false;
        for (ItemSlot item: itemSlots){

        }
        return result;
    }
}
