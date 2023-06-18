import java.util.Scanner;
public class VendingMachine {

    public VendingMachine(int maxSlots, int slotMaxItems) {
        this.itemSlots = new ItemSlot[maxSlots];    //initializing the number of slots in the vending machine
        for (int i = 0; i < maxSlots; i++) {    //loop to assign SLOTNUMBER and max items in each slot
            itemSlots[i] = new ItemSlot(i + 1, slotMaxItems);
        }
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

    public boolean receivePayment(int cost, Money wallet) {
        int change;
        int temp = -1;
        Money payment = new Money();
        Money tempWallet = new Money(wallet);
        Scanner sc = new Scanner(System.in);
        boolean b = false;

        System.out.println("Amount to Pay: " + cost + " Pesos");
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

        while (payment.getMoney() < cost && temp != 0) {
            System.out.println("Insert: ");
            temp = sc.nextInt();
            switch (temp) {
                case 1:
                    payment.addOnePeso(1);
                    break;
                case 2:
                    payment.addFivePeso(1);
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
                case 0:
                    break;
                default:
                    System.out.println("Error: Invalid Option");
            }

            if (temp <= 9 && temp >= 1) {
                if (tempWallet.removeMoney(payment)) {
                    System.out.println("Paid: " + payment.getMoney());
                    if (payment.getMoney() < cost)
                        tempWallet = wallet;
                }
            }
        }

        do {
            System.out.println("Confirm Transaction: (1) Yes   (0) No");
            temp = sc.nextInt();
        } while (temp != 1 && temp != 0);

        if (temp == 0) {
            System.out.println("Cancelling Transaction...");
        }
        else if (payment.getMoney() >= cost) {
            if (payment.getMoney() != cost)
                System.out.println("Calculating Change");

            change = payment.getMoney() - cost;
            //Display Details of the Transaction
            System.out.println("=========================");
            System.out.println("Amount Paid: " + payment.getMoney());
            System.out.println("Total Cost:  " + cost);
            System.out.println("Amount Paid - Total Cost");
            System.out.println("(Change):    " + change);
            System.out.println("=========================");

            money.addMoney(payment);

            if (money.removeMoney(change)) {
                wallet = tempWallet;
                System.out.println("Transaction Successful");
                b = true;
            }
            else {
                money.removeMoney(payment);
                System.out.println("The Machine Does Not Have Enough Change\nCancelling Transaction...");
            }
        }

        payment = null;
        tempWallet = null;

        if (!b)
            System.out.println("Transaction Failed");
        return b;   //true transaction is successful, false otherwise (cancelling of payment or no change)
    }

    private ItemSlot[] itemSlots;
    private Money money;
    private ItemTransaction[] transactionLog;
    private VendingMachine startingInventory;

}
