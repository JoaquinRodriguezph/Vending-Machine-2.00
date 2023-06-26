/**
 * The Money Class contains attributes for each
 * denomination of money.
 */
public class Money {
    /**
     * This method is a constructor that is used to create a money instance.
     * It sets all its attributes to a 0 value.
     */
    public Money(){
        onePeso = fivePeso = tenPeso = twentyPeso = fiftyPeso = 0;
        oneHundredPeso = twoHundredPeso = fiveHundredPeso = oneThousandPeso = 0;
    }

    public Money(Money money) {
        onePeso = money.onePeso;
        fivePeso = money.fivePeso;
        tenPeso = money.tenPeso;
        twentyPeso = money.twentyPeso;
        fiftyPeso = money.fiftyPeso;
        oneHundredPeso = money.oneHundredPeso;
        twoHundredPeso = money.twoHundredPeso;
        fiveHundredPeso = money.fiveHundredPeso;
        oneThousandPeso = money.oneThousandPeso;
    }

    public int getMoney(){
        int total = 0;

        total += onePeso + fivePeso * 5 + tenPeso * 10 + twentyPeso * 20 + fiftyPeso * 50 + oneHundredPeso * 100;
        return (total + twoHundredPeso * 200 + fiveHundredPeso * 500 + oneThousandPeso * 1000);
    }
/*
    public void setMoney(Money money) {
        onePeso = money.onePeso;
        fivePeso = money.fivePeso;
        tenPeso = money.tenPeso;
        twentyPeso = money.twentyPeso;
        fiftyPeso = money.fiftyPeso;
        oneHundredPeso = money.oneHundredPeso;
        twoHundredPeso = money.twoHundredPeso;
        fiveHundredPeso = money.fiveHundredPeso;
        oneThousandPeso = money.oneThousandPeso;
    }
*/
    public int getOnePeso() {
        return onePeso;
    }

    public int getFivePeso() {
        return fivePeso;
    }

    public int getTenPeso() {
        return tenPeso;
    }

    public int getTwentyPeso() {
        return twentyPeso;
    }

    public int getFiftyPeso() {
        return fiftyPeso;
    }

    public int getOneHundredPeso() {
        return oneHundredPeso;
    }

    public int getTwoHundredPeso() {
        return twoHundredPeso;
    }

    public int getFiveHundredPeso() {
        return fiveHundredPeso;
    }

    public int getOneThousandPeso() {
        return oneThousandPeso;
    }

    public void setOnePeso(int n) {
        this.onePeso = n;
    }

    public void setFivePeso(int n) {
        this.fivePeso = n;
    }

    public void setTenPeso(int n) {
        this.tenPeso = n;
    }

    public void setTwentyPeso(int n) {
        this.twentyPeso = n;
    }

    public void setFiftyPeso(int n) {
        this.fiftyPeso = n;
    }

    public void setOneHundredPeso(int n) {
        this.oneHundredPeso = n;
    }

    public void setTwoHundredPeso(int n) {
        this.twoHundredPeso = n;
    }

    public void setFiveHundredPeso(int n) {
        this.fiveHundredPeso = n;
    }

    public void setOneThousandPeso(int n) {
        this.oneThousandPeso = n;
    }

    public void addMoney(Money money){
        onePeso += money.onePeso;
        fivePeso += money.fivePeso;
        tenPeso += money.tenPeso;
        twentyPeso += money.twentyPeso;
        fiftyPeso += money.fiftyPeso;
        oneHundredPeso += money.oneHundredPeso;
        twoHundredPeso += money.twoHundredPeso;
        fiveHundredPeso += money.fiveHundredPeso;
        oneThousandPeso += money.oneThousandPeso;
    }

    public boolean removeMoney(Money money) {
        Money temp = new Money(this);
        boolean b = false;

        temp.onePeso -= money.onePeso;
        temp.fivePeso -= money.fivePeso;
        temp.tenPeso -= money.tenPeso;
        temp.twentyPeso -= money.twentyPeso;
        temp.fiftyPeso -= money.fiftyPeso;
        temp.oneHundredPeso -= money.oneHundredPeso;
        temp.twoHundredPeso -= money.twoHundredPeso;
        temp.fiveHundredPeso -= money.fiveHundredPeso;
        temp.oneThousandPeso -= money.oneThousandPeso;

        if (temp.isValid()) {
            this.onePeso = temp.onePeso;
            this.fivePeso = temp.fivePeso;
            this.tenPeso = temp.tenPeso;
            this.twentyPeso = temp.twentyPeso;
            this.fiftyPeso = temp.fiftyPeso;
            this.oneHundredPeso = temp.oneHundredPeso;
            this.twoHundredPeso = temp.twoHundredPeso;
            this.fiveHundredPeso = temp.fiveHundredPeso;
            this.oneThousandPeso = temp.oneThousandPeso;
            b = true;
        }

        temp = null;
        return b;
    }

