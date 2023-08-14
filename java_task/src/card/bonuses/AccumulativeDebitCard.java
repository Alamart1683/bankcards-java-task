package card.bonuses;

import card.DebitCard;

public final class AccumulativeDebitCard extends DebitCard {
    private final double accumulativePercentage;

    public AccumulativeDebitCard(double accumulativePercentage) {
        this.accumulativePercentage = accumulativePercentage;
    }

    @Override
    public void replenish(Double value) {
        super.replenish(value);
        balance += value * accumulativePercentage;
    }

    @Override
    public void getAvailableFundsInfo() {
        double accumulativePercentage = this.accumulativePercentage * 100;
        System.out.println("Процент накопления от пополнения: " + accumulativePercentage + "%");
        System.out.println("Собственные средства: " + Math.round(balance * 1000.) / 1000. + " руб.");
    }
}
