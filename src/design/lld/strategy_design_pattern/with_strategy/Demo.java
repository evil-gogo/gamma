package design.lld.strategy_design_pattern.with_strategy;

public class Demo {
    public static void main(String[] args) {
        PaymentModeContext paymentModeContext = new PaymentModeContext();
        paymentModeContext.setPaymentModeStrategy(new CardStrategy());
        paymentModeContext.makePayment();
        paymentModeContext.setPaymentModeStrategy(new NetBankingStrategy());
        paymentModeContext.makePayment();
        paymentModeContext.setPaymentModeStrategy(new UPIStrategy());
        paymentModeContext.makePayment();
    }
}
