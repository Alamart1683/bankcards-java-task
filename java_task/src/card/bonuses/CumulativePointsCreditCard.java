package card.bonuses;

import card.CreditCard;

public final class CumulativePointsCreditCard extends CreditCard {
    private final double pointsPercentage;

    private Double points;

    public CumulativePointsCreditCard(double creditLimit, double pointsPercentage) {
        super(creditLimit);
        this.pointsPercentage = pointsPercentage;
        this.points = 0.;
    }

    @Override
    public Boolean pay(Double value) {
        Boolean payResult = super.pay(value);
        if (payResult) {
            points += value * pointsPercentage;
        }
        return payResult;
    }

    @Override
    public void getAvailableFundsInfo() {
        int pointsPercentage = (int)(this.pointsPercentage * 100);
        System.out.println("Процент баллов от суммы покупки: " + pointsPercentage + "%");
        System.out.println("Количество накопительных баллов: " + Math.round(points * 1000.) / 1000.);
        System.out.println("Кредитный лимит: " + creditLimit);
        System.out.println("Кредитные средства: " + Math.round((creditLimit - creditBalance) * 1000.) / 1000.);
        System.out.println("Собственные средства: " + Math.round(balance * 1000.) / 1000.);
    }
}
