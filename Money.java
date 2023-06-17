public class Money {
    public Money(){
        onePeso = fivePeso = tenPeso = twentyPeso = fiftyPeso = 0;
        oneHundredPeso = twoHundredPeso = fiveHundredPeso = oneThousandPeso = 0;
    }

    public int getMoney(){
        int total = 0;

        total += onePeso + fivePeso * 5 + tenPeso * 10 + twentyPeso * 20 + fiftyPeso * 50 + oneHundredPeso * 100;
        return (total + twoHundredPeso * 200 + fiveHundredPeso * 500 + oneThousandPeso * 1000);
    }

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
