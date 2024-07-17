package design.lld.strategy_design_pattern.without_strategy;

public class Card extends PaymentMode {
    public void makePayment() {
        System.out.println("makePayment : Card");
    }
}
