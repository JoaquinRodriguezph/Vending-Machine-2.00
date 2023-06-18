import java.util.Scanner;
public class VendingMachine {

    public VendingMachine(int maxSlots, int slotMaxItems, int passcode) {
        this.itemSlots = new ItemSlot[maxSlots];    //initializing the number of slots in the vending machine
        for (int i = 0; i < maxSlots; i++) {    //loop to assign SLOTNUMBER and max items in each slot
            itemSlots[i] = new ItemSlot(i + 1, slotMaxItems);
        }
        startingInventory = null;   //there is no startingInventory when the Vending Machine is first instantiated
        transactionLog = new ItemTransaction[maxSlots]; //initializing the number of possible items for the item transactions
        money = new Money();
        maintenanceCode = passcode;
    }

    public void mainMenu(Money wallet) {
        boolean bCon = false;
        boolean bTransaction = false;
        Scanner sc = new Scanner(System.in);
        int slotSelection;
        Item itemSelection;

        displayItemMenu();
        do {
            System.out.println("(0) Exit");
            System.out.println("Pick an Item: ");
            slotSelection = sc.nextInt();

            if (slotSelection != maintenanceCode) { //if the user is a maintenance person that would or would not like to conduct maintenance
                bCon = chooseItem(slotSelection);
                if (bCon && slotSelection != 0) {   //if the user selects a valid item
                    itemSelection = itemSlots[slotSelection - 1].getItem();
                    bTransaction = receivePayment(itemSelection.getCost(), wallet); //receives the payment from the user

                    if (bTransaction)   //updates the transaction log of that item if the transaction was successful
                        transactionLog[slotSelection - 1].addTransaction();

                    mainMenu(wallet);
                }
            }
            else {
                maintenance();
                mainMenu(wallet);
            }
        } while (!bCon);   //exit detection also exists within the chooseItem() method

        if (bTransaction)
            System.out.println("Thank You for Your Purchase!");
        else
            System.out.println("Thank You Come Again!");
    }

    private void displayItemMenu(){
        System.out.println("=========================");
        System.out.println("Slot Number|| Item");
        System.out.println("==========Food===========");
        System.out.println("1  || Fried Egg (Sunny Side Up");
        System.out.println("2  || Tapas");
        System.out.println("3  || Hotdog");
        System.out.println("4  || Piattos");
        System.out.println("5  || V-Cut");
        System.out.println("6  || Corn");
        System.out.println("7  || Fried Chicken");
        System.out.println("8  || Bangus");
        System.out.println("9  || Pork Chop");
        System.out.println("10 || Tosino");
        System.out.println("11 || Rice");
        System.out.println("==========Drinks=========");
        System.out.println("12 || Coca-Cola");
        System.out.println("13 || Royal");
        System.out.println("14 || Bottled Water");
    }

    private boolean chooseItem(int slot){
        boolean b = false;
        ItemSlot selectedSlot = null;
        Item selectedItem = null;
        int temp;
        Scanner sc = new Scanner(System.in);

        if (slot == 0)  //slot selection at 0 for exit per user input
            return true;

        for (ItemSlot itemSlot: itemSlots){ //looks for the corresponding slot number in the itemSlots array
            if (slot == itemSlot.getSlotNumber() && itemSlot.isAvailable()) {   //only accept item slots that are valid and have available stock/s
                b = true;
                selectedSlot = itemSlot;
                selectedItem = selectedSlot.getItem();
            }
        }

        if (!b) //identifying whether the item selection is valid
            System.out.println("Error: Invalid Item Selection");
        else {  //details of the selected item
            System.out.println("=========================");
            System.out.println("(" + slot + ")Selected Item: " + selectedItem.getName());
            System.out.println("Price:           " + selectedItem.getCost() + "PHP");
            System.out.println("Calorie/s:       " + selectedItem.getCalories());
            System.out.println("=========================");
        }

        return b;
    }

    private boolean receivePayment(int cost, Money wallet) {
        int change;
        int temp = -1;
        Money payment = new Money();
        Money tempWallet = new Money(wallet);
        Scanner sc = new Scanner(System.in);
        boolean b = false;

        System.out.println("Amount to Pay: " + cost + " PHP");
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

    private void maintenance() {
//reminder to make ItemSlot reflect directly onto transactionLog
    }

    private ItemSlot[] itemSlots;
    private Money money;
    private ItemTransaction[] transactionLog;
    private VendingMachine startingInventory;
    private int maintenanceCode;

}
