import java.util.ArrayList;

public class Person {

    public Person(String name) {
        wallet = new Money();
        NAME = name;
    }

    public Money getWallet() {
        return wallet;
    }

    public String getName() {
        return NAME;
    }

    public Money setWallet(Money wallet) {
        Money money = this.wallet;
        this.wallet = wallet;
        return money;
    }

    protected final String NAME;

    protected Money wallet;
}

class MaintenancePerson extends Person{
    public MaintenancePerson(String name) {
        super(name);
        ArrayList<VendingMachine> vendingMachine = new ArrayList<VendingMachine>();
    }



    private ArrayList<VendingMachine> vendingMachines;

    //private ArrayList<>
}