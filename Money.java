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
        while (money > 0) {
            while (money > 5) {
                while (money > 10) {
                    while (money > 20) {
                        while (money > 50) {
                            while (money > 100) {
                                while (money > 200) {
                                    while (money > 500) {
                                        while (money > 1000) {
                                            oneThousandPeso--;
                                            money -= 1000;
                                        }
                                        fiveHundredPeso--;
                                        money -= 500;
                                    }
                                    twoHundredPeso--;
                                    money -= 200;
                                }
                                oneHundredPeso--;
                                money -= 100;
                            }
                            fiftyPeso--;
                            money -= 50;
                        }
                        twentyPeso--;
                        money -= 20;
                    }
                    tenPeso--;
                    money -= 10;
                }
                fivePeso--;
                money -= 5;
            }
            onePeso--;
            money -= 1;
        }
        if (onePeso < 0 || fivePeso < 0 || tenPeso < 0 || twentyPeso < 0 || fiftyPeso < 0 || oneHundredPeso < 0 || twoHundredPeso < 0 || fiveHundredPeso < 0 || oneThousandPeso < 0){
            this = temp;
            temp = null;
            return false;
        }
        return true;
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
