package card;

public abstract class BankCard {
    protected Double balance;

    BankCard() {
        balance = 0.;
    }

    public abstract void replenish(Double value);

    public abstract Boolean pay(Double value);

    public void getBalanceInfo() {
        System.out.println("Собственные средства: " + Math.round(balance * 1000.) / 1000.);
    }

    public abstract void getAvailableFundsInfo();
}
