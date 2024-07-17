package design.lld.strategy_design_pattern.with_strategy;

public class PaymentModeContext {
    private PaymentModeStrategy paymentModeStrategy;

    public void setPaymentModeStrategy(PaymentModeStrategy paymentModeStrategy) {
        this.paymentModeStrategy = paymentModeStrategy;
    }

    public PaymentModeStrategy getPaymentModeStrategy() {
        return paymentModeStrategy;
    }

    public void makePayment() {
        paymentModeStrategy.makePayment();
    }
}
