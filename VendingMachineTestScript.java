public class VendingMachineTestScript {
    public static void main(String args[]){
        Item item1 = new Item("Piattos1", 123);
        ItemSlot itemslot1 = new ItemSlot(1,8);
        ItemStock itemstock1 = new ItemStock("Piattos", 10, 123);
        itemstock1.addStock(0);
        System.out.println(itemstock1.getStock());
    }
}
