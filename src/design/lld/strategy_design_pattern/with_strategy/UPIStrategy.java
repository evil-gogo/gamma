package design.lld.strategy_design_pattern.with_strategy;

public class UPIStrategy implements PaymentModeStrategy {
    public void makePayment() {
        System.out.println("makePayment : UPI");
    }
}
