import java.util.ArrayList;

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

    /**
     * This method is a constructor that is used to create a money instance
     * from a given money instance.
     * It initializes all attributes to the values of the given instance.
     * @param money is the money instance that this instance will be based off of
     */
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

    /**
     * This method is used to get the total amount of money in the instance.
     * @return the total amount of money.
     */
    public int getMoney(){
        int total = 0;

        total += onePeso + fivePeso * 5 + tenPeso * 10 + twentyPeso * 20 + fiftyPeso * 50 + oneHundredPeso * 100;
        return (total + twoHundredPeso * 200 + fiveHundredPeso * 500 + oneThousandPeso * 1000);
    }

    /**
     * This method returns the total amount of one peso coins.
     * @return the total amount of one peso coins.
     */
    public int getOnePeso() {
        return onePeso;
    }

    /**
     * This method returns the total amount of five peso coins.
     * @return the total amount of five peso coins.
     */
    public int getFivePeso() {
        return fivePeso;
    }

    /**
     * This method returns the total amount of ten peso coins.
     * @return the total amount of ten peso coins.
     */
    public int getTenPeso() {
        return tenPeso;
    }

    /**
     * This method returns the total amount of twenty peso coins.
     * @return the total amount of twenty peso coins.
     */
    public int getTwentyPeso() {
        return twentyPeso;
    }

    /**
     * This method returns the total amount of fifty peso bills.
     * @return the total amount of fifty peso bills.
     */
    public int getFiftyPeso() {
        return fiftyPeso;
    }

    /**
     * This method returns the total amount of one hundred peso bills.
     * @return the total amount of one hundred peso bills.
     */
    public int getOneHundredPeso() {
        return oneHundredPeso;
    }

    /**
     * This method returns the total amount of two hundred peso bills.
     * @return the total amount of two hundred peso bills.
     */
    public int getTwoHundredPeso() {
        return twoHundredPeso;
    }

    /**
     * This method returns the total amount of five hundred peso bills.
     * @return the total amount of five hundred peso bills.
     */
    public int getFiveHundredPeso() {
        return fiveHundredPeso;
    }

    /**
     * This method returns the total amount of one thousand peso bills.
     * @return the total amount of one thousand peso bills.
     */
    public int getOneThousandPeso() {
        return oneThousandPeso;
    }

    /**
     * Sets the amount of one peso coins.
     * @param n the amount of one peso coins to be set.
     */
    public void setOnePeso(int n) {
        this.onePeso = n;
    }
    /**
     * Sets the amount of five peso coins.
     * @param n the amount of five peso coins to be set.
     */
    public void setFivePeso(int n) {
        this.fivePeso = n;
    }

    /**
     * Sets the amount of ten peso coins.
     * @param n the amount of ten peso coins to be set.
     */
    public void setTenPeso(int n) {
        this.tenPeso = n;
    }

    /**
     * Sets the amount of twenty peso coins.
     * @param n the amount of twenty peso coins to be set.
     */
    public void setTwentyPeso(int n) {
        this.twentyPeso = n;
    }

    /**
     * Sets the amount of fifty peso bills.
     * @param n the amount of fifty peso bills to be set.
     */
    public void setFiftyPeso(int n) {
        this.fiftyPeso = n;
    }

    /**
     * Sets the amount of one hundred peso bills.
     * @param n the amount of one hundred peso bills to be set.
     */
    public void setOneHundredPeso(int n) {
        this.oneHundredPeso = n;
    }

    /**
     * Sets the amount of two hundred peso bills.
     * @param n the amount of two hundred peso bills to be set.
     */
    public void setTwoHundredPeso(int n) {
        this.twoHundredPeso = n;
    }

    /**
     * Sets the amount of five hundred peso bills.
     * @param n the amount of five hundred peso bills to be set.
     */
    public void setFiveHundredPeso(int n) {
        this.fiveHundredPeso = n;
    }

    /**
     * Sets the amount of one thousand peso bills.
     * @param n the amount of one thousand peso bills to be set.
     */
    public void setOneThousandPeso(int n) {
        this.oneThousandPeso = n;
    }

    /**
     * Adds the amount of money from the Money instance in the parameter to the
     * current Money instance.
     * @param money the Money instance whose attributes will be added from.
     */
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

    /**
     * Removes the amount of money from the Money instance in the parameter to the
     * current Money instance.
     * @param money the Money instance whose attributes will be removed from.
     * @return true if successful and false if not
     */
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

        if (temp.isValid()) {   //making sure the denominations does not become a negative value
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

    /**
     * Removes specified amount of money from current Money instance.
     * @param money the amount of money to be removed.
     * @return true if successful and false if not.
     */
    public boolean removeMoney(int money) {
        Money temp = new Money(this);
        boolean b = false;

        //deducting money while providing suffice denominations for each level
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
            temp.twentyPeso--;
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

        if (money == 0) {   //money == 0 meaning the money was given enough and sufficient denominations to equal the money
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

    /**
     * This method checks if the Money instance is valid by checking if
     * each attribute is positive.
     * @return true if valid and false if not valid.
     */
    public boolean isValid() {
        return !(onePeso < 0 || fivePeso < 0 || tenPeso < 0 || twentyPeso < 0 || fiftyPeso < 0 || oneHundredPeso < 0 || twoHundredPeso < 0 || fiveHundredPeso < 0 || oneThousandPeso < 0);
    }

    /**
     * This method sets all attributes of the Money instance to 0.
     */
    public void empty() {
        onePeso = fivePeso = tenPeso = twentyPeso = fiftyPeso = 0;
        oneHundredPeso = twoHundredPeso = fiveHundredPeso = oneThousandPeso = 0;
    }

    /**
     * This method sets all attributes of the Money instance to 0.
     * It then adds money from a given money instance.
     * @param money the money instance who's added from.
     */
    public void replace(Money money) {
        empty();
        addMoney(money);
    }

    /**
     * Adds n amount of one peso coins to the current money instance.
     * @param n amount of one peso coins.
     */
    public void changeOnePeso(int n){
        this.onePeso += n;
    }

    /**
     * Adds n amount of five peso coins to the current money instance.
     * @param n amount of five peso coins.
     */
    public void changeFivePeso(int n){
        this.fivePeso += n;
    }

    /**
     * Adds n amount of ten peso coins to the current money instance.
     * @param n amount of ten peso coinsd.
     */
    public void changeTenPeso(int n){
        this.tenPeso += n;
    }

    /**
     * Adds n amount of twenty peso coins to the current money instance.
     * @param n amount of twenty peso coins.
     */
    public void changeTwentyPeso(int n){
        this.twentyPeso += n;
    }

    /**
     * Adds n amount of fifty peso bills to the current money instance.
     * @param n amount of fifty peso bills.
     */
    public void changeFiftyPeso(int n){
        this.fiftyPeso += n;
    }

    /**
     * Adds n amount of one hundred peso bills to the current money instance.
     * @param n amount of one hundred peso bills.
     */
    public void changeOneHundredPeso(int n){
        this.oneHundredPeso += n;
    }

    /**
     * Adds n amount of two hundred peso bills to the current money instance.
     * @param n amount of two hundred peso bills.
     */
    public void changeTwoHundredPeso(int n){
        this.twoHundredPeso += n;
    }

    /**
     * Adds n amount of five hundred peso bills to the current money instance.
     * @param n amount of five hundred peso bills.
     */
    public void changeFiveHundredPeso(int n){
        this.fiveHundredPeso += n;
    }

    /**
     * Adds n amount of one thousand peso bills to the current money instance.
     * @param n amount of one thousand peso bills.
     */
    public void changeOneThousandPeso(int n){
        this.oneThousandPeso += n;
    }

    /**
     * Displays the amount of money in info's currency and the total.
     * @param info the currency of the money.
     */
    public void showMoney(String info) {
        ArrayList<String> str = moneyString(info);
        for (String string : str) {
            System.out.println(string);
        }
    }

    /**
     * Displays the total amount of money without the currency.
     */
    public void showMoney() {
        ArrayList<String> str = moneyString();
        for (String string : str) {
            System.out.println(string);
        }
    }

    public ArrayList<String> moneyString(String info) {
        ArrayList<String> str = new ArrayList<String>();
        str.add("*************************");
        str.add("Money in " + info);
        str.addAll(denomString());
        str.add("Total:      " + getMoney());
        str.add("*************************");
        return str;
    }

    public ArrayList<String> moneyString() {
        ArrayList<String> str = new ArrayList<String>();
        str.add("*************************");
        str.addAll(denomString());
        str.add("Total:      " + getMoney());
        str.add("*************************");
        return str;
    }

    public ArrayList<String> denomString() {
        ArrayList<String> str = new ArrayList<String>();
        int[] list = toList();  //utilizing an array to display the number of each denominations
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
                str.add(temp + list[i]);
            }
        }

        return str;
    }


    /**
     * Makes a list of integers from 0 to 8 corresponding the denominations and their respective
     * totals.
     * @return list of 9 integers containing the nine denominations and their respective totals.
     */
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
