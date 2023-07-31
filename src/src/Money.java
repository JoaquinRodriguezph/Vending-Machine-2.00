/**
 * The Money Class is the denomination of actual money.
 */
public class Money {
    /**
     * This method is a constructor that is used to create a money instance.
     * It sets all its attributes to a 0 value.
     */
    public Money(int value) throws IllegalArgumentException {
        if (value != 1 && value != 5 && value != 10 && value != 20 && value != 50 && value != 100 && value != 200 && value != 500 && value != 1000)
            throw new IllegalArgumentException("Invalid Denomination Value");
        this.value = value;
    }

    /**
     * This method gets the value of the money.
     *
     * @return the value of the money
     */
    public int getValue() {
        return value;
    }

    /**
     * The value of the money object
     */
    private int value;
}
