package card.bonuses;

import card.DebitCard;

public final class CashbackDebitCard extends DebitCard {
    private final double cashbackPercentage;
    private final double cashbackThreshold;

    public CashbackDebitCard(double cashbackPercentage, double cashbackThreshold) {
        this.cashbackPercentage = cashbackPercentage;
        this.cashbackThreshold = cashbackThreshold;
    }

    @Override
    public Boolean pay(Double value) {
        Boolean payResult = super.pay(value);
        if (payResult && value >= cashbackThreshold) {
            this.replenish(value * cashbackPercentage);
        }
        return payResult;
    }

    @Override
    public void getAvailableFundsInfo() {
        int cashbackPercentage = (int)(this.cashbackPercentage * 100);
        System.out.println("Размер кэшбэка: " + cashbackPercentage + "%");
        System.out.println("Кэшбэк действует от покупок в: " + Math.round(cashbackThreshold * 1000.) / 1000.);
        System.out.println("Собственные средства: " + Math.round(balance * 1000.) / 1000. + " руб.");
    }
}
