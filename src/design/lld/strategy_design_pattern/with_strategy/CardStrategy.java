package design.lld.strategy_design_pattern.with_strategy;

public class CardStrategy implements PaymentModeStrategy {
    public void makePayment() {
        System.out.println("makePayment : Card");
    }
}
