public class AddOnStock extends ItemStock{
    /**
     * This method is a constructor used to create an AddOnStock instance
     * from the following parameters:
     * @param name This is the name of the AddOnStock. IT IS FINAL.
     * @param srp This is the SRP of the AddOnStock. IT IS FINAL
     * @param calories This is the amount of calories in the item. IT IS FINAL.
     */
    public AddOnStock(String name, int srp, int calories){
        this(name, srp, calories, 0);   //stock set to zero by default
    }

    /**
     * This method is a constructor used to create an AddOnStock instance
     * from the following parameters:
     * @param name This is the name of the AddOnStock. IT IS FINAL.
     * @param srp This is the SRP of the AddOnStock. IT IS FINAL
     * @param calories This is the amount of calories in the item. IT IS FINAL.
     * @param stock This is the amount of stock for the item.
     */
    public AddOnStock(String name, int srp, int calories, int stock){
        super(name, srp, calories, stock);
    }

}
