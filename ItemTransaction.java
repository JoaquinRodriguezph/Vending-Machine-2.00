public class ItemTransaction {
    public ItemTransaction(Item item){
        this.item = item;
    }
//dang
    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return item.getCost() * quantity;
    }

    private Item item;
    private int quantity;
}
