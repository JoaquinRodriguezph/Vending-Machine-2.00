import java.util.Scanner;
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
        int change;
        int temp = -1;
        Money payment = new Money();
        Scanner sc = new Scanner(System.in);
        boolean b = false;

        System.out.println("=========================");
        System.out.println("(0) Cancel Payment");
        System.out.println("Insert Bills/Coins: ");
        System.out.println("(1) 1 Peso");
        System.out.println("(2) 5 Pesos");
        System.out.println("(3) 10 Pesos");
        System.out.println("(4) 20 Pesos");
        System.out.println("(5) 50 Pesos");
        System.out.println("(6) 100 Pesos");
        System.out.println("(7) 200 Pesos");
        System.out.println("(8) 500 Pesos");
        System.out.println("(9) 1000 Pesos");
        System.out.println("=========================");

        while (payment.getMoney() < cost && temp == 0) {
            System.out.println("Insert: ");
            temp = sc.nextInt();
            switch (temp) {
                case 1:
                    payment.addOneHundredPeso(1);
                    break;
                case 2:
                    payment.addFiftyPeso(1);
                    break;
                case 3:
                    payment.addTenPeso(1);
                    break;
                case 4:
                    payment.addTwentyPeso(1);
                    break;
                case 5:
                    payment.addFiftyPeso(1);
                    break;
                case 6:
                    payment.addOneHundredPeso(1);
                    break;
                case 7:
                    payment.addTwoHundredPeso(1);
                    break;
                case 8:
                    payment.addFiveHundredPeso(1);
                    break;
                case 9:
                    payment.addOneThousandPeso(1);
            }

            System.out.println("Paid: " + payment.getMoney());
        }

        if (temp == 0) {
            System.out.println("Cancelling Payment...");
        }
        else if (payment.getMoney() >= cost) {
            System.out.println("Payment Successful!");
            if (payment.getMoney() != cost)
                System.out.println("Calculating Change");

            change = payment.getMoney() - cost;

            money.removeMoney(change);
        }


        return b;
    }

}
