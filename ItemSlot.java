public class ItemSlot {
    public ItemSlot(int slot, int max){
        this.SLOTNUMBER = slot;
        this.item = null;
        this.stock = 0;
        this.MAX = max;
    }

    public int getSlotNumber() {
        return SLOTNUMBER;
    }

    public Item getItem() {
        return item;
    }

    public int getStock() {
        return stock;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean addStock(int stock){
        if (this.item != null && stock > 0 && MAX >= this.stock + stock){
            this.stock += stock;
            System.out.println("Adding Stock Successful");
            return true;
        }

        System.out.println("Error: Invalid Amount/Stock");
        return false;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    private final int SLOTNUMBER;

    private Item item;

    private int stock;

    private final int MAX;
}
