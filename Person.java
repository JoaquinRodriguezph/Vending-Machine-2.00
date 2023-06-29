import java.util.ArrayList;

/**
 * This class represents a person with a wallet and a name.
 */
public class Person {

    /**
     * This method creates a person instance using:
     * @param name the name of the person.
     */
    public Person(String name) {
        wallet = new Money();
        NAME = name;
    }

    /**
     * This method gets the money of the person.
     * @return returns the money of the person instance.
     */
    public Money getWallet() {
        return wallet;
    }

    /**
     * This method gets the name of the person.
     * @return returns the name of the person instance.
     */
    public String getName() {
        return NAME;
    }

    /**
     * This method sets the wallet of a person.
     * @param wallet the wallet to be copied.
     * @return the Money Class of the new wallet.
     */
    public Money setWallet(Money wallet) {
        Money money = this.wallet;
        this.wallet = wallet;
        return money;
    }

    protected final String NAME;

    protected Money wallet;
}

/**
 * This is a subclass of person that has access to maintenance
 * features of a vending machine.
 */
class MaintenancePerson extends Person{
    /**
     * This method is a constructor that uses the following to create an instance:
     * @param name the name of the maintenance person.
     */
    public MaintenancePerson(String name) {
        super(name);
        ArrayList<VendingMachine> vendingMachine = new ArrayList<VendingMachine>();
    }



    private ArrayList<VendingMachine> vendingMachines;

    //private ArrayList<>
}