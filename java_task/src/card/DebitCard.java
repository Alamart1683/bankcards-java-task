package card;

public class DebitCard extends BankCard {

    @Override
    public void replenish(Double value) {
        this.balance += value;
    }

    @Override
    public Boolean pay(Double value) {
        if (balance >= value) {
            balance -= value;
            return true;
        }
        return false;
    }

    @Override
    public void getBalanceInfo() {
        System.out.println("Текущий баланс: " + Math.round(balance * 1000.) / 1000.);
    }

    @Override
    public void getAvailableFundsInfo() {
        System.out.println("Собственные средства: " + Math.round(balance * 1000.) / 1000.);
    }
}