    public boolean removeMoney(int money) {
        Money temp = new Money();
        temp = this;
        boolean b = false;

        while (temp.oneThousandPeso > 0 && money >= 1000) {
            temp.oneThousandPeso--;
            money -= 1000;
        }

        while (temp.fiveHundredPeso > 0 && money >= 500) {
            temp.fiveHundredPeso--;
            money -= 500;
        }

        while (temp.twoHundredPeso > 0 && money >= 200) {
            temp.twoHundredPeso--;
            money -= 200;
        }

        while (temp.oneHundredPeso > 0 && money >= 100) {
            temp.oneHundredPeso--;
            money -= 100;
        }

        while (temp.fiftyPeso > 0 && money >= 50) {
            temp.fiftyPeso--;
            money -= 50;
        }

        while (temp.twentyPeso > 0 && money >= 20) {
            temp.fiveHundredPeso--;
            money -= 20;
        }

        while (temp.tenPeso > 0 && money >= 10) {
            temp.tenPeso--;
            money -= 10;
        }

        while (temp.fivePeso > 0 && money >= 5) {
            temp.fivePeso--;
            money -= 5;
        }

        while (temp.onePeso > 0 && money >= 1) {
            temp.fiveHundredPeso--;
            money -= 1;
        }

        if (money == 0) {
            this.onePeso = temp.onePeso;
            this.fivePeso = temp.fivePeso;
            this.tenPeso = temp.tenPeso;
            this.twentyPeso = temp.twentyPeso;
            this.fiftyPeso = temp.fiftyPeso;
            this.oneHundredPeso = temp.oneHundredPeso;
            this.twoHundredPeso = temp.twoHundredPeso;
            this.fiveHundredPeso = temp.fiveHundredPeso;
            this.oneThousandPeso = temp.oneThousandPeso;
            b = true;
        }
        temp = null;
        return b;
    }

    public boolean isValid() {
        return !(onePeso < 0 || fivePeso < 0 || tenPeso < 0 || twentyPeso < 0 || fiftyPeso < 0 || oneHundredPeso < 0 || twoHundredPeso < 0 || fiveHundredPeso < 0 || oneThousandPeso < 0);
    }

    public void addOnePeso(int n){
        this.onePeso += n;
    }

    public void addFivePeso(int n){
        this.fivePeso += n;
    }

    public void addTenPeso(int n){
        this.tenPeso += n;
    }

    public void addTwentyPeso(int n){
        this.twentyPeso += n;
    }

    public void addFiftyPeso(int n){
        this.fiftyPeso += n;
    }

    public void addOneHundredPeso(int n){
        this.oneHundredPeso += n;
    }

    public void addTwoHundredPeso(int n){
        this.twoHundredPeso += n;
    }

    public void addFiveHundredPeso(int n){
        this.fiveHundredPeso += n;
    }

    public void addOneThousandPeso(int n){
        this.oneThousandPeso += n;
    }

    public void showMoney(String info) {
        System.out.println("*************************");
        System.out.println("Money in " + info);
        displayDenominations();
        System.out.println("Total:      " + getMoney());
        System.out.println("*************************");
    }

    public void showMoney() {
        System.out.println("*************************");
        displayDenominations();
        System.out.println("Total:      " + getMoney());
        System.out.println("*************************");
    }

    private void displayDenominations() {
        int[] list = toList();
        String temp = "";

        for (int i = 0; i < 9; i++) {
            if (list[i] != 0) {
                switch (i) {
                    case 0:
                        temp = "1 Peso:     ";
                        break;
                    case 1:
                        temp = "5 Pesos:    ";
                        break;
                    case 2:
                        temp = "10 Pesos:   ";
                        break;
                    case 3:
                        temp = "20 Pesos:   ";
                        break;
                    case 4:
                        temp = "50 Pesos:   ";
                        break;
                    case 5:
                        temp = "100 Pesos:  ";
                        break;
                    case 6:
                        temp = "200 Pesos:  ";
                        break;
                    case 7:
                        temp = "500 Pesos:  ";
                        break;
                    case 8:
                        temp = "1000 Pesos: ";
                }
                System.out.println(temp + list[i]);
            }
        }
    }

    private int[] toList() {
        int[] list = new int[9];
        list[0] = onePeso;
        list[1] = fivePeso;
        list[2] = tenPeso;
        list[3] = twentyPeso;
        list[4] = fiftyPeso;
        list[5] = oneHundredPeso;
        list[6] = twoHundredPeso;
        list[7] = fiveHundredPeso;
        list[8] = oneThousandPeso;

        return list;
    }

    private int onePeso;
    private int fivePeso;
    private int tenPeso;
    private int twentyPeso;
    private int fiftyPeso;
    private int oneHundredPeso;
    private int twoHundredPeso;
    private int fiveHundredPeso;
    private int oneThousandPeso;
}
