package design.lld.strategy_design_pattern.with_strategy;

public class NetBankingStrategy implements PaymentModeStrategy {
    public void makePayment() {
        System.out.println("makePayment : NetBanking");
    }
}
