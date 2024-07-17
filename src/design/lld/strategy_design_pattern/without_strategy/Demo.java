package design.lld.strategy_design_pattern.without_strategy;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<PaymentMode> paymentModes = new ArrayList<>();
        paymentModes.add(new NetBanking());
        paymentModes.add(new Card());
        paymentModes.add(new UPI());

        for (PaymentMode paymentMode : paymentModes) {
            paymentMode.makePayment();
        }
    }
}
