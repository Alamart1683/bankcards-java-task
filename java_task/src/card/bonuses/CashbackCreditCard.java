package card.bonuses;

import card.CreditCard;

public final class CashbackCreditCard extends CreditCard {
    private final double cashbackPercentage;
    private final double cashbackThreshold;

    public CashbackCreditCard(double creditLimit, double cashbackPercentage, double cashbackThreshold) {
        super(creditLimit);
        this.cashbackPercentage = cashbackPercentage;
        this.cashbackThreshold = cashbackThreshold;
    }

    @Override
    public Boolean pay(Double value) {
        Boolean payResult = super.pay(value);
        if (payResult && value >= cashbackThreshold) {
            replenish(value * cashbackPercentage);
        }
        return payResult;
    }

    @Override
    public void getAvailableFundsInfo() {
        int cashbackPercentage = (int)(this.cashbackPercentage * 100);
        System.out.println("Размер кэшбэка: " + cashbackPercentage + "%");
        System.out.println("Кэшбэк действует от покупок в: " + Math.round(cashbackThreshold * 1000.) / 1000.);
        System.out.println("Кредитный лимит: " + creditLimit);
        System.out.println("Кредитные средства: " + Math.round((creditLimit - creditBalance) * 1000.) / 1000.);
        System.out.println("Собственные средства: " + Math.round(balance * 1000.) / 1000.);
    }
}
