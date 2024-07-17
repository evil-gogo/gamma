package design.lld.strategy_design_pattern.with_strategy;

public class Demo {
    public static void main(String[] args) {
        PaymentModeContext paymentModeContext = new PaymentModeContext();
        paymentModeContext.setPaymentModeStrategy(new Card());
        paymentModeContext.makePayment();
        paymentModeContext.setPaymentModeStrategy(new NetBanking());
        paymentModeContext.makePayment();
        paymentModeContext.setPaymentModeStrategy(new UPI());
        paymentModeContext.makePayment();
    }
}
