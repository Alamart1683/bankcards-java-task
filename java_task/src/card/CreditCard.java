package card;

public class CreditCard extends BankCard {
    protected final double creditLimit;
    protected Double creditBalance;

    public CreditCard(double creditLimit) {
        this.creditLimit = creditLimit;
        this.creditBalance = 0.;
    }

    @Override
    public void replenish(Double value) {
        if (creditBalance > 0.) {
            creditBalance -= value;
            if (creditBalance < 0.) {
                balance -= creditBalance;
                creditBalance = 0.;
            }
        } else {
            balance += value;
        }
    }

    @Override
    public Boolean pay(Double value) {
        if (balance + creditLimit - creditBalance - value >= 0.) { // Отобьем заведомо непроходяшую операцию
            if (balance - value >= 0.) {
                balance -= value;
            } else {
                creditBalance -= balance - value;
                balance = 0.;
            }
            return true;
        }
        return false;
    }

    @Override
    public void getBalanceInfo() {
        System.out.println("Кредитные средства: " + Math.round((creditLimit - creditBalance) * 1000.) / 1000.);
        System.out.println("Собственные средства: " + Math.round(balance * 1000.) / 1000.);
    }

    @Override
    public void getAvailableFundsInfo() {
        System.out.println("Кредитный лимит: " + creditLimit);
        System.out.println("Кредитные средства: " + Math.round((creditLimit - creditBalance) * 1000.) / 1000.);
        System.out.println("Собственные средства: " + Math.round(balance * 1000.) / 1000.);
    }
}
