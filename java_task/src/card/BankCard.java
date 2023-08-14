package card;

public abstract class BankCard {
    protected Double balance;

    BankCard() {
        balance = 0.;
    }

    public abstract void replenish(Double value);

    public abstract Boolean pay(Double value);

    public abstract void getBalanceInfo();

    public abstract void getAvailableFundsInfo();
}
